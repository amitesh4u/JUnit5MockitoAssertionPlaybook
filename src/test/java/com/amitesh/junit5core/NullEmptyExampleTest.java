package com.amitesh.junit5core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Should check for Null values")
public class NullEmptyExampleTest {

  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @CsvSource(value = {"null", "foo", "NULL", "bar", "nl"}, nullValues = {"null", "NULL", "nl"})
  void testBlankAndNull_csvSource(String str) {
    assertThat(str).isNotNull();
  }

  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @NullSource
  @EmptySource
  void testBlankAndNull_separateAnnotations(String input) {
    assertThat(input).isNotNull().isBlank();
  }

  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @NullAndEmptySource
  @ValueSource(strings = {" ", "\t", "\n"})
  void testBlankAndNull_singleAnnotation(String input) {
    assertThat(input).isNotNull().isBlank();
  }

  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @MethodSource("nullEmptyBlankSource")
  void testBlankAndNull_methodSource(String input) {
    assertThat(input).isNotNull().isBlank();
  }

  @ParameterizedTest(name = "#{index} - Run test with args={0}")
  @MethodSource("blankOrNullStrings")
  void testBlankAndNull_methodSourceStream(String input) {
      assertThat(input).isNotNull().isBlank();
  }

  private static Stream<String> blankOrNullStrings() {
    return Stream.of("", " ", null, "\t", "\n");
  }

  private static String[] nullEmptyBlankSource() {
    return new String[] { null, "", " " };
  }
}
