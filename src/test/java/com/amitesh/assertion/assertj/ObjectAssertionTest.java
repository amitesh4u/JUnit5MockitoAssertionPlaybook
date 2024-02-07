package com.amitesh.assertion.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * This class demonstrates how we can write assertions for objects by using AssertJ.
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
     * The Object.
     */
    private final Object OBJECT = null;

    /**
     * Should be null.
     */
    @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertThat(OBJECT).isNull();
        }

    /**
     * Should be null with custom error message.
     */
    @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertThat(OBJECT)
                    .overridingErrorMessage("Expected object to be null but it was: %s", OBJECT)
                    .isNull();
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
            assertThat(NOT_NULL).isNotNull();
        }

    /**
     * Should not be null with custom error message.
     */
    @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertThat(NOT_NULL)
                    .overridingErrorMessage("Expected the object to be not null but it was null")
                    .isNotNull();
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
                assertThat(ACTUAL).isEqualByComparingTo(EXPECTED);
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the integer to be: %d but it was: %d",
                                EXPECTED,
                                ACTUAL
                        )
                        .isEqualByComparingTo(EXPECTED);
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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

      /**
       * Should be equal with custom error message.
       */
      @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the object to be: %s but it was: %s",
                                EXPECTED,
                                ACTUAL
                        )
                        .isEqualTo(EXPECTED);
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
                assertThat(ACTUAL).isNotEqualByComparingTo(EXPECTED);
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the integer: %d to not be equal to the integer: %d but they were equal",
                                ACTUAL,
                                EXPECTED
                        )
                        .isNotEqualByComparingTo(EXPECTED);
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
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

      /**
       * Should not be equal with custom error message.
       */
      @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected that the string: %s is not equal to the string: %s but they were equal",
                                ACTUAL,
                                EXPECTED
                        )
                        .isNotEqualTo(EXPECTED);
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
            assertThat(ACTUAL).isSameAs(EXPECTED);
        }

    /**
     * Should refer to same error object with custom error message.
     */
    @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertThat(ACTUAL)
                    .overridingErrorMessage("The objects don't refer to the same object")
                    .isSameAs(EXPECTED);
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
            assertThat(ACTUAL).isNotSameAs(EXPECTED);
        }

    /**
     * Should not refer to same object with custom error message.
     */
    @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertThat(ACTUAL)
                    .overridingErrorMessage("The objects refer to the same objects")
                    .isNotSameAs(EXPECTED);
        }
    }


}
