# DIO Spring Boot - Course 03: Spring Security (proposal-management)

## Introduction

This module introduces authentication and authorization in Spring Boot applications using Spring Security.

The implementation keeps a DDD-oriented structure so security concerns integrate without collapsing architectural boundaries.

## Code Context

The project provides a proposal management API with two main modules:

- `auth`: identity, authentication flow, and authorization setup
- `proposal`: proposal lifecycle and access-scoped listing

Typical flow:

1. User logs in through a REST endpoint.
2. Session context is established.
3. Proposal actions are authorized based on role and scope.

## Project Structure

~~- `src/main/java/dio/proposalmanagement/auth`
  - Security configuration and user integration.
- `src/main/java/dio/proposalmanagement/proposal/domain`~~
  - Proposal model and domain contracts.
- `src/main/java/dio/proposalmanagement/proposal/application`
  - Use cases and listing strategies.
- `src/main/java/dio/proposalmanagement/proposal/infrastructure`
  - HTTP and JPA adapters.

## Module-Specific Topics

### REST authentication

- Login endpoint: `POST /api/auth/login`.
- `RestUsernamePasswordAuthenticationFilter` reads JSON credentials.
- `SecurityConfig` centralizes endpoint protection rules.

### Stateful session model

- The module uses HTTP session-based authentication.
- This highlights default Spring Security behavior before token-based variants.

### Context boundary signal

- `proposal` uses `Owner` as a domain concept instead of directly exposing `User` semantics.
- This supports clearer bounded-context evolution.

## Shared Architecture References

Common architecture concepts are documented in the root README:

- DDD layers: `../README.md#ddd-layered-architecture`
- Class vs record: `../README.md#java-class-vs-java-record-in-domain-modeling`
- Strong typed identifiers: `../README.md#strong-typed-identifiers`
- Repository pattern: `../README.md#repository-pattern`
- Use cases and Clean Architecture: `../README.md#use-cases-and-clean-architecture`
- Docker Compose support: `../README.md#docker-compose-support-in-development`

## How to Run

```bash
./gradlew bootRun
./gradlew test
```

Example login request:

```bash
curl -i -c cookies.txt \
  -H "Content-Type: application/json" \
  -d '{"username":"fitness_vibe","password":"password"}' \
  http://localhost:8080/api/auth/login
```

## Notes

- Educational module focused on applying security in layered architecture.
- Session-based auth can later evolve to stateless token strategies.
