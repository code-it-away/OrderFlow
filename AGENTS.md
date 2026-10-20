# OrderFlow development guide

OrderFlow is the primary integrated learning project: a production-minded order tracking system built in small, understandable, tested increments. It complements standalone practice; it does not replace it.

## Technical baseline

- Java 21 source and target baseline; use a supported JDK 21 locally for verified builds.
- Spring Boot 3.5.x, Maven, JUnit 5, PostgreSQL and Flyway when persistence begins.
- Start as a modular monolith. Do not introduce microservices, Kafka, Redis, security, or infrastructure until a concrete requirement warrants them.

## Working agreement

1. Inspect the current state before changing it; preserve existing work.
2. For each feature, name the concepts to learn and teach the relevant theory, problem, terminology, trade-offs, and plan before implementation.
3. Implement in small increments and add meaningful automated tests; run them when the environment allows.
4. Introduce controlled failure scenarios where useful, then give the user a short code-reading, debugging, or interview exercise.
5. Record what the user learned and what needs revision in the session log or task notes.
6. Never claim a build or test passed without command output proving it.
7. Record meaningful work in `docs/project/`, especially actual state, decisions, tasks, and failures.
8. Do not commit, install dependencies, alter machine-wide configuration, or expose secrets without explicit user approval.

## Learning tracks

- Integrate SQL, testing, security, Kafka, Redis, observability, Docker, CI/CD, and practical concurrency into OrderFlow when a feature gives the concept a real purpose.
- Keep isolated Java concurrency experiments when they teach a concept more clearly than production code. Cover races, synchronization, locks, `volatile`, happens-before, executors, thread pools, `CompletableFuture`, concurrent collections, and deadlocks deliberately.
- Keep DSA as a recurring standalone practice track, separate from application features.
- Use OrderFlow for HLD, LLD, and system design. Periodically assign independent interview design problems too.
- Do not force a topic into production code merely to check it off, and do not generate the whole application at once.

## Project documentation

`docs/project/` is the durable record. Keep it concise and distinguish planned, implemented, and verified work. At session wrap-up update the relevant files.
