package com.amitesh.assertion.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.amitesh.assertion.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class demonstrates how we can combine assertions with Hamcrest.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Group multiple assertions")
class CombineAssertionsTest {

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
        assertThat(person, allOf(
                hasProperty("firstName", equalTo(FIRST_NAME)),
                hasProperty("lastName", equalTo(LAST_NAME))
        ));
    }

  /**
   * Should have correct first name or last name.
   */
  @Test
    @DisplayName("Should have correct first name or last name")
    void shouldHaveCorrectFirstNameOrLastName() {
        assertThat(person, anyOf(
                hasProperty("firstName", equalTo(FIRST_NAME)),
                hasProperty("lastName", equalTo(LAST_NAME))
        ));
    }
}
