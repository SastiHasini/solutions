# Microservices2

This project contains three Spring Cloud microservices:

- Eureka Discovery Server
- Account Service
- Loan Service

## Folder structure

- eureka-discovery-server/
- account-service/
- loan-service/

## Build

Run the following commands from the project root:

```bash
cd eureka-discovery-server
mvn clean package

cd ../account-service
mvn clean package

cd ../loan-service
mvn clean package
```

## Run

### 1. Start Eureka server

```bash
cd eureka-discovery-server
mvn spring-boot:run
```

Open: http://localhost:8761

### 2. Start Account service

```bash
cd account-service
mvn spring-boot:run
```

Test: http://localhost:8080/accounts/00987987973432

### 3. Start Loan service

```bash
cd loan-service
mvn spring-boot:run
```

Test: http://localhost:8081/loans/H00987987972342
