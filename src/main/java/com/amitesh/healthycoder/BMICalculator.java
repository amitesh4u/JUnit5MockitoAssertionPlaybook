package com.amitesh.healthycoder;

import java.util.Comparator;
import java.util.List;

/**
 * The type Bmi calculator.
 */
public class BMICalculator {

	/**
	 * Instantiates a new Bmi calculator.
	 */
	private BMICalculator(){}

	/**
	 * The constant BMI_THRESHOLD.
	 */
	private static final double BMI_THRESHOLD = 25.0;

	/**
	 * Is diet recommended boolean.
	 *
	 * @param weight the weight
	 * @param height the height
	 * @return the boolean
	 */
	public static boolean isDietRecommended(double weight, double height) {
		if (height == 0.0) throw new ArithmeticException();
		double bmi = weight / (height * height);
		return bmi >= BMI_THRESHOLD;
	}

	/**
	 * Find coder with worst bmi coder.
	 *
	 * @param coders the coders
	 * @return the coder
	 */
	public static Coder findCoderWithWorstBMI(List<Coder> coders) {
		return coders.stream().sorted(Comparator.comparing(BMICalculator::calculateBMI))
				.reduce((first, second) -> second).orElse(null);
	}

	/**
	 * Get bmi scores double [ ].
	 *
	 * @param coders the coders
	 * @return the double [ ]
	 */
	public static double[] getBMIScores(List<Coder> coders) {
		double[] bmiScores = new double[coders.size()];
		for (int i = 0; i < bmiScores.length; i++) {
			bmiScores[i] = BMICalculator.calculateBMI(coders.get(i));
		}
		return bmiScores;
	}

	/**
	 * Calculate bmi double.
	 *
	 * @param coder the coder
	 * @return the double
	 */
	public static double calculateBMI(Coder coder) {
		if (coder.getHeight() == 0.0) {
			throw new IllegalArgumentException("Height can not be zero");
		}
		if (coder.getWeight() == 0.0) {
			throw new IllegalArgumentException("Weight can not be zero");
		}

		double height = coder.getHeight();
		double weight = coder.getWeight();
		double bmi = weight / (height * height);
		return Math.round(bmi * 100) / 100.0;
	}

}
