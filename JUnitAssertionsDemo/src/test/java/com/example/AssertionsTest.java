package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertions() {
        AssertionsExample example = new AssertionsExample();

        // Verifies that the arithmetic expression evaluates to the expected value.
        assertEquals(5, 2 + 3);

        // Verifies that the add method returns the correct sum for the provided inputs.
        assertEquals(5, example.add(2, 3));

        // Verifies that the condition is true.
        assertTrue(5 > 3);

        // Verifies that the condition is false.
        assertFalse(5 < 3);

        // Verifies that the value is null.
        assertNull(null);

        // Verifies that the object reference is not null.
        assertNotNull(new Object());
    }
}
