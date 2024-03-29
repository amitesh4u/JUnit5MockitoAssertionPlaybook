package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can provide a custom error message that is shown when an assertion
 * fails.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Provide a custom error message")
class CustomErrorMessageTest {

  /**
   * The type When we provide only description.
   */
  @Nested
    @DisplayName("When we provide only the description")
    class WhenWeProvideOnlyDescription {

    /**
     * Should be false with custom error message.
     */
    @Test
        @DisplayName("Should override only the description")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false)
                    .describedAs("The boolean is not false")
                    .isFalse();
        }
    }

  /**
   * The type When we provide entire error message.
   */
  @Nested
    @DisplayName("When we provide the entire error message")
    class WhenWeProvideEntireErrorMessage {

    /**
     * Should be false with custom error message.
     */
    @Test
        @DisplayName("Should override entire error message")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false)
                    .overridingErrorMessage("The boolean is not false")
                    .isFalse();
        }
    }
}
