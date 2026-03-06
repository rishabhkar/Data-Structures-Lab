package com.collections.implementation.queue;

public class Deque {

  int[] data;
  int capacity;
  int size;

  public Deque(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public int getSize() {
    return this.size;
  }

  public void addFirst(int value) {
    if (size == capacity) {
      System.out.println("Queue Full");
      return;
    }

    for (int i = size - 1; i >= 0; i--) {
      data[i + 1] = data[i];
    }
    data[0] = value;
    size++;
  }

  public void addLast(int value) {
    if (size == capacity) {
      System.out.println("Queue Full");
      return;
    }

    data[size] = value;
    size++;
  }

  public int peek() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return -1;
    }
    return data[0];
  }

  public int rear() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return -1;
    }
    return data[size - 1];
  }

  public void removeFirst() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return;
    }
    for (int i = 0; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
  }

  public void removeLast() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return;
    }

    data[size - 1] = 0; // optional
    size--;
  }
}
