package existing.data.structures.arrays;

import java.lang.reflect.*;

/**
 * Fixed-size generic one-dimensional array wrapper.
 * Stores values in a reflection-created backing array.
 * @param <T> type of element stored in the array
 */
public class NonPrimitiveStatic1DArray<T> {

  int size;
  T[] array;

  /**
   * Creates a fixed-size generic array using the given type and size.
   * @param className runtime type of the elements
   * @param size length of the array
   */
  public NonPrimitiveStatic1DArray(Class<T> className, int size) {
    this.size = size;

    // Java does not allow direct creation of new T[], so reflection is used here.
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) Array.newInstance(className, size);
    array = temp;
  }

  /**
   * Returns the backing array stored by this wrapper.
   * @return internal array reference
   */
  public T[] getArray() {
    return this.array;
  }

  /**
   * Stores an element at the given index.
   * @param index position where the value should be stored
   * @param element value to place in the array
   */
  public void setElement(int index, T element) {
    if (index < size) {
      array[index] = element;
    } else throw new IndexOutOfBoundsException("Index you are passing is exceeding the size");
  }

  /**
   * Returns the element at the given index.
   * @param index position to read from
   * @return value stored at the given index
   */
  public T getElement(int index) {
    if (index < size) {
      return array[index];
    } else throw new IndexOutOfBoundsException("Index you are passing is exceeding the size");
  }

  /**
   * Returns the configured length of the array.
   * @return total size of the array
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Checks whether every position in the array is null.
   * @return true if no non-null element is stored
   */
  public boolean isEmpty() {

    int left = 0, right = size - 1;

    // Check from both ends so the scan can finish early when a value is found.
    while (left <= right) {

      if (array[left] != null || array[right] != null) return false;
      left++;
      right--;
    }

    return true;
  }

  /**
   * Checks whether the given element exists in the array.
   * @param element value to search for
   * @return true if the value is found, otherwise false
   */
  public boolean contains(T element) {

    int left = 0, right = size - 1;
    if (element != null) {

      // Compare from both ends to reduce the number of passes in common cases.
      while (left <= right) {

        if (((array[left] != null) && (array[left].equals(element)))
            || ((array[right] != null) && (array[right].equals(element)))) return true;
        left++;
        right--;
      }
    }
    return false;
  }

  /**
   * Finds the first index of the given element.
   * @param element value to search for
   * @return first matching index, or -1 if not found
   */
  public int indexOf(T element) {

    if (element != null) {
      for (int i = 0; i < size; i++) {
        if (array[i].equals(element)) return i;
      }
    }
    return -1;
  }

  /**
   * Finds the last index of the given element.
   * @param element value to search for
   * @return last matching index, or -1 if not found
   */
  public int lastIndexOf(T element) {

    if (element != null) {
      for (int i = size - 1; i >= 0; i--) {
        if (array[i].equals(element)) return i;
      }
    }
    return -1;
  }

  /**
   * Clears the array by setting each position to null.
   */
  public void clear() {

    for (int i = 0; i < size; i++) {
      array[i] = null;
    }
  }

  /**
   * Fills every position in the array with the same value.
   * @param element value to store in each position
   */
  public void fill(T element) {

    for (int i = 0; i < size; i++) {
      array[i] = element;
    }
  }

  /**
   * Prints each element with its index.
   */
  public void print() {

    for (int i = 0; i < size; i++) {
      System.out.println("Element " + i + ": " + this.array[i]);
    }
  }

  /**
   * Creates a shallow copy of the backing array.
   * @return cloned array with the same element references
   */
  public T[] copyArray() {
    // clone creates a new array object, but the stored element references stay the same.
    return array.clone();
  }

  /**
   * Swaps the values stored at two indexes.
   * @param index1 first index to swap
   * @param index2 second index to swap
   */
  public void swap(int index1, int index2) {

    if (index1 < size && index2 < size) {
      T temp = array[index1];
      array[index1] = array[index2];
      array[index2] = temp;
    }
  }

  /**
   * Counts how many positions currently store non-null values.
   * @return number of filled positions
   */
  public int elementCount() {

    int count = 0;

    for (T value : array) {
      if (value != null) count++;
    }
    return count;
  }

  /**
   * Joins the string form of all stored values into one string.
   * @return combined string made from each element
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    // Each value is appended in order to build one continuous string.
    for (T value : array) {
      stringBuilder.append(value.toString());
    }

    return stringBuilder.toString();
  }
}

