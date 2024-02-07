package com.amitesh.healthycoder;

/**
 * The type Diet planner.
 */
public class DietPlanner {

	/**
	 * The Protein percentage.
	 */
	private final int proteinPercentage;
	/**
	 * The Fat percentage.
	 */
	private final int fatPercentage;
	/**
	 * The Carbohydrate percentage.
	 */
	private final int carbohydratePercentage;

	/**
	 * Instantiates a new Diet planner.
	 *
	 * @param proteinPercentage the protein percentage
	 * @param fatPercentage the fat percentage
	 * @param carbohydratePercentage the carbohydrate percentage
	 */
	public DietPlanner(int proteinPercentage, int fatPercentage, int carbohydratePercentage) {
		if (proteinPercentage + fatPercentage + carbohydratePercentage != 100) {
			throw new IllegalArgumentException("Protein, Fat and Carbohydrate percentages must add up to 100!");
		}
			
		this.proteinPercentage = proteinPercentage;
		this.fatPercentage = fatPercentage;
		this.carbohydratePercentage = carbohydratePercentage;
	}

	/**
	 * Calculate diet diet plan.
	 *
	 * @param coder the coder
	 * @return the diet plan
	 */
	public DietPlan calculateDiet(Coder coder) {
		int calories = this.calculateBMR(coder);
		int protein = this.calculateProtein(calories);
		int fat = this.calculateFat(calories);
		int carbohydrate = this.calculateCarbohydrate(calories);
		
		return new DietPlan(calories, protein, fat, carbohydrate);
	}

	/**
	 * Calculate protein int.
	 *
	 * @param bmr the bmr
	 * @return the int
	 */
	private int calculateProtein(int bmr) {
		return (int) Math.round(bmr * proteinPercentage / 400.0);
	}

	/**
	 * Calculate fat int.
	 *
	 * @param bmr the bmr
	 * @return the int
	 */
	private int calculateFat(int bmr) {
		return (int) Math.round(bmr * fatPercentage / 900.0);
	}

	/**
	 * Calculate carbohydrate int.
	 *
	 * @param bmr the bmr
	 * @return the int
	 */
	private int calculateCarbohydrate(int bmr) {
		return (int) Math.round(bmr * carbohydratePercentage / 400.0);
	}

	/**
	 * Calculate bmr int.
	 *
	 * @param coder the coder
	 * @return the int
	 */
	private int calculateBMR(Coder coder) {
		if (coder.getGender() == Gender.MALE) {
			return (int) Math.round(
					(66.5 + 13.8 * coder.getWeight() 
					+ 5.0 * coder.getHeight() * 100 
					- 6.8 * coder.getAge()) * 1.2
			);
		}
		
		return (int) Math.round(
				(655.1 + 9.6 * coder.getWeight() 
				+ 1.9 * coder.getHeight() * 100 
				- 4.7 * coder.getAge()) * 1.2 
		);
	}
}