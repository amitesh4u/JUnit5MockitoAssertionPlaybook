package com.amitesh.assertion.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * This class demonstrates how we can write assertions for the exceptions thrown by the system under
 * test with AssertJ.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

  /**
   * The type When we write assertions for thrown exception.
   */
  @Nested
    @DisplayName("When we write assertions directly to the thrown exception")
    class WhenWeWriteAssertionsForThrownException {

    /**
     * The type When system under test throws exception.
     */
    @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsException {

      /**
       * Should throw correct exception.
       */
      @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                assertThatThrownBy(() -> { throw new NullPointerException(); })
                        .isExactlyInstanceOf(NullPointerException.class);
            }
        }

    /**
     * The type When system under test throws exception with correct message.
     */
    @Nested
        @DisplayName("When the system under test throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

      /**
       * The Error message.
       */
      private final String ERROR_MESSAGE = "Hello World!";

      /**
       * Should throw an exception with correct message.
       */
      @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                assertThatThrownBy(() -> { throw new NullPointerException(ERROR_MESSAGE); })
                        .hasMessage(ERROR_MESSAGE);
            }
        }
    }

  /**
   * The type When we catch thrown exception object.
   */
  @Nested
    @DisplayName("When we catch the thrown exception object")
    class WhenWeCatchThrownExceptionObject {

    /**
     * The type When system under test throws exception.
     */
    @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsException {

      /**
       * Should throw correct exception.
       */
      @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(); });
                assertThat(thrown).isExactlyInstanceOf(NullPointerException.class);
            }

      /**
       * Should throw correct exception with custom error message.
       */
      @Test
            @DisplayName("Should throw the correct exception (with custom error message)")
            void shouldThrowCorrectExceptionWithCustomErrorMessage() {
                final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(); });
                assertThat(thrown)
                        .overridingErrorMessage(
                                "Expected the code to throw a NullPointerException but it threw: %s",
                                thrown.getClass().getSimpleName()
                        )
                        .isExactlyInstanceOf(NullPointerException.class);
            }
        }

    /**
     * The type When system under test throws exception with correct message.
     */
    @Nested
        @DisplayName("When the system under test throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

      /**
       * The Error message.
       */
      private final String ERROR_MESSAGE = "Hello World!";

      /**
       * Should throw an exception with correct message.
       */
      @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(ERROR_MESSAGE); });
                assertThat(thrown.getMessage())
                        .overridingErrorMessage(
                                "Expected the error message of the exception to be: %s but it was: %s",
                                ERROR_MESSAGE,
                                thrown.getMessage()
                        )
                        .isEqualTo(ERROR_MESSAGE);
            }
        }
    }
}
