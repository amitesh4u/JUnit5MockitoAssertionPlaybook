package com.amitesh.junit5core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * The type J unit 5 nested example test.
 */
@DisplayName("JUnit 5 Nested Example")
class JUnit5NestedExampleTest {

  /**
   * Before all.
   */
  @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

  /**
   * Before each.
   */
  @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

  /**
   * After each.
   */
  @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }

  /**
   * After all.
   */
  @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

  /**
   * The type A.
   */
  @Nested
    @DisplayName("Tests for the method A")
    class A {

    /**
     * Before each.
     */
    @BeforeEach
        void beforeEach() {
            System.out.println("Before each test method of the A class");
        }

    /**
     * After each.
     */
    @AfterEach
        void afterEach() {
            System.out.println("After each test method of the A class");
        }

    /**
     * Sample test for method a.
     */
    @Test
        @DisplayName("Example test for method A")
        void sampleTestForMethodA() {
            System.out.println("Example test for method A");
        }

    /**
     * The type When x.
     */
    @Nested
        @DisplayName("When X is true")
        class WhenX {

      /**
       * Before each.
       */
      @BeforeEach
            void beforeEach() {
                System.out.println("Before each test method of the WhenX class");
            }

      /**
       * After each.
       */
      @AfterEach
            void afterEach() {
                System.out.println("After each test method of the WhenX class");
            }

      /**
       * Sample test for method a when x.
       */
      @Test
            @DisplayName("Example test for method A when X is true")
            void sampleTestForMethodAWhenX() {
                System.out.println("Example test for method A when X is true");
            }
        }
    }
}
