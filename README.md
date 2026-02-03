Assignment 4 – SOLID Architecture & Advanced OOP
Car Rental Management System

Course: Object-Oriented Programming
Assignment: Milestone 2 (Assignment 4)
Topic: Car Rental
Language: Java
Database: PostgreSQL
Based on: Assignment 3

Project Overview

This project is a Car Rental Management System developed in Java with PostgreSQL.
It is a continuation of Assignment 3, refactored to meet Assignment 4 requirements, focusing on:

SOLID principles

Layered architecture

Advanced OOP features

Clean separation of concerns

Proper JDBC usage

The goal of Assignment 4 is architectural quality, not feature complexity.

A. SOLID Documentation
Single Responsibility Principle (SRP)

Each class has one responsibility:

Model classes (Car, Customer, Rental) represent domain data

CarRepository handles database access (JDBC)

RentalService handles business logic and validation

Utility classes handle sorting and reflection

Main acts as controller/driver

Open–Closed Principle (OCP)

The system is extensible without modifying existing logic:

Car is abstract

EconomyCar and LuxuryCar extend Car

New car types can be added as new subclasses

Liskov Substitution Principle (LSP)

Subclasses can replace the base class safely:

EconomyCar and LuxuryCar are used through Car references

Overridden methods preserve correct behavior

Interface Segregation Principle (ISP)

Small, focused interfaces are used:

Validatable for validation logic

PricedItem for pricing behavior

Classes implement only what they need.

Dependency Inversion Principle (DIP)

High-level modules depend on abstractions:

RentalService depends on CarRepositoryInterface

Repository implementation is injected via constructor

B. Advanced OOP Features
Generics

A generic CRUD interface is implemented:

CrudRepository<T>

Improves reusability and type safety

Lambdas

Lambda expressions are used for sorting cars by price:

Implemented in SortingUtils

Demonstrated at runtime (ss 4)

Reflection

Reflection (RTTI) is demonstrated using ReflectionUtils:

Prints class name, fields, and methods

Executed at runtime (ss 3)

Interface Default & Static Methods

The Validatable interface contains:

a default method (isValid)

a static helper method

C. OOP Documentation
Abstract Class & Subclasses

BaseEntity → abstract parent

Car → abstract child

EconomyCar, LuxuryCar → concrete subclasses

Composition

Rental has a Car

Rental has a Customer

Polymorphism

Pricing logic is overridden in subclasses

Objects are handled via base class references

UML Diagram

An updated UML diagram is included showing:

inheritance

interfaces

composition

service–repository dependency

D. Database Section
Schema

Tables:

cars

customers

rentals

Constraints

Primary keys on all tables

Foreign keys:

rentals.car_id → cars.id

rentals.customer_id → customers.id

CHECK constraints on numeric values

Sample Inserts
INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Toyota Corolla', 'ECONOMY', 50, true);

INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Mercedes S-Class', 'LUXURY', 150, true);

E. Architecture Explanation
Layered Architecture
Main (Controller)
   ↓
RentalService (Service)
   ↓
CarRepository (Repository)
   ↓
PostgreSQL Database

Example Flow

Main calls a service method

Service validates input

Repository executes SQL via JDBC

Result is returned and printed

F. Execution Instructions
Requirements

Java JDK 17+

PostgreSQL

PostgreSQL JDBC Driver

How to Run

Create tables using schema.sql

Configure DB credentials in DatabaseConnection

Compile the project

Run Main.java

G. Screenshots

Screenshots are located in docs/screenshots/:

ss 1 – Successful CRUD operations

ss 2 – Validation failure

ss 3 – Reflection utility output

ss 4 – Lambda-based sorting

H. Reflection
What I Learned

Applying SOLID principles in a real project

Designing clean layered architecture

Using generics, lambdas, and reflection in practice

Challenges

Correctly applying dependency inversion

Understanding reflection output

Keeping architecture clean without overengineering

Value of SOLID Architecture

SOLID principles improved:

maintainability

extensibility

readability

real-world applicability of the code

Conclusion

This project fully satisfies Assignment 4 requirements, building on Assignment 3 and demonstrating:

SOLID principles

Advanced OOP features

Clean Java architecture

Proper SQL integration
