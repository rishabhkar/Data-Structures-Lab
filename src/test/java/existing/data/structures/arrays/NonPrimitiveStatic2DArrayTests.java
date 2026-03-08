package existing.data.structures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Non-Primitive Static 2D Array Tests")
class NonPrimitiveStatic2DArrayTests {

    NonPrimitiveStatic2DArray<String> array;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        array = new NonPrimitiveStatic2DArray<>(String.class, 3, 3);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    private void fillMatrix() {
        array.setElement(0, 0, "A");
        array.setElement(0, 1, "B");
        array.setElement(0, 2, "C");
        array.setElement(1, 0, "D");
        array.setElement(1, 1, "E");
        array.setElement(1, 2, "F");
        array.setElement(2, 0, "G");
        array.setElement(2, 1, "H");
        array.setElement(2, 2, "I");
    }

    @Test
    @DisplayName("New 2D array should be empty")
    void newArrayIsEmpty() {
        boolean empty = array.isEmpty();
        printValue("isEmpty", empty);
        assertTrue(empty);
    }

    @Test
    @DisplayName("2D array should not be empty after setting one value")
    void arrayIsNotEmptyAfterInsertion() {
        array.setElement(0, 0, "A");
        boolean empty = array.isEmpty();
        printValue("isEmpty after set", empty);
        assertFalse(empty);
    }

    @Test
    @DisplayName("Get array should return the backing matrix")
    void getArrayReturnsBackingMatrix() {
        array.setElement(1, 1, "Center");
        String[][] values = array.getArray();
        printValue("Backing matrix", Arrays.deepToString(values));
        assertEquals(3, values.length);
        assertEquals("Center", values[1][1]);
    }

    @Test
    @DisplayName("Set array should replace the backing matrix when dimensions match")
    void setArrayReplacesBackingMatrix() {
        String[][] replacement = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };

        array.setArray(replacement);
        printValue("Matrix after setArray", Arrays.deepToString(array.getArray()));
        assertSame(replacement, array.getArray());
    }

    @Test
    @DisplayName("Set array should throw when passed null")
    void setArrayThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> array.setArray(null));
    }

    @Test
    @DisplayName("Set value should be returned from the same row and column")
    void setAndGetElement() {
        array.setElement(1, 2, "Hello");
        String value = array.getElement(1, 2);
        printValue("Value at [1][2]", value);
        assertEquals("Hello", value);
    }

    @Test
    @DisplayName("Should allow setting values at both corner positions")
    void setElementAtCorners() {
        array.setElement(0, 0, "TopLeft");
        array.setElement(2, 2, "BottomRight");
        printValue("Top-left", array.getElement(0, 0));
        printValue("Bottom-right", array.getElement(2, 2));
        assertEquals("TopLeft", array.getElement(0, 0));
        assertEquals("BottomRight", array.getElement(2, 2));
    }

    @Test
    @DisplayName("Setting element with invalid row should throw exception")
    void setElementThrowsOnOutOfBoundsRow() {
        printValue("Requested row", 5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.setElement(5, 0, "X"));
    }

    @Test
    @DisplayName("Setting element with invalid column should throw exception")
    void setElementThrowsOnOutOfBoundsCol() {
        printValue("Requested column", 5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.setElement(0, 5, "X"));
    }

    @Test
    @DisplayName("Getting element with negative index should throw exception")
    void getElementThrowsOnNegativeIndex() {
        printValue("Requested coordinates", "[-1][0]");
        assertThrows(IndexOutOfBoundsException.class, () -> array.getElement(-1, 0));
    }

    @Test
    @DisplayName("Get row should return the correct row values")
    void getRowReturnsCorrectRow() {
        array.setElement(1, 0, "R1C0");
        array.setElement(1, 1, "R1C1");
        String[] row = array.getRow(1);
        printValue("Row 1", Arrays.toString(row));
        assertEquals("R1C0", row[0]);
        assertEquals("R1C1", row[1]);
    }

    @Test
    @DisplayName("Get row with invalid index should throw exception")
    void getRowThrowsOnOutOfBounds() {
        printValue("Requested row", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.getRow(10));
    }

    @Test
    @DisplayName("Set row should replace one full row")
    void setRowReplacesValuesCorrectly() {
        String[] newRow = {"X", "Y", "Z"};
        array.setRow(1, newRow);
        printValue("Row 1 after setRow", Arrays.toString(array.getRow(1)));
        assertArrayEquals(newRow, array.getRow(1));
    }

    @Test
    @DisplayName("Set row with invalid length should throw exception")
    void setRowThrowsWhenLengthDoesNotMatch() {
        String[] newRow = {"X", "Y"};
        assertThrows(IllegalArgumentException.class, () -> array.setRow(1, newRow));
    }

    @Test
    @DisplayName("Get column should return the correct column values")
    void getColumnReturnsArrayWithCorrectLength() {
        fillMatrix();
        String[] col = array.getColumn(1);
        printValue("Column 1", Arrays.toString(col));
        assertArrayEquals(new String[]{"B", "E", "H"}, col);
    }

    @Test
    @DisplayName("Get column with invalid index should throw exception")
    void getColumnThrowsOnOutOfBounds() {
        printValue("Requested column", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.getColumn(10));
    }

    @Test
    @DisplayName("Set column should replace all values in that column")
    void setColumnReplacesValuesCorrectly() {
        String[] newCol = {"X", "Y", "Z"};
        array.setColumn(0, newCol);
        printValue("Column 0 values", array.getElement(0, 0) + ", " + array.getElement(1, 0) + ", " + array.getElement(2, 0));
        assertEquals("X", array.getElement(0, 0));
        assertEquals("Y", array.getElement(1, 0));
        assertEquals("Z", array.getElement(2, 0));
    }

    @Test
    @DisplayName("Contains should return true for stored value")
    void containsReturnsTrueForStoredValue() {
        String val = "Target";
        array.setElement(2, 2, val);
        boolean contains = array.contains(val);
        printValue("Contains Target", contains);
        assertTrue(contains);
    }

    @Test
    @DisplayName("Contains should return false for missing value")
    void containsReturnsFalseForMissingElement() {
        String val = "Missing";
        boolean contains = array.contains(val);
        printValue("Contains Missing", contains);
        assertFalse(contains);
    }

    @Test
    @DisplayName("Contains with null should throw exception")
    void containsThrowsForNull() {
        printValue("Contains value", null);
        assertThrows(IllegalArgumentException.class, () -> array.contains(null));
    }

    @Test
    @DisplayName("IndexOf should return the first matching coordinates")
    void indexOfReturnsFirstMatch() {
        fillMatrix();
        Object index = invokeCoordinatesMethod("indexOf", "E");
        printValue("Index of E", index);
        assertEquals(1, rowOf(index));
        assertEquals(1, colOf(index));
    }

    @Test
    @DisplayName("IndexOf should return minus one coordinates when value is missing")
    void indexOfReturnsMinusOneWhenMissing() {
        Object index = invokeCoordinatesMethod("indexOf", "Missing");
        printValue("Index of Missing", index);
        assertEquals(-1, rowOf(index));
        assertEquals(-1, colOf(index));
    }

    @Test
    @DisplayName("LastIndexOf should return the last matching coordinates")
    void lastIndexOfReturnsLastMatch() {
        array.setElement(0, 1, "Dup");
        array.setElement(2, 2, "Dup");
        Object index = invokeCoordinatesMethod("lastIndexOf", "Dup");
        printValue("Last index of Dup", index);
        assertEquals(2, rowOf(index));
        assertEquals(2, colOf(index));
    }

    @Test
    @DisplayName("Clear should make the 2D array empty")
    void clearMakesArrayEmpty() {
        array.setElement(0, 0, "A");
        array.setElement(1, 1, "B");
        array.clear();
        boolean empty = array.isEmpty();
        printValue("isEmpty after clear", empty);
        assertTrue(empty);
    }

    @Test
    @DisplayName("Fill should set the same value in every slot")
    void fillSetsEverySlot() {
        String val = "F";
        array.fill(val);
        printValue("Filled matrix", Arrays.deepToString(array.getArray()));
        for (int i = 0; i < array.getRowSize(); i++) {
            for (int j = 0; j < array.getColSize(); j++) {
                assertEquals(val, array.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Swap should exchange two valid coordinates")
    void swapExchangesValues() {
        array.setElement(0, 0, "First");
        array.setElement(2, 2, "Second");
        invokeSwap(0, 0, 2, 2);
        printValue("Matrix after swap", Arrays.deepToString(array.getArray()));
        assertEquals("Second", array.getElement(0, 0));
        assertEquals("First", array.getElement(2, 2));
    }

    @Test
    @DisplayName("Swap with invalid coordinates should throw exception")
    void swapThrowsOnInvalidCoordinates() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> invokeSwap(0, 0, 5, 5));
        printValue("Swap exception", exception.getClass().getSimpleName());
        assertNotNull(exception.getCause());
    }

    @Test
    @DisplayName("Print should show row and column positions with values")
    void printShowsCoordinatesAndValues() {
        array.fill("P");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;

        try {
            System.setOut(new PrintStream(output));
            array.print();
        } finally {
            System.setOut(original);
        }

        String printed = output.toString();
        printValue("Printed output", printed.replace(System.lineSeparator(), " | "));
        assertTrue(printed.contains("Element at Row 0 and Column 0 is : P"));
        assertTrue(printed.contains("Element at Row 2 and Column 2 is : P"));
    }

    @Test
    @DisplayName("Copy array should fill the target matrix and return a clone")
    void copyArrayCopiesValuesIntoTarget() {
        fillMatrix();
        String[][] target = new String[3][3];
        String[][] copy = array.copyArray(target);
        printValue("Copied target", Arrays.deepToString(target));
        assertArrayEquals(array.getArray(), target);
        assertArrayEquals(array.getArray(), copy);
        assertNotSame(array.getArray(), copy);
    }

    @Test
    @DisplayName("Element count should match non-null matrix values")
    void elementCountReturnsFilledSlotCount() {
        array.setElement(0, 0, "A");
        array.setElement(1, 1, "B");
        array.setElement(2, 2, "C");
        int count = array.elementCount();
        printValue("Element count", count);
        assertEquals(3, count);
    }

    @Test
    @DisplayName("Boundary traversal should return outer ring values in order")
    void boundaryTraversalReturnsOuterElements() {
        fillMatrix();
        String[] boundary = array.boundaryTraversal();
        printValue("Boundary traversal", Arrays.toString(boundary));
        assertArrayEquals(new String[]{"A", "B", "C", "F", "I", "H", "G", "D"}, boundary);
    }

    @Test
    @DisplayName("isJagged should return false for a uniform matrix")
    void isJaggedReturnsFalseForUniformArray() {
        String[][] uniform = {{"A", "B"}, {"C", "D"}};
        boolean jagged = array.isJagged(uniform);
        printValue("isJagged", jagged);
        assertFalse(jagged);
    }

    @Test
    @DisplayName("isJagged should return true when a row is null")
    void isJaggedReturnsTrueForNullRow() {
        String[][] jagged = {{"A", "B"}, null};
        boolean result = array.isJagged(jagged);
        printValue("isJagged for null row", result);
        assertTrue(result);
    }

    @Test
    @DisplayName("isJagged with null matrix should throw exception")
    void isJaggedThrowsForNullArray() {
        printValue("Checked matrix", null);
        assertThrows(IllegalArgumentException.class, () -> array.isJagged(null));
    }

    @Test
    @DisplayName("Row size and column size should match configured dimensions")
    void getDimensionsReturnConfiguredValues() {
        int rows = array.getRowSize();
        int cols = array.getColSize();
        printValue("Row size", rows);
        printValue("Column size", cols);
        assertEquals(3, rows);
        assertEquals(3, cols);
    }

    private Object createCoordinates(int row, int col) {
        try {
            Class<?> coordinatesClass = Class.forName("existing.data.structures.arrays.Coordinates");
            var constructor = coordinatesClass.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(row, col);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private Object invokeCoordinatesMethod(String methodName, String value) {
        try {
            var method = NonPrimitiveStatic2DArray.class.getMethod(methodName, Object.class);
            return method.invoke(array, value);
        } catch (NoSuchMethodException exception) {
            try {
                var method = NonPrimitiveStatic2DArray.class.getDeclaredMethod(methodName, Object.class);
                method.setAccessible(true);
                return method.invoke(array, value);
            } catch (Exception innerException) {
                throw new RuntimeException(innerException);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private int rowOf(Object coordinates) {
        try {
            return (int) coordinates.getClass().getDeclaredMethod("row").invoke(coordinates);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private int colOf(Object coordinates) {
        try {
            return (int) coordinates.getClass().getDeclaredMethod("col").invoke(coordinates);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private void invokeSwap(int row1, int col1, int row2, int col2) {
        try {
            Class<?> coordinatesClass = Class.forName("existing.data.structures.arrays.Coordinates");
            var method = NonPrimitiveStatic2DArray.class.getMethod("swap", coordinatesClass, coordinatesClass);
            method.invoke(array, createCoordinates(row1, col1), createCoordinates(row2, col2));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
