package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for booleans with AssertJ.
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
            assertThat(false).isFalse();
        }

    /**
     * Should be false with custom error message.
     */
    @Test
        @DisplayName("Should be false (with custom error message)")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false)
                    .overridingErrorMessage("The boolean is not false")
                    .isFalse();
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
            assertThat(true).isTrue();
        }

    /**
     * Should be true with custom error message.
     */
    @Test
        @DisplayName("Should be true (with custom error message)")
        void shouldBeTrueWithCustomErrorMessage() {
            assertThat(true)
                    .overridingErrorMessage("The boolean is not true")
                    .isTrue();
        }
    }
}
