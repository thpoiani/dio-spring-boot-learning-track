# DIO Spring Boot Learning Track

This repository contains a DIO Spring Boot learning track organized as incremental modules.

The track starts with architecture foundations and progressively moves through web APIs, data access, security, service integration, and AI-enabled workflows.

<img width="2752" height="1536" alt="unnamed" src="https://github.com/user-attachments/assets/a7bcbe19-4d0c-4395-8696-8c64be22764f" />

## Modules

- `00-domain-driven-design/`  
  DDD foundations with a catalog domain and no web layer.
- `01-spring-web/`  
  REST API design with Spring Web and API documentation with Spring REST Docs.
- `02-spring-data/`  
  Data access in a multi-context application using MySQL, MongoDB, Redis, and PostgreSQL.
- `03-spring-security/`  
  Authentication and authorization with Spring Security in a proposal management API.
- `04-spring-cloud-openfeign/`  
  External service integration (KYC/AML) using Spring Cloud OpenFeign and resilience patterns.
- `05-spring-ai/`  
  Final project using Spring AI for speech-to-text, tool calling, and text-to-speech.

## Recommended Study Order

1. `00-domain-driven-design`
2. `01-spring-web`
3. `02-spring-data`
4. `03-spring-security`
5. `04-spring-cloud-openfeign`
6. `05-spring-ai`

---

## Shared Architecture Guide

The sections below consolidate architecture topics that are intentionally reused across modules.

### DDD Layered Architecture

Most modules follow the same conceptual split:

```text
domain/          -> business model, invariants, contracts
application/     -> use cases, orchestration, application policies
infrastructure/  -> adapters (HTTP, persistence, external clients, framework glue)
```

Why this matters:

- `domain` stays focused on business language and rules, not framework details.
- `application` coordinates domain behavior for specific user/business actions.
- `infrastructure` can change (database, web transport, external APIs) without forcing core business rewrites.

This separation reduces coupling and supports long-term maintainability.

### Java Class vs Java Record in Domain Modeling

A practical guideline used across the track:

- Use `class` for entities/aggregates that have identity and may evolve behavior over time.
- Use `record` for immutable value objects and DTO-style transport models.

Design trade-offs:

- `class` supports richer lifecycle behavior and controlled mutation.
- `record` reduces boilerplate and makes immutability explicit.

This distinction improves code intent and keeps domain concepts clearer.

### Strong Typed Identifiers

Instead of passing raw primitives (`UUID`, `String`) everywhere, modules wrap identifiers in explicit types such as `BookId`, `TaskId`, `ProposalId`, and `TransactionId`.

Benefits:

- Better compile-time safety (fewer accidental ID mix-ups).
- More expressive signatures (`findById(TaskId id)` communicates intent).
- Cleaner evolution path for ID rules and validation.

### Repository Pattern

The repository contract belongs to the business side, while technology-specific implementations stay in infrastructure.

Pattern used in this repository:

- Domain contract: `XxxRepository` in `domain/`.
- Adapter implementation: JPA/in-memory/etc. in `infrastructure/`.

Architectural impact:

- Business logic depends on abstractions, not persistence frameworks.
- Switching storage technology becomes an adapter change, not a domain rewrite.
- Unit testing use cases becomes simpler with fake/mock repositories.

### Use Cases and Clean Architecture

Each use case models one business capability (for example, create task, list proposals, analyze company risk).

Common flow:

1. Controller/listener receives an external request.
2. It calls one application use case.
3. The use case orchestrates domain objects and repository/gateway contracts.
4. Infrastructure adapters handle persistence or external integrations.

Why this is important:

- Strong single-responsibility boundaries.
- Easier testability and refactoring.
- Better readability of business workflows.

### Docker Compose Support in Development

Several modules include `compose.yml` and Spring Boot Docker Compose support.

Typical local development role:

- Start required infra services (database/cache/message dependencies).
- Keep local setup reproducible for all students.
- Reduce onboarding friction by standardizing environment dependencies.

Note: exact behavior can vary by module configuration and runtime profile.

---

## Quick Start

Choose a module and run its local instructions:

```bash
cd 01-spring-web
./gradlew test
```

For module-specific details, always check that module's `README.md`.
