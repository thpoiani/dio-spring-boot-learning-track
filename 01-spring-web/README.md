# DIO Spring Boot - Course 01: Spring Web (task-manager)

## Introduction

This module introduces REST API development with Spring Boot while preserving the architecture boundaries established in Course 00.

The focus is to connect HTTP endpoints to use cases without moving business rules into controllers.

## Code Context

The project implements a task management API with CRUD operations:

- create task
- list tasks
- get task by id
- update task
- delete task

## Project Structure

- `src/main/java/dio/taskmanager/domain`
  - Domain model and contracts.
- `src/main/java/dio/taskmanager/application`
  - Use cases and input/output models.
- `src/main/java/dio/taskmanager/infrastructure`
  - HTTP controller, exception mapping, and technical adapters.

## Module-Specific Topics

### Spring Web adapter

- `TaskController` exposes `/tasks` endpoints.
- Request validation uses `@Valid` and Jakarta Validation.
- `GlobalExceptionHandler` maps domain/application errors to HTTP responses.

### API documentation with Spring REST Docs

- `TaskControllerTest` generates snippets in `build/generated-snippets`.
- Asciidoctor assembles documentation from tested behavior.

## Shared Architecture References

Common architecture concepts are documented in the root README:

- [DDD layers](../README.md#ddd-layered-architecture)
- [Class vs record](../README.md#java-class-vs-java-record-in-domain-modeling)
- [Strong typed identifiers](../README.md#strong-typed-identifiers)
- [Repository pattern](../README.md#repository-pattern)
- [Use cases and Clean Architecture](../README.md#use-cases-and-clean-architecture)
- [Docker Compose support](../README.md#docker-compose-support-in-development)

## How to Run

```bash
./gradlew test
./gradlew asciidoctor
./gradlew bootRun
```

Useful paths:

- `build/generated-snippets`
- `src/docs/asciidoc/index.adoc`

## Notes

- Educational module focused on web adapters and API boundaries.
- In-memory persistence keeps the module focused on HTTP and use case flow.
