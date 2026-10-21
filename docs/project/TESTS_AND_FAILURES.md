# Tests and failures

## 2026-10-20 — Foundation smoke test passed

**Test:** `OrderFlowApplicationTest.applicationContextStarts`

**Expected result:** Spring Boot creates the application context successfully.

**Execution:** Both `mvn test` and `./mvnw test`, with `JAVA_HOME` set to the Homebrew JDK 21 installation.

**Result:** Passed twice: 1 test, 0 failures, 0 errors. Spring Boot 3.5.16 started the context on Java 21.0.12.1.

**Environment issue resolved:** The initial Maven run could not create `~/.m2/repository/.locks` under the managed sandbox. After Maven cache access was granted, dependency resolution and the build succeeded. Homebrew installed `openjdk@21` 21.0.12.1 and Maven 3.10.0. The default `java` command remains Java 27, so use the installed JDK 21 `JAVA_HOME` for project commands.

## 2026-10-21 — Order lifecycle tests pass; full suite has an environment error

**Focused test:** `OrderLifecycleTest` exercises creation, every allowed transition, representative invalid transitions, and immutability.

**Execution:** `./mvnw -Dtest=OrderLifecycleTest test` with `JAVA_HOME` set to Homebrew OpenJDK 21.

**Result:** BUILD SUCCESS; 14 tests, 0 failures, 0 errors. The focused suite was rerun after refining the allowed-transition test to exercise `Order.transitionTo` directly.

**Full-suite result:** `mvn -DforkCount=0 test` ran 15 tests: 14 lifecycle tests passed, while the existing `OrderFlowApplicationTest.applicationContextStarts` errored in Spring's Mockito reset listener. Mockito could not self-attach its Byte Buddy inline mock maker (`Could not self-attach to current VM using external process`). The Spring application context did start. This managed environment appears to restrict the attach mechanism; full-suite success is not verified here.

**Regression action:** Re-run `./mvnw test` in IntelliJ or a normal local terminal with JDK 21. If the same error occurs outside the managed environment, diagnose the test dependency/mock-maker configuration rather than treating the lifecycle tests as failed.
