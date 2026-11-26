# Wealth Common: rules

Read this before changing code, config or deploys in this repo. It applies to every assistant and developer.

## Shared rules (all new Wealth projects)

Projects: `wealth-ui` (Next.js on Vercel), `wealth-bff` and `wealth-bss` (Spring Boot), `wealth-common` (shared library).
Plan and design: `wealth/docs/plans/2026-11-25-springboot-migration-plan.md` and `2026-11-25-wealth-migration-design.md`.
The old Node app in `wealth/` has its own `rules.md` (ledger, balances, interest). These rules do not change it.

### 1. The chain
- Browser → wealth-ui server → BFF → BSS → Neon Postgres and Redis. No step is skipped.
- Only wealth-ui talks to the BFF. Only the BFF talks to the BSS. Only the BSS talks to the database and Redis.
- The BSS address lives only in the BFF setting `WEALTH_BSS_BASE_URL`. It is never set in Vercel or the browser.
- The BSS runs in Docker on `140.245.200.17`, port 8081, bound to that server only. Its public address is the Cloudflare tunnel `https://speeds-unto-portland-experienced.trycloudflare.com`, which is `140.245.200.17:8081`. The BFF uses that address (`WEALTH_BSS_BASE_URL`). Never use `localhost:18081` on the BFF server: that old local BSS is stopped and disabled.
- A quick tunnel gets a new address when it restarts. If it changes, update `WEALTH_BSS_BASE_URL` in `/etc/wealth/bff.env`, update this rule, and restart the BFF (with approval).
- The BFF address lives only in the server-side Vercel variable `WEALTH_BFF_URL`. The browser never sees it or the JWT.

### 2. Never invent
- No table, column, API, validation, status value or business rule that is not in `docs/` or the code. If it is missing, ask.
- Check that a class, route or table does not already exist before adding one.
- Do not add dependencies, packages or configuration properties without being asked.

### 3. Secrets and personal data
- Never print, log, commit or paste keys, passwords, tokens, database URLs, `.env` files, private keys or customer data.
- List server settings by name only, from one named file. Never run `cat`, `sed` or a glob over `/etc/wealth/*` (it holds the JWT private key).
- Mask email addresses in logs.
- Never commit `application-prod.properties` with real values. Production values come from environment variables.

### 4. Approval before anything that changes something live
Ask first, every time, for: a push to GitHub, a deploy, a restart or stop of a service, a change to a server setting or Vercel variable,
a database change, a dependency change, and removing anything. A deploy approved once is not approval for the next one.

### 5. Branches, GitHub and deploys
- GitHub is not reachable from this laptop. Push only through the relay. From the repo root run
  `REPO=akashkarthi11/<repo> bash /c/karthi/UAB/wealth/scripts/relay-push-repo.sh development "<message>"` (add `dry` to list files first).
  The repo must be on the relay's allowed list (`GITHUB_RELAY_REPOS`); a 403 means it is not.
- Work and push on `development`. Never push `main` unless asked in that message.
- A push to `development` of `wealth-bff` or `wealth-bss` starts a deploy to Oracle. Say so before pushing.
- Commit first (the relay sends committed work only). Do not commit generated or foreign files.
- When the owner says "push": check wealth-bff, wealth-bss and wealth-common for commits newer than `refs/relay/development`, push only those through the relay, then check the live health of every service that deploys from them (the BFF and BSS deploy through their own CI). wealth-ui is not pushed to GitHub for now: the assistant only deploys it to Vercel after changes (commit locally first).
- The relay is the Vercel project `karthi-github-relay`. Nothing relay-related runs on the Oracle servers.

### 6. Code style (from the design doc)
- Layers follow GrowX. BFF: `contract → controller → validator → Feign client`. BSS: `contract → controller → service interface → service impl → DAO interface → DaoImple → query constants`.
- One `WealthFeignClient` in the BFF and one constants file per project. No inline SQL. Entities extend `GenericEntity`.
- APIs are `POST`, lowercase hyphenated URLs, `ApiResponse` envelope, `KarthiException` with an error code. Health checks are the one `GET` exception.
- Logging with `KarthiLogger`, no `{}` placeholders. Comments at most 2 lines, short and factual. No wildcard imports.
- No new packages, helper, mapper or factory classes unless asked.

### 7. Prove it, then say so
- Run the tests and report the totals before claiming something works. Never write "passed" without the output.
- After a deploy, check the live result (health URL or the changed route) and report what it returned.
- Report the commit hash and the branch for every commit and push.
- Say what was not checked.

### 8. Data safety
- No test touches the production database or Redis. Use a Neon branch or a test container.
- Schema changes go only through the existing migrations in `wealth/scripts/migrations` until the plan says otherwise. The BSS never runs DDL.

### 9. Build and run (this laptop)
- Java: `JAVA_HOME` is Zulu 21. There is no `mvn` on PATH. Use the cached Maven under `~/.m2/wrapper/dists/apache-maven-3.9.11/*/bin/mvn`, offline (`-o`).
- Node is not installed. Run Node tools through Docker (`node:20-alpine`). With Git Bash set `MSYS_NO_PATHCONV=1`.
- Vercel deploy: `docker run ... node:20-alpine npx vercel@latest deploy --prod --yes`, with auth mounted from `C:/Users/THINKPAD/vercel-auth`.
- `curl` to some HTTPS hosts needs `--ssl-no-revoke` on this laptop.

## wealth-common rules
- Shared library used by both the BFF and the BSS: config, errors, logger, interceptor, DTOs. A change here affects both services.
- Publish `wealth-common` before building the BSS or BFF in CI. Run both services' tests after a change.
- The interceptor decides which paths are public. Keep that list short and covered by tests (`InterceptorTest`).
- The JWT public key in this library pairs with the BSS private key. Never commit a private key.
- Keep shared DTOs backward compatible. Removing or renaming a field needs the BFF and BSS changed in the same release.
