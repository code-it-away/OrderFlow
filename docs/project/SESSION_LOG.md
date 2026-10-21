# Session log

## 2026-10-21 — Teaching mode adjusted to scaffold-first

- The user clarified that they want to author substantive logic and tests rather than receive complete implementations.
- Updated `AGENTS.md`, `ROADMAP.md`, and `TASKS.md`: default to theory plus starter structure/TODOs, learner-written logic/tests, then review and graduated hints. Give a full solution only when asked or for a small teaching example.
- The order lifecycle implementation already exists from this session; use it as a reference and keep subsequent features scaffold-first.
- Learning progress: user has not yet completed the lifecycle code-reading exercise. Needs revision will be identified from their explanation and code.
- Next: have the user explain the transition invariant and immutability in the existing lifecycle feature; for the next implementation task, leave substantive code and test assertions to the user.

## 2026-10-21 — Order lifecycle started

- Worked on `feature/order-lifecycle` in `/Users/arpitmalviya/Documents/OrderFlow`.
- Added `OrderStatus`, immutable `Order`, and `InvalidOrderTransitionException`; added parameterized allowed/disallowed transition tests and checks for identity preservation and unchanged original state.
- Regenerated the missing Maven Wrapper metadata in this project copy. Wrapper pins Maven 3.10.0.
- Verified the focused lifecycle suite through the wrapper on Java 21: 14 tests passed.
- Full-suite attempt: 14 lifecycle tests passed, but the pre-existing Spring context test errored when Mockito could not self-attach Byte Buddy under the managed environment. The context started; full-suite green status remains unverified.
- Concepts covered: finite state machines, domain invariants, aggregate transition methods, immutable state replacement, domain exceptions, and testing allowed plus rejected paths.
- Learning exercise pending: explain why the transition graph lives in `OrderStatus`, why `Order.transitionTo` preserves identity, and how the tests prove an invalid transition leaves the original order unchanged. Review whether the lifecycle statuses fit the intended product flow.
- Needs revision: not yet assessed; update this after the learner exercise.
- Next: discuss the lifecycle exercise and refine the domain rules if needed; do not add persistence or APIs in this task.

## 2026-10-20 — Learning strategy updated

- Clarified that OrderFlow is the primary integrated project and is complemented by standalone practice.
- Updated the roadmap with a theory-to-implementation cycle, integrated backend learning phases, a deliberate Java concurrency lab, recurring DSA practice, and standalone interview-design prompts.
- Added durable per-feature teaching expectations to `AGENTS.md` and tracked the recurring practice tracks in `TASKS.md`.
- Learned/reinforced: realistic application context and isolated foundational experiments serve different learning goals; topics should be placed where they are easiest to understand and verify.
- Needs revision: none newly assessed in this documentation-only update; record specific topics after learner exercises.
- Next: user review of the foundation and strategy; after approval begin the order lifecycle task.

## 2026-10-19 — Foundation established

- Inspected an empty workspace and available tool versions; initialized a local Git repository without commits.
- Created the minimal Spring Boot source layout, a smoke test, and project operating documents.
- Did not run a Maven build: Maven is unavailable. Did not create a Maven Wrapper because generating it requires Maven or obtaining wrapper artifacts.
- Next: provide JDK 21 and Maven, run the test suite, then generate and verify the wrapper.

## 2026-10-20 — Homebrew prerequisite installation attempted

- Confirmed Homebrew 7.0.9 is present; JDK 21 and Maven are not installed.
- Attempted `brew install openjdk@21 maven`. Homebrew bottle verification failed because this managed execution environment blocks macOS `sandbox-exec` (`sandbox_apply: Operation not permitted`). A retry to skip Homebrew's nested sandbox was refused because Homebrew uses the default prefix; elevated execution was rejected by the environment policy.
- Verified afterward that `java` remains OpenJDK 27 and `mvn` is still unavailable. No project files or Homebrew packages were changed by the failed attempts.
- The user subsequently installed the prerequisites outside the managed sandbox.

## 2026-10-20 — Foundation verified

- Confirmed Homebrew OpenJDK 21.0.12.1 and Maven 3.10.0 are installed alongside Java 27. The shell default remains Java 27.
- Ran `mvn test` with `JAVA_HOME` set to the JDK 21 Homebrew path: BUILD SUCCESS, 1 test passed.
- Generated the Maven Wrapper with `mvn -N wrapper:wrapper`; it pins Maven 3.10.0.
- Ran `./mvnw test` with JDK 21: BUILD SUCCESS, 1 test passed.
- Concepts: `JAVA_HOME` selects the JDK used by Maven; the Maven Wrapper provides a project-pinned Maven distribution and repeatable build entry point.
- Next: user review of the foundation. After approval, model order status transitions and test both valid and invalid transitions.
