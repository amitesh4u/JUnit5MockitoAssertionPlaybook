package com.amitesh.assertion.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class demonstrates how we can write assertions for booleans with JUnit 5 and Hamcrest.
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
            assertThat(false, is(false));
        }

    /**
     * Should be false with custom error message.
     */
    @Test
        @DisplayName("Should be false (with custom error message)")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat("The boolean is not false", false, is(false));
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
            assertThat(true, is(true));
        }

    /**
     * Should true with custom error message.
     */
    @Test
        @DisplayName("Should be true (with custom error message)")
        void shouldTrueWithCustomErrorMessage() {
            assertThat("The boolean is not true", true, is(true));
        }
    }
}
