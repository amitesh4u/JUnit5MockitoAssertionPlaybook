package com.amitesh.assertion.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * This class demonstrates how we can write assertions for the execution time of the system under
 * test.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Writing assertions for the execution time of the system under test")
class TimeoutAssertionTest {

  /**
   * The type When execution is not aborted.
   */
  @Nested
    @DisplayName("When the execution is not aborted if the timeout is exceeded")
    class WhenExecutionIsNotAborted {

    /**
     * Should return correct message before timeout is exceeded.
     */
    @Test
        @DisplayName("Should return the correct message before timeout is exceeded")
        void shouldReturnCorrectMessageBeforeTimeoutIsExceeded() {
            final String message = assertTimeout(Duration.ofMillis(50), () -> {
                Thread.sleep(20);
                return "Hello World!";
            });
            assertEquals("Hello World!", message);
        }
    }

  /**
   * The type When execution is aborted.
   */
  @Nested
    @DisplayName("When the execution is aborted if the timeout is exceeded")
    class WhenExecutionIsAborted {

    /**
     * Should return correct message before timeout is exceeded.
     */
    @Test
        @DisplayName("Should return the correct message before timeout is exceeded")
        void shouldReturnCorrectMessageBeforeTimeoutIsExceeded() {
            final String message = assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
                Thread.sleep(20);
                return "Hello World!";
            });
            assertEquals("Hello World!", message);
        }
    }
}
