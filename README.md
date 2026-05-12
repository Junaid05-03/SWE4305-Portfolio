# SWE4305 - Object Oriented Programming Portfolio

**Student:** Junaid Qureshi  
**Student ID:** 100167140  
**Tutor:** Nick Shepherd  
**Institution:** University of Bolton - Burnley Campus  
**Module:** SWE4305 - Object Oriented Programming  
**Submission Date:** May 2026  

---

## Overview

This repository contains the complete portfolio for the SWE4305 Object Oriented Programming module. The portfolio demonstrates progression from basic Java input/output through to two fully functional object-oriented applications, covering all four OOP principles: encapsulation, inheritance, polymorphism and abstraction.

---

## Repository Structure

```
SWE4305-Portfolio/
├── Weekly-Exercises/
│   ├── Week1/          # Input and Output (Exercises 1-9)
│   ├── Week2/          # Iteration and Selection (Exercises 1-9)
│   ├── Week3/          # Classes and Objects
│   ├── Week4/          # Data Structures and Collections
│   └── Week5/          # Consolidation - Stock Management System
├── ProjectA-Playlist/
│   ├── src/            # Song.java, PlaylistManager.java, Main.java
│   └── UML/            # PA_UseCase.svg, PA_ClassDiagram.svg
├── ProjectB-StudentPerformance/
│   ├── src/            # All 9 Java class files
│   └── UML/            # PB_UseCase.svg, PB_ClassDiagram.svg
├── Documentation/
│   └── SWE4305_Portfolio_Logbook_Junaid_Qureshi_v2.docx
├── Research/
│   └── Research_Report_Junaid_Qureshi.docx
└── Reflection/
    └── Reflection_Junaid_Qureshi.docx
```

---

## Weekly Exercises

### Week 1 - Input and Output
Nine exercises covering the fundamental building blocks of Java: outputting text with `System.out.println()`, reading user input with the `Scanner` class, arithmetic calculations, data types (`int`, `double`, `String`), operator precedence, `final` constants, and the `java.time` API for date calculations.

| Exercise | Topic |
|----------|-------|
| Exercise 1 | Hello World |
| Exercise 2 | Personal greeting using Scanner |
| Exercise 3 | Rectangle perimeter and area |
| Exercise 4 | Average of two numbers |
| Exercise 5 | Swap two values using a temporary variable |
| Exercise 6 | Birth year calculator using Calendar |
| Exercise 7 | Days old calculator using ChronoUnit |
| Exercise 8 | Feet to miles converter with final constant |
| Exercise 9 | Savings account interest calculator |

### Week 2 - Iteration and Selection
Nine exercises covering control flow using `if-else`, `switch`, `for`, `while` and `do-while`. Key concepts include boundary value testing, the modulo operator for divisibility checks, and `printf()` for formatted output.

| Exercise | Topic |
|----------|-------|
| Exercise 1 | Age check with if-else |
| Exercise 2 | Grade to classification converter using switch |
| Exercise 3 | Output digits 0 to 9 using for loop |
| Exercise 4 | Seven times table |
| Exercise 5 | User-chosen times table |
| Exercise 6 | Do-while loop with restart option |
| Exercise 7 | Exam mark grade calculator with boundary testing |
| Exercise 8 | Print even numbers using modulo |
| Exercise 9 | Feet to miles conversion table using printf |

### Week 3 - Classes and Objects
Introduction to OOP fundamentals. Three classes created: `Student`, `Course` and `Main`. Demonstrates encapsulation with private fields and public getters/setters, the `this` keyword, object associations, and null checking.

### Week 4 - Data Structures and Collections
Extended the Week 3 classes to include data structures. Uses a `Grade` enum for type-safe grade values, an `int[]` array for fixed-size mark storage, and `ArrayList<Module>` for dynamic module collections. Includes extension statistics showing mean, min and max marks per module.

### Week 5 - Consolidation
A multi-class stock management system demonstrating separation of concerns. Four classes: `Product`, `StockList`, `StockDemo` and `Main`. Key learning: fixing a `ConcurrentModificationException` caused by modifying an ArrayList during iteration, and implementing case-insensitive search with `equalsIgnoreCase()`.

---

## Project A - Playlist Application

A console-based music playlist manager built in Java, populated with Urdu, Hindi and Qawwali music.

### Features
- View all songs in a formatted table with play count
- Add a song with full input validation and duplicate detection
- Remove a song by title (case-insensitive)
- Filter songs above a minimum play count
- Search songs by artist name

### OOP Concepts Demonstrated
- **Encapsulation:** `Song` class with private fields and public getters/setters
- **Collections:** `ArrayList<Song>` managed by `PlaylistManager`
- **Validation:** Empty string rejection, negative play count rejection, duplicate detection
- **Exception handling:** `try-catch` for all numeric input

### Classes
| Class | Responsibility |
|-------|---------------|
| `Song` | Encapsulates song data (title, artist, play count) |
| `PlaylistManager` | Manages the ArrayList and all business logic |
| `Main` | Interactive menu using do-while loop |

### How to Run
```bash
cd ProjectA-Playlist/src
javac Song.java PlaylistManager.java Main.java
java Main
```

---

## Project B - Student Performance System

A console-based student marks management system demonstrating all four OOP principles with full CRUD operations, statistical analysis and grade reporting.

### Features
- Add, edit and delete students and modules
- Enter and update marks (validated 0-100)
- View marks by student or by module
- Module statistics (mean, minimum, maximum)
- Grade distribution showing percentage per grade
- Full student report across all modules

### OOP Principles Demonstrated
- **Encapsulation:** All fields private across all classes with public getters/setters
- **Inheritance:** `Student extends Person` (abstract base class)
- **Polymorphism:** `print()` overridden in `Student` with `@Override`
- **Abstraction:** `Person` declared abstract, cannot be instantiated directly
- **HashMap:** Used in `StudentManager` and `ModuleManager` for O(1) lookup by ID

### Classes
| Class | Type | Responsibility |
|-------|------|---------------|
| `Person` | Abstract | Base class with id and name |
| `Student` | Extends Person | Adds email and module enrolment |
| `Module` | Concrete | Module code, name and credits |
| `Mark` | Concrete | Links student to module with a value |
| `Grade` | Enum | Type-safe grade values A, B, C, D, F |
| `StudentManager` | Manager | HashMap-based student CRUD |
| `ModuleManager` | Manager | HashMap-based module CRUD |
| `MarkManager` | Manager | Mark storage and statistics |
| `Main` | Entry point | Full menu system |

### How to Run
```bash
cd ProjectB-StudentPerformance/src
javac Grade.java Person.java Student.java Module.java Mark.java StudentManager.java ModuleManager.java MarkManager.java Main.java
java Main
```

---

## Documentation

| Document | Description |
|----------|-------------|
| Portfolio Logbook | Full evidence logbook covering all exercises and projects with code, testing tables, evaluation and reflective review |
| Research Report | 1,500-word academic report on OOP principles with 10 Harvard references |
| Reflective Review | Personal reflection on learning progression, challenges and development |

---

## Technologies Used

- **Language:** Java (JDK 17)
- **IDE:** Visual Studio Code
- **Version Control:** Git and GitHub
- **Build:** javac (Java compiler via terminal)

---

## Key Learning Points

- The difference between `next()` and `nextLine()` in Java Scanner input handling
- Fixing a `ConcurrentModificationException` by exiting a loop before modifying the collection
- Why `HashMap` provides O(1) lookup compared to O(n) for ArrayList iteration
- The difference between compile-time (static) and runtime (dynamic) polymorphism
- How abstract classes and interfaces enforce design contracts

---

*SWE4305 Object Oriented Programming | University of Bolton | May 2026*
