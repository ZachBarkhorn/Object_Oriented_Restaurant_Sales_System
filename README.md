## Object-Oriented Automated Restaurant System 

A text-based automated restaurant management system built in Java using object-oriented principles and multiple design patterns. The system simulates restaurant operations such as ordering, tab generation, multi-table management, and dynamic menu selection, with a strong focus on extensibility and clean architecture.

## Motivation

This project was developed as a part of my coursework to apply object-oriented design principles and industry-standard design patterns to a realistic domain problem. The goal was to design a restaurant system that is modular, scalable, and easy to extend without modifying existing, stable code.

## Core Features

Text-based user interface for restaurant operations

Order placement using menu item identifiers

Automated tab generation combining order and menu data

Support for multiple tables within the restaurant

Dynamic menu selection (e.g., entrees, appetizers, desserts)

Daily sales tracking across all tables

## Design Patterns Used

# Command Pattern (Core Architecture)

The system is built around the Command design pattern, allowing user actions to be encapsulated as objects and executed in a decoupled manner.

Key components:

SystemInterface
Defines the available user actions and serves as the entry point from the UI.

Invoker
Creates and executes command objects corresponding to user actions.

Command Interface & Concrete Command Classes
Each user operation is implemented as its own command class.

Aggregator
Maintains references to the Menu and Orders objects and provides controlled access to shared system data.

Menu / MenuItem
Stores menu items including item number, description, and cost.

Orders / OrderItem
Stores placed orders using item numbers only, maintaining separation from menu descriptions.

Tab
Aggregates menu and order data to generate a readable tab for display.

This design cleanly separates the user interface from business logic and allows new commands to be added without modifying existing code.

# Observer Pattern (Multi-Table Management)

The Observer pattern was implemented to support multiple tables operating independently within the restaurant.

A RestaurantManager class observes table state changes

Tables notify the manager when orders are placed or when their state changes

The manager aggregates total sales across all tables

Tables remain fully decoupled from manager logic

This approach enables scalable table management while adhering to the open/closed principle.

# Strategy Pattern (Dynamic Menu Selection)

The Strategy pattern enables the system to support multiple menus without tightly coupling menu logic.

Each menu is implemented as a separate strategy

All menus share a common MenuStrategy interface

Menus can be swapped at runtime using a setStrategy method

New menus can be added without modifying existing implementations

This allows seamless menu expansion while minimizing risk to existing functionality.

## System Architecture Overview

Language: Java

Interface: Text-based console UI

Architecture: Object-oriented, pattern-driven

Design Patterns:

Command

Observer

Strategy

## Key Design Benefits

Strong separation of concerns

Highly extensible architecture

Low coupling between system components

Adherence to SOLID design principles

Easy addition of new features without refactoring

## Future Improvements

Persistent storage for orders and sales data

Graphical user interface

Role-based access (server vs. manager)

Payment and receipt processing

Integration with external ordering systems
