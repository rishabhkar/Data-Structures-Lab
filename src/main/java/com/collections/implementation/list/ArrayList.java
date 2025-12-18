package com.collections.implementation.list;

import org.springframework.stereotype.*;

@Service
public class ArrayList implements List {

  int[] list;
  int size = 0; // Denotes the number of variables filled

  // Get and Print
  public int[] getList() {
    return this.list;
  }

  public int getSize() {
    return this.size;
  }

  @Override
  public void printList(ArrayList list) {
    for (int i = 0; i < size; i++) {
      System.out.printf("Element %d = %d%n", i + 1, list.getList()[i]);
    }
  }

  // 1. Basic Constructor Implementation
  //    1.1 Empty Constructor
  public ArrayList() {
    this.list = new int[10];
  }

  //    1.2 Constructor with array as parameter
  public ArrayList(int[] arr) {
    this.list = arr;
    this.size = arr.length;
  }

  //    1.3 Constructor with single integer as parameter
  public ArrayList(int value) {
    this.list[0] = value;
    this.size++;
  }

  // 2. Addition
  //    2.1 Addition at the end (default)
  @Override
  public void addElement(int value) {

    for (int i = 0; i < list.length; i++) {
      if (size == list.length) {
        list = upsize(list);
      }
      if (i == size) {
        list[i] = value;
        size++;
        break;
      }
    }
  }

  //    2.2 Addition in the beginning
  @Override
  public void addElementAtBeginning(int value) {

    if (size == list.length) {
      list = upsize(list);
    }
    for (int i = list.length - 1; i >= 0; i--) {
      if (i == 0) {
        list[i] = value;
        size++;
        break;
      }
      list[i] = list[i - 1];
    }
  }

  //    2.3 Addition in a specific index
  @Override
  public void addAtIndex(int value, int index) {

    if (size == list.length) {
      list = upsize(list);
    }
    for (int i = list.length - 1; i >= index; i--) {
      if (i == index) {
        list[i] = list[i - 1];
        if (i - 1 >= 0) {
          list[i - 1] = value;
        } else {
          throw new IllegalArgumentException("Use the Add at Beginning Function");
        }
        size++;
        break;
      }
      list[i] = list[i - 1];
    }
  }

  // 3. Removal
  //    3.1 Removal from the end (default)
  @Override
  public void removeLast() {

    for (int i = list.length - 1; i >= 0; i--) {
      if (list[i] != 0) {
        list[i] = 0;
        size--;
        break;
      }
    }
  }

  //    3.2 Removal from the beginning
  @Override
  public void removeFirst() {

    int[] tempList = new int[list.length - 1];

    for (int i = 1; i < list.length; i++) {
      tempList[i - 1] = list[i];
    }
    list = tempList;
    tempList = null;
    size--;
  }

  //    3.3 Removal from a specific index
  @Override
  public void removeAtIndex(int index) {

    for (int i = index; i < this.list.length; i++) {
      if (i + 1 < this.list.length) {
        this.list[i] = this.list[i + 1];
        this.size--;
      }
      if (index == this.list.length) {
        this.list[index] = 0;
        this.size--;
        break;
      }
    }
  }

  //    3.4 Removal of first occurrence of an element
  @Override
  public void removeFirstOccurrence(int value) {

    for (int i = 0; i < this.list.length; i++) {
      if (list[i] != value) {
        continue;
      } else {
        if (i + 1 >= this.list.length) {
          list[i] = 0;
          this.size--;
        } else {
          list[i] = list[i + 1];
          this.size--;
        }
      }
    }
  }

  //    3.5 Removal of all occurrence of an element
  @Override
  public void removeAllOccurrences(int value) {

    //    boolean found = false;

    for (int i = 0, j = 1; i < this.list.length; j++) {

    }

  }

  //    3.6 Removal of last occurrence of an element
  @Override
  public void removeLastOccurrence(int value) {

      for (int i=list.length-1; i>=0; i--) {
            if (list[i] != value) {
                  continue;
            } else {
                  if (i - 1 < 0) {
                        list[i] = 0;
                        this.size--;
                  } else {
                        list[i] = list[i + 1];
                        this.size--;
                  }
            }
      }
    }

  // 4. Dynamic Resizing
  //    4.1 Doubling the size of array in case of out of bounds
  @Override
  public int[] upsize(int[] list) {
    int[] newList = new int[list.length * 2];

    for (int i = 0; i < newList.length; i++) {
      if (i < list.length) {
        newList[i] = list[i];
      } else break;
    }
    list = newList;
    return newList;
  }

  //    4.2 Dynamic reduction of size before
  @Override
  public int[] downsize() {
    int[] downSizedList = new int[this.size];

    for (int i = 0; i < downSizedList.length; i++) {
      downSizedList[i] = this.list[i];
    }
    this.list = downSizedList;
    downSizedList = null;
    return list;
  }
}
