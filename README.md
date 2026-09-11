# Soccor-System
#  Soccer Management System

![Java](https://img.shields.io/badge/Java-JDK_8%2B-orange?style=for-the-badge&logo=java)
![OOP](https://img.shields.io/badge/Architecture-OOP_Principles-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A robust, professional-grade **Soccer Management & Match Simulation System** built in Java. This application demonstrates core Object-Oriented Programming (OOP) concepts by managing 21+ players across pitch positions, coaching staff, real-time disciplinary logging, dynamic match results, and automated league standings.

---

##  Table of Contents
- [Key Features](#-key-features)
- [OOP Architecture & Concepts](#-oop-architecture--concepts)
- [Project Structure](#-project-structure)
- [Installation & Usage](#-installation--usage)
- [Match Simulation Scenario](#-match-simulation-scenario)

---

##  Key Features

* **Squad & Position Allocation**: Assigns up to 21 players with explicit pitch positions (`Goalkeeper`, `Defender`, `Midfielder`, `Forward`).
* **Polymorphic Management**: Processes all participants using a unified abstract `Person[]` structure.
* **Match Simulation Engine**: Handles match logic, goal tracking (scorer, minute, team), and automated winner determination.
* **Disciplinary Action Tracking**: Issues and logs Yellow and Red cards per player in real-time.
* **Analytics & Metrics**:
  * **Player Fitness**: Calculates Body Mass Index (BMI) and health status.
  * **Coach Salary**: Dynamically computes compensation based on experience years and UEFA licences (`UEFA Pro`, `UEFA A`, `UEFA B`).
* **League Table & Standings**: Automatically awards points (Win: 3 pts, Draw: 1 pt, Loss: 0 pts) and prints updated league tables.

---

##  OOP Architecture & Concepts

1. **Abstraction**: `Person.java` acts as an abstract base class defining core properties without direct instantiation.
2. **Inheritance**: `Player.java` and `Coach.java` extend `Person.java`, inheriting core fields while introducing role-specific logic.
3. **Polymorphism**: Dynamic method dispatch is showcased by running overridden methods (e.g., age validation logic) over a heterogeneous `Person[]` array.
4. **Encapsulation**: Strict use of private attributes paired with clean getter and setter mutators.

---

##  Project Structure

```text
src/soccor/
├── Person.java      # Abstract base class for all league participants
├── Player.java      # Player metrics, cards, goals, and BMI calculation
├── Coach.java       # Experience tracking, UEFA licensing, and salary logic
├── Team.java        # Roster container, coach association, and team goals
├── Goal.java        # Goal event metadata (scorer, minute, team)
├── Match.java       # Core engine for scoring, cards, and match outcomes
├── Schedule.java    # League manager generating standings tables
└── Soccor.java      # Main entry point driving the El Clásico match scenario
