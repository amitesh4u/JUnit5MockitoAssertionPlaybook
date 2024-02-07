package com.amitesh.assertion.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for objects by using JUnit 5 and Hamcrest.
 */
@DisplayName("Writing assertions for objects")
class ObjectAssertionTest {

  /**
   * The type When object is null.
   */
  @Nested
    @DisplayName("When object is null")
    class WhenObjectIsNull {

    /**
     * Should be null.
     */
    @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertThat(null, nullValue());
        }

    /**
     * Should be null with custom error message.
     */
    @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertThat("The object is not null", null, nullValue());
        }
    }

  /**
   * The type When object is not not null.
   */
  @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

    /**
     * The Not null.
     */
    private final Object NOT_NULL = new Object();

    /**
     * Should not be null.
     */
    @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertThat(NOT_NULL, notNullValue());
        }

    /**
     * Should not be null with custom error message.
     */
    @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertThat("The object is null", NOT_NULL, notNullValue());
        }
    }

  /**
   * The type When two objects are equal.
   */
  @Nested
    @DisplayName("When two objects are equal")
    class WhenTwoObjectsAreEqual {

    /**
     * The type When objects are integers.
     */
    @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

      /**
       * The Actual.
       */
      private final Integer ACTUAL = 9;
      /**
       * The Expected.
       */
      private final Integer EXPECTED = 9;

      /**
       * Should be equal.
       */
      @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat("The integers are not equal", ACTUAL, equalTo(EXPECTED));
            }
        }

    /**
     * The type When objects are strings.
     */
    @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

      /**
       * The Actual.
       */
      private final String ACTUAL = "Foo";
      /**
       * The Expected.
       */
      private final String EXPECTED = "Foo";

      /**
       * Should be equal.
       */
      @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat("The strings are not equal", ACTUAL, equalTo(EXPECTED));
            }
        }
    }

  /**
   * The type When two objects are not equal.
   */
  @Nested
    @DisplayName("When two objects aren't equal")
    class WhenTwoObjectsAreNotEqual {

    /**
     * The type When objects are integers.
     */
    @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

      /**
       * The Actual.
       */
      private final Integer ACTUAL = 9;
      /**
       * The Expected.
       */
      private final Integer EXPECTED = 4;

      /**
       * Should not be equal.
       */
      @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat("The integers are equal", ACTUAL, not(EXPECTED));
            }
        }

    /**
     * The type When objects are strings.
     */
    @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

      /**
       * The Actual.
       */
      private final String ACTUAL = "Foo";
      /**
       * The Expected.
       */
      private final String EXPECTED = "Bar";

      /**
       * Should not be equal.
       */
      @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat("The strings are equal", ACTUAL, not(EXPECTED));
            }
        }
    }

  /**
   * The type When two objects refer to same object.
   */
  @Nested
    @DisplayName("When two objects refer to the same object")
    class WhenTwoObjectsReferToSameObject {

    /**
     * The Actual.
     */
    private final Object ACTUAL = new Object();
    /**
     * The Expected.
     */
    private final Object EXPECTED = ACTUAL;

    /**
     * Should refer to same object.
     */
    @Test
        @DisplayName("Should refer to the same object")
        void shouldReferToSameObject() {
            assertThat(ACTUAL, sameInstance(EXPECTED));
        }

    /**
     * Should refer to same error object with custom error message.
     */
    @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertThat("Objects don't refer to the same object", ACTUAL, sameInstance(EXPECTED));
        }
    }

  /**
   * The type When two objects do not refer to same object.
   */
  @Nested
    @DisplayName("When two objects don't refer to the same object")
    class WhenTwoObjectsDoNotReferToSameObject {

    /**
     * The Actual.
     */
    private final Object ACTUAL = new Object();
    /**
     * The Expected.
     */
    private final Object EXPECTED = new Object();

    /**
     * Should not refer to same object.
     */
    @Test
        @DisplayName("Should not refer to the same object")
        void shouldNotReferToSameObject() {
           assertThat(ACTUAL, not(sameInstance(EXPECTED)));
        }

    /**
     * Should not refer to same object with custom error message.
     */
    @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertThat("Objects refer to the same object", ACTUAL, not(sameInstance(EXPECTED)));
        }
    }
}
