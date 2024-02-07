package com.amitesh.junit5extension.executioncondition;

import org.junit.jupiter.api.Test;

/**
 * The type Execution condition example test.
 */
class ExecutionConditionExampleTest {

  /**
   * Should be run.
   */
  @Test
    void shouldBeRun() {
        System.out.println("This test method should be run");
    }

  /**
   * Should not be run.
   */
  @Test
    @DisableTest
    void shouldNotBeRun() {
        System.out.println("This test method shouldn't be run");
    }
}
