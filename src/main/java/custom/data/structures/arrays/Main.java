package custom.data.structures.arrays;

/**
 * Simple runner for the arrays folder.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("==============================");
    System.out.println("CUSTOM DYNAMIC ARRAY");
    System.out.println("==============================");

    NonPrimitiveDynamic1DArray<String> array = new NonPrimitiveDynamic1DArray<>(String.class, 4);

    System.out.println("Initial empty state: " + array.isEmpty());
    array.add(0, "One");
    array.add(1, "Two");
    array.add(2, "Three");
    array.add(3, "Four");

    System.out.println("After adding values:");
    array.print();
    System.out.println("Contains Three: " + array.contains("Three"));
    System.out.println("Index of Two: " + array.indexOf("Two"));
    System.out.println("Element count: " + array.elementCount());
    System.out.println();

    System.out.println("Removing index 1...");
    array.remove(1);
    array.print();
    System.out.println("Element count after remove: " + array.elementCount());
  }
}
