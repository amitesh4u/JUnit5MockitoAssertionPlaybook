package com.amitesh.junit5extension.predestroycallback;

import com.amitesh.junit5extension.lifecyclecallback.BeforeAfterAllCallbackExtension;
import com.amitesh.junit5extension.lifecyclecallback.BeforeAfterEachCallbackExtension;
import com.amitesh.junit5extension.lifecyclecallback.BeforeAfterTestExecutionCallbackExtension;
import com.amitesh.junit5extension.postprocessor.Logger;
import com.amitesh.junit5extension.postprocessor.LoggerTestInstancePostProcessorExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This example demonstrates how we can use our custom lifecycle callback extension and helps us to
 * see the execution order of setup methods, teardown methods, test methods, and the callback
 * methods when we register our extensions at the class level.
 */
@ExtendWith({
        BeforeAfterAllCallbackExtension.class,
        BeforeAfterEachCallbackExtension.class,
        BeforeAfterTestExecutionCallbackExtension.class,
        LoggerTestInstancePostProcessorExtension.class,
        TestInstancePreDestroyExtension.class
})
class TestInstancePreDestroyExampleTest {

  /**
   * The Logger.
   */
  private Logger logger;

  /**
   * Before all.
   */
  @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll() method");
    }

  /**
   * Before each.
   */
  @BeforeEach
    void beforeEach() {
        logger.log("beforeEach() method");
    }

  /**
   * Test method.
   */
  @Test
    void testMethod() {
        logger.log("Test method");
    }

  /**
   * After each.
   */
  @AfterEach
    void afterEach() {
        logger.log("afterEach() method");
    }

  /**
   * After all.
   */
  @AfterAll
    static void afterAll() {
        System.out.println("afterAll() method");
    }
}
