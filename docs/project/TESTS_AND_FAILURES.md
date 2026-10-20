# Tests and failures

## 2026-10-20 — Foundation smoke test passed

**Test:** `OrderFlowApplicationTest.applicationContextStarts`

**Expected result:** Spring Boot creates the application context successfully.

**Execution:** Both `mvn test` and `./mvnw test`, with `JAVA_HOME` set to the Homebrew JDK 21 installation.

**Result:** Passed twice: 1 test, 0 failures, 0 errors. Spring Boot 3.5.16 started the context on Java 21.0.12.1.

**Environment issue resolved:** The initial Maven run could not create `~/.m2/repository/.locks` under the managed sandbox. After Maven cache access was granted, dependency resolution and the build succeeded. Homebrew installed `openjdk@21` 21.0.12.1 and Maven 3.10.0. The default `java` command remains Java 27, so use the installed JDK 21 `JAVA_HOME` for project commands.
