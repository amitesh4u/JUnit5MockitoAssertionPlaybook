package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Arguments source example test.
 */
@DisplayName("Should pass the method parameters provided by the CustomArgumentProvider class")
class ArgumentsSourceExampleTest {

  /**
   * Sum.
   *
   * @param a the a
   * @param b the b
   * @param sum the sum
   */
  @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @ArgumentsSource(CustomArgumentProvider.class)
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

  /**
   * The type Custom argument provider.
   */
  static class CustomArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(1, 1, 2),
                    Arguments.of(2, 3, 5)
            );
        }
    }
}
