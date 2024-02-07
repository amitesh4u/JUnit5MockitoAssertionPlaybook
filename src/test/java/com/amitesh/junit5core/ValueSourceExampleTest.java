package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Value source example test.
 */
@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
class ValueSourceExampleTest {

  /**
   * Should pass non null message as method parameter.
   *
   * @param message the message
   */
  @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }
}
