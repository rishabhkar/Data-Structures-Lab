# Advanced Data Structures

## Track

Advanced implementation track: `advanced-data-structures`

This is the third track in the project, alongside:
- `custom/data/structures/` — core structures written from scratch
- `existing/data/structures/` — using Java's built-in structures

## What this track covers

This side is for **more advanced structures written from scratch**: self-balancing trees,
heaps, hash tables, probabilistic structures, caches, and similar.

## Layout convention

Unlike the flat `custom` track, the advanced track is **nested per structure**:

```text
advanced/data/structures/
└── <category>/
    ├── README.md            (category overview)
    └── <structure>/
        ├── <Structure>.java      (blank class — implement manually)
        ├── <Structure>Main.java  (runner for this structure only)
        └── README.md             (structure notes)
```

Each concrete structure is its own runnable module with its own `<Structure>Main`.

## Categories

| Category | Structures |
|---|---|
| `cache/` | `lrucache` (planned: `lfucache`, `fifocache`, `mrucache`, `ttlcache`, `randomcache`, `noevictioncache`) |
| `trees/` | `avltree`, `redblacktree`, `trie`, `segmenttree`, `fenwicktree`, `btree` |
| `heaps/` | `minheap`, `maxheap`, `priorityqueue` |
| `hashing/` | `separatechaining`, `openaddressing` |
| `queues/` | `circularqueue` |
| `sets/` | `disjointset` |
| `lists/` | `skiplist` |
| `probabilistic/` | `bloomfilter` |

## Status

All classes here are **blank scaffolds** to be implemented manually. Each structure ships with an
empty `<Structure>Main` runner so a single module can be run in isolation once implemented.

## Naming convention

Package segments are lowercase with no underscores and no camelCase
(e.g. `advanced.data.structures.trees.avltree`), matching the rest of the repository.
