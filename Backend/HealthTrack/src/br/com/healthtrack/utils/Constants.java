package br.com.healthtrack.utils;

public class Constants {
	public static final String CALORIES_UNIT_SYMBOL = "cal";
	
	public static String formatCalories(double calories) {
		return String.format("%.2f", calories) + " " + CALORIES_UNIT_SYMBOL;
	}
}

