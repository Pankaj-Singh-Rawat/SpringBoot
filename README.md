# 🍃 Spring Boot Intensive: From Zero to API Pro

This repository is a **day-by-day learning log** documenting my journey of mastering the **Spring Boot Framework** — starting from core HTTP concepts and evolving into **production-ready backend APIs**.

It covers everything from:
- Basic HTTP & JSON
- Layered architecture
- Dependency Injection
- JPA & persistence
- DTO patterns
- Validation, logging, and global exception handling

This repo acts as both a **learning reference** and a **backend development roadmap**.

---

## 🚀 Overview

The goal of this repository is to build a **strong backend foundation** using Spring Boot by learning and implementing concepts **incrementally**, day by day, just like in real-world backend projects.

Each folder represents a **self-contained milestone** in the learning process.

---

## 📂 Project Roadmap & Structure

```text
.
├── 📂 Day-1                 # HTTP Fundamentals, JSON & API Basics
├── 📂 Day-2                 # First Web App & Layered Architecture
├── 📂 Day-3                 # Dependency Injection & Component Scanning
├── 📂 Day-4                 # Configuration: Profiles, YAML vs Properties
├── 📂 Day-5                 # JPA Persistence, Repositories & Exception Handling
├── 📂 Day-6                 # DTO Pattern & Data Validation
├── 📂 Day-7                 # Logging & Professional API Error Handling
└── 📂 Day-7-ReviewPhase     # Final review & project consolidation
```

## 🚀 Daily Breakdown
### 🔹 Day 1: Web Fundamentals

### Understanding how the web works:
 - HTTP methods (GET, POST, PUT, DELETE)
 - Client–Server architecture
 - JSON structure & formatting
 - Basic API concepts

### 🔹 Day 2 & Day 3: Layered Architecture & Dependency Injection

#### Moving from monolithic code to clean architecture:
 - Controller layer (handling HTTP requests)
 - Service layer (business logic)
 - Model / Entity layer (data representation)
 - Dependency Injection (DI)
 - Inversion of Control (IoC)
 - Component Scanning

### 🔹 Day 4: Externalized Configuration

#### Managing real-world environments:
 - Application profiles (dev / prod)
 - application.yml vs application.properties
 - Using @Configuration and @Bean
 - Environment-based configuration switching

### 🔹 Day 5: Data Persistence & Exception Handling

#### Connecting APIs to databases:
 - Spring Data JPA
 - Entity & Repository design
 - CRUD operations

#### Centralized exception handling using:
 - @ControllerAdvice
 - @ExceptionHandler

### 🔹 Day 6: DTO Pattern & Validation

#### Decoupling the database layer from the API:
 - Request & Response DTOs
 - Data validation before reaching service logic
 - Cleaner, safer, and more maintainable APIs

### 🔹 Day 7: Production-Ready Features

#### Finalizing backend best practices:
 - Logging using SLF4J & Logback
 - Writing logs to app.log
 - Global API error responses
 - Custom ApiError structure
 - Cleaner and standardized error handling

## 🛠️ Tech Stack

Language: Java
Framework: Spring Boot (Web, Data JPA)
Build Tool: Maven (using mvnw wrapper)
Configuration: YAML & Properties
Logging: SLF4J + Logback
Documentation: PDF guides included per module

## 🚦 Getting Started
### ✅ Prerequisites
 - Java JDK 17 or higher
 - IDE: IntelliJ IDEA / VS Code / Eclipse

### ▶️ How to Run

 - Each day is an independent Spring Boot project.
 - Navigate to the desired day before running.

# Example: Running Day 7 project

```text
cd Day-7/Day7
./mvnw spring-boot:run
```

## 📈 Current Status & Roadmap

  - HTTP & JSON Fundamentals
  - Spring Boot Layered Architecture
  - Dependency Injection & Beans
  - JPA & Hibernate Integration
  - DTO Pattern & Validation
  - Logging & Global Exception Handling
  - Spring Security & JWT (Upcoming)
  - Unit & Integration Testing (Upcoming)

## 🤝 Contributing

This is primarily a personal learning repository, but contributions are welcome!
If you:
Find a bug
See an optimization opportunity
Want to improve service-layer logic
Feel free to open a Pull Request 🚀

## 👤 Author

Pankaj Singh Rawat
Learning Path: Java Backend Development
Created to document progress and master the Spring ecosystem.

## 📜 License

This project is intended for educational purposes.
You are free to use, modify, and learn from this repository.

⭐ If this repo helps you, consider starring it!
