package com.collections.implementation.queue;

public class SimpleQueue {

  int[] data;
  int capacity;
  int size;

  public SimpleQueue(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  public void enqueue(int value) {
    if (size == capacity) {
      System.out.println("SimpleQueue Full");
      return;
    }
    data[size] = value;
    size++;
  }

  public void dequeue() {
    if (size == 0) {
      System.out.println("SimpleQueue Empty Already!");
      return;
    }
    for (int i = 0; i < size-1; i++) {
      data[i] = data[i + 1];
    }
    size--;
  }

  public int peek() {
    if (size == 0) {
      System.out.println("SimpleQueue Empty");
      return -1;
    }
    return data[0];
  }

  public int rear() {
        if (size == 0) {
              System.out.println("SimpleQueue Empty");
              return -1;
        }
        return data[size-1];
  }

  public int getSize() {
        return size;
  }

  public int getCapacity() {
        return capacity;
  }
}
