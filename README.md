# wealth-common

Shared Java library for Wealth services.

- Java 21
- Spring Boot 3.5.7
- Maven artifact: `com.wealth:wealth-common:0.1.0-SNAPSHOT`
- Package registry: GitHub Packages
- Branch: `development`

## Publishing

Every push to `development` runs GitHub Actions tests and publishes the Maven package to GitHub Packages when tests pass. The workflow can also be triggered manually.

## Consume from BFF/BSS

Add the GitHub Packages repository to Maven settings and depend on:

```xml
<dependency>
  <groupId>com.wealth</groupId>
  <artifactId>wealth-common</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

For package access, Maven uses a GitHub token with `read:packages`. Do not commit tokens.

## Scope

Only the pieces genuinely shared by both `wealth-bff` and `wealth-bss` live here: CORS/REST-template
config, security headers + OpenAPI setup (`WebConfig`), Spring Batch job infrastructure (`job/*`), generic
exception/response types, loggers, and JWT verification (`JwtTokenUtil`).

The database connection, the generic repository, the Nexus/Customers-service Feign clients, and the
request-context interceptor that used them are **not** here - each service (`wealth-bff-dev`,
`wealth-bss-dev`) carries its own local copy of those under `com.wealth.<service>.common.*`, since they
turned out to need per-service configuration (its own `DataSource`, its own feign targets) rather than one
shared instance. See each service's own `pom.xml` for what it adds on top of this library.

Review component compatibility before importing a shared configuration into BFF/BSS. Avoid enabling duplicate Spring beans or auto-configurations blindly.
