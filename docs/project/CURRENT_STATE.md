# Current state

**Last updated:** 2026-10-20

## Implemented

- Maven project descriptor targeting Java 21 and Spring Boot 3.5.16.
- Application bootstrap class and basic application configuration.
- One `@SpringBootTest` application-context smoke test.
- Maven Wrapper pinned to Maven 3.10.0 (`mvnw`, `mvnw.cmd`, `.mvn/wrapper/`).
- Project documentation and Git ignore rules.

## Verification

- **Verified:** `mvn test` passed with JDK 21: 1 test, 0 failures, 0 errors.
- **Verified:** `./mvnw test` passed with JDK 21: 1 test, 0 failures, 0 errors.
- Java 21 is installed, but the shell's default `java` still selects Java 27; set `JAVA_HOME` to the Homebrew JDK 21 path when building.
- Docker is not installed; it is not needed for the current foundation.

## Environment observed

- Java: OpenJDK 21.0.12.1 and 27.0.0 installed; default is 27.0.0
- Maven: 3.10.0
- Git: 2.56.0
- Docker: unavailable
- Git repository: initialized locally; no commits

## Exact next task

Review the foundation and this learning strategy. After approval, teach and implement the order lifecycle as a pure domain model with tests for valid and invalid status transitions, then finish with a code-reading or interview exercise. No persistence or API yet.

## Learning strategy

OrderFlow is the primary integrated practice project, complemented by separate recurring DSA and interview-design practice. Each feature has a theory-to-implementation learning cycle. Java concurrency topics are covered deliberately in isolated experiments when that is clearer than embedding artificial examples in production code. See `ROADMAP.md` and `TASKS.md` for tracks and milestones.
