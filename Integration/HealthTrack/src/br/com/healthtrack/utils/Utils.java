package br.com.healthtrack.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static final int PASSWORD_SIZE = 6;
	public static final String CALORIES_UNIT_SYMBOL = "cal";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DATETIME_FORMAT = "dd-MM-yyyy";
	public static final String KILOGRAMS_UNIT_SYMBOL = "kg";
	public static final String MERCURY_MILLIMETERS_UNIT_SYMBOL = "mmHg";
	public static final String METERS_UNIT_SYMBOL = "m";
	public static final String KILOMETERS_UNIT_SYMBOL = "km";
	public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
	public static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

	public static String formatCalories(double calories) {
		return String.format("%.2f", calories) + " " + CALORIES_UNIT_SYMBOL;
	}

	public static String formatDate(LocalDate date) {
		return date.format(dateFormat);
	}

	public static String formatDateTime(LocalDateTime dateTime) {
		return dateTime.format(dateTimeFormat);
	}

	public static String formatKilograms(double value) {
		return String.format("%.2f", value) + " " + KILOGRAMS_UNIT_SYMBOL;
	}
	
	public static String formatMeters(double value) {
		return String.format("%.2f", value) + " " + METERS_UNIT_SYMBOL;
	}
	
	public static String formatKilometers(double value) {
		return String.format("%.2f", value) + " " + KILOMETERS_UNIT_SYMBOL;
	}
}
