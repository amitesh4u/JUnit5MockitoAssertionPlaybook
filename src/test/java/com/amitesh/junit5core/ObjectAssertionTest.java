package com.amitesh.junit5core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates how we can write assertions for objects by using JUnit 5.
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
            assertNull(null);
        }

    /**
     * Should be null with custom error message.
     */
    @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertNull(null, "The object is not null");
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
            assertNotNull(NOT_NULL);
        }

    /**
     * Should not be null with custom error message.
     */
    @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertNotNull(NOT_NULL, "The object is null");
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
                assertEquals(EXPECTED, ACTUAL);
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED, ACTUAL, "The integers are not equal");
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
                assertEquals(EXPECTED, ACTUAL);
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED, ACTUAL, "The strings are not equal");
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
                assertNotEquals(EXPECTED, ACTUAL);
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertNotEquals(EXPECTED, ACTUAL, "The integers are equal");
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
                assertNotEquals(EXPECTED, ACTUAL);
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertNotEquals(EXPECTED, ACTUAL, "The strings are equal");
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
            assertSame(EXPECTED, ACTUAL);
        }

    /**
     * Should refer to same error object with custom error message.
     */
    @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertSame(EXPECTED, ACTUAL, "Objects don't refer to the same object");
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
            assertNotSame(EXPECTED, ACTUAL);
        }

    /**
     * Should not refer to same object with custom error message.
     */
    @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertNotSame(EXPECTED, ACTUAL, "Objects refer to the same object");
        }
    }
}
