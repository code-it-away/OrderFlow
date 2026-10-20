# Decisions

## 2026-10-19 — Begin as a modular monolith

**Decision:** One Spring Boot application with clear package boundaries.

**Why:** The first learning goal is correct domain and data behaviour. Microservices would introduce operational complexity before there is a product boundary that justifies it.

## 2026-10-19 — Java 21 is the project baseline

**Decision:** Target Java 21 even though this machine currently has Java 27.

**Why:** Java 21 is an LTS release and a dependable enterprise baseline. The installed Java 27 is newer than the Spring Boot versions verified for support, so it is not the supported project runtime yet.

## 2026-10-19 — Spring Boot 3.5.16

**Decision:** Use the stable 3.5 release line.

**Why:** It provides a mature Spring Boot 3 / Jakarta baseline while keeping the initial project conventional. Spring Boot 4.1.1 is current but its published compatibility stops at Java 26, which does not resolve the installed Java 27 mismatch.

## 2026-10-19 — No database dependency yet

**Decision:** Defer PostgreSQL, Flyway, and Testcontainers.

**Why:** Adding persistence before an order model would create configuration without a behaviour to protect. Introduce them with the first persisted use case.

## 2026-10-20 — OrderFlow is the integrated learning track, not the only practice

**Decision:** Use OrderFlow to learn concepts in realistic context while maintaining recurring standalone DSA and interview-design practice. Teach theory before feature implementation, test meaningful behavior, add failure scenarios and a learner exercise where useful, and record learning plus revision needs. Use isolated concurrency experiments for topics that would be artificial in application code.

**Why:** Product engineering requires integration practice, while interview fluency and foundational concurrency concepts also benefit from focused exercises. Keeping both tracks avoids either unrelated-course drift or forcing every topic into production code.
