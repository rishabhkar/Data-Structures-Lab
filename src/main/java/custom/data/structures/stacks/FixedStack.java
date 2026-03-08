package custom.data.structures.stacks;

/**
 * Simple fixed-size stack using an array.
 * It stores integers and stops accepting values when full.
 */
public class FixedStack {

  int[] data;
  int capacity;
  int size;

  /**
   * Creates a stack with the given capacity.
   * @param capacity maximum number of values
   */
  public FixedStack(int capacity) {
    this.capacity = capacity;
    this.data = new int[capacity];
    this.size = 0;
  }

  /**
   * Pushes a value on top of the stack.
   * @param value value to push
   */
  public void push(int value) {
    if (size == capacity) {
      System.out.println("Stack Full");
      return;
    }
    data[size] = value;
    size++;
  }

  /**
   * Returns the top value.
   * @return current top value
   */
  public int getTop() {
    return data[size-1];
  }

  /**
   * Prints the stack from top to bottom.
   */
  public void printStack() {
    for (int i = size-1; i >= 0; i--) {
      System.out.println(data[i]);
    }
  }

  /**
   * Removes the top value from the stack.
   */
  public void pop() {
        if (size == 0) {
      System.out.println("Stack Empty");
      return;
        }
        data[size-1] = 0;
        size--;
  }
}
