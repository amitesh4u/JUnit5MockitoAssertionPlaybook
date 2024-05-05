package com.amitesh.junit5core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * The type Csv source example test.
 */
@DisplayName("Should pass the method parameters provided by the @CsvSource annotation")
class CsvSourceExampleTest {

  /**
   * Sum.
   *
   * @param a the a
   * @param b the b
   * @param sum the sum
   */
  @DisplayName("Should calculate the correct sum")
  @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
  @CsvSource({
      "1, 1, 2",
      "2, 3, 5"
  })
  void sum(int a, int b, int sum) {
    assertEquals(sum, a + b);
  }

  @DisplayName("Should check for Null values")
  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @CsvSource(value = {"null", "foo", "NULL", "bar", "nl"} , nullValues = {"null", "NULL", "nl"})
  void test_null(String str) {
    assertThat(str).isNotNull();
  }
}
