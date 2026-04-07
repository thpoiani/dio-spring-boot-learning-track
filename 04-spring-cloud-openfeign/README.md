# DIO Spring Boot - Course 04: Spring Cloud OpenFeign (compliance)

## Introduction

This module focuses on external service integration using Spring Cloud OpenFeign.

The business scenario is a compliance onboarding workflow with KYC and AML checks.

## Code Context

The project analyzes company risk by combining internal rules with external screening services.

Primary flow:

1. Receive company registration data.
2. Call external KYC and AML endpoints through Feign clients.
3. Map external responses into domain structures.
4. Evaluate risk using compliance policies.
5. Persist the risk assessment.

## Project Structure

- `src/main/java/dio/compliance/domain`
  - Core model, policies, and repository contracts.
- `src/main/java/dio/compliance/application`
  - Main orchestration use case (`AnalyzeCompanyRiskUseCase`).
- `src/main/java/dio/compliance/infrastructure`
  - Feign clients, DTOs, and persistence adapters.

## Module-Specific Topics

### OpenFeign clients

- Declarative HTTP interfaces reduce integration boilerplate.
- Each client encapsulates one external contract.

### Boundary translation

- Integration DTOs are converted into domain-oriented structures.
- Domain logic does not depend on external API formats.

### Resilience strategy

- Feign fallback behavior supports graceful degradation on remote failures.
- The use case remains predictable under partial integration outages.

## Shared Architecture References

Common architecture concepts are documented in the root README:

- DDD layers: `../README.md#ddd-layered-architecture`
- Class vs record: `../README.md#java-class-vs-java-record-in-domain-modeling`
- Strong typed identifiers: `../README.md#strong-typed-identifiers`
- Repository pattern: `../README.md#repository-pattern`
- Use cases and Clean Architecture: `../README.md#use-cases-and-clean-architecture`
- Docker Compose support: `../README.md#docker-compose-support-in-development`

## Mockoon Setup (Local API Simulation)

This module can simulate external KYC and AML services locally using Mockoon.

### What Mockoon is used for here

- Simulate external compliance endpoints without calling real providers.
- Keep local development and demos reproducible.
- Test Feign integration behavior with controlled responses.

### How to install Mockoon

- Go to the official website: `https://mockoon.com/`
- Download the Desktop app for your OS and install it.
- If you prefer CLI usage, use the installation instructions from the official Mockoon docs.

### How to use it in this project

1. Open Mockoon.
2. Import the environment files from:
   - `src/main/resources/mockoon_kyc.json`
   - `src/main/resources/mockoon_aml.json`
3. Start both mock environments.
4. Run the Spring Boot application and call the compliance flow.

## How to Run

```bash
./gradlew test
./gradlew bootRun
```

For local API simulation, check Mockoon files in `src/main/resources`.

## Notes

- Educational module focused on integration boundaries and reliability.
- KYC/AML is used as a realistic domain for external screening workflows.
