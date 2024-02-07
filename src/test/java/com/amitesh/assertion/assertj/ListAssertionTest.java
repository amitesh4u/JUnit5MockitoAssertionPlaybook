package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for {@code List} objects by using AssertJ.
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
            assertThat(list).hasSize(EXPECTED_SIZE);
        }

    /**
     * Should contain two elements with custom error message.
     */
    @Test
        @DisplayName("Should contain two elements (with custom error message)")
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertThat(list)
                    .overridingErrorMessage(
                            "Expected the size of the list to be: %d but it was: %d",
                            EXPECTED_SIZE,
                            list.size()
                    )
                    .hasSize(EXPECTED_SIZE);
        }

    /**
     * Should contain correct elements in given order.
     */
    @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list).containsExactly(first, second);
        }

    /**
     * Should contain correct elements in given order with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct elements in the given order (with custom error message)")
        void shouldContainCorrectElementsInGivenOrderWithCustomErrorMessage() {
            assertThat(list)
                    .overridingErrorMessage(
                            "Expected the list to contain the objects: %s and %s but it contained: %s",
                            first,
                            second,
                            Arrays.toString(list.toArray())
                    )
                    .containsExactly(first, second);
        }

    /**
     * Should contain correct elements in any order.
     */
    @Test
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list).containsExactlyInAnyOrder(second, first);
        }

    /**
     * Should contain correct elements in any with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct elements in any order (with custom error message)")
        void shouldContainCorrectElementsInAnyWithCustomErrorMessage() {
            assertThat(list)
                    .overridingErrorMessage(
                            "Expected the list to contain the objects: %s and %s in any order but it contained: %s",
                            second,
                            first,
                            Arrays.toString(list.toArray())
                    )
                    .containsExactlyInAnyOrder(second, first);
        }

    /**
     * Should contain correct element once.
     */
    @Test
        @DisplayName("Should contain the correct element once")
        void shouldContainCorrectElementOnce() {
            assertThat(list).containsOnlyOnce(first);
        }

    /**
     * Should contain correct element once with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct element once (with custom error message)")
        void shouldContainCorrectElementOnceWithCustomErrorMessage() {
            assertThat(list)
                    .overridingErrorMessage(
                            "Expected the list to contain the object: %s only",
                            first
                    )
                    .containsOnlyOnce(first);
        }

    /**
     * Should not contain incorrect element.
     */
    @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(list).doesNotContain(new Object());
        }

    /**
     * Should not contain incorrect element with custom error message.
     */
    @Test
        @DisplayName("Should not contain an incorrect element (with custom error message)")
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertThat(list)
                    .overridingErrorMessage(
                            "Expected the list to not contain the object: %s",
                            incorrect
                    )
                    .doesNotContain(new Object());
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
            assertThat(FIRST).isEqualTo(SECOND);
        }

    /**
     * Should contain same elements with custom error message.
     */
    @Test
        @DisplayName("Should contain the same elements (with custom error message)")
        void shouldContainSameElementsWithCustomErrorMessage() {
            assertThat(FIRST)
                    .overridingErrorMessage(
                            "Expected the list to contain: %s but it contained: %s",
                            Arrays.toString(SECOND.toArray()),
                            Arrays.toString(FIRST.toArray())
                    )
                    .isEqualTo(SECOND);
        }
    }
}
