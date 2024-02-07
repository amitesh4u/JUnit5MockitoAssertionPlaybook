package com.amitesh.junit5extension.postprocessor;

/**
 * A "logger" which writes the log message to the {@code System.out}.
 */
public class Logger {

  /**
   * Log.
   *
   * @param message the message
   */
  public void log(String message) {
        System.out.println(message);
    }
}
