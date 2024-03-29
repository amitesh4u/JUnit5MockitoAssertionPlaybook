package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Message converter example test.
 */
@DisplayName("Pass converted Message objects to our test method")
class MessageConverterExampleTest {

  /**
   * Should pass correct messages.
   *
   * @param actual the actual
   * @param expected the expected
   */
  @DisplayName("Should pass Message objects that contain same messages as method parameters")
    @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
    @CsvSource({
            "Hello, Hello",
            "Hi, Hi",
    })
    void shouldPassCorrectMessages(@ConvertWith(MessageConverter.class) Message actual,
                                   @ConvertWith(MessageConverter.class) Message expected) {
        assertEquals(expected.getMessage(), actual.getMessage());
    }
}
