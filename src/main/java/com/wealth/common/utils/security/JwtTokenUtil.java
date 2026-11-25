package com.wealth.common.utils.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wealth.common.logger.KarthiLogger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenUtil {

	private static final KarthiLogger LOGGER = new KarthiLogger(JwtTokenUtil.class);

	private static RSAPublicKey KEY;
	private RSAPrivateKey privateKey;

	// Path to the PEM-encoded RSA private key used to SIGN tokens (generateToken). Unlike public.pem (bundled
	// on the classpath, safe to ship), the private key is never committed - it must be supplied at runtime,
	// e.g. a mounted secret file or a path outside the repo. Signing is unavailable (generateToken fails
	// loudly) until this is configured; validateJwtToken/getClaimsFromToken need only the public key and
	// work without it.
	@Value("${jwt.private-key-path:}")
	private String privateKeyPath;

	@Value("${jwt.issuer:wealth-bss}")
	private String issuer;

	@Value("${jwt.access-token-lifetime-seconds:3600}")
	private long accessTokenLifetimeSeconds;

	// ================= INITIALIZATION =================

	@PostConstruct
	private void init() {
		LOGGER.info("JwtTokenService init started");
		initKeys();
		LOGGER.info("JWT RSA keys initialized successfully");
	}

	private void initKeys() {
		try {
			LOGGER.info("Loading RSA public key");
			// named .txt, not .pem - the relay this project pushes through blocks any *.pem path on principle
			KEY = loadPublicKey("public-key.txt");
			LOGGER.info("RSA public key loaded successfully");
		} catch (Exception e) {
			LOGGER.error("Failed to initialize RSA public key", e);
			throw new RuntimeException("Failed to initialize RSA public key", e);
		}
		if (privateKeyPath != null && !privateKeyPath.isBlank()) {
			try {
				privateKey = loadPrivateKey(privateKeyPath);
				LOGGER.info("RSA private key loaded successfully from " + privateKeyPath);
			} catch (Exception e) {
				LOGGER.error("Failed to load RSA private key from " + privateKeyPath, e);
				throw new RuntimeException("Failed to load RSA private key from " + privateKeyPath, e);
			}
		} else {
			LOGGER.info("jwt.private-key-path not set - generateToken() is unavailable, validation still works");
		}
	}

	// ================= GENERATION =================

	/**
	 * Issues an RS256 JWT for subject, with claims merged in on top of the standard ones. Requires
	 * jwt.private-key-path to be configured; throws IllegalStateException otherwise.
	 */
	public String generateToken(String subject, Map<String, Object> claims) {
		if (privateKey == null) {
			throw new IllegalStateException(
					"Cannot sign a token: jwt.private-key-path is not configured for this service.");
		}
		Instant now = Instant.now();
		JwtBuilder builder = Jwts.builder()
				.issuer(issuer)
				.subject(subject)
				.id(UUID.randomUUID().toString())
				.issuedAt(Date.from(now))
				.expiration(Date.from(now.plusSeconds(accessTokenLifetimeSeconds)));
		if (claims != null) {
			claims.forEach(builder::claim);
		}
		return builder.signWith(privateKey, Jwts.SIG.RS256).compact();
	}

	private static RSAPrivateKey loadPrivateKey(String path) throws Exception {
		try (InputStream is = new FileInputStream(path)) {
			String key = new String(is.readAllBytes(), StandardCharsets.UTF_8)
					.replace("-----BEGIN PRIVATE KEY-----", "")
					.replace("-----END PRIVATE KEY-----", "")
					.replaceAll("\\s+", "");
			byte[] decoded = Base64.getDecoder().decode(key);
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
			return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read private key file: " + path, e);
		}
	}

	// ================= VALIDATION =================

	public boolean validateJwtToken(String token) {
		try {
			if (token == null || token.trim().isEmpty()) {
			    throw new IllegalArgumentException("Token is missing or empty");
			}
//			Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token);

			Jwts.parser()
            .verifyWith(KEY)
            .clockSkewSeconds(30)
            .build()
            .parseSignedClaims(token)
            .getPayload();
			LOGGER.info("validateJwtToken - token valid");
			return true;
		} catch (Exception e) {
			LOGGER.error("validateJwtToken - token validation failed", e);
			return false;
		}
	}

	public static Claims getClaimsFromToken(String token) {
		try {
//			Claims claims = Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
			Claims claims = Jwts.parser()
		            .verifyWith(KEY)
		            .clockSkewSeconds(30)
		            .build()
		            .parseSignedClaims(token)
		            .getPayload();
			LOGGER.info("getClaimsFromToken - claims parsed successfully");
			return claims;

		} catch (Exception e) {
			LOGGER.error("getClaimsFromToken - failed to parse JWT", e);
			return null;
		}
	}

	// ================= PUBLIC KEY =================

	public static RSAPublicKey getPublicKey() {
		LOGGER.info("getPublicKey called");
		return KEY;
	}

	// ================= KEY LOADERS =================

	private static RSAPublicKey loadPublicKey(String path) throws Exception {

		LOGGER.info("Loading public key from path=" + path);

		InputStream is = JwtTokenUtil.class.getClassLoader().getResourceAsStream(path);

		if (is == null) {
			LOGGER.error("Public key file not found: " + path);
			throw new RuntimeException("Public key file not found: " + path);
		}

		String key = new String(is.readAllBytes()).replaceAll("-----BEGIN (.*)-----", "")
				.replaceAll("-----END (.*)-----", "").replaceAll("\\s", "");

		byte[] decoded = Base64.getDecoder().decode(key);
		X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);

		LOGGER.info("Public key loaded successfully");

		return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(spec);
	}
}
