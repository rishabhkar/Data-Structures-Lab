package custom.data.structures.list;

import org.springframework.stereotype.*;

/**
 * Basic contract for the custom list implementation.
 * It keeps the main add, remove, and resize operations in one place.
 */
@Service
public interface List {

  /**
   * Prints the current values in the list.
   * @param list list object to print
   */
  void printList(ArrayList list);

  /**
   * Adds a value at the end of the list.
   * @param value value to add
   */
  void addElement(int value);

  /**
   * Adds a value at the start of the list.
   * @param value value to add
   */
  void addElementAtBeginning(int value);

  /**
   * Adds a value near the given index position.
   * @param value value to add
   * @param index position used for insertion
   * @throws IllegalArgumentException when the index points before the first position
   */
  void addAtIndex(int value, int index);

  /**
   * Removes the last stored value.
   */
  void removeLast();

  /**
   * Removes the first stored value.
   */
  void removeFirst();

  /**
   * Removes the value at the given index.
   * @param index index to remove
   */
  void removeAtIndex(int index);

  /**
   * Removes the first matching value.
   * @param value value to remove
   */
  void removeFirstOccurrence(int value);

  /**
   * Removes every matching value.
   * @param value value to remove
   */
  void removeAllOccurrences(int value);

  /**
   * Removes the last matching value.
   * @param value value to remove
   */
  void removeLastOccurrence(int value);

  /**
   * Creates a bigger backing array.
   * @param list current array
   * @return bigger array with copied values
   */
  int[] upsize(int[] list);

  /**
   * Shrinks the backing array to the current size.
   * @return resized array
   */
  int[] downsize();
}
