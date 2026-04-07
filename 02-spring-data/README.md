# DIO Spring Boot - Course 02: Spring Data (marketplace)

## Introduction

This module explores Spring Data in a modular, DDD-oriented application.

The goal is to show how different bounded contexts can use different persistence technologies while preserving architectural consistency.

## Code Context

The project simulates a marketplace with three main contexts:

- `registration`: customer registration
- `catalog`: event catalog and metadata
- `ticketing`: seat selection and lock control

Data technologies used in the module:

- MySQL
- MongoDB
- PostgreSQL
- Redis

## Project Structure

Common context structure:

```text
<context>/
  domain/          -> entities, value objects, contracts
  application/     -> use cases and orchestration
  infrastructure/  -> adapters (REST, JPA, Mongo, Redis, listeners)
```

## Module-Specific Topics

### Multi-database strategy

- Relational and document stores are used based on context needs.
- Redis is used for cache and short-lived lock scenarios.

### Caching and seat locking

- Read-oriented flows can use cache annotations.
- Seat lock keys combine `eventId` and `seatId` with TTL to reduce concurrency collisions.

### Event-driven integration

- The module demonstrates event publication/consumption between contexts.
- Different listener styles appear in repository, JPA, and Mongo integration points.

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
./gradlew bootRun
./gradlew test
```

## Notes

- Educational module focused on persistence trade-offs and modular data architecture.
- Infrastructure services are defined in `compose.yml` for local development support.
