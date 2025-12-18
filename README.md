# Data Structures Lab

A personal Java/Spring Boot playground for implementing classic data structure collections from scratch.

## Overview

This project is a hands-on lab for re‑implementing common collection data structures and related algorithms. The focus is on:

- Understanding how the underlying data structures actually work
- Practicing reasoning about time and space complexity
- Building confidence with clean, tested Java code

The Spring Boot setup is mainly used to give the project a familiar structure and to make it easy to add demos or simple APIs later if needed.

## Goals & Learning Outcomes

- Implement core collections without using `java.util` implementations as a crutch
- Compare different implementations of the same abstraction (e.g. array vs linked lists)
- Practice test-driven development with JUnit
- Strengthen understanding of Big-O complexity and trade-offs
- Keep the code readable, well-documented, and easy to extend

## Tech Stack

- Java 21
- Spring Boot 4.0.0 (starter project)
- Maven (build + dependency management)
- Testing: Spring Boot Test, JUnit 4

## Project Structure

High-level layout:

- `src/main/java/com/collections/implementation/DataStructuresLab/`  
  Main Spring Boot application and wiring.
- `src/main/java/com/collections/implementation/...`  
  Packages for custom data structures (lists, stacks, queues, trees, graphs, maps, etc.).
- `src/test/java/com/collections/implementation/DataStructuresLab/`  
  Test suite for verifying correctness and edge cases.

As new structures are added, they will be grouped into clearly named packages (for example, `list`, `stack`, `queue`, `tree`, `graph`, `map`).

## Building and Running

All commands should be run from the project root (where `pom.xml` lives).

### Build the project

```powershell
mvn clean package
```

### Run tests

```powershell
mvn test
```

### Run the Spring Boot application

```powershell
mvn spring-boot:run
```

## Current / Planned Implementations

This checklist is for tracking progress; items will be checked off as implementations and tests are added.

### Linear Collections
- [ ] Dynamic array list(s)
- [ ] Singly linked list
- [ ] Doubly linked list

### Stacks & Queues
- [ ] Stack (array-based)
- [ ] Stack (linked list-based)
- [ ] Queue (array-based / circular buffer)
- [ ] Queue (linked list-based)
- [ ] Deque

### Trees
- [ ] Binary Search Tree (BST)
- [ ] Self-balancing tree (e.g. AVL or Red‑Black)
- [ ] Heap / Priority Queue

### Graphs
- [ ] Graph representation (adjacency list)
- [ ] Graph representation (adjacency matrix)
- [ ] Traversals (DFS, BFS)

### Maps & Sets
- [ ] Hash map (separate chaining or open addressing)
- [ ] Hash set
- [ ] Tree map / ordered map

## How to Use the Structures

Initially, usage examples will live in test classes. Each structure will have:

- A corresponding test class under `src/test/java` with example usage
- Tests that cover typical operations and edge cases

As the APIs stabilize, this README can be updated with code snippets and usage notes for each structure.

## Future Extensions

Ideas for extending the lab:

- Add more advanced structures (tries, union-find, segment trees, B-trees)
- Implement basic algorithms that rely on these structures (sorting, pathfinding, etc.)
- Add benchmarks comparing custom structures with `java.util` collections
- Expose simple REST endpoints to experiment with data structures via HTTP
- Add visualizations or a small UI to show structure state and operations over time

