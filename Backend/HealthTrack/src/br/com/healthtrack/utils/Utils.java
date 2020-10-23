package br.com.healthtrack.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static final int PASSWORD_SIZE = 6;
	// TODO: Deprecated
	public static final String CALORIES_UNIT_SYMBOL = "cal";
	public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	// TODO: Deprecated
	public static final String GRAMS_UNIT_SYMBOL = "g";
	// TODO: Deprecated
	public static final String KILOGRAMS_UNIT_SYMBOL = "kg";
	// TODO: Deprecated
	public static final String MERCURY_MILLIMETERS_UNIT_SYMBOL = "mmHg";
	// TODO: Deprecated
	public static final String METERS_UNIT_SYMBOL = "m";
	
	// TODO: Deprecated
	public static String formatCalories(double calories) {
		return String.format("%.2f", calories) + " " + CALORIES_UNIT_SYMBOL;
	}

	public static String formatDateTime(LocalDateTime dateTime) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
		return dateTime.format(format);
	}

	// TODO: Deprecated
	public static String formatGrams(double value) {
		return String.format("%.2f", value) + " " + GRAMS_UNIT_SYMBOL;
	}

	// TODO: Deprecated
	public static String formatKilograms(double value) {
		return String.format("%.2f", value) + " " + KILOGRAMS_UNIT_SYMBOL;
	}

	// TODO: Deprecated
	public static String formatMeters(double value) {
		return String.format("%.2f", value) + " " + METERS_UNIT_SYMBOL;
	}
}

