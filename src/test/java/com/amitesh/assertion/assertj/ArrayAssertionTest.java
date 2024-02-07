package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for arrays by using AssertJ.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

  /**
   * The type When arrays are equal.
   */
  @Nested
    @DisplayName("When two arrays are equal")
    class WhenArraysAreEqual {

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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

      /**
       * Should contain same integers with custom error message.
       */
      @Test
            @DisplayName("Should contain the same integers (with custom error message)")
            void shouldContainSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

      /**
       * Should contain same strings with custom error message.
       */
      @Test
            @DisplayName("Should contain the same strings (with custom error message)")
            void shouldContainSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
            }
        }
    }

  /**
   * The type When arrays are not equal.
   */
  @Nested
    @DisplayName("When two arrays are not equal")
    class WhenArraysAreNotEqual {

    /**
     * The type When arrays contain integers.
     */
    @Nested
        @DisplayName("When arrays contain integers")
        class WhenArraysContainIntegers {

      /**
       * The Actual.
       */
      final int[] ACTUAL = new int[]{2, 6, 7};
      /**
       * The Expected.
       */
      final int[] EXPECTED = new int[]{2, 5, 7};

      /**
       * Should not contain same integers.
       */
      @Test
            @DisplayName("Should not contain the same integers")
            void shouldNotContainSameIntegers() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

      /**
       * Should not contain same integers with custom error message.
       */
      @Test
            @DisplayName("Should not contain the same integers (with custom error message)")
            void shouldNotContainSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
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
      final String[] ACTUAL = new String[] {"foo", "bar1"};
      /**
       * The Expected.
       */
      final String[] EXPECTED = new String[] {"foo", "bar"};

      /**
       * Should not contain same strings.
       */
      @Test
            @DisplayName("Should not contain the same strings")
            void shouldNotContainSameStrings() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

      /**
       * Should not contain same strings with custom error message.
       */
      @Test
            @DisplayName("Should not contain the same strings (with custom error message)")
            void shouldNotContainSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
            }
        }
    }
}
