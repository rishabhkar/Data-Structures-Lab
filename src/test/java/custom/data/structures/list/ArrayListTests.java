package custom.data.structures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Custom Array List Tests")
class ArrayListTests {

    private ArrayList list;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        list = new ArrayList();
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Default constructor should create capacity ten")
    void defaultConstructorCreatesCapacityTen() {
        printValue("Length", list.getList().length);
        printValue("Size", list.getSize());
        assertEquals(10, list.getList().length);
        assertEquals(0, list.getSize());
    }

    @Test
    @DisplayName("Add element should store values at the end")
    void addElementStoresValuesAtTheEnd() {
        list.addElement(10);
        list.addElement(20);
        printValue("First value", list.getList()[0]);
        printValue("Second value", list.getList()[1]);
        assertEquals(2, list.getSize());
        assertEquals(10, list.getList()[0]);
        assertEquals(20, list.getList()[1]);
    }

    @Test
    @DisplayName("Add element at beginning should shift old values")
    void addElementAtBeginningShiftsOldValues() {
        list.addElement(20);
        list.addElement(30);
        list.addElementAtBeginning(10);
        printValue("Values", list.getList()[0] + ", " + list.getList()[1] + ", " + list.getList()[2]);
        assertEquals(3, list.getSize());
        assertEquals(10, list.getList()[0]);
        assertEquals(20, list.getList()[1]);
        assertEquals(30, list.getList()[2]);
    }

    @Test
    @DisplayName("Add at index should place value before the target spot")
    void addAtIndexPlacesValueBeforeTargetSpot() {
        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.addAtIndex(99, 2);
        printValue("Values", list.getList()[0] + ", " + list.getList()[1] + ", " + list.getList()[2] + ", " + list.getList()[3]);
        assertEquals(4, list.getSize());
        assertEquals(10, list.getList()[0]);
        assertEquals(99, list.getList()[1]);
        assertEquals(20, list.getList()[2]);
        assertEquals(30, list.getList()[3]);
    }

    @Test
    @DisplayName("Remove last should clear the last stored value")
    void removeLastClearsLastStoredValue() {
        list.addElement(10);
        list.addElement(20);
        list.removeLast();
        printValue("Size after removeLast", list.getSize());
        assertEquals(1, list.getSize());
        assertEquals(10, list.getList()[0]);
    }

    @Test
    @DisplayName("Remove first should shift the remaining values")
    void removeFirstShiftsRemainingValues() {
        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.removeFirst();
        printValue("First value after removeFirst", list.getList()[0]);
        assertEquals(2, list.getSize());
        assertEquals(20, list.getList()[0]);
        assertEquals(30, list.getList()[1]);
    }

    @Test
    @DisplayName("Upsize should double the array length")
    void upsizeDoublesTheArrayLength() {
        int[] biggerList = list.upsize(list.getList());
        printValue("New length", biggerList.length);
        assertEquals(20, biggerList.length);
    }

    @Test
    @DisplayName("Downsize should shrink the array to current size")
    void downsizeShrinksArrayToCurrentSize() {
        list.addElement(10);
        list.addElement(20);
        int[] smallList = list.downsize();
        printValue("Downsized length", smallList.length);
        assertEquals(2, smallList.length);
        assertEquals(10, smallList[0]);
        assertEquals(20, smallList[1]);
    }
}

