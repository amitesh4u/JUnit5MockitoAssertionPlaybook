package com.amitesh.assertion.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for maps by using JUnit 5 and Hamcrest.
 *
 * @author Amitesh Kumar
 */
@DisplayName("Writing assertions for maps")
class MapAssertionTest {

  /**
   * The constant INCORRECT_KEY.
   */
  private static final String INCORRECT_KEY = "incorrectKey";
  /**
   * The constant KEY.
   */
  private static final String KEY = "key";
  /**
   * The constant VALUE.
   */
  private static final String VALUE = "value";

  /**
   * The Map.
   */
  private Map<String, String> map;

  /**
   * Create and initialize map.
   */
  @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

  /**
   * The type When we check if map contains given key.
   */
  @Nested
    @DisplayName("When we check if the map contains the given key")
    class WhenWeCheckIfMapContainsGivenKey {

    /**
     * Should contain correct key.
     */
    @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map, hasKey(KEY));
        }

    /**
     * Should contain correct key with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct key (with custom error message)")
        void shouldContainCorrectKeyWithCustomErrorMessage() {
            assertThat(String.format("The map doesn't contain the key: %s", KEY), map, hasKey(KEY));
        }

    /**
     * Should not contain incorrect key.
     */
    @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map, not(hasKey(INCORRECT_KEY)));
        }

    /**
     * Should not contain incorrect key with custom error message.
     */
    @Test
        @DisplayName("Should not contain the incorrect key (with custom error message)")
        void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
            assertThat(String.format("The map contains the key: %s", INCORRECT_KEY), map, not(hasKey(INCORRECT_KEY)));
        }
    }

  /**
   * The type When we check if map contains correct value.
   */
  @Nested
    @DisplayName("When we check if the map contains the correct value")
    class WhenWeCheckIfMapContainsCorrectValue {

    /**
     * Should contain correct value.
     */
    @Test
        @DisplayName("Should contain the correct value")
        void shouldContainCorrectValue() {
            assertThat(map, hasEntry(KEY, VALUE));
        }
    }

  /**
   * The type When we get value from map.
   */
  @Nested
    @DisplayName("When we get a value from the map")
    class WhenWeGetValueFromMap {

    /**
     * The type When value is found.
     */
    @Nested
        @DisplayName("When the value is found")
        class WhenValueIsFound {

      /**
       * Should return found value.
       */
      @Test
            @DisplayName("Should return the found value")
            void shouldReturnFoundValue() {
                final String returned = map.get(KEY);
                assertThat(returned, is(VALUE));
            }

      /**
       * Should return found value with custom error message.
       */
      @Test
            @DisplayName("Should return the found value (with custom error message)")
            void shouldReturnFoundValueWithCustomErrorMessage() {
                final String returned = map.get(KEY);
                assertThat("The map returned an incorrect value", returned, is(VALUE));
            }
        }

    /**
     * The type When value is not found.
     */
    @Nested
        @DisplayName("When the value is not found")
        class WhenValueIsNotFound {

      /**
       * Should return null.
       */
      @Test
            @DisplayName("Should return null")
            void shouldReturnNull() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned, nullValue());
            }

      /**
       * Should return null with custom error message.
       */
      @Test
            @DisplayName("Should return null (with custom error message)")
            void shouldReturnNullWithCustomErrorMessage() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat("The map didn't return null", returned, nullValue());
            }
        }
    }
}
