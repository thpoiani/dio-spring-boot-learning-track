# DIO Spring Boot - Course 00: DDD Introduction (catalog)

## Introduction

This module starts the track with Domain-Driven Design (DDD) fundamentals in a small Spring Boot application.

The goal is to understand domain/application/infrastructure boundaries before introducing web APIs.

## Code Context

This project models a simple catalog flow: add a book from an ISBN.

Primary flow:

1. Create an `Isbn` value object.
2. Execute `AddBookToCatalogUseCase`.
3. Fetch external data using `BookSearchGateway`.
4. Build domain entity `Book`.
5. Persist through `BookRepository`.

## Project Structure

- `src/main/java/dio/catalog/domain`
  - Domain model and contracts.
- `src/main/java/dio/catalog/application`
  - Use cases and application ports.
- `src/main/java/dio/catalog/infrastructure`
  - Technical adapters (JPA, external client).

## Module-Specific Topics

### Test-first entry point

There is no web layer in this module.

Start from:

- `src/test/java/dio/catalog/application/AddBookToCatalogUseCaseTest.java`

### Integration testing with Testcontainers

The main test uses a real PostgreSQL container to validate persistence behavior.

## Shared Architecture References

Common architecture concepts are documented in the root README:

- DDD layers: `../README.md#ddd-layered-architecture`
- Class vs record: `../README.md#java-class-vs-java-record-in-domain-modeling`
- Strong typed identifiers: `../README.md#strong-typed-identifiers`
- Repository pattern: `../README.md#repository-pattern`
- Use cases and Clean Architecture: `../README.md#use-cases-and-clean-architecture`
- Docker Compose support: `../README.md#docker-compose-support-in-development`

## How to Run

Run the main scenario test:

```bash
./gradlew test --tests "dio.catalog.application.AddBookToCatalogUseCaseTest"
```

## Notes

- Educational project focused on architecture fundamentals.
- The absence of a web layer is intentional at this stage.
