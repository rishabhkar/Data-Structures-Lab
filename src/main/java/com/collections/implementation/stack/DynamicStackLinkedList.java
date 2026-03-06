package com.collections.implementation.stack;

public class DynamicStackLinkedList {

  public int data;
  public DynamicStackLinkedList next;

  public DynamicStackLinkedList(int data) {
    this.data = data;
    this.next = null;
  }

  public DynamicStackLinkedList push(DynamicStackLinkedList head, int data) {

    DynamicStackLinkedList dynamicStackObject = new DynamicStackLinkedList(data);
    dynamicStackObject.next = head;
    return dynamicStackObject;
  }

  public DynamicStackLinkedList pop(DynamicStackLinkedList head) {
    if (head == null) return null;
    return head.next;
  }

  public int getSize(DynamicStackLinkedList head) {
    DynamicStackLinkedList pointer = head;
    int counter = 0;

    while (pointer != null) {
      pointer = pointer.next;
      counter++;
    }
    return counter;
  }

  public int getTop(DynamicStackLinkedList head) {
    return head.data;
  }
}
