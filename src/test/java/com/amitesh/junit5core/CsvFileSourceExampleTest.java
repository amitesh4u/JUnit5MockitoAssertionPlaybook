package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Csv file source example test.
 */
@DisplayName("Should pass the method parameters provided by the test-data.csv file")
class CsvFileSourceExampleTest {

  /**
   * Sum.
   *
   * @param a the a
   * @param b the b
   * @param sum the sum
   */
  @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(resources = "/test-data.csv")
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}
