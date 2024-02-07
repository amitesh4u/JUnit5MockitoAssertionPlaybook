package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates how we can write assertions for the exceptions thrown by the system under
 * test.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

  /**
   * The type When system under test throws exception.
   */
  @Nested
    @DisplayName("When the system under test throws an exception")
    class WhenSystemUnderTestThrowsException {

    /**
     * The type When system under test throws correct exception.
     */
    @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsCorrectException {

      /**
       * Should throw correct exception.
       */
      @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                assertThrows(NullPointerException.class, () -> { throw new NullPointerException(); });
            }

      /**
       * Should throw correct exception with custom error message.
       */
      @Test
            @DisplayName("Should throw the correct exception (with custom error message)")
            void shouldThrowCorrectExceptionWithCustomErrorMessage() {
                assertThrows(NullPointerException.class,
                        () -> { throw new NullPointerException(); },
                        "The code didn't throw a NullPointerException"
                );
            }
        }

    /**
     * The type When system under test throws exception with correct message.
     */
    @Nested
        @DisplayName("When the system under test throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

      /**
       * Should throw an exception with correct message.
       */
      @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                final NullPointerException thrown = assertThrows(NullPointerException.class,
                        () -> { throw new NullPointerException("Hello World!"); }
                );
                assertEquals("Hello World!", thrown.getMessage(), "The thrown exception don't have the correct error message");
            }
        }
    }

  /**
   * The type When system under test does not throw exception.
   */
  @Nested
    @DisplayName("When the system under test doesn't throw an exception")
    class WhenSystemUnderTestDoesNotThrowException {

    /**
     * The type When no exception is thrown.
     */
    @Nested
        @DisplayName("When no exception is thrown")
        class WhenNoExceptionIsThrown {

      /**
       * Should not throw exception.
       */
      @Test
            @DisplayName("Should not throw an exception")
            void shouldNotThrowException() {
                assertDoesNotThrow(() -> {});
            }

      /**
       * Should not throw exception with custom error message.
       */
      @Test
            @DisplayName("Should not throw an exception (with a custom error message)")
            void shouldNotThrowExceptionWithCustomErrorMessage() {
                assertDoesNotThrow(() -> {}, "The system under test threw an exception");
            }
        }
    }
}
