package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * This class demonstrates how we can write assertions for arrays by using JUnit 5.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

  /**
   * The type When arrays contain integers.
   */
  @Nested
    @DisplayName("When arrays contain integers")
    class WhenArraysContainIntegers {

    /**
     * The Actual.
     */
    final int[] ACTUAL = new int[]{2, 5, 7};
    /**
     * The Expected.
     */
    final int[] EXPECTED = new int[]{2, 5, 7};

    /**
     * Should contain same integers.
     */
    @Test
        @DisplayName("Should contain the same integers")
        void shouldContainSameIntegers() {
            assertArrayEquals(EXPECTED, ACTUAL);
        }

    /**
     * Should contain same integers with custom error message.
     */
    @Test
        @DisplayName("Should contain the same integers (with custom error message)")
        void shouldContainSameIntegersWithCustomErrorMessage() {
            assertArrayEquals(
                    EXPECTED,
                    ACTUAL,
                    "The arrays don't contain the same integers"
            );
        }
    }

  /**
   * The type When arrays contain strings.
   */
  @Nested
    @DisplayName("When arrays contain strings")
    class WhenArraysContainStrings {

    /**
     * The Actual.
     */
    final String[] ACTUAL = new String[] {"foo", "bar"};
    /**
     * The Expected.
     */
    final String[] EXPECTED = new String[] {"foo", "bar"};

    /**
     * Should contain same strings.
     */
    @Test
        @DisplayName("Should contain the same strings")
        void shouldContainSameStrings() {
            assertArrayEquals(EXPECTED, ACTUAL);
        }

    /**
     * Should contain same strings with custom error message.
     */
    @Test
        @DisplayName("Should contain the same strings (with custom error message)")
        void shouldContainSameStringsWithCustomErrorMessage() {
            assertArrayEquals(
                    EXPECTED,
                    ACTUAL,
                    "The arrays don't contain the same strings"
            );
        }
    }
}
