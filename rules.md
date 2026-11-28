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
- Every table has the GrowX audit columns (`crtd_dt`, `crtd_by`, `updt_dt`, `updt_by`; migration 0054). A new table's migration ends with `SELECT wealth_add_audit('table');`, and `scripts/db/check-audit-columns.sql` must return 0 rows. System and cron writes are user 1.

### 9. Build and run (this laptop)
- Java: `JAVA_HOME` is Zulu 21. There is no `mvn` on PATH. Use the cached Maven under `~/.m2/wrapper/dists/apache-maven-3.9.11/*/bin/mvn`, offline (`-o`).
- Node is not installed. Run Node tools through Docker (`node:20-alpine`). With Git Bash set `MSYS_NO_PATHCONV=1`.
- Vercel deploy: `docker run ... node:20-alpine npx vercel@latest deploy --prod --yes`, with auth mounted from `C:/Users/THINKPAD/vercel-auth`.
- `curl` to some HTTPS hosts needs `--ssl-no-revoke` on this laptop.
- When `wealth-common` changes: build and install it first (`mvn -o -f wealth-common/pom.xml clean install`, tests green), then build `wealth-bss` and `wealth-bff` against it. Push `wealth-common` before them, because their CI builds it from GitHub `development`. A common change reaches the servers only when `wealth-bff` and `wealth-bss` are redeployed (ask first).

### 10. Cached reads and refresh through Kafka (the nexus)
Owner rule, 2026-11-27. Plan: `wealth/docs/plans/2026-11-27-nexus-cache-refresh-via-kafka-plan.md` (draft; the values below are the proposed defaults).
- Redis is reached **only through the BSS nexus API** (`com.wealth.bss.nexus`). No other class calls Redis directly. The login limiter, the request-context cache and the sync lock still do today; they move behind the nexus (plan D4).
- A heavy read, for example the total balance, is **not** computed from the tables on every call. The nexus returns it from Redis, stored as `{ data, fetchedAt }` under a key the **server** builds from the signed-in user's id. The client names what it wants (for example `totals`), never the key.
- **Fresh** (younger than the refresh time): return it. **Stale** (older): return it now and ask Kafka for a refresh. **Missing**: read the database once, store it, return it.
- A refresh is a Kafka message (topic `wealth.money-events`, header `eventType=cache.refresh`, message key = the cache key). The nexus consumer reads the database and writes Redis. One refresh per key at a time (a short lock key).
- **Hard refresh:** the dashboard Refresh button sends the same message forced (age ignored), limited per user, and the page asks again until `fetchedAt` is newer.
- **Refresh time:** an admin sets it in the Kafka card of Environment config (default 10 s, allowed 5 to 60). It needs a new migration (next free number) to survive a restart (owner approval and a snapshot first).
- After a user's own change, the affected key is refreshed or removed, so they see it at once.
- Redis or Kafka Inactive or down: fall back to a database read or an in-BSS refresh. A screen never shows an error because Kafka is down.
- No values, passwords or tokens in Kafka messages or logs.


### 11. API usage counting (internal and external)
Owner rule, 2026-11-27. Plan: `wealth/docs/plans/2026-11-27-api-usage-counting-plan.md`.
- **Internal** usage is every finished request to our own APIs (BSS, and BFF as below), counted once where it is served by the shared interceptor (`ApiUsageRecorder` in `wealth-common`) under the **route template**, never the raw address. A rejected request (401) counts; an error forward (`/error`), `OPTIONS`, `/actuator/**` and the usage screen itself do not.
- **External** usage is every call we make to an outside API (Angel One, Gemini, Anthropic, Yahoo and later ones), counted once at the single place the call is made, per provider and endpoint name (`login`, `holdings`, `test`), with ok or failed and the time. Checks of our own Redis, Kafka and Postgres are not external usage.
- The BFF counts its own routes the same way and **reports them to the BSS every 15 seconds** with the shared service key (the BFF has no Redis); the screen lists BFF and BSS apart. The kinds are `bff`, `bss`, `external` and `job`.
- Every scheduled job runs inside `IfApiUsageService.runJob(name, work)`: a run is one call (worked or failed, with its time), and an outside call made inside the job is listed apart as `<provider> <endpoint> (job <name>)`. A new `@Scheduled` job without it is not counted, so it is not done.
- Counts are kept in memory, added to a Redis hash per IST day and kind (`wealth:usage:<yyyyMMdd>:<internal|external>`, atomic `HINCRBY`, 8-day expiry) every few seconds, and **saved to the database every 5 minutes**: the hash is moved aside, added to `wealth_api_usage` in one transaction with a batch ledger (`wealth_api_usage_batch`), then deleted. A batch id is never added twice.
- Redis Inactive or down: the counts stay in memory and are saved to the database directly (rules 10a). Counting never fails or slows a call, and a failure in it is swallowed.
- Only names, counts and milliseconds are stored: no user id, email, token or body.
- Any new outgoing call to an outside API must go through the one counted place for that provider (or add one), so the numbers stay complete.

### 12. Performance: what runs in the request, what runs behind it
Owner rule, 2026-11-28. Measured from the laptop: one Redis or Neon round trip is about 80 ms (58 to 112), so the number of trips a call makes **one after another** sets its time. On the Oracle server the trips are much shorter: judge a cache there, not here.
- **Count the trips.** Every new or changed endpoint states how many round trips it makes in a row (caller lookup 1, plus the data) and keeps them as few as it can. Never read the same data twice in one request.
- **Decide where the work runs:**

| Work | Where |
|---|---|
| The answer the caller waits for, security and session checks, money writes and their audit | In the request, synchronous |
| Independent reads of one request | In parallel, not one after another |
| Storing a cache copy after a miss, counting usage, non-critical side effects | In-process background (the nexus executor). It never delays or fails the call; a failure is swallowed and logged at WARN |
| Refreshing a stale heavy read, events another instance or a later step needs, work that must survive a restart | Kafka (rule 10), with its direct-call fallback when Kafka is off (rule 10a) |

- **Never in the background:** anything the response, a permission check or a change the user must see at once depends on. A background write must be harmless if it lands late (versioned key or short time to live) and if it never runs.
- **Heavy reads** (over about 300 ms warm) go through the nexus (rule 10) with a time to live and an eviction on every write that changes them. The first call may be slow; the repeat must not be.
- **Cache scope:** private data is cached per user; one shared copy only for data that is the same for everyone (account types, menus per role). Do not add a version read to shared data.
- **Prove a cache before keeping it.** Report first-call and repeat-call times on the same machine. A cache that does not beat the database trip is not added (`users/me`, 2026-11-28: Redis 81 ms against a 80 ms query, so it was removed).
- **Screens:** load one data set once per page and share it with every component (do not call `accounts/list` from each one); load independent data in parallel; show the data already held first and refresh quietly; page long lists.
- **Measure** with the BSS log line `API END ... Time=` and the API usage screen. Over 300 ms warm is slow and needs a reason in the change.

## wealth-common rules
- Shared library used by both the BFF and the BSS: config, errors, logger, interceptor, DTOs. A change here affects both services.
- Publish `wealth-common` before building the BSS or BFF in CI. Run both services' tests after a change.
- The interceptor decides which paths are public. Keep that list short and covered by tests (`InterceptorTest`).
- The JWT public key in this library pairs with the BSS private key. Never commit a private key.
- Keep shared DTOs backward compatible. Removing or renaming a field needs the BFF and BSS changed in the same release.
