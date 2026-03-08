package custom.data.structures.queues;

/**
 * Simple runner for the queues package.
 */
public class Main {

  public static void main(String[] args) {
    SimpleQueue queue = new SimpleQueue(5);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    System.out.println("Simple queue front: " + queue.peek());
    System.out.println("Simple queue rear: " + queue.rear());

    Deque deque = new Deque(5);
    deque.addFirst(20);
    deque.addFirst(10);
    deque.addLast(30);

    System.out.println("Deque front: " + deque.peek());
    System.out.println("Deque rear: " + deque.rear());
  }
}

