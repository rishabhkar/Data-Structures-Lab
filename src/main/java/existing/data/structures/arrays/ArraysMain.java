package existing.data.structures.arrays;

/**
 * Simple runner for quick manual array checks.
 */
public class ArraysMain {

  /**
   * Runs small examples for the array classes.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    runStaticOneDimensionalExample();
    runStaticTwoDimensionalExample();

    System.out.println("Dynamic array examples now live in custom.data.structures.arrays.Main");
  }

  private static void runStaticOneDimensionalExample() {
    System.out.println("==============================");
    System.out.println("STATIC 1D ARRAY");
    System.out.println("==============================");

    NonPrimitiveStatic1DArray<String> array = new NonPrimitiveStatic1DArray<>(String.class, 4);

    System.out.println("Initial empty state: " + array.isEmpty());
    array.setElement(0, "A");
    array.setElement(1, "B");
    array.setElement(2, "C");
    array.setElement(3, "D");

    System.out.println("After inserting A, B, C, D:");
    array.print();
    System.out.println("Contains C: " + array.contains("C"));
    System.out.println("Index of B: " + array.indexOf("B"));
    System.out.println("Last index of D: " + array.lastIndexOf("D"));
    System.out.println("Element count: " + array.elementCount());
    System.out.println();
  }

  private static void runStaticTwoDimensionalExample() {
    System.out.println("==============================");
    System.out.println("STATIC 2D ARRAY");
    System.out.println("==============================");

    NonPrimitiveStatic2DArray<String> array = new NonPrimitiveStatic2DArray<>(String.class, 2, 2);

    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";

    array.setElement(0, 0, a);
    array.setElement(0, 1, b);
    array.setElement(1, 0, c);
    array.setElement(1, 1, d);

    System.out.println("After filling the matrix:");
    array.print();
    System.out.println("First row: " + java.util.Arrays.toString(array.getRow(0)));
    System.out.println("Contains C reference: " + array.contains(c));
    System.out.println("Current elementCount result: " + array.elementCount());
    System.out.println();
  }
}
