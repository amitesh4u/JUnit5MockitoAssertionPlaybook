package com.amitesh.healthycoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * The type Diet planner test.
 */
class DietPlannerTest {

  /**
   * The Diet planner.
   */
  private DietPlanner dietPlanner;

  /**
   * Before all.
   */
  @BeforeAll
  static void beforeAll() {
    System.out.println("Started Unit Testing");
  }


  /**
   * After all.
   */
  @AfterAll
  static void afterAll() {
    System.out.println("Finished Unit Testing");
  }

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    System.out.println("Started a Unit Test");
    dietPlanner = new DietPlanner(20, 30, 50);
  }

  /**
   * Tear down.
   */
  @AfterEach
  void tearDown() {
    System.out.println("Finished a Unit test.");
    dietPlanner = null;
  }

  /**
   * Calculate diet for Male and assert all.
   */
  @Test
  void calculateDiet_Male_assertAll() {
    Coder coder = new Coder(1.82, 75, 26, Gender.MALE);
    DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);
    final DietPlan dietPlan = dietPlanner.calculateDiet(coder);
    // Object comparison fails (If No equals and Hashcode)
    // assertEquals(expectedDietPlan, dietPlan);

    assertAll(
        () -> assertEquals(expectedDietPlan.getCalories(), dietPlan.getCalories()),
        () -> assertEquals(expectedDietPlan.getCarbohydrate(), dietPlan.getCarbohydrate()),
        () -> assertEquals(expectedDietPlan.getFat(), dietPlan.getFat()),
        () -> assertEquals(expectedDietPlan.getProtein(), dietPlan.getProtein())
    );
  }

  /**
   * Calculate diet for Female and assert all.
   */
  @Test
  void calculateDiet_Female_assertAll() {
    Coder coder = new Coder(1.73, 65, 23, Gender.FEMALE);
    DietPlan expectedDietPlan = new DietPlan(1800, 90, 60, 225);
    final DietPlan dietPlan = dietPlanner.calculateDiet(coder);
    // Object comparison fails (If No equals and Hashcode)
    // assertEquals(expectedDietPlan, dietPlan);

    assertAll(
        () -> assertEquals(expectedDietPlan.getCalories(), dietPlan.getCalories()),
        () -> assertEquals(expectedDietPlan.getCarbohydrate(), dietPlan.getCarbohydrate()),
        () -> assertEquals(expectedDietPlan.getFat(), dietPlan.getFat()),
        () -> assertEquals(expectedDietPlan.getProtein(), dietPlan.getProtein())
    );
  }

  /**
   * Calculate diet repeated test.
   */
/*
  calculateDiet_repeatedTest()
    repetition 1 of 5
    repetition 2 of 5
    repetition 3 of 5
    repetition 4 of 5
    repetition 5 of 5
   */
  @RepeatedTest(5)
  void calculateDiet_repeatedTest() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Calculate diet repeated test with name as only index value.
   */
/*
  calculateDiet_repeatedTest_withNameAsOnlyIndexValue()
    1
    2
    3
    4
    5
   */
  @RepeatedTest(value = 5, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
  void calculateDiet_repeatedTest_withNameAsOnlyIndexValue() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Calculate diet repeated test with name as method name.
   */
/*
  calculateDiet_repeatedTest_withNameAsMethodName()
    calculateDiet_repeatedTest_withNameAsMethodName()
    calculateDiet_repeatedTest_withNameAsMethodName()
    calculateDiet_repeatedTest_withNameAsMethodName()
    calculateDiet_repeatedTest_withNameAsMethodName()
    calculateDiet_repeatedTest_withNameAsMethodName()
   */
  @RepeatedTest(value = 5, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER)
  void calculateDiet_repeatedTest_withNameAsMethodName() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Calculate diet repeated test with name as method name and index.
   */
/*
  calculateDiet_repeatedTest_withNameAsMethodNameAndIndex()
    calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() :: repetition 1 of 5
    calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() :: repetition 2 of 5
    calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() :: repetition 3 of 5
    calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() :: repetition 4 of 5
    calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() :: repetition 5 of 5
   */
  @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
  void calculateDiet_repeatedTest_withNameAsMethodNameAndIndex() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Calculate diet repeated test with name as index default.
   */
/*
  calculateDiet_repeatedTest_withNameAsIndex_Default()
    repetition 1 of 5
    repetition 2 of 5
    repetition 3 of 5
    repetition 4 of 5
    repetition 5 of 5
   */
  @RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
  void calculateDiet_repeatedTest_withNameAsIndex_Default() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Calculate diet repeated test with name as total index static value.
   */
/*
  calculateDiet_repeatedTest_withNameAsIndex_()
    5
    5
    5
    5
    5
   */
  @RepeatedTest(value = 5, name = RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
  void calculateDiet_repeatedTest_withNameAsTotalIndex_StaticValue() {
    calculateDiet_Male_assertAll();
  }

  /**
   * Test Invalid constructor argument
   */
  @Test
  void testDietPlannerConstructor_InvalidArguments_ThrowsException() {
    assertThatThrownBy(() -> new DietPlanner(1, 2, 3))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessage("Protein, Fat and Carbohydrate percentages must add up to 100!");
  }
}