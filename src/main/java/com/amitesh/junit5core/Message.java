package com.amitesh.junit5core;

/**
 * The type Message.
 */
final class Message {

  /**
   * The Message.
   */
  private final String message;

  /**
   * Instantiates a new Message.
   *
   * @param message the message
   */
  Message(String message) {
        this.message = message;
    }

  /**
   * Gets message.
   *
   * @return the message
   */
  String getMessage() {
        return message;
    }
}
