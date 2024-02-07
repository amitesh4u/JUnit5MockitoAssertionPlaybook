package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Method source example test.
 */
@DisplayName("Should pass the method parameters provided by the sumProvider() method")
class MethodSourceExampleTest {

  /**
   * Sum.
   *
   * @param a the a
   * @param b the b
   * @param sum the sum
   */
  @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("sumProvider")
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

  /**
   * Sum provider stream.
   *
   * @return the stream
   */
  private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5)
        );
    }
}
