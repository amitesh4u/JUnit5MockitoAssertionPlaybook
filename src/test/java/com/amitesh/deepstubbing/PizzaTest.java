package com.amitesh.deepstubbing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amitesh.deepstubbing.Pizza.PizzaSize;
import org.junit.jupiter.api.Test;

/**
 * The type Pizza test.
 */
class PizzaTest {

  /**
   * Test Pizza Builder. Pizza has correct attributes.
   */
  @Test
  void testPizzaBuilder_correctInput_PizzaHasCorrectAttributes() {
    Pizza pizza = new Pizza.PizzaBuilder()
        .name("Margherita")
        .size(PizzaSize.LARGE)
        .withExtraTopping("Mushroom")
        .withExtraTopping("Paneer")
        .withStuffedCrust(false)
        .willCollect(true)
        .applyDiscount(20)
        .build();

    assertEquals("Margherita", pizza.getName(), "Pizza name is Margherita");
    assertEquals(PizzaSize.LARGE, pizza.getSize(), "Pizza size is Large ");
    assertArrayEquals(new String[]{"Mushroom","Paneer"}, pizza.getToppings().toArray(), "Extra toppings are Mushroom and Paneer");
    assertFalse(pizza.isStuffedCrust(), "Has stuffed crust");
    assertTrue(pizza.isCollecting(), "Will collect" );
    assertEquals(Integer.valueOf(20), pizza.getDiscount(), "Discount is 20 unit");
  }

}

