# Data Structures Lab

A long-term Java data structures repository split into two clear learning tracks:

1. **`use-existing-data-structures/`** — practicing Java's built-in arrays, collections, and access patterns.
2. **`custom-data-structures/`** — implementing data structures from scratch for deeper understanding and interview prep.

## Repository Goals

This lab is organized to keep two different skills separate:

- **Using standard Java data structures well**
  - choosing the right API
  - understanding access patterns and trade-offs
  - learning when to use which collection
- **Building data structures from scratch**
  - understanding internal representation
  - implementing operations manually
  - practicing core interview-style data structure design

## Top-Level Structure

```text
DataStructuresLab/
├── use-existing-data-structures/
│   ├── README.md
│   ├── arrays/
│   ├── lists/
│   ├── queues-and-deques/
│   └── maps/
├── custom-data-structures/
│   ├── README.md
│   ├── arrays/
│   ├── linked-lists/
│   ├── stacks/
│   ├── queues/
│   ├── trees/
│   ├── graphs/
│   ├── hashing/
│   └── advanced-structures/
└── src/
    ├── main/java/com/collections/implementation/
    └── test/java/com/collections/implementation/
```

## Track Guide

### 1) `use-existing-data-structures`

This track is for **Java built-in and standard-library usage**.

It covers:
- native Java arrays
- Java `List` usage such as `ArrayList`, `LinkedList`, and `CopyOnWriteArrayList`
- queue APIs such as `Deque`, `PriorityQueue`, and `BlockingQueue`
- Java `Map` types such as `HashMap`, `LinkedHashMap`, `TreeMap`, `NavigableMap`, `ConcurrentHashMap`, `WeakHashMap`, `IdentityHashMap`, and `EnumMap`

This side is about **usage, APIs, performance, and practical selection**, not handwritten reimplementation.

### 2) `custom-data-structures`

This track is for **handwritten implementations from scratch**.

It covers:
- dynamic arrays and sparse arrays
- linked lists
- custom stacks and queues
- trees, BSTs, AVL trees, heaps, and tries
- graph representations and traversals
- hash tables, probing strategies, chaining, and rehashing
- advanced structures such as DSU, skip list, Bloom filter, caches, suffix structures, and related interview-prep topics

This side is about **internal mechanics, manual implementation, and design trade-offs**.

## How Existing Source Code Maps During Migration

The current Java implementation code under `src/main/java/com/collections/implementation/` is still the active codebase. Conceptually, it maps into the new structure like this:

- `src/main/java/com/collections/implementation/list/`
  - custom dynamic-array style work belongs under `custom-data-structures/arrays/`
  - future node-based list implementations belong under `custom-data-structures/linked-lists/`
- `src/main/java/com/collections/implementation/stack/`
  - belongs under `custom-data-structures/stacks/`
- `src/main/java/com/collections/implementation/queue/`
  - belongs under `custom-data-structures/queues/`
- `src/main/java/com/collections/implementation/tree/`
  - belongs under `custom-data-structures/trees/`
- `src/main/java/com/collections/implementation/graphs/`
  - belongs under `custom-data-structures/graphs/`

For now, this restructure is **documentation-first**: the folders and README files define the long-term organization without changing Java packages or Maven source roots yet.

## Current Migration Notes

- Keep `src/` as the working Maven source tree for now.
- Use the new top-level folders as the canonical content map for future additions.
- Do not treat `target/` as part of the learning structure.
- When future refactors happen, move implementation-oriented content into the matching concept area intentionally rather than by package name alone.

## Build and Test

All existing Maven and Spring Boot commands still run from the project root.

```powershell
mvn clean package
mvn test
mvn spring-boot:run
```

## Scope Control

This repository structure is based on the provided data structures sheet.

- Trivial labels such as definition, overview, advantages, and formulas stay inside README sections.
- Duplicate concepts are normalized instead of repeated across many folders.
- Built-in usage and handwritten implementation stay separated unless a README explicitly explains the relationship.
