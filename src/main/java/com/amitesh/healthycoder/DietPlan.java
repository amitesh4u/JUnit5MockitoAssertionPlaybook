package com.amitesh.healthycoder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Diet plan.
 */
public class DietPlan {

  /**
   * The Calories.
   */
  private int calories;
  /**
   * The Protein.
   */
  private int protein;
  /**
   * The Fat.
   */
  private int fat;
  /**
   * The Carbohydrate.
   */
  private int carbohydrate;

  /**
   * Instantiates a new Diet plan.
   *
   * @param calories the calories
   * @param protein the protein
   * @param fat the fat
   * @param carbohydrate the carbohydrate
   */
  public DietPlan(int calories, int protein, int fat, int carbohydrate) {
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbohydrate = carbohydrate;
	}

  /**
   * Default Constructor
   */
  public DietPlan(){}

  /**
   * Gets calories.
   *
   * @return the calories
   */
  public int getCalories() {
		return calories;
	}

  /**
   * Sets calories.
   *
   * @param calories the calories
   */
  public void setCalories(int calories) {
		this.calories = calories;
	}

  /**
   * Gets protein.
   *
   * @return the protein
   */
  public int getProtein() {
		return protein;
	}

  /**
   * Sets protein.
   *
   * @param protein the protein
   */
  public void setProtein(int protein) {
		this.protein = protein;
	}

  /**
   * Gets fat.
   *
   * @return the fat
   */
  public int getFat() {
		return fat;
	}

  /**
   * Sets fat.
   *
   * @param fat the fat
   */
  public void setFat(int fat) {
		this.fat = fat;
	}

  /**
   * Gets carbohydrate.
   *
   * @return the carbohydrate
   */
  public int getCarbohydrate() {
		return carbohydrate;
	}

  /**
   * Sets carbohydrate.
   *
   * @param carbohydrate the carbohydrate
   */
  public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("calories", calories)
        .append("protein", protein)
        .append("fat", fat)
        .append("carbohydrate", carbohydrate)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DietPlan dietPlan = (DietPlan) o;

    return new EqualsBuilder().append(calories, dietPlan.calories)
        .append(protein, dietPlan.protein).append(fat, dietPlan.fat)
        .append(carbohydrate, dietPlan.carbohydrate).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(calories).append(protein).append(fat)
        .append(carbohydrate).toHashCode();
  }
}
