package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how we can write assertions for {@code Optional} objects with AssertJ.
 */
@DisplayName("Writing assertions for Optional objects")
class OptionalAssertionTest {

  /**
   * The type When optional is empty.
   */
  @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

    /**
     * Should be empty.
     */
    @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Optional.empty()).isEmpty();
        }

    /**
     * Should be empty with custom error message.
     */
    @Test
        @DisplayName("Should be empty (with custom error message)")
        void shouldBeEmptyWithCustomErrorMessage() {
            final Optional<Object> empty = Optional.empty();
            assertThat(empty)
                    .overridingErrorMessage("Expected optional to be empty but it was: %s", empty)
                    .isEmpty();
        }
    }

  /**
   * The type When optional is not empty.
   */
  @Nested
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty {

    /**
     * The Object.
     */
    private final Object OBJECT = new Object();

    /**
     * Should not be empty.
     */
    @Test
        @DisplayName("Should not be empty")
        void shouldNotBeEmpty() {
            assertThat(Optional.of(OBJECT)).isNotEmpty();
        }

    /**
     * Should not be empty with custom error message.
     */
    @Test
        @DisplayName("Should not be empty (with custom error message)")
        void shouldNotBeEmptyWithCustomErrorMessage() {
            assertThat(Optional.of(OBJECT))
                    .overridingErrorMessage("Expected optional to not be empty but it was empty")
                    .isNotEmpty();
        }

    /**
     * Should contain correct object.
     */
    @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            assertThat(Optional.of(OBJECT)).contains(OBJECT);
        }

    /**
     * Should contain correct object with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct object (with custom error message)")
        void shouldContainCorrectObjectWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(OBJECT);
            assertThat(actual)
                    .overridingErrorMessage(
                            "Expected optional to contain the object: %s but it contained the object: %s",
                            OBJECT,
                            actual.get()
                    )
                    .contains(OBJECT);
        }
    }
}
