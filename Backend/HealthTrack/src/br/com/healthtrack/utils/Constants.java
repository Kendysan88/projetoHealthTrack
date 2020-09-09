package br.com.healthtrack.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constants {
	public static final String CALORIES_UNIT_SYMBOL = "cal";
	public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
	
	public static String formatCalories(double calories) {
		return String.format("%.2f", calories) + " " + CALORIES_UNIT_SYMBOL;
	}

	public static String formatDateTime(LocalDateTime dateTime) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
		return dateTime.format(format);
	}
}

