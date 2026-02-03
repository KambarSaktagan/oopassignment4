# Assignment 4 – SOLID Architecture & Advanced OOP  
## Car Rental Management System

**Course:** Object-Oriented Programming  
**Assignment:** Milestone 2 (Assignment 4)  
**Topic:** Car Rental  
**Language:** Java  
**Database:** PostgreSQL  
**Based on:** Assignment 3  

---

## Project Overview

This project is a **Car Rental Management System** developed in Java with PostgreSQL.

It is a continuation of **Assignment 3**, refactored to meet **Assignment 4 requirements**, focusing on:

- SOLID principles  
- Layered architecture  
- Advanced OOP features  
- Clean separation of concerns  
- Proper JDBC usage  

The goal of Assignment 4 is **architectural quality**, not feature complexity.

---

## A. SOLID Documentation

### Single Responsibility Principle (SRP)

Each class has one responsibility:

- Model classes (`Car`, `Customer`, `Rental`) represent domain data  
- `CarRepository` handles database access using JDBC  
- `RentalService` handles business logic and validation  
- Utility classes handle sorting and reflection  
- `Main` acts as the controller/driver  

---

### Open–Closed Principle (OCP)

The system is extensible without modifying existing logic:

- `Car` is an abstract class  
- `EconomyCar` and `LuxuryCar` extend `Car`  
- New car types can be added as new subclasses  

---

### Liskov Substitution Principle (LSP)

Subclasses can safely replace the base class:

- `EconomyCar` and `LuxuryCar` are used through `Car` references  
- Overridden methods preserve correct behavior  

---

### Interface Segregation Principle (ISP)

Small, focused interfaces are used:

- `Validatable` for validation logic  
- `PricedItem` for pricing behavior  

Classes implement only what they need.

---

### Dependency Inversion Principle (DIP)

High-level modules depend on abstractions:

- `RentalService` depends on `CarRepositoryInterface`  
- Repository implementation is injected via constructor  

---

## B. Advanced OOP Features

### Generics

A generic CRUD interface is implemented:

- `CrudRepository<T>`  
- Improves reusability and type safety  

---

### Lambdas

Lambda expressions are used for sorting cars by price:

- Implemented in `SortingUtils`  
- Demonstrated at runtime (**ss 4**)  

---

### Reflection

Reflection (RTTI) is demonstrated using `ReflectionUtils`:

- Prints class name, fields, and methods  
- Executed at runtime (**ss 3**)  

---

### Interface Default and Static Methods

The `Validatable` interface contains:

- A default method (`isValid`)  
- A static helper method  

---

## C. OOP Documentation

### Abstract Class and Subclasses

- `BaseEntity` → abstract parent  
- `Car` → abstract child  
- `EconomyCar`, `LuxuryCar` → concrete subclasses  

---

### Composition

- `Rental` has a `Car`  
- `Rental` has a `Customer`  

---

### Polymorphism

- Pricing logic is overridden in subclasses  
- Objects are handled via base class references  

---

### UML Diagram

An **updated UML diagram** is included showing:

- Inheritance  
- Interfaces  
- Composition  
- Service–repository dependency  

---

## D. Database Section

### Schema

Tables:

- `cars`  
- `customers`  
- `rentals`  

---

### Constraints

- Primary keys on all
