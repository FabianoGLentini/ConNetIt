# ConNetIt

**ConNetIt** is a personal connection manager and networking diary designed to help users remember, organize, and nurture their professional and personal relationships.
Unlike traditional platforms like LinkedIn, which emphasize static profiles, ConNetIt focuses on the *context* and *quality* of your interactions, allowing you to tag, describe, and track meaningful details about the people you meet.

---

## Design Preview

The app’s design is based on a Figma prototype I put together:

[**Figma Design Preview**](https://github.com/FabianoGLentini/ConNetIt/blob/main/ConNetIt%20Design.png)

![Design](https://github.com/FabianoGLentini/ConNetIt/blob/main/ConNetIt%20Design.png)

*Note: Implementation of this design is in progress.*

---

## Project Overview

ConNetIt provides a **personalized networking diary** experience that allows users to:

* Add detailed profiles for people they meet.
* Record how they met, mutual interests, or conversation points.
* Tag connections with hobbies, industries, or roles.
* Assign and track connection strength over time.
* Filter and sort connections based on relevance or personal value.

The app is designed to bring humanity and meaningfull memory back into networking.

---

## Why ConNetIt?

This project was motivated by the limitations of existing professional networking platforms.
People are more than job titles and profile summaries. With ConNetIt, you can capture:

* Your impressions of a person.
* Interests they’ve shared.
* Notes about how you connected.
* Context for future follow-ups or collaborations.

It acts as a **private, personalized CRM** tailored to your own memory and networking style.

---

## Core Functionality

### Current Features

* Create, update, or delete a connection.
* Store details including name, pronouns, company, job title, and a personal description.
* View all connections through a desktop-based GUI (Java Swing, temporary for testing purposes).
* Save and load the entire app state from a JSON file.
* Log all actions performed (additions, deletions, edits).

### In Progress

* Reworking the frontend design using React to provide a cleaner, more professional interface.
* Assigning connection strength levels and enabling sort/filter by strength.
* Adding advanced hobby tagging and filtering.
* Improving consistency in string handling (e.g., case-insensitive comparisons).
* Centralizing reusable GUI logic through abstract classes.
* Tag connections with hobbies or interests.

---

## Logging Examples

When actions are performed, they are recorded in a log. For example:

```txt
Fri Mar 28 14:02:04 PDT 2025
Added John to network

Sat Mar 29 08:38:57 PDT 2025
Removed Iris from network

Fri Mar 28 14:49:48 PDT 2025
Updated Name: Iris to Cheese
Updated Pronouns: They/Them to Am
```

---

## Architectural Overview

The application is built using an object-oriented architecture:

* **Model Layer**
  Core classes including `Connection`, `Network`, and `Hobbies` manage the data structures and business logic. JSON serialization is supported for saving and loading data.

* **Persistence Layer**
  JSON-based read/write functionality through `JsonReader` and `JsonWriter`.

* **UI Layer**
  Desktop interface built using Java Swing. Modular components include add/edit forms, a main menu, and a terminal-based network manager for CLI interaction.

* **Testing**
  Unit tests cover key model and persistence components.

---

## Technical Highlights

The current implementation incorporates several technical strategies designed to ensure modularity, maintainability, and extensibility:

* **Object-Oriented Design (OOD):**
  The system follows object-oriented principles, with a clear separation of concerns across model, persistence, and user interface layers.

* **JSON Persistence:**
  All user data is serialized and deserialized through custom `JsonReader` and `JsonWriter` classes. A standardized `Writable` interface ensures consistency across model objects.

* **Event Logging System:**
  User actions such as adding, editing, and deleting connections are logged using an `EventLog` class, supporting transparency and providing a foundation for possible future features such as undo/redo.

* **Modular and Testable UI Components:**
  The Swing-based interface is structured with modular components for different tasks (adding, editing, listing connections), allowing for easier testing.

* **Unit Testing:**
  Comprehensive unit tests, using JUnit, have been implemented for the creation and modification of connections, JSON read/write operations, and data integrity of the network structure.

* **Separation of Concerns:**
  Business logic is decoupled from the user interface, which simplifies maintenance and facilitates the ongoing migration to a React-based frontend.

* **Command Line Interface Support:**
  A terminal-based network manager (`TerminalNetworkManager`) is included, providing an alternative testing and interaction environment independent of the graphical UI.

---

## Planned Architectural Improvements

* Abstracting repeated GUI logic into shared interface classes.
* Refactoring `Network` and `Hobbies` to implement collection-based abstract classes.
* Enforcing case-insensitive hobby naming and filtering.

---

## Future Exploration

* Adding data structures like maps and sets to optimize filtering and categorization.
* Introducing autosave and backup functionality.
* Exploring potential LinkedIn API integration for auto-updating connections (concept to explore — not yet implemented nor fully planned).

---

## Development Status

The **Java Swing version** of ConNetIt is functional and supports all core implemented features listed above.
A **React-based frontend rework** is currently underway but not yet integrated.
Additional features will be under development following completion of the core React UI creation.

