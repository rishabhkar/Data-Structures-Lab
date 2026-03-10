# Data Structures Lab

This repository is a Java practice space for learning data structures in two different ways:

1. **use existing data structures well**
2. **build custom data structures from scratch**

That split is the main rule used to organise this project.

## Repository split

### 1. Use existing data structures
Path:
- `src/main/java/existing/data/structures/`

This side is for Java's built-in and standard-library data structures.
It focuses on usage, access patterns, basic API understanding, and practical behaviour.

### 2. Custom data structures
Path:
- `src/main/java/custom/data/structures/`

This side is for handwritten implementations.
It focuses on internal logic, node/array handling, edge cases, and interview-style practice.

## Current folder structure

```text
DataStructuresLab/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── custom/data/structures/
│   │   │   │   ├── arrays/
│   │   │   │   ├── linkedLists/
│   │   │   │   ├── list/
│   │   │   │   ├── stacks/
│   │   │   │   ├── queues/
│   │   │   │   ├── trees/
│   │   │   │   ├── graphs/
│   │   │   │   ├── hashing/
│   │   │   │   ├── Main.java
│   │   │   │   └── README.md
│   │   │   └── existing/data/structures/
│   │   │       ├── arrays/
│   │   │       ├── lists/
│   │   │       ├── maps/
│   │   │       ├── queuesanddeques/
│   │   │       └── README.md
│   │   └── resources/
│   └── test/
│       └── java/
│           ├── custom/data/structures/
│           └── existing/data/structures/
├── pom.xml
└── README.md
```

## What is implemented right now

## Existing data structures track

Implemented:
- ✅ native Java arrays
- ✅ non-primitive static 1D array wrapper
- ✅ non-primitive static 2D array wrapper

Planned but not implemented yet:
- ⬜ Java `List` usage
- ⬜ Java `Map` usage
- ⬜ Java queue and deque usage

Main source folder in use:
- `src/main/java/existing/data/structures/arrays/`

Main test folder in use:
- `src/test/java/existing/data/structures/arrays/`

## Custom data structures track

Implemented:
- ✅ custom dynamic array
- ✅ custom array-backed list
- ✅ singly linked list
- ✅ doubly linked list
- ✅ singly circular linked list
- ✅ doubly circular linked list
- ✅ fixed stack
- ✅ linked-list stack
- ✅ simple queue
- ✅ deque
- ✅ binary tree node structure
- ✅ binary search tree insert
- ✅ binary search tree search
- ✅ binary search tree delete
- ✅ adjacency matrix representation
- ✅ adjacency list representation
- ✅ breadth-first search
- ✅ depth-first search

Planned but not implemented yet:
- ⬜ hashing structures
- ⬜ AVL tree
- ⬜ trie
- ⬜ circular queue / ring buffer
- ⬜ advanced specialised structures

Main source folders in use:
- `src/main/java/custom/data/structures/arrays/`
- `src/main/java/custom/data/structures/list/`
- `src/main/java/custom/data/structures/linkedLists/`
- `src/main/java/custom/data/structures/stacks/`
- `src/main/java/custom/data/structures/queues/`
- `src/main/java/custom/data/structures/trees/`
- `src/main/java/custom/data/structures/graphs/`

Main test folders in use:
- `src/test/java/custom/data/structures/arrays/`
- `src/test/java/custom/data/structures/list/`
- `src/test/java/custom/data/structures/linkedLists/`
- `src/test/java/custom/data/structures/stacks/`
- `src/test/java/custom/data/structures/queues/`
- `src/test/java/custom/data/structures/trees/`
- `src/test/java/custom/data/structures/graphs/`

## Folder notes

- `custom/data/structures/arrays/` now owns the custom dynamic-array implementation.
- `existing/data/structures/arrays/` is reserved for Java array usage work.
- `custom/data/structures/linkedLists/` contains all linked-list implementations currently in the project.
- `existing/data/structures/queuesanddeques/` uses a valid folder name without hyphens.
- `hashing/`, `lists/`, `maps/`, and `queuesanddeques/` are still mostly planning folders at the moment.

## Test coverage notes

This repository now has test classes for:
- existing arrays
- custom dynamic arrays
- custom linked lists
- custom list
- custom stacks
- custom queues
- custom trees
- custom graphs

Surefire test reports are generated under:
- `target/surefire-reports/`

## Build and run

The packaged entry point used by the project is:
- `custom.data.structures.Main`

Common Maven commands:

```powershell
mvn clean package
mvn test
mvn spring-boot:run
```

Run folder-specific demo classes directly from the IDE if needed:
- `custom.data.structures.arrays.Main`
- `custom.data.structures.list.Main`
- `custom.data.structures.linkedLists.LinkedListsMain`
- `custom.data.structures.stacks.Main`
- `custom.data.structures.queues.Main`
- `custom.data.structures.graphs.Main`
- `custom.data.structures.trees.Main`
- `existing.data.structures.arrays.ArraysMain`

## Why this repository is organised this way

This project is meant to stay clean and long-term maintainable.

The goal is to keep a clear difference between:
- **using Java's existing data structures properly**
- **understanding how those structures work by implementing them yourself**

That makes the repository useful for revision, interview preparation, and step-by-step practice.
