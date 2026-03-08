package custom.data.structures.stacks;

/**
 * Simple runner for the stacks package.
 */
public class Main {

  public static void main(String[] args) {
    FixedStack fixedStack = new FixedStack(3);
    fixedStack.push(10);
    fixedStack.push(20);
    fixedStack.push(30);

    System.out.println("Fixed stack top: " + fixedStack.getTop());
    fixedStack.printStack();

    DynamicStackLinkedList head = new DynamicStackLinkedList(100);
    head = head.push(head, 200);
    head = head.push(head, 300);

    System.out.println("Linked stack top: " + head.getTop(head));
    System.out.println("Linked stack size: " + head.getSize(head));
  }
}

