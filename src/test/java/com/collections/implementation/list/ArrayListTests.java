package com.collections.implementation.list;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import java.io.*;
import java.util.concurrent.*;

@SpringBootTest
public class ArrayListTests {

    ArrayList list;

    @BeforeEach
    void setup() {
        list = new ArrayList();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    @DisplayName("Test Add Single Element - Tests after adding a single element")
    void testAddSingleElement() {

        list.addElement(2);
        Assertions.assertEquals(10,list.getList().length);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(2, list.getList()[0]);

    }

    @Test
    @DisplayName("Test Printing Mechanism - Prints values existing in the array")
    void testPrintFunction() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.addElement(6);
        list.addElement(91);
        list.addElement(1);

        list.printList(list);

        String printed = outContent.toString();

        Assertions.assertTrue(printed.contains("6"));
        Assertions.assertTrue(printed.contains("91"));
        Assertions.assertTrue(printed.contains("1"));

    }

    @Test
    @DisplayName("Test Upsizing Logic - Test to check dynamic upscaling mechanism")
    void testUpsizing() {


        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(5); // last element and should auto upsize to 11th position

        Assertions.assertEquals(5, list.getList()[10]);
        Assertions.assertEquals(11, list.getSize());
        Assertions.assertEquals(20, list.getList().length);
        Assertions.assertEquals(0, list.getList()[ThreadLocalRandom.current().nextInt(12, 19)]); // Generates a random number between 12 to 19 and ensures it is 0 as empty values in array are 0

    }

    @Test
    @DisplayName("Test Add Element at the Beginning (Without Resizing) - Tests the shift of element towards right to add element at the beginning of the list")
    void testAddElementAtBeginningWithoutResizing() {

        list.addElement(2);
        list.addElement(4);
        list.addElementAtBeginning(5);

        Assertions.assertEquals(5, list.getList()[0]);
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals(10, list.getList().length);
    }

    @Test
    @DisplayName("Test Add Element at the Beginning (With Resizing) - Tests the shift of element towards right to add element at the beginning of the list")
    void testAddElementAtBeginningWithResizing() {

        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElement(2);
        list.addElement(4);
        list.addElementAtBeginning(5);

        Assertions.assertEquals(5, list.getList()[0]);
        Assertions.assertEquals(11, list.getSize());
        Assertions.assertEquals(20, list.getList().length);
    }


    @Test
    @DisplayName("Test Add Element at specified Index (Without Resizing) - Adds element at a specific position in the list")
    void testAddElementAtIndexWithoutResizing() {

        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addAtIndex(99, 2);

        Assertions.assertEquals(99, list.getList()[1]);
        Assertions.assertEquals(5, list.getSize());
        Assertions.assertEquals(10, list.getList().length);


    }

      @Test
      @DisplayName("Test Add Element at specified Index (With Resizing) - Adds element at a specific position in the list")
      void testAddElementAtIndexWithResizing() {

            list.addElement(2);
            list.addElement(4);
            list.addElement(2);
            list.addElement(4);
            list.addElement(2);
            list.addElement(4);
            list.addElement(2);
            list.addElement(4);
            list.addElement(2);
            list.addElement(4);

            list.addAtIndex(99, 2);

            Assertions.assertEquals(99, list.getList()[1]);
            Assertions.assertEquals(11, list.getSize());
            Assertions.assertEquals(20, list.getList().length);


      }

      @Test
      @DisplayName("Test Remove First Element - Removes element from the beginning of the list")
      void testRemoveFirstElement() {

          list.addElement(2);
          list.addElement(4);
          list.addElement(4);
          list.addElement(4);
          list.addElement(4);

          list.removeFirst();

          Assertions.assertEquals(4, list.getList()[0]);
          Assertions.assertEquals(4, list.getSize());
          Assertions.assertEquals(9, list.getList().length);

      }

      @Test
      @DisplayName("Test Remove Last Element - Removes the last non-zero element of the list depending on the size")
      void testRemoveLastElement() {

            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(6);


            list.removeLast();

            Assertions.assertEquals(5, list.getList()[3]);
            Assertions.assertEquals(4, list.getSize());
            Assertions.assertEquals(10, list.getList().length);
      }

      @Test
      @DisplayName("Test Downsizing - Trims the list to only the number of elements present in the list")
      void testDownsizing() {

          list.addElement(2);
          list.addElement(4);


          int[] downSizedList = list.downsize();

          Assertions.assertEquals(2, downSizedList.length);
      }


      @Test
      @DisplayName("Test Remove At Index - Removes element at a particular index")
      void testRemoveAtIndex() {

            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(6);

            list.removeAtIndex(2);

            Assertions.assertEquals(5, list.getList()[2]);

      }

      @Test
      @DisplayName("Test Remove First Occurrence (End) - Removes first occurrence of an element occurring at the end of the list")
      void testRemoveFirstOccurrenceAtEnd() {

            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(6);
            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(7);

            list.removeFirstOccurrence(7);

            Assertions.assertEquals(0, list.getList()[9]);

      }

      @Test
      @DisplayName("Test Remove First Occurrence (Beginning) - Removes first occurrence of an element occurring at the beginning of the list")
      void testRemoveFirstOccurrenceAtBeginning() {

            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(6);
            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(7);

            list.removeFirstOccurrence(2);

            Assertions.assertEquals(3, list.getList()[0]);

      }

      @Test
      @DisplayName("Test Remove First Occurrence (Middle) - Removes first occurrence of an element occurring at the middle of the list")
      void testRemoveFirstOccurrenceAtMiddle() {

            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(6);
            list.addElement(2);
            list.addElement(3);
            list.addElement(4);
            list.addElement(5);
            list.addElement(7);

            list.removeFirstOccurrence(4);

            Assertions.assertEquals(5, list.getList()[2]);

      }


//      @Test
//      @DisplayName("Test Remove All Occurrences - Removes all occurrences of an element")
//      void testRemoveAllOccurrences() {
//
//            list.addElement(2);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(6);
//            list.addElement(2);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(7);
//
//            list.removeFirstOccurrence(3);
//
//            Assertions.assertEquals(1, list.getList()[4]);
////            Assertions.assertEquals()
//
//      }

//      @Test
//      @DisplayName("Test Last Occurrence (End) - Removes last occurrence of an element occurring at the end of the list")
//      void testRemoveLastOccurrenceAtEnd() {
//
//            list.addElement(2);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(6);
//            list.addElement(1);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(7);
//
//            list.removeLastOccurrence(7);
//
//            Assertions.assertEquals(0, list.getList()[9]);
//
//      }
//
//      @Test
//      @DisplayName("Test Remove Last Occurrence (Beginning) - Removes Last occurrence of an element occurring at the beginning of the list")
//      void testRemoveLastOccurrenceAtBeginning() {
//
//            list.addElement(3);
//            list.addElement(2);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(6);
//            list.addElement(1);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(7);
//
//            list.removeLastOccurrence(2);
//
//            Assertions.assertEquals(4, list.getList()[1]);
//
//      }
//
//      @Test
//      @DisplayName("Test Remove Last Occurrence (Middle) - Removes Last occurrence of an element occurring at the middle of the list")
//      void testRemoveLastOccurrenceAtMiddle() {
//
//            list.addElement(2);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(6);
//            list.addElement(2);
//            list.addElement(3);
//            list.addElement(4);
//            list.addElement(5);
//            list.addElement(7);
//
//            list.removeLastOccurrence(6);
//
//            Assertions.assertEquals(2, list.getList()[4]);
//
//      }
}
