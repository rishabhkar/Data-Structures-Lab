package com.collections.implementation.stack;

public class FixedStack {

  int[] data;
  int capacity;
  int size;

  public FixedStack(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  public void push(int value) {
    if (size == capacity) {
      System.out.println("Stack Full");
      return;
    }
    data[size] = value;
    size++;
  }

  public int getTop() {
    return data[size-1];
  }

  public void printStack() {
    for (int i = size-1; i >= 0; i--) {
      System.out.println(data[i]);
    }
  }

  public void pop() {
        if (size == 0) {
      System.out.println("Stack Empty");
      return;
        }
        data[size-1] = 0;
        size--;
  }
}
