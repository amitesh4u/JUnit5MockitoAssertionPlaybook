package com.amitesh.assertion.junit5;

import com.amitesh.assertion.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class demonstrates how we can group assertions by using JUnit 5.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Group multiple assertions")
class GroupAssertionsTest {

  /**
   * The constant FIRST_NAME.
   */
  private static final String FIRST_NAME = "Jane";
  /**
   * The constant LAST_NAME.
   */
  private static final String LAST_NAME = "Doe";

  /**
   * The Person.
   */
  private Person person;

  /**
   * Create person.
   */
  @BeforeEach
    void createPerson() {
        person = new Person();
        person.setFirstName(FIRST_NAME);
        person.setLastName(LAST_NAME);
    }

  /**
   * Should have correct name.
   */
  @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        assertAll("name",
                () -> assertEquals(FIRST_NAME, person.getFirstName(), "The first name is incorrect"),
                () -> assertEquals(LAST_NAME, person.getLastName(), "The last name is incorrect")
        );
    }
}
