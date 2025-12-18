package com.collections.implementation.list;

import org.springframework.stereotype.*;

@Service
public interface List {

  // 1. Printing
  void printList(ArrayList list);

  // 2. Addition
  void addElement(int value);

  void addElementAtBeginning(int value);

  void addAtIndex(int value, int index);

  // 3. Removal
  void removeLast();

  void removeFirst();

      void removeAtIndex(int index);
      void removeFirstOccurrence(int value);
      void removeAllOccurrences(int value);
      void removeLastOccurrence(int value);
  ///

  // 4. Dynamic resizing
  int[] upsize(int[] list);
  int[] downsize();
}
