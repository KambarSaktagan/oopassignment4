Assignment 4 – SOLID Architecture & Advanced OOP
Car Rental Management System

Course: Object-Oriented Programming
Assignment: Milestone 2 (Assignment 4)
Topic: Car Rental
Language: Java
Database: PostgreSQL
Based on: Assignment 3


Project Overview

This project is a Car Rental Management System developed in Java using Object-Oriented Programming principles and PostgreSQL with JDBC.

It is a continuation of Assignment 3 and focuses on architectural quality rather than feature complexity. The project emphasizes SOLID principles, layered architecture, advanced OOP features, clean separation of concerns, and proper JDBC usage.

The application is console-based and simulates backend behavior using service and repository layers.


A. SOLID Documentation

Single Responsibility Principle (SRP)

Each class in the system has exactly one responsibility:
- Car, EconomyCar, LuxuryCar, Customer, and Rental represent domain data and related behavior.
- CarRepository is responsible only for database access using JDBC.
- RentalService handles business logic and validation.
- Utility classes handle sorting and reflection.
- Main acts as the controller/driver coordinating execution.

Open–Closed Principle (OCP)

The system is open for extension but closed for modification:
- Car is an abstract class.
- EconomyCar and LuxuryCar extend Car.
- New car types can be added as subclasses without modifying existing logic.

Liskov Substitution Principle (LSP)

Subclasses safely replace the base class:
- EconomyCar and LuxuryCar are used through Car references.
- Overridden methods preserve correct behavior and expectations.

Interface Segregation Principle (ISP)

Small, focused interfaces are used:
- Validatable defines validation behavior.
- PricedItem defines pricing behavior.
Classes implement only the interfaces they need.

Dependency Inversion Principle (DIP)

High-level modules depend on abstractions:
- RentalService depends on CarRepositoryInterface.
- CarRepository implements the interface.
- Repository is injected via constructor.


B. Advanced OOP Features

Generics

Generics are used through CrudRepository<T>:
- Provides reusable CRUD operations.
- Ensures type safety.
- Reduces duplicated repository code.

Lambdas

Lambda expressions are used to sort cars by price:
- Implemented using a comparator.
- Demonstrated at runtime

Reflection

Reflection (RTTI) is demonstrated using a reflection utility:
- Prints class name and methods at runtime.
- Demonstrated in console output

Interface Default and Static Methods

The Validatable interface contains:
- A default validation method.
- A static helper method.


C. OOP Documentation

Abstract Class and Subclasses

- BaseEntity is an abstract base class.
- Car is an abstract subclass of BaseEntity.
- EconomyCar and LuxuryCar are concrete subclasses.

Composition Relationships

- Rental has a Car.
- Rental has a Customer.

Polymorphism Examples

- Pricing behavior is overridden in subclasses.
- Objects are handled via Car base-class references.

UML Diagram

<img width="1057" height="504" alt="umldiagram" src="https://github.com/user-attachments/assets/c53aab9e-af02-44b3-a319-554b2f3c753a" />

D. Database Section

Schema

Tables:
- cars
- customers
- rentals

Constraints

- Primary keys on all tables.
- Foreign keys:
  rentals.car_id → cars.id
  rentals.customer_id → customers.id
- CHECK constraints ensure valid numeric values.

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

Request / Response Example

1. Main calls a method in RentalService.
2. RentalService validates input.
3. CarRepository executes SQL via JDBC.
4. Results are returned and printed.


F. Execution Instructions

Requirements

- Java JDK 17 or higher
- PostgreSQL database
- PostgreSQL JDBC Driver

How to Compile and Run

1. Create database tables using the SQL schema.
2. Ensure PostgreSQL is running.
3. Configure database credentials in DatabaseConnection.
4. Add the PostgreSQL JDBC driver to the classpath.
5. Compile the project.
6. Run Main.java.


G. Screenshots

Successful CRUD 
<img width="1822" height="769" alt="ss1" src="https://github.com/user-attachments/assets/e670e5c8-8291-4216-a770-b7f9ac8ab02b" />


Validation Failures
<img width="1811" height="922" alt="ss2" src="https://github.com/user-attachments/assets/6e8321e3-92b7-43bc-9110-a4cb8aadfcf0" />


Reflection Utility Output 
<img width="442" height="270" alt="ss3" src="https://github.com/user-attachments/assets/fcea8b1a-d121-4c1e-bafc-134ebca5ca0e" />


Sorted Lists Showing Lambdas 
<img width="331" height="75" alt="ss4" src="https://github.com/user-attachments/assets/603c30f6-137e-48bc-a378-133dc591ce73" />


H. Reflection

What I Learned

- Applying SOLID principles in a real project.
- Designing clean layered architecture.
- Using generics, lambdas, and reflection effectively.

Challenges

- Applying dependency inversion correctly.
- Managing database state during testing.
- Understanding reflection output.

Value of SOLID Architecture

SOLID principles improved maintainability, extensibility, readability, and real-world applicability of the code.


Conclusion

This project fully satisfies Assignment 4 requirements and demonstrates SOLID architecture, advanced OOP features, clean design, and proper database integration.
