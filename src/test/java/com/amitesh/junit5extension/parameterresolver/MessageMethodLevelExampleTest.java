package com.amitesh.junit5extension.parameterresolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This test class demonstrates how we can use the {@link MessageParameterResolverExtension}
 * extension when we register the extension at the method level.
 */
class MessageMethodLevelExampleTest {

  /**
   * Because only one test method takes a custom message as a method parameter, we can annotate only
   * that method with the {@link ExtendWith} annotation.
   *
   * @param message the message
   */
  @Test
    @ExtendWith(MessageParameterResolverExtension.class)
    void messageTest(String message) {
        System.out.println("A test with resolved message argument");
        assertEquals("Hello World!", message);
    }

  /**
   * Test with no message.
   */
  @Test
    void testWithNoMessage() {
        System.out.println("A test with no message");
    }
}
