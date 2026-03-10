package custom.data.structures.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Fixed Stack Tests")
class FixedStackTests {

    private FixedStack stack;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        stack = new FixedStack(3);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Constructor should create an empty stack")
    void constructorCreatesEmptyStack() {
        printValue("Capacity", stack.capacity);
        printValue("Size", stack.size);
        assertEquals(3, stack.capacity);
        assertEquals(0, stack.size);
    }

    @Test
    @DisplayName("Push should add values and update top")
    void pushAddsValuesAndUpdatesTop() {
        stack.push(10);
        stack.push(20);
        printValue("Top value", stack.getTop());
        assertEquals(2, stack.size);
        assertEquals(20, stack.getTop());
    }

    @Test
    @DisplayName("Push on full stack should keep size unchanged")
    void pushOnFullStackKeepsSizeUnchanged() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            stack.push(40);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Console output", printed);
        assertEquals(3, stack.size);
        assertEquals("Stack Full", printed);
    }

    @Test
    @DisplayName("Pop should remove the top value")
    void popRemovesTopValue() {
        stack.push(10);
        stack.push(20);
        stack.pop();
        printValue("Size after pop", stack.size);
        printValue("Top after pop", stack.getTop());
        assertEquals(1, stack.size);
        assertEquals(10, stack.getTop());
    }

    @Test
    @DisplayName("Pop on empty stack should keep size at zero")
    void popOnEmptyStackKeepsSizeAtZero() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            stack.pop();
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Console output", printed);
        assertEquals(0, stack.size);
        assertEquals("Stack Empty", printed);
    }
}

