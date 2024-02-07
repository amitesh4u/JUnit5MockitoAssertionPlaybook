package com.amitesh.junit5core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The JUnit 5 test.
 */
@Tag("JUnit5 Demo")
@DisplayName("DisplayName Demo at Class level")
class JUnit5Test {

  /**
   * This annotation executes a method before all tests. This is analogous to JUnit 4’s @BeforeClass.
   * The @BeforeAll annotation is typically used to initialize various things for the tests.
   */
  @BeforeAll
  static void init() {
    System.out.println("Only run once before all tests");
  }

  /**
   * The @AfterAll annotation is used to execute the annotated method, only after all tests have
   * been executed. This is analogous to JUnit 4’s @AfterClass. We use this annotation to tear down
   * or terminate all processes at the end of all tests.
   */
  @AfterAll
  static void after() {
    System.out.println("Only run once after all tests");
  }

  /**
   * This annotation denotes that a method is a test method. Note this annotation does not take any
   * attributes.
   */
  @Test
  void helloJUnit5() {
    assertEquals(10, 5 + 5);
  }

  /**
   * Parameterized tests make it possible to run a test multiple times with different arguments.
   * They are declared just like regular @Test methods but use the @ParameterizedTest annotation
   * instead.
   *
   * In addition, you must declare at least one source that will provide the arguments for each
   * invocation and then consume the arguments in the test method.
   *
   * For example, the following example demonstrates a parameterized test that uses the @ValueSource
   * annotation to specify a String array as the source of arguments.
   *
   * @param str the str
   */
  @ParameterizedTest
  @ValueSource(strings = {"cali", "bali", "dani"})
  void endsWithI(String str) {
    assertTrue(str.endsWith("i"));
  }

  /**
   * JUnit 5 has the ability to repeat a test a specified number of times simply by annotating a
   * method with @RepeatedTest and specifying the total number of repetitions desired.
   *
   * Each invocation of a repeated test behaves like the execution of a regular @Test method.
   *
   * This is particularly useful in UI testing with Selenium.
   *
   * @param repInfo the rep info
   * @param testInfo the test info
   */
  @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
  @DisplayName("RepeatingTest")
  void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
    int i = 3;
    int currentRepetition = repInfo.getCurrentRepetition();
    System.out.println(testInfo.getDisplayName() +
        "-->" + currentRepetition
    );

    if(currentRepetition == 3) {
      assertEquals(currentRepetition, i);
    }else {
      assertNotEquals(currentRepetition, i);
    }
  }

  /**
   * Test classes and test methods can declare custom display names that will be displayed by test
   * runners and test reports.
   */
  @Test
  @DisplayName("Custom test name")
  void testWithDisplayName() {
    assertTrue(true);
  }

  /**
   * Print display name.
   *
   * @param testInfo the test info
   */
  @Test
  @DisplayName("Print test name")
  void printDisplayName(TestInfo testInfo) {
    System.out.println(testInfo.getDisplayName());
    assertTrue(true);
  }

  /**
   * The @BeforeEach annotation denotes that the annotated method should be executed before each
   * test method, analogous to JUnit 4’s @Before.
   *
   * @param testInfo the test info
   */
  @BeforeEach
  void init(TestInfo testInfo) {
    String callingTest = testInfo.getTestMethod().map(Method::getName).orElse(null);
    System.out.println(callingTest);
  }

  /**
   * This annotation denotes that the annotated method should be executed after each test method,
   * analogous to JUnit 4’s @After. For example, if the tests need to reset a property after each
   * test, we can annotate a method with @AfterEach for that task.
   *
   * @param testInfo the test info
   */
  @AfterEach
  void after(TestInfo testInfo) {
    String callingTest = testInfo.getTestMethod().map(Method::getName).orElse(null);
    System.out.println(callingTest);
  }

  /**
   * First test.
   */
  @Test
  void firstTest() {
    System.out.println(1);
    assertTrue(true);
  }

  /**
   * Second test.
   */
  @Test
  void secondTest() {
    System.out.println(2);
    assertTrue(true);
  }

  /**
   * We can use this annotation to declare tags for filtering tests, either at the class or method
   * level.
   *
   * The @Tag annotation is useful when we want to create a test pack with selected tests.
   */
  @Test
  @Tag("login")
  void validLoginTest() {
    assertTrue(true);
  }

  /**
   * Search test.
   */
  @Test
  @Tag("search")
  void searchTest() {
    assertTrue(true);
  }


  /**
   * The @Disabled annotation is used to disable or skip tests at class or method level. This is
   * analogous to JUnit 4’s @Ignore.
   *
   * When declared at class level, all @test methods are skipped. When we use @Disabled at the
   * method level, only the annotated method is disabled.
   */
  @Disabled("Sample example")
  @Test
  void testWillBeSkipped() {
    assertTrue(true);
  }

}