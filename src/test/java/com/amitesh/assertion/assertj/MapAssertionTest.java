package com.amitesh.assertion.assertj;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for maps by using AssertJ.
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
   * The type When we verify that map contains given key.
   */
  @Nested
    @DisplayName("When we verify that the map contains the given key")
    class WhenWeVerifyThatMapContainsGivenKey {

    /**
     * Should contain correct key.
     */
    @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map).containsKey(KEY);
        }

    /**
     * Should contain correct key with custom error message.
     */
    @Test
        @DisplayName("Should contain the correct key (with custom error message)")
        void shouldContainCorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map doesn't contain the key: %s", KEY)
                    .containsKey(KEY);
        }
    }

  /**
   * The type When we verify that map does not contain given key.
   */
  @Nested
    @DisplayName("When we verify that the map does not contain the given key")
    class WhenWeVerifyThatMapDoesNotContainGivenKey {

    /**
     * Should not contain incorrect key.
     */
    @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map).doesNotContainKey(INCORRECT_KEY);
        }

    /**
     * Should not contain incorrect key with custom error message.
     */
    @Test
        @DisplayName("Should not contain the incorrect key (with custom error message)")
        void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map contains the key: %s", INCORRECT_KEY)
                    .doesNotContainKey(INCORRECT_KEY);
        }
    }

  /**
   * The type When we verify that map contains correct value.
   */
  @Nested
    @DisplayName("When we verify that the map contains the given entry")
    class WhenWeVerifyThatMapContainsCorrectValue {

    /**
     * Should contain given entry.
     */
    @Test
        @DisplayName("Should contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).containsEntry(KEY, VALUE);
        }

    /**
     * Should contain given entry with custom error message.
     */
    @Test
        @DisplayName("Should contain the given entry (with custom error message)")
        void shouldContainGivenEntryWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "The map didn't contain the value: %s for the key: %s",
                            VALUE,
                            KEY
                    )
                    .containsEntry(KEY, VALUE);
        }
    }

  /**
   * The type When we verify that map does not contain given entry.
   */
  @Nested
    @DisplayName("When we verify that the map doesn't contain the given entry")
    class WhenWeVerifyThatMapDoesNotContainGivenEntry {

    /**
     * Should contain given entry.
     */
    @Test
        @DisplayName("Should not contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).doesNotContainEntry(INCORRECT_KEY, VALUE);
        }

    /**
     * Should contain given entry with custom error message.
     */
    @Test
        @DisplayName("Should contain the given entry (with custom error message)")
        void shouldContainGivenEntryWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "Expected the map to not contain the value: %s for the key: %s but it contained it",
                            VALUE,
                            INCORRECT_KEY
                    )
                    .doesNotContainEntry(INCORRECT_KEY, VALUE);
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
                assertThat(returned).isEqualTo(VALUE);
            }

      /**
       * Should return found value with custom error message.
       */
      @Test
            @DisplayName("Should return the found value (with custom error message)")
            void shouldReturnFoundValueWithCustomErrorMessage() {
                final String returned = map.get(KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return: %s by using the key: %s but it returned: %s",
                                VALUE,
                                KEY,
                                returned
                        )
                        .isEqualTo(VALUE);
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
                assertThat(returned).isNull();
            }

      /**
       * Should return null with custom error message.
       */
      @Test
            @DisplayName("Should return null (with custom error message)")
            void shouldReturnNullWithCustomErrorMessage() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return null for the key: %s but it returned: %s",
                                KEY,
                                returned
                        )
                        .isNull();
            }
        }
    }
}
