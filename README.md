# Data Structures Lab

This repository is a Java practice space for learning data structures and algorithms in four complementary ways:

1. **use existing data structures well** — `existing/`
2. **build core data structures from scratch** — `custom/`
3. **build advanced data structures from scratch** — `advanced/`
4. **implement named algorithms from scratch** — `algorithms/`

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

This side is for handwritten implementations of the **core** structures.
It focuses on internal logic, node/array handling, edge cases, and interview-style practice.

### 3. Advanced data structures
Path:
- `src/main/java/advanced/data/structures/`

This side is for handwritten implementations of **more advanced** structures
(self-balancing trees, heaps, hash tables, probabilistic structures, caches).
It uses a nested folder per structure. Its classes are currently blank scaffolds ready to implement.

### 4. Named algorithms
Path:
- `src/main/java/algorithms/`

This side is for handwritten implementations of **classic, named algorithms**
(sorting, searching, graph algorithms, string matching, dynamic programming, greedy).
It uses a nested folder per algorithm so each one can be run on its own. Currently blank scaffolds.

## Naming convention

- Package segments are **lowercase, no underscores, no camelCase**
  (e.g. `custom.data.structures.linkedlists`, `advanced.data.structures.trees.avltree`).
- Every module has an internal runner — `<Module>Main` in the custom/existing tracks,
  `<Structure>Main` in the advanced track — so a single module can be run in isolation.
- Every module folder has its own `README.md`.

## Current folder structure

```text
DataStructuresLab/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── custom/data/structures/
│   │   │   │   ├── arrays/        linkedlists/   lists/
│   │   │   │   ├── stacks/        queues/        trees/
│   │   │   │   ├── graphs/        hashing/
│   │   │   │   ├── Main.java
│   │   │   │   └── README.md
│   │   │   ├── existing/data/structures/
│   │   │   │   ├── arrays/  lists/  maps/  queues/
│   │   │   │   └── README.md
│   │   │   ├── advanced/data/structures/
│   │   │   │   ├── cache/        → lrucache/
│   │   │   │   ├── trees/        → avltree/ redblacktree/ trie/ segmenttree/ fenwicktree/ btree/
│   │   │   │   ├── heaps/        → minheap/ maxheap/ priorityqueue/
│   │   │   │   ├── hashing/      → separatechaining/ openaddressing/
│   │   │   │   ├── queues/       → circularqueue/
│   │   │   │   ├── sets/         → disjointset/
│   │   │   │   ├── lists/        → skiplist/
│   │   │   │   ├── probabilistic/→ bloomfilter/
│   │   │   │   └── README.md
│   │   │   └── algorithms/
│   │   │       ├── sorting/            → bubblesort/ insertionsort/ selectionsort/ mergesort/ quicksort/ heapsort/ countingsort/ radixsort/
│   │   │       ├── searching/          → linearsearch/ binarysearch/
│   │   │       ├── graphs/             → dijkstra/ bellmanford/ floydwarshall/ kruskal/ prim/ topologicalsort/ astar/
│   │   │       ├── strings/            → kmp/ rabinkarp/ zalgorithm/ manacher/ triematching/
│   │   │       ├── dynamicprogramming/ → knapsack/ longestcommonsubsequence/ longestincreasingsubsequence/ editdistance/ coinchange/
│   │   │       ├── greedy/             → activityselection/ huffmancoding/
│   │   │       └── README.md
│   │   └── resources/
│   └── test/
│       └── java/
│           ├── custom/data/structures/
│           └── existing/data/structures/
├── pom.xml
└── README.md
```

Each advanced `<structure>/` folder holds a blank class, a `<Structure>Main` runner, and a README.

## What is implemented right now

### Custom track — implemented
- ✅ custom dynamic array, custom array-backed list
- ✅ singly / doubly / singly-circular / doubly-circular linked lists
- ✅ fixed stack, linked-list stack
- ✅ simple queue, deque
- ✅ binary tree node structure, binary search tree (insert, search, delete)
- ✅ adjacency matrix, adjacency list, breadth-first search, depth-first search

### Custom track — planned (blank)
- ⬜ hashing structures

### Advanced track — blank scaffolds (implement manually)
- ⬜ trees: AVL, red-black, trie, segment tree, Fenwick tree, B-tree
- ⬜ heaps: min-heap, max-heap, priority queue
- ⬜ hashing: separate chaining, open addressing
- ⬜ queues: circular queue / ring buffer
- ⬜ sets: disjoint set (union-find)
- ⬜ lists: skip list
- ⬜ probabilistic: bloom filter
- ⬜ cache: LRU cache

### Algorithms track — blank scaffolds (implement manually)
- ⬜ sorting: bubble, insertion, selection, merge, quick, heap, counting, radix
- ⬜ searching: linear, binary
- ⬜ graphs: Dijkstra, Bellman-Ford, Floyd-Warshall, Kruskal, Prim, topological sort, A*
- ⬜ strings: KMP, Rabin-Karp, Z-algorithm, Manacher, trie matching
- ⬜ dynamic programming: knapsack, LCS, LIS, edit distance, coin change
- ⬜ greedy: activity selection, Huffman coding

### Existing track
- ✅ native Java arrays, non-primitive static 1D/2D array wrappers
- ⬜ Java `List` / `Map` / queue & deque usage

## Module runners

Each module has an internal runner so it can be run on its own.

Custom track:
- `custom.data.structures.arrays.ArraysMain`
- `custom.data.structures.lists.ListsMain`
- `custom.data.structures.linkedlists.LinkedListsMain`
- `custom.data.structures.stacks.StacksMain`
- `custom.data.structures.queues.QueuesMain`
- `custom.data.structures.trees.TreesMain`
- `custom.data.structures.graphs.GraphsMain`
- `custom.data.structures.hashing.HashingMain`

Existing track:
- `existing.data.structures.arrays.ArraysMain`
- `existing.data.structures.lists.ListsMain`
- `existing.data.structures.maps.MapsMain`
- `existing.data.structures.queues.QueuesMain`

Advanced track — one `<Structure>Main` per structure, e.g.:
- `advanced.data.structures.trees.avltree.AVLTreeMain`
- `advanced.data.structures.heaps.minheap.MinHeapMain`
- `advanced.data.structures.cache.lrucache.LRUCacheMain`

Algorithms track — one `<Algorithm>Main` per algorithm, e.g.:
- `algorithms.sorting.quicksort.QuickSortMain`
- `algorithms.graphs.dijkstra.DijkstraMain`
- `algorithms.strings.kmp.KMPMain`

The packaged application entry point remains:
- `custom.data.structures.Main`

## Build and run

```powershell
mvn clean package
mvn test
mvn spring-boot:run
```

Run any module runner directly from the IDE, e.g. `custom.data.structures.stacks.StacksMain`.

## Test coverage notes

Test classes mirror the implemented custom structures (arrays, lists, linked lists, stacks,
queues, trees, graphs) and existing arrays. Advanced structures are blank scaffolds — add tests
under `src/test/java/advanced/...` as each one is implemented.

Surefire test reports are generated under:
- `target/surefire-reports/`

## Why this repository is organised this way

The goal is a clean, long-term-maintainable separation between:
- **using Java's existing data structures properly**
- **implementing the core structures yourself**
- **implementing the advanced structures yourself**

That makes the repository useful for revision, interview preparation, and step-by-step practice.
