# ConNetIt

**ConNetIt** is a personal connection manager and networking diary designed to help users remember, organize, and nurture their professional and personal relationships. Unlike traditional platforms like LinkedIn, which prioritize static profiles, ConNetIt focuses on the *context* and *quality* of your interactions, allowing you to tag, describe, and track meaningful details about the people you meet.

---

## Figma Design Preview

Attached here is the [Figma design](https://github.com/FabianoGLentini/ConNetIt/blob/main/ConNetIt%20Design.png) I created that serves as the foundation for the development of this app. (Implementation of design in Progress)

![Design](https://github.com/FabianoGLentini/ConNetIt/blob/main/ConNetIt%20Design.png)

---

## Project Overview

ConNetIt allows you to:
- Add detailed profiles for people you meet
- Record how you met, mutual interests, or conversation points
- Tag connections with hobbies, industries, or roles
- Assign and track connection strength over time
- Filter and sort connections based on relevance or personal value

It’s designed as a tool to bring humanity and memory back into networking.

---

## Why ConNetIt?

This project was inspired by the limits of existing professional platforms. People are more than job titles. With ConNetIt, you can capture:
- Your impression of a person
- Interests they’ve shared with you
- Notes about how you connected
- Context for future follow-ups or collaborations

It acts like a personalized, private CRM for your network — built with empathy and utility in mind.

---

## Core Functionality

### Current Features:
- Add, update, or delete a *Connection*
- Store details like name, pronouns, company, job title, and a personal description
- Save and load the entire app state to/from a file
- View a list of all current connections
- View real-time logging of actions (e.g., added, deleted, or edited a connection)

### In Progress:
- Rework of Front end design using React for clearner more professional feal
- Assign connection levels and sort/filter by strength
- Add hobby tagging and related features
- Filter connections by company or interests
- Improve consistency with string handling (e.g., case-insensitive comparisons)
- Centralize repeated GUI logic through abstract interface classes
 
---

## Logging Examples

When actions are performed, they are logged. For example:

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

## Planned Architectural Improvements

- Create a shared GUI interface for reusable methods  
- Abstract `EditAddGUI` to consolidate `AddConnectionUI` and `EditMenuUI`  
- Refactor `Network` and `Hobbies` to extend a shared collection-based abstract class  
- Convert `Hobbies` and `Network` into Singleton classes  
- Enforce case-insensitive hobby naming and filtering

---

## Future Exploration

- Add map/set structures for optimized filtering and categorization  
- Introduce autosave and backup functionality
- Implementation of linkin API for potnetial link if for auto update connections
