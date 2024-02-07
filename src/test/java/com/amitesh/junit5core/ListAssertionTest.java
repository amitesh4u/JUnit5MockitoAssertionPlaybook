package com.amitesh.junit5core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates how we can write assertions for {@code List} objects by using JUnit 5.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Writing assertions for lists")
class ListAssertionTest {

  /**
   * The type When we write assertions for elements.
   */
  @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements {

    /**
     * The Expected size.
     */
    private final int EXPECTED_SIZE = 2;

    /**
     * The First.
     */
    private Object first;
    /**
     * The Second.
     */
    private Object second;

    /**
     * The List.
     */
    private List<Object> list;

    /**
     * Create and initialize list.
     */
    @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

    /**
     * Should contain two elements.
     */
    @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertEquals(EXPECTED_SIZE, list.size());
        }

    /**
     * Should contain two elements with custom error message.
     */
    @Test
        @DisplayName("Should contain two elements (with custom error message)")
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertEquals(EXPECTED_SIZE,
                    list.size(),
                    () -> String.format("The size of the list was not %d", EXPECTED_SIZE)
            );
        }

    /**
     * Should contain correct elements.
     */
    @Test
        @DisplayName("Should contain the correct elements")
        void shouldContainCorrectElements() {
            assertTrue(list.containsAll(Arrays.asList(first, second)));
        }

    /**
     * Should contain correct elements with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct elements (with custom error message)")
        void shouldContainCorrectElementsWithCustomErrorMessage() {
            assertTrue(list.containsAll(Arrays.asList(first, second)),
                    () -> String.format("The list doesn't contain the objects: %s and %s", first, second)
            );
        }

    /**
     * Should not contain incorrect element.
     */
    @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertFalse(list.contains(new Object()));
        }

    /**
     * Should not contain incorrect element with custom error message.
     */
    @Test
        @DisplayName("Should not contain an incorrect element (with custom error message)")
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertFalse(list.contains(incorrect),
                    () -> String.format("The list contains an incorrect object: %s", incorrect)
            );
        }
    }

  /**
   * The type When we compare two lists.
   */
  @Nested
    @DisplayName("When we compare two lists")
    class WhenWeCompareTwoLists {

    /**
     * The First.
     */
    private final List<Integer> FIRST = Arrays.asList(1, 2, 3);
    /**
     * The Second.
     */
    private final List<Integer> SECOND = Arrays.asList(1, 2, 3);

    /**
     * Should contain same elements.
     */
    @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertIterableEquals(FIRST, SECOND);
        }

    /**
     * Should contain same elements with custom error message.
     */
    @Test
        @DisplayName("Should contain the same elements (with custom error message)")
        void shouldContainSameElementsWithCustomErrorMessage() {
            assertIterableEquals(FIRST, SECOND, "The lists don't contain the same elements");
        }
    }
}
