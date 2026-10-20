# Roadmap

OrderFlow is the primary integrated project, with recurring practice outside the application. Each feature follows a learning cycle: identify concepts; explain theory and trade-offs; implement incrementally; add meaningful tests; explore a failure when useful; finish with a short code-reading, debugging, or interview exercise; record what was learned and what needs revision.

## Integrated application path

| Phase | Feature and learning focus | Practice and verification | Depends on |
| --- | --- | --- | --- |
| 0 | Foundation: Java 21, Maven, Spring Boot, JUnit 5, repository workflow | Build, context smoke test, read project structure | JDK 21, Maven |
| 1 | Order lifecycle: domain modelling, invariants, valid status transitions, LLD | Unit tests for accepted/rejected transitions; reason through an invalid transition | Phase 0 |
| 2 | Persistence: relational modelling, SQL, constraints, indexes, query plans, Flyway, transactions | Integration tests; inspect a query plan; test rollback and constraint failures | Phase 1 |
| 3 | Order REST API: HTTP semantics, validation, error handling, maintainable boundaries | Controller/API tests; malformed input and not-found exercises | Phase 2 |
| 4 | Catalogue, inventory, cancellation: transaction boundaries, concurrency, consistency | Competing stock requests, oversell reproduction, transaction tests | Phases 2–3 |
| 5 | Authentication, authorization, ownership, idempotency | Security tests for unauthenticated, forbidden, replayed, and duplicate requests | Phase 3 |
| 6 | Kafka events, asynchronous processing, retries, dead-letter queues, outbox trade-offs | Consumer integration tests; duplicate delivery, poison message, and retry exercises | Phases 4–5 |
| 7 | Redis and caching trade-offs | Measure before/after; test expiry and stale-data cases; decide what not to cache | Phases 3–6 as relevant |
| 8 | Logs, metrics, tracing, production debugging | Diagnose an injected failure from telemetry; explain signal selection | Phases 3–7 |
| 9 | Docker Compose, CI/CD, deployment | Reproducible local environment; pipeline gates; deployment and rollback exercise | Earlier phases |
| 10 | HLD, LLD, system design synthesis | Explain OrderFlow decisions, consistency, scaling, and operational trade-offs | Ongoing; culminates after phase 9 |

This is a dependency guide, not a requirement to build every listed item. Introduce technology only when a concrete feature benefits from it; keep the architecture a modular monolith unless evidence justifies a change.

## Isolated Java concurrency lab

Use small programs with controlled inputs and repeatable demonstrations when production code would make the lesson artificial. Cover each topic deliberately:

1. Data races and visibility failures.
2. Intrinsic synchronization and atomicity.
3. Explicit locks, lock scope, and fairness trade-offs.
4. `volatile`, including what it guarantees and what it does not.
5. Happens-before relationships and safe publication.
6. Executors, task lifecycle, and shutdown.
7. Thread-pool sizing, queueing, and saturation.
8. `CompletableFuture`, composition, failure propagation, and executor choice.
9. Concurrent collections and their consistency guarantees.
10. Deadlocks: construct a safe reproduction, capture evidence, then fix via ordering or reduced lock scope.

Connect lab lessons back to OrderFlow only where they clarify a real invariant, such as inventory reservation or duplicate request handling.

## Recurring standalone practice

- **DSA:** maintain a separate recurring practice track; record topic/problem, attempted approach, complexity, outcome, and revision date. Do not turn DSA exercises into application features.
- **Interview design:** periodically solve standalone HLD/LLD prompts in addition to designing and reviewing OrderFlow. Record assumptions, APIs/data model, bottlenecks, failure modes, and trade-offs.
- **Review loop:** revisit concepts marked for revision in `SESSION_LOG.md` or `TASKS.md` and schedule spaced follow-up exercises.
