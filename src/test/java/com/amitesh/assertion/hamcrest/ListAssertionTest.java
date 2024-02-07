package com.amitesh.assertion.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for {@code List} objects by using JUnit 5 and
 * Hamcrest.
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
            assertThat(list, hasSize(2));
        }

    /**
     * Should contain two elements with custom error message.
     */
    @Test
        @DisplayName("Should contain two elements (with custom error message)")
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertThat(String.format("The size of the list was not %d", EXPECTED_SIZE), list, hasSize(2));
        }

    /**
     * Should contain correct elements in any order.
     */
    @Test
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list, containsInAnyOrder(second, first));
        }

    /**
     * Should contain correct elements in any order with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct elements in any order (with custom error message)")
        void shouldContainCorrectElementsInAnyOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    containsInAnyOrder(second, first)
            );
        }

    /**
     * Should contain correct elements in given order.
     */
    @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list, contains(first, second));
        }

    /**
     * Should contain correct elements in given order with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct elements in the given order(with custom error message)")
        void shouldContainCorrectElementsInGivenOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    contains(first, second)
            );
        }

    /**
     * Should contain correct element.
     */
    @Test
        @DisplayName("Should contain a correct element")
        void shouldContainCorrectElement() {
            assertThat(list, hasItem(first));
        }

    /**
     * Should contain correct element with custom error message.
     */
    @Test
        @DisplayName("Should contain a correct element (with custom error message)")
        void shouldContainCorrectElementWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the expected object: %s", first),
                    list,
                    hasItem(first)
            );
        }

    /**
     * Should not contain incorrect element.
     */
    @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(list, not(hasItem(new Object())));
        }

    /**
     * Should not contain incorrect element with custom error message.
     */
    @Test
        @DisplayName("Should not contain an incorrect element (with custom error message)")
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertThat(String.format("The list contains an incorrect object: %s", incorrect),
                    list,
                    not(hasItem(incorrect))
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
     * The Actual.
     */
    private final List<Integer> ACTUAL = Arrays.asList(1, 2, 3);
    /**
     * The Expected.
     */
    private final List<Integer> EXPECTED = Arrays.asList(1, 2, 3);

    /**
     * Should contain same elements.
     */
    @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(ACTUAL, equalTo(EXPECTED));
        }

    /**
     * Should contain same elements with custom error message.
     */
    @Test
        @DisplayName("Should contain the same elements (with custom error message)")
        void shouldContainSameElementsWithCustomErrorMessage() {
            assertThat("The lists don't contain the same elements", ACTUAL, equalTo(EXPECTED));
        }
    }
}
