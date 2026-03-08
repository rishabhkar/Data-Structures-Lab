package existing.data.structures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Non-Primitive Static 1D Array Tests")
class NonPrimitiveStatic1DArrayTests {

    NonPrimitiveStatic1DArray<String> array;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        array = new NonPrimitiveStatic1DArray<>(String.class, 5);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    // --- isEmpty ---

    @Test
    @DisplayName("New array should be empty")
    void newArrayIsEmpty() {
        boolean empty = array.isEmpty();
        printValue("isEmpty", empty);
        assertTrue(empty);
    }

    @Test
    @DisplayName("Array should not be empty after setting one value")
    void arrayIsNotEmptyAfterInsertion() {
        array.setElement(0, "A");
        boolean empty = array.isEmpty();
        printValue("isEmpty after set", empty);
        assertFalse(empty);
    }

    // --- setElement / getElement ---

    @Test
    @DisplayName("Set value should be returned from the same index")
    void setAndGetElement() {
        array.setElement(2, "Hello");
        String value = array.getElement(2);
        printValue("Value at index 2", value);
        assertEquals("Hello", value);
    }

    @Test
    @DisplayName("Should allow setting value at last valid index")
    void setElementAtLastIndex() {
        array.setElement(4, "Last");
        String value = array.getElement(4);
        printValue("Value at last index", value);
        assertEquals("Last", value);
    }

    @Test
    @DisplayName("Setting element outside bounds should throw exception")
    void setElementThrowsOnOutOfBounds() {
        printValue("Requested set index", 5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.setElement(5, "X"));
    }

    @Test
    @DisplayName("Getting element outside bounds should throw exception")
    void getElementThrowsOnOutOfBounds() {
        printValue("Requested get index", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.getElement(10));
    }

    // --- contains ---

    @Test
    @DisplayName("Contains should return true for stored value")
    void containsReturnsTrueForExistingElement() {
        array.setElement(1, "B");
        boolean contains = array.contains("B");
        printValue("Contains B", contains);
        assertTrue(contains);
    }

    @Test
    @DisplayName("Contains should return false for missing value")
    void containsReturnsFalseForMissingElement() {
        boolean contains = array.contains("Z");
        printValue("Contains Z", contains);
        assertFalse(contains);
    }

    @Test
    @DisplayName("Contains should return false for null")
    void containsReturnsFalseForNull() {
        boolean contains = array.contains(null);
        printValue("Contains null", contains);
        assertFalse(contains);
    }

    // --- indexOf ---
    // Note: fill the array first so indexOf doesn't hit a null slot and throw NPE.

    @Test
    @DisplayName("IndexOf should return the matching index")
    void indexOfReturnsCorrectIndex() {
        array.fill("X");
        array.setElement(3, "C");
        int index = array.indexOf("C");
        printValue("Index of C", index);
        assertEquals(3, index);
    }

    @Test
    @DisplayName("IndexOf should return minus one when value is missing")
    void indexOfReturnsMinusOneWhenNotFound() {
        array.fill("X");
        int index = array.indexOf("Missing");
        printValue("Index of Missing", index);
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("IndexOf should return minus one for null")
    void indexOfReturnsMinusOneForNull() {
        int index = array.indexOf(null);
        printValue("Index of null", index);
        assertEquals(-1, index);
    }

    // --- lastIndexOf ---

    @Test
    @DisplayName("LastIndexOf should return the last matching index")
    void lastIndexOfReturnLastOccurrence() {
        array.fill("Z");
        array.setElement(0, "X");
        array.setElement(3, "X");
        int index = array.lastIndexOf("X");
        printValue("Last index of X", index);
        assertEquals(3, index);
    }

    @Test
    @DisplayName("LastIndexOf should return minus one when value is missing")
    void lastIndexOfReturnsMinusOneWhenNotFound() {
        array.fill("X");
        int index = array.lastIndexOf("Missing");
        printValue("Last index of Missing", index);
        assertEquals(-1, index);
    }

    // --- clear ---

    @Test
    @DisplayName("Clear should make the array empty")
    void clearMakesArrayEmpty() {
        array.setElement(0, "A");
        array.setElement(1, "B");
        array.clear();
        boolean empty = array.isEmpty();
        printValue("isEmpty after clear", empty);
        assertTrue(empty);
    }

    // --- fill ---

    @Test
    @DisplayName("Fill should set the same value in every slot")
    void fillSetsEverySlot() {
        array.fill("Z");
        printValue("Filled array", Arrays.toString(array.copyArray()));
        for (int i = 0; i < array.getSize(); i++) {
            assertEquals("Z", array.getElement(i));
        }
    }

    // --- swap ---

    @Test
    @DisplayName("Swap should exchange values at two valid indexes")
    void swapExchangesTwoElements() {
        array.setElement(0, "First");
        array.setElement(4, "Last");
        array.swap(0, 4);
        printValue("Array after swap", Arrays.toString(array.copyArray()));
        assertEquals("Last", array.getElement(0));
        assertEquals("First", array.getElement(4));
    }

    @Test
    @DisplayName("Swap should ignore invalid index and keep values unchanged")
    void swapDoesNothingOnOutOfBoundsIndex() {
        array.setElement(0, "A");
        array.swap(0, 10);
        String value = array.getElement(0);
        printValue("Value at index 0 after invalid swap", value);
        assertEquals("A", value);
    }

    // --- elementCount ---

    @Test
    @DisplayName("Element count should match non-null values")
    void elementCountReturnsNumberOfNonNullSlots() {
        array.setElement(0, "A");
        array.setElement(2, "B");
        int count = array.elementCount();
        printValue("Element count", count);
        assertEquals(2, count);
    }

    @Test
    @DisplayName("Element count should be zero for empty array")
    void elementCountIsZeroOnEmptyArray() {
        int count = array.elementCount();
        printValue("Element count", count);
        assertEquals(0, count);
    }

    // --- copyArray ---

    @Test
    @DisplayName("Copy array should keep the same size and values")
    void copyArrayReturnsSameLengthAndValues() {
        array.setElement(1, "Copy");
        String[] copy = array.copyArray();
        printValue("Copied array", Arrays.toString(copy));
        assertEquals(array.getSize(), copy.length);
        assertEquals("Copy", copy[1]);
    }

    // --- getSize ---

    @Test
    @DisplayName("Get size should return the configured size")
    void getSizeReturnsCorrectSize() {
        int size = array.getSize();
        printValue("Array size", size);
        assertEquals(5, size);
    }

    // --- getArray ---

    @Test
    @DisplayName("Get array should return the backing array with stored values")
    void getArrayReturnsBackingArray() {
        array.setElement(1, "B");
        String[] values = array.getArray();
        printValue("Backing array", Arrays.toString(values));
        assertEquals(5, values.length);
        assertEquals("B", values[1]);
    }

    // --- print ---

    @Test
    @DisplayName("Print should show each index and value")
    void printShowsIndexesAndValues() {
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
        assertTrue(printed.contains("Element 0: P"));
        assertTrue(printed.contains("Element 4: P"));
    }

    // --- toString ---

    @Test
    @DisplayName("ToString should join all values in order")
    void toStringReturnsCombinedValues() {
        array.fill("A");
        array.setElement(2, "B");
        String text = array.toString();
        printValue("toString", text);
        assertEquals("AABAA", text);
    }
}
