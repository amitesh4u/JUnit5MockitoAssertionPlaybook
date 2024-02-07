package com.amitesh.junit5extension.postprocessor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This test class demonstrates how we can use the {@link LoggerTestInstancePostProcessorExtension}
 * extension to inject a {@link Logger} object into our test object.
 */
@ExtendWith(LoggerTestInstancePostProcessorExtension.class)
class LoggingExampleTest {

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
