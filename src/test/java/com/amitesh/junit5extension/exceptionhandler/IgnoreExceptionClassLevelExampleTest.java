package com.amitesh.junit5extension.exceptionhandler;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This example demostrates how we can use an extension which ignore all {@link
 * NullPointerException}* objects thrown by our test methods when we register the extension at the
 * class level.
 */
@ExtendWith(IgnoreNullPointerExtension.class)
class IgnoreExceptionClassLevelExampleTest {

  /**
   * This test should pass because the thrown exception is swallowed by our extension.
   */
  @Test
    void throwNullPointerException() {
        System.out.println("Throw NullPointerException");
        throw new NullPointerException();
    }

  /**
   * This test should fail because the thrown exception is rethrown by our extension and it can be
   * processed by subsequent exception handlers.
   *
   * @throws IOException the io exception
   */
//    @Test
    void throwIOException() throws IOException {
        System.out.println("Throw IOException");
        throw new IOException();
    }
}
