package custom.data.structures.queues;

/**
 * Simple array-based deque.
 * It supports adding and removing values from both ends.
 */
public class Deque {

  int[] data;
  int capacity;
  int size;

  /**
   * Creates a deque with the given capacity.
   * @param capacity maximum number of values
   */
  public Deque(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  /**
   * Returns the total capacity.
   * @return maximum size
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Returns how many values are stored.
   * @return current size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Adds a value at the front.
   * @param value value to add
   */
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

  /**
   * Adds a value at the rear.
   * @param value value to add
   */
  public void addLast(int value) {
    if (size == capacity) {
      System.out.println("Queue Full");
      return;
    }

    data[size] = value;
    size++;
  }

  /**
   * Returns the front value.
   * @return front value or -1 when empty
   */
  public int peek() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return -1;
    }
    return data[0];
  }

  /**
   * Returns the rear value.
   * @return rear value or -1 when empty
   */
  public int rear() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return -1;
    }
    return data[size - 1];
  }

  /**
   * Removes the front value.
   */
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

  /**
   * Removes the rear value.
   */
  public void removeLast() {
    if (size == 0) {
      System.out.println("Queue Empty");
      return;
    }

    data[size - 1] = 0; // optional
    size--;
  }
}
