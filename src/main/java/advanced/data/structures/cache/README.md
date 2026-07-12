# Custom Cache Data Structures

## 1. Purpose

This directory contains custom cache data structures implemented in a Java Maven-based application.

Each cache type should have its own folder and should explain its behaviour, use case, and eviction rule clearly.

This README is only for the main cache directory. Detailed implementation notes should stay inside the specific cache folder.

---

## 2. What Is A Cache?

A cache is a temporary storage layer used to keep frequently accessed data closer to the application.

Instead of fetching the same data again from a slower source, the application can read it from the cache.

A cache usually stores data as key-value pairs.

Example idea:

```text
key -> cached value
```

---

## 3. Why Cache Is Used

Caches are used to improve system performance.

Main reasons:

1. To reduce repeated expensive operations.

2. To reduce database, API, file, or network calls.

3. To improve response time.

4. To handle repeated requests efficiently.

5. To store temporary data that may be reused soon.

---

## 4. Basic Cache Behaviour

A cache usually supports these basic actions:

1. Add data to cache.

2. Get data from cache.

3. Update existing cached data.

4. Remove data from cache.

5. Clear expired or unwanted data.

---

## 5. Cache Hit

A cache hit happens when the requested data is found in the cache.

This is the fast path because the application does not need to fetch the data from the original source again.

---

## 6. Cache Miss

A cache miss happens when the requested data is not found in the cache.

In this case, the application may fetch the data from the original source and then store it in the cache for later use.

---

## 7. Cache Capacity

Most caches have limited storage.

When the cache becomes full, it must decide which item should be removed.

This removal decision depends on the cache type.

---

## 8. Custom Cache Types

Multiple custom cache types can be created depending on the eviction rule or usage behaviour.

Common cache types:

| Cache Type | Folder Name | Basic Idea |
|---|---|---|
| LRU Cache | `lrucache` | Removes the least recently used item |
| LFU Cache | `lfucache` | Removes the least frequently used item |
| FIFO Cache | `fifocache` | Removes the item inserted first |
| MRU Cache | `mrucache` | Removes the most recently used item |
| TTL Cache | `ttlcache` | Removes items after a fixed expiry time |
| Random Cache | `randomcache` | Removes a random item when full |
| No Eviction Cache | `noevictioncache` | Does not remove items automatically |

---

## 9. LRU Cache

LRU means Least Recently Used.

An LRU Cache removes the item that has not been used for the longest time.

This is useful when recently accessed data is more likely to be accessed again.

Folder:

```text
lrucache
```

---

## 10. Suggested Directory Structure

```text
cache/
│
├── README.md
│
├── lrucache/
│   └── README.md
│
├── lfucache/
│   └── README.md
│
├── fifocache/
│   └── README.md
│
├── mrucache/
│   └── README.md
│
├── ttlcache/
│   └── README.md
│
├── randomcache/
│   └── README.md
│
└── noevictioncache/
    └── README.md
```

---

## 11. Notes For This Maven Project

This folder is meant to group different custom cache implementations in one place.

Each cache should be kept separate so that its behaviour can be tested, extended, and compared independently.

The main goal is to understand different cache policies and how they behave under different access patterns.
