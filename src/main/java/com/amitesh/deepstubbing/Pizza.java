package com.amitesh.deepstubbing;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Pizza.
 *
 * @author Amitesh Kumar
 */
public class Pizza {

  /**
   * The enum Pizza size.
   */
  public enum PizzaSize {
    /**
     * Large pizza size.
     */
    LARGE,
    /**
     * Medium pizza size.
     */
    MEDIUM,
    /**
     * Small pizza size.
     */
    SMALL
  }

  /**
   * The Name.
   */
  private final String name;
  /**
   * The Size.
   */
  private final PizzaSize size;
  /**
   * The Toppings.
   */
  private final List<String> toppings;
  /**
   * The Stuffed crust.
   */
  private final boolean stuffedCrust;
  /**
   * The Collect.
   */
  private final boolean collect;
  /**
   * The Discount.
   */
  private final Integer discount;

  /**
   * Instantiates a new Pizza.
   *
   * @param builder the builder
   */
  private Pizza(PizzaBuilder builder) {
    this.name = builder.name;
    this.size = builder.size;
    this.toppings = builder.toppings;
    this.stuffedCrust = builder.stuffedCrust;
    this.collect = builder.collect;
    this.discount = builder.discount;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public PizzaSize getSize() {
    return size;
  }

  /**
   * Gets toppings.
   *
   * @return the toppings
   */
  public List<String> getToppings() {
    return toppings;
  }

  /**
   * Is stuffed crust boolean.
   *
   * @return the boolean
   */
  public boolean isStuffedCrust() {
    return stuffedCrust;
  }

  /**
   * Is collecting boolean.
   *
   * @return the boolean
   */
  public boolean isCollecting() {
    return collect;
  }

  /**
   * Gets discount.
   *
   * @return the discount
   */
  public Integer getDiscount() {
    return discount;
  }

  /**
   * The type Pizza builder.
   */
  public static class PizzaBuilder {

    /**
     * The Name.
     */
    private String name;
    /**
     * The Size.
     */
    private PizzaSize size;

    /**
     * The Toppings.
     */
    private List<String> toppings;
    /**
     * The Stuffed crust.
     */
    private boolean stuffedCrust;
    /**
     * The Collect.
     */
    private boolean collect;
    /**
     * The Discount.
     */
    private Integer discount = null;

    /**
     * Name pizza builder.
     *
     * @param name the name
     * @return the pizza builder
     */
    public PizzaBuilder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Size pizza builder.
     *
     * @param size the size
     * @return the pizza builder
     */
    public PizzaBuilder size(PizzaSize size) {
      this.size = size;
      return this;
    }

    /**
     * With extra topping pizza builder.
     *
     * @param extraTopping the extra topping
     * @return the pizza builder
     */
    public PizzaBuilder withExtraTopping(String extraTopping) {
      if (this.toppings == null) {
        toppings = new ArrayList<>();
      }
      this.toppings.add(extraTopping);
      return this;
    }

    /**
     * With stuffed crust pizza builder.
     *
     * @param stuffedCrust the stuffed crust
     * @return the pizza builder
     */
    public PizzaBuilder withStuffedCrust(boolean stuffedCrust) {
      this.stuffedCrust = stuffedCrust;
      return this;
    }

    /**
     * Will collect pizza builder.
     *
     * @param collect the collect
     * @return the pizza builder
     */
    public PizzaBuilder willCollect(boolean collect) {
      this.collect = collect;
      return this;
    }

    /**
     * Apply discount pizza builder.
     *
     * @param discount the discount
     * @return the pizza builder
     */
    public PizzaBuilder applyDiscount(Integer discount) {
      this.discount = discount;
      return this;
    }

    /**
     * Build pizza.
     *
     * @return the pizza
     */
    public Pizza build() {
      return new Pizza(this);
    }
  }

}
