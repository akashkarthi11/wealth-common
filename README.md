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

This repository currently contains shared legacy Wealth/GrowX components, including generic DAO/repository, assemblers, DTOs/entities, constants, client configuration, Redis/DataSource/Web configuration, job infrastructure, security utilities and interceptors.

Review component compatibility before importing a shared configuration into BFF/BSS. Avoid enabling duplicate Spring beans or auto-configurations blindly.
