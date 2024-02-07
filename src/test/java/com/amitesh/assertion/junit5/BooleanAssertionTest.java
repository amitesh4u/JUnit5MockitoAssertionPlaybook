package com.amitesh.assertion.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how we can write assertions for booleans with JUnit 5.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Write assertions for booleans")
class BooleanAssertionTest {

  /**
   * The type When boolean is false.
   */
  @Nested
    @DisplayName("When boolean is false")
    class WhenBooleanIsFalse {

    /**
     * Should be false.
     */
    @Test
        @DisplayName("Should be false")
        void shouldBeFalse() {
            assertFalse(false);
        }

    /**
     * Should be false with custom error message.
     */
    @Test
        @DisplayName("Should be false (with custom error message)")
        void shouldBeFalseWithCustomErrorMessage() {
            assertFalse(false, "The boolean is not false");
        }
    }

  /**
   * The type When boolean is true.
   */
  @Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {

    /**
     * Should be true.
     */
    @Test
        @DisplayName("Should be true")
        void shouldBeTrue() {
            assertTrue(true);
        }

    /**
     * Should true with custom error message.
     */
    @Test
        @DisplayName("Should be true (with custom error message)")
        void shouldTrueWithCustomErrorMessage() {
            assertTrue(true, "The boolean is not true");
        }
    }
}
