package custom.data.structures.queues;

/**
 * Simple array-based FIFO queue.
 * Values are removed from the front and added at the rear.
 */
public class SimpleQueue {

  int[] data;
  int capacity;
  int size;

  /**
   * Creates a queue with the given capacity.
   * @param capacity maximum number of values
   */
  public SimpleQueue(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  /**
   * Adds a value at the rear of the queue.
   * @param value value to add
   */
  public void enqueue(int value) {
    if (size == capacity) {
      System.out.println("SimpleQueue Full");
      return;
    }
    data[size] = value;
    size++;
  }

  /**
   * Removes the front value from the queue.
   */
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

  /**
   * Returns the front value.
   * @return front value or -1 when empty
   */
  public int peek() {
    if (size == 0) {
      System.out.println("SimpleQueue Empty");
      return -1;
    }
    return data[0];
  }

  /**
   * Returns the last value in the queue.
   * @return rear value or -1 when empty
   */
  public int rear() {
        if (size == 0) {
              System.out.println("SimpleQueue Empty");
              return -1;
        }
        return data[size-1];
  }

  /**
   * Returns how many values are stored.
   * @return current size
   */
  public int getSize() {
        return size;
  }

  /**
   * Returns the queue capacity.
   * @return maximum size
   */
  public int getCapacity() {
        return capacity;
  }
}
