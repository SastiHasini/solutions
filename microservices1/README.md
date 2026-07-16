# Microservices1

This folder contains two independent Spring Boot REST microservices:

- Account service
- Loan service

## Structure

- account/
- loan/

## Run the Account service

```bash
cd account
mvn spring-boot:run
```

Then open:

- http://localhost:8080/accounts/00987987973432

## Run the Loan service

```bash
cd loan
mvn spring-boot:run
```

Then open:

- http://localhost:8081/loans/H00987987972342
