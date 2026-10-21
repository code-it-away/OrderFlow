# Tasks

| Status | Task | Acceptance criteria |
| --- | --- | --- |
| Done | Create minimal Spring Boot foundation | Project structure, bootstrap class, and context test exist. |
| Done | Install and verify build prerequisites | JDK 21 and Maven are installed; both Maven test commands pass. |
| Done | Generate Maven Wrapper | Wrapper metadata pins Maven 3.10.0; focused lifecycle tests pass through `./mvnw`. Full suite is blocked by the environment-only Mockito agent attach error recorded in `TESTS_AND_FAILURES.md`. |
| Implemented; learner exercise pending | Model order lifecycle | Encode valid transitions; test accepted/rejected changes and immutability; review the domain rules and explain the code. |
| Recurring | DSA practice (standalone) | Track problem, approach, complexity, result, and revision date separately from OrderFlow features. |
| Recurring | HLD/LLD interview design (standalone) | Solve independent design prompts periodically and record assumptions, interfaces, data model, failure modes, and trade-offs. |
| Planned | Java concurrency lab | Complete deliberate isolated experiments for races, synchronization, locks, `volatile`, happens-before, executors, pools, `CompletableFuture`, concurrent collections, and deadlocks. |
| Per feature | Learning cycle | Theory and contracts first; assistant provides scaffold; learner authors core logic and meaningful tests; review uses hints before solutions; failure exercise when useful; learning and revision notes recorded. |
