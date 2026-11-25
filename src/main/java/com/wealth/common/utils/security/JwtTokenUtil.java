package com.wealth.common.utils.security;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.wealth.common.logger.GrowxLogger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenUtil {

	private static final GrowxLogger LOGGER = new GrowxLogger(JwtTokenUtil.class);

	private static RSAPublicKey KEY;

	// ================= INITIALIZATION =================

	@PostConstruct
	private void init() {
		LOGGER.info("JwtTokenService init started");
		initKeys();
		LOGGER.info("JWT RSA keys initialized successfully");
	}

	private static void initKeys() {
		try {
			LOGGER.info("Loading RSA private & public keys");
			KEY = loadPublicKey("public.pem");
			LOGGER.info("RSA keys loaded successfully");
		} catch (Exception e) {
			LOGGER.error("Failed to initialize RSA keys", e);
			throw new RuntimeException("Failed to initialize RSA keys", e);
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
