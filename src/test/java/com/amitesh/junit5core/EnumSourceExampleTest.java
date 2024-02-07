package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The enum Enum source example test.
 */
@DisplayName("Pass enum values to our test method")
class EnumSourceExampleTest {

  /**
   * Should pass non null enum values as method parameter.
   *
   * @param pet the pet
   */
  @DisplayName("Should pass non-null enum values as method parameters")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(Pet.class)
    void shouldPassNonNullEnumValuesAsMethodParameter(Pet pet) {
        assertNotNull(pet);
    }

  /**
   * Should pass non null enum value as method parameter.
   *
   * @param pet the pet
   */
  @DisplayName("Should pass only the specified enum value as a method parameter")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(value = Pet.class, names = {"CAT"})
    void shouldPassNonNullEnumValueAsMethodParameter(Pet pet) {
        assertNotNull(pet);
    }
}
