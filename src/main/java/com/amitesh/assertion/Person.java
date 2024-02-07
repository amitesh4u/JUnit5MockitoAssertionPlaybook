package com.amitesh.assertion;

/**
 * The type Person.
 */
public class Person {

  /**
   * The First name.
   */
  private String firstName;
  /**
   * The Last name.
   */
  private String lastName;

  /**
   * Instantiates a new Person.
   */
  public Person() {}

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
        return firstName;
    }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
        return lastName;
    }

  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
