package com.amitesh.healthycoder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Coder.
 */
public class Coder {

  /**
   * The Height.
   */
  private double height;
  /**
   * The Weight.
   */
  private double weight;
  /**
   * The Age.
   */
  private int age;
  /**
   * The Gender.
   */
  private Gender gender;

  /**
   * Default Constructor
   */
  public Coder() {}

  /**
   * Instantiates a new Coder.
   *
   * @param height the height
   * @param weight the weight
   */
  public Coder(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

  /**
   * Instantiates a new Coder.
   *
   * @param height the height
   * @param weight the weight
   * @param age the age
   * @param gender the gender
   */
  public Coder(double height, double weight, int age, Gender gender) {
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

  /**
   * Gets height.
   *
   * @return the height
   */
  public double getHeight() {
		return height;
	}

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(double height) {
		this.height = height;
	}

  /**
   * Gets weight.
   *
   * @return the weight
   */
  public double getWeight() {
		return weight;
	}

  /**
   * Sets weight.
   *
   * @param weight the weight
   */
  public void setWeight(double weight) {
		this.weight = weight;
	}

  /**
   * Gets age.
   *
   * @return the age
   */
  public int getAge() {
		return age;
	}

  /**
   * Sets age.
   *
   * @param age the age
   */
  public void setAge(int age) {
		this.age = age;
	}

  /**
   * Gets gender.
   *
   * @return the gender
   */
  public Gender getGender() {
		return gender;
	}

  /**
   * Sets gender.
   *
   * @param gender the gender
   */
  public void setGender(Gender gender) {
		this.gender = gender;
	}

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("height", height)
        .append("weight", weight)
        .append("age", age)
        .append("gender", gender)
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

    Coder coder = (Coder) o;

    return new EqualsBuilder().append(height, coder.height)
        .append(weight, coder.weight).append(age, coder.age).append(gender, coder.gender)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(height)
        .append(weight)
        .append(age).append(gender).toHashCode();
  }
}
