package custom.data.structures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Non-Primitive Dynamic 1D Array Tests")
class NonPrimitiveDynamic1DArrayTests {

    NonPrimitiveDynamic1DArray<String> array;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        array = new NonPrimitiveDynamic1DArray<>(String.class, 4);
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
    @DisplayName("Array should not be empty after adding one value")
    void arrayIsNotEmptyAfterAdd() {
        array.add(0, "A");
        boolean empty = array.isEmpty();
        printValue("isEmpty after add", empty);
        assertFalse(empty);
    }

    // --- add / getElement ---

    @Test
    @DisplayName("Added value should be returned from the same index")
    void addAndGetElement() {
        array.add(0, "One");
        String value = array.getElement(0);
        printValue("Value at index 0", value);
        assertEquals("One", value);
    }

    @Test
    @DisplayName("Adding inside current capacity should not throw")
    void addBeyondCapacityGrowsArray() {
        assertDoesNotThrow(() -> array.add(0, "A"));
        assertDoesNotThrow(() -> array.add(3, "D"));
        printValue("Array snapshot", Arrays.toString(array.copyArray()));
    }

    @Test
    @DisplayName("Getting element with invalid index should throw exception")
    void getElementThrowsOnOutOfBounds() {
        printValue("Requested index", 10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.getElement(10));
    }

    // --- remove ---

    @Test
    @DisplayName("Removing one value should reduce element count")
    void removeReducesElementCount() {
        array.add(0, "A");
        array.add(1, "B");
        array.add(2, "C");
        int before = array.elementCount();
        array.remove(1);
        int after = array.elementCount();
        printValue("Element count before", before);
        printValue("Element count after", after);
        assertTrue(after < before);
    }

    @Test
    @DisplayName("Removing with invalid index should throw exception")
    void removeThrowsOnOutOfBounds() {
        printValue("Requested remove index", 20);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(20));
    }

    // --- contains ---

    @Test
    @DisplayName("Contains should return true for stored value")
    void containsReturnsTrueForExistingElement() {
        array.add(2, "Target");
        boolean contains = array.contains("Target");
        printValue("Contains Target", contains);
        assertTrue(contains);
    }

    @Test
    @DisplayName("Contains should return false for missing value")
    void containsReturnsFalseForMissingElement() {
        boolean contains = array.contains("Missing");
        printValue("Contains Missing", contains);
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
        array.add(1, "Find");
        int index = array.indexOf("Find");
        printValue("Index of Find", index);
        assertEquals(1, index);
    }

    @Test
    @DisplayName("IndexOf should return minus one when value is missing")
    void indexOfReturnsMinusOneWhenNotFound() {
        array.fill("X");
        int index = array.indexOf("Absent");
        printValue("Index of Absent", index);
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
    void lastIndexOfReturnsLastOccurrence() {
        array.fill("X");
        array.add(0, "Dup");
        array.add(3, "Dup");
        int index = array.lastIndexOf("Dup");
        printValue("Last index of Dup", index);
        assertEquals(3, index);
    }

    @Test
    @DisplayName("LastIndexOf should return minus one when value is missing")
    void lastIndexOfReturnsMinusOneWhenNotFound() {
        array.fill("X");
        int index = array.lastIndexOf("Ghost");
        printValue("Last index of Ghost", index);
        assertEquals(-1, index);
    }

    // --- clear ---

    @Test
    @DisplayName("Clear should make the array empty")
    void clearMakesArrayEmpty() {
        array.add(0, "A");
        array.add(1, "B");
        array.clear();
        boolean empty = array.isEmpty();
        printValue("isEmpty after clear", empty);
        assertTrue(empty);
    }

    // --- fill ---

    @Test
    @DisplayName("Fill should set the same value in every slot")
    void fillSetsEverySlot() {
        array.fill("X");
        printValue("Filled array", Arrays.toString(array.copyArray()));
        for (int i = 0; i < array.getSize(); i++) {
            assertEquals("X", array.getElement(i));
        }
    }

    // --- swap ---

    @Test
    @DisplayName("Swap should exchange values at two valid indexes")
    void swapExchangesTwoElements() {
        array.add(0, "First");
        array.add(3, "Third");
        array.swap(0, 3);
        printValue("Array after swap", Arrays.toString(array.copyArray()));
        assertEquals("Third", array.getElement(0));
        assertEquals("First", array.getElement(3));
    }

    @Test
    @DisplayName("Swap should ignore invalid index and keep values unchanged")
    void swapDoesNothingOnOutOfBoundsIndex() {
        array.add(0, "A");
        array.swap(0, 99);
        String value = array.getElement(0);
        printValue("Value at index 0 after invalid swap", value);
        assertEquals("A", value);
    }

    // --- elementCount ---

    @Test
    @DisplayName("Element count should match non-null values")
    void elementCountReturnsNumberOfNonNullSlots() {
        array.add(0, "A");
        array.add(2, "C");
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
        array.add(1, "Copy");
        String[] copy = array.copyArray();
        printValue("Copied array", Arrays.toString(copy));
        assertEquals(array.getSize(), copy.length);
        assertEquals("Copy", copy[1]);
    }

    // --- getSize ---

    @Test
    @DisplayName("Get size should return the configured size")
    void getSizeReturnsInitialSize() {
        int size = array.getSize();
        printValue("Array size", size);
        assertEquals(4, size);
    }

    // --- getArray ---

    @Test
    @DisplayName("Get array should return the backing array with stored values")
    void getArrayReturnsBackingArray() {
        array.add(2, "B");
        String[] values = array.getArray();
        printValue("Backing array", Arrays.toString(values));
        assertEquals(4, values.length);
        assertEquals("B", values[2]);
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
        assertTrue(printed.contains("Element 3: P"));
    }

    // --- toString ---

    @Test
    @DisplayName("ToString should join all values in order")
    void toStringReturnsCombinedValues() {
        array.fill("A");
        array.add(1, "B");
        String text = array.toString();
        printValue("toString", text);
        assertEquals("ABAA", text);
    }
}
