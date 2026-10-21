# Current state

**Last updated:** 2026-10-21

## Implemented

- Maven project descriptor targeting Java 21 and Spring Boot 3.5.16.
- Application bootstrap class and basic application configuration.
- One `@SpringBootTest` application-context smoke test.
- Order lifecycle model in `com.orderflow.order`: immutable `Order`, explicit `OrderStatus` transitions, and an invalid-transition exception.
- Lifecycle tests for allowed/rejected transitions and immutable state behavior.
- Maven Wrapper pinned to Maven 3.10.0 (`mvnw`, `mvnw.cmd`, `.mvn/wrapper/`); wrapper metadata was regenerated in this project copy.
- Project documentation and Git ignore rules.

## Verification

- **Verified previously:** The foundation smoke test passed before this feature was added (1 test, 0 failures, 0 errors).
- **Verified:** `./mvnw -Dtest=OrderLifecycleTest test` passed with JDK 21: 14 tests, 0 failures, 0 errors.
- **Not fully verified:** Full suite has 14 lifecycle tests passing and the pre-existing Spring context smoke test errored because Mockito's Byte Buddy agent could not self-attach in the managed environment. The context itself started. See `TESTS_AND_FAILURES.md`.
- Java 21 is installed, but the shell's default `java` still selects Java 27; set `JAVA_HOME` to the Homebrew JDK 21 path when building.
- Docker is not installed; it is not needed for the current foundation.

## Environment observed

- Java: OpenJDK 21.0.12.1 and 27.0.0 installed; default is 27.0.0
- Maven: 3.10.0
- Git: 2.56.0
- Docker: unavailable
- Git repository: `feature/order-lifecycle` tracks `origin/feature/order-lifecycle`; local main and master refs are also present. The user reports that main is the hosted default; the local `origin/HEAD` symbolic ref still points to master.

## Exact next task

Complete the learner exercise for the order lifecycle: explain how transition validation and immutability prevent invalid state changes, and review whether the proposed statuses match the intended business flow. Then record learning and revisions. Persistence and API are still out of scope for this task.

## Learning strategy

OrderFlow is the primary integrated practice project, complemented by separate recurring DSA and interview-design practice. Each feature has a theory-to-implementation learning cycle. Java concurrency topics are covered deliberately in isolated experiments when that is clearer than embedding artificial examples in production code. See `ROADMAP.md` and `TASKS.md` for tracks and milestones.
