package com.amitesh.healthycoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The type Bmi calculator test.
 */
class BMICalculatorTest {

  /**
   * The constant ENVIRONMENT.
   */
  private static final String ENVIRONMENT = "dev";

  /**
   * The type Is diet recommended test.
   */
// We can have infinite Nesting with InnerClasses and each inner class can have its own annotated methods i.e.BeforeEach.
  @Nested
  @DisplayName("Diet")
  class IsDietRecommendedTest {

    /**
     * Skipped test.
     */
    @Test
    @Disabled("Sample example for Use of Disabled")
    @DisplayName("Disabled Test")
    void skippedTest() {
      assertTrue(true);
    }

    /**
     * Skipped test on linux.
     */
    @Test
    @DisabledOnOs(OS.LINUX)
    @DisplayName("Disabled Test on Linux")
    void skippedTestOnLinux() {
      assertEquals("LINUX", OS.LINUX.name());
    }

    /**
     * Skipped test on windows.
     */
    @Test
    @DisabledOnOs(OS.WINDOWS)
    @DisplayName("Disabled Test on Windows")
    void skippedTestOnWindows() {
      assertEquals("WINDOWS", OS.WINDOWS.name());
    }

    /**
     * Is diet recommended bad bmi returns true.
     */
    @Test
    @DisplayName("BadBMI")
    void isDietRecommended_badBMI_returnsTrue() {
      double weight = 99;
      double height = 1.7;
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended good bmi returns false.
     */
    @Test
    void isDietRecommended_goodBMI_returnsFalse() {
      double weight = 59;
      double height = 1.7;
      assertFalse(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended zero height throws exception.
     */
    @Test
    void isDietRecommended_zeroHeight_throwsException() {
      double weight = 59;
      double height = 0.0;

      //Executable executor = () -> BMICalculator.isDietRecommended(weight, height);
      //assertThrows(ArithmeticException.class, executor);

      assertThrows(ArithmeticException.class,
          () -> BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended parametrized test value source single value.
     *
     * @param weight the weight
     */
    @ParameterizedTest
    @ValueSource(doubles = {170.0, 180.0, 100.0})
    void isDietRecommended_parametrizedTest_valueSource_singleValue(Double weight) {
      double height = 1.7;
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended parametrized test csv source multiple values.
     *
     * @param weight the weight
     * @param height the height
     */
    @ParameterizedTest
    @CsvSource(value = {"170.0, 1.7", "180.0, 1.7", "100.0, 1.7"})
    void isDietRecommended_parametrizedTest_csvSource_multipleValues(Double weight, Double height) {
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended parametrized test customized log csv source multiple values.
     *
     * @param weight the weight
     * @param height the height
     */
    @ParameterizedTest(name = "Weight={0}, Height={1}")
    @CsvSource(value = {"170.0, 1.7", "180.0, 1.7", "100.0, 1.7"})
    void isDietRecommended_parametrizedTest_customizedLog_csvSource_multipleValues(Double weight,
        Double height) {
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended parametrized test customized log csv file source multiple values.
     *
     * @param weight the weight
     * @param height the height
     */
    @ParameterizedTest(name = "Weight={0}, Height={1}")
    @CsvFileSource(resources = "/diet_recommended_input_data.csv", numLinesToSkip = 1)
    void isDietRecommended_parametrizedTest_customizedLog_csvFileSource_multipleValues(
        Double weight, Double height) {
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }

    /**
     * Is diet recommended assumptions.
     */
    @Test
    void isDietRecommended_assumptions() {
      assumeTrue(BMICalculatorTest.ENVIRONMENT.equals("prod"));// Skip test if fails
      double weight = 99;
      double height = 1.7;
      assertTrue(BMICalculator.isDietRecommended(weight, height));
    }
  }

  /**
   * The type Find coder with worst bmi tests.
   */
  @Nested
  class FindCoderWithWorstBMITests {

    /**
     * Find coder with worst bmi valid data returns valid coder.
     */
    @Test
    void findCoderWithWorstBMI_validData_returnsValidCoder() {
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.8, 50));
      coders.add(new Coder(1.8, 100)); // Worse BMI
      coders.add(new Coder(1.8, 60));

      final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      assertEquals(1.8, coderWithWorstBMI.getHeight());
      assertEquals(100, coderWithWorstBMI.getWeight());
    }

    /**
     * Find coder with worst bmi empty list returns null.
     */
    @Test
    void findCoderWithWorstBMI_emptyList_returnsNull() {
      List<Coder> coders = new ArrayList<>();
      final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      assertNull(coderWithWorstBMI);
    }

    /**
     * Find coder with worst bmi performance test.
     */
    @Test
    void findCoderWithWorstBMI_performanceTest() {
//    List<Coder> coders = new ArrayList<>();
//    for(int i = 0 ; i < 10000 ; i++) {
//      coders.add(new Coder(1.0+i, 10.0+i));
//    }

      List<Coder> coders = IntStream.range(0, 10000).mapToObj(i -> new Coder(1.0 + i, 10.0 + i))
          .collect(Collectors.toList());
      //org.opentest4j.AssertionFailedError: execution exceeded timeout of 1 ms by 8 ms
      //assertTimeout(Duration.ofMillis(1), () -> BMICalculator.findCoderWithWorstBMI(coders));

      assertTimeout(Duration.ofMillis(10), () -> BMICalculator.findCoderWithWorstBMI(coders));
    }

    /**
     * Find coder with worst bmi first assert failure.
     */
    @Test
    void findCoderWithWorstBMI_firstAssertFailure() {
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.8, 50));
      coders.add(new Coder(1.8, 100)); // Worse BMI
      coders.add(new Coder(1.8, 60));

      final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      assertEquals(1.8, coderWithWorstBMI.getHeight());
      assertEquals(100, coderWithWorstBMI.getWeight());
    }

    /**
     * Find coder with worst bmi assert all assert failures.
     */
//@Test
    void findCoderWithWorstBMI_assertAll_allAssertFailures() {
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.8, 50));
      coders.add(new Coder(1.8, 100)); // Worse BMI
      coders.add(new Coder(1.8, 60));

      final Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
    /*
    BMICalculatorTest.findCoderWithWorstBMI_assertAll_allAssertFailures:91 Multiple Failures (2 failures)
	org.opentest4j.AssertionFailedError: expected: <1.9> but was: <1.8>
	org.opentest4j.AssertionFailedError: expected: <10.0> but was: <100.0>
     */
      assertAll(
          () -> assertEquals(1.9, coderWithWorstBMI.getHeight(), 0.1),
          () -> assertEquals(10, coderWithWorstBMI.getWeight(), 0.1)
      );
    }
  }


  /**
   * The type Get bmi scores.
   */
  @Nested
  class GetBMIScores {

    /**
     * Gets bmi scores test assert array.
     */
    @Test
    void getBMIScores_testAssertArray() {
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.8, 60));
      coders.add(new Coder(1.82, 98));
      coders.add(new Coder(1.82, 64.7));
      final double[] expectedBMIScores = {18.52, 29.59, 19.53};
      final double[] bmiScores = BMICalculator.getBMIScores(coders);

      // org.opentest4j.AssertionFailedError: expected: [D@149494d8<[18.52, 29.59, 19.53]> but was: [D@710726a3<[18.52, 29.59, 19.53]>
      //assertEquals(expectedBMIScores, bmiScores);

      assertArrayEquals(expectedBMIScores, bmiScores);
    }

    /**
     * Gets bmi scores test assert array with failure.
     */
    @Test
    void getBMIScores_testAssertArray_withFailure() {
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.8, 60));
      coders.add(new Coder(1.82, 98));
      coders.add(new Coder(1.82, 64.7));
      final double[] expectedBMIScores = {18.52, 29.60, 19.53};
      final double[] bmiScores = BMICalculator.getBMIScores(coders);

      // Use Delta. org.opentest4j.AssertionFailedError: array contents differ at index [1], expected: <29.6> but was: <29.59>
      assertArrayEquals(expectedBMIScores, bmiScores, 0.1);
    }

    @Test
    void testCalculateBMI_ZeroHeight_ThrowsException() {
      Coder coder = new Coder();
      coder.setHeight(0);
      coder.setWeight(50);

      assertThatThrownBy(() -> BMICalculator.calculateBMI(coder))
          .isExactlyInstanceOf(IllegalArgumentException.class)
          .hasMessage("Height can not be zero");
    }

    @Test
    void testCalculateBMI_ZeroWeight_ThrowsException() {
      Coder coder = new Coder();
      coder.setHeight(60);
      coder.setWeight(0);

      assertThatThrownBy(() -> BMICalculator.calculateBMI(coder))
          .isExactlyInstanceOf(IllegalArgumentException.class)
          .hasMessage("Weight can not be zero");
    }
  }
}