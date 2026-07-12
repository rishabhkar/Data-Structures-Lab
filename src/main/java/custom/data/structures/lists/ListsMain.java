package custom.data.structures.lists;

/**
 * Simple runner for the custom list package.
 */
public class ListsMain {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.addElement(10);
    list.addElement(20);
    list.addElementAtBeginning(5);

    System.out.println("Custom array-backed list");
    System.out.println("Current size: " + list.getSize());
    list.printList(list);
  }
}

