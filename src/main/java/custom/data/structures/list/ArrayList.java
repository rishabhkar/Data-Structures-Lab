package custom.data.structures.list;

import org.springframework.stereotype.*;

/**
 * Simple custom array-backed list.
 * It stores integers and grows when the array becomes full.
 */
@Service
public class ArrayList implements List {

  int[] list;
  int size = 0; // Denotes the number of variables filled

  /**
   * Returns the backing array.
   * @return current array
   */
  public int[] getList() {
    return this.list;
  }

  /**
   * Returns how many values are currently stored.
   * @return current size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Prints the values stored in the list.
   * @param list list to print
   */
  @Override
  public void printList(ArrayList list) {
    for (int i = 0; i < size; i++) {
      System.out.printf("Element %d = %d%n", i + 1, list.getList()[i]);
    }
  }

  /**
   * Creates a list with default capacity 10.
   */
  public ArrayList() {
    this.list = new int[10];
  }

  /**
   * Creates a list from an existing array.
   * @param arr array used as the backing store
   */
  public ArrayList(int[] arr) {
    this.list = arr;
    this.size = arr.length;
  }

  /**
   * Creates a list with one starting value.
   * @param value first value to store
   */
  public ArrayList(int value) {
    this.list[0] = value;
    this.size++;
  }

  /**
   * Adds a value at the end of the list.
   * @param value value to add
   */
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

  /**
   * Adds a value at the start of the list.
   * @param value value to add
   */
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

  /**
   * Adds a value using the given index position.
   * @param value value to add
   * @param index index used for insertion
   * @throws IllegalArgumentException when the first position should be handled by another method
   */
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

  /**
   * Removes the last stored value.
   */
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

  /**
   * Removes the first stored value.
   */
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

  /**
   * Removes the value at the given index.
   * @param index index to remove
   */
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

  /**
   * Removes the first matching value.
   * @param value value to remove
   */
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

  /**
   * Removes all matching values.
   * @param value value to remove
   */
  @Override
  public void removeAllOccurrences(int value) {

    //    boolean found = false;

    for (int i = 0, j = 1; i < this.list.length; j++) {

    }

  }

  /**
   * Removes the last matching value.
   * @param value value to remove
   */
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

  /**
   * Doubles the size of the array.
   * @param list current array
   * @return bigger array
   */
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

  /**
   * Shrinks the array to the used size.
   * @return downsized array
   */
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
