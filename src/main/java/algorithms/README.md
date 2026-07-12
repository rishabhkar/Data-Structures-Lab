# Algorithms

## Track

Algorithms track: `algorithms`

This is the fourth track in the project, alongside:
- `custom/data/structures/` — core structures written from scratch
- `existing/data/structures/` — using Java's built-in structures
- `advanced/data/structures/` — advanced structures written from scratch

## What this track covers

This side is for **named, classic algorithms written from scratch** — sorting, searching,
graph algorithms, string matching, dynamic programming, and greedy algorithms.

## Layout convention

Like the advanced track, the algorithms track is **nested per algorithm**:

```text
algorithms/
└── <category>/
    ├── README.md               (category overview)
    └── <algorithm>/
        ├── <Algorithm>.java      (blank class — implement manually)
        ├── <Algorithm>Main.java  (runner to try this algorithm on its own)
        └── README.md             (algorithm notes)
```

Each algorithm is its own runnable module with its own `<Algorithm>Main`, so you can try one
in isolation.

## Categories

| Category | Algorithms |
|---|---|
| `sorting/` | `bubblesort`, `insertionsort`, `selectionsort`, `mergesort`, `quicksort`, `heapsort`, `countingsort`, `radixsort` |
| `searching/` | `linearsearch`, `binarysearch` |
| `graphs/` | `dijkstra`, `bellmanford`, `floydwarshall`, `kruskal`, `prim`, `topologicalsort`, `astar` |
| `strings/` | `kmp`, `rabinkarp`, `zalgorithm`, `manacher`, `triematching` |
| `dynamicprogramming/` | `knapsack`, `longestcommonsubsequence`, `longestincreasingsubsequence`, `editdistance`, `coinchange` |
| `greedy/` | `activityselection`, `huffmancoding` |

## Status

All classes here are **blank scaffolds** to be implemented manually. Each algorithm ships with an
empty `<Algorithm>Main` runner — add a small example there to try it out.

## Naming convention

Package segments are lowercase with no underscores and no camelCase
(e.g. `algorithms.sorting.quicksort`, `algorithms.graphs.dijkstra`), matching the rest of the repository.
