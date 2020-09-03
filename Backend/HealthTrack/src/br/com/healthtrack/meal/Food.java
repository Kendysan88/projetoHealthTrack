package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

public class Food {

	private double amount;
	private double calories;
	private String description;
	private String name;
	
	public Food() {
	}
	
	public Food(double amount, double calories, String name) {
		this.amount = amount;
		this.calories = calories;
		this.name = name;
	}
	
	public Food(double amount, double calories, String name, String description) {
		this.amount = amount;
		this.calories = calories;
		this.name = name;
		this.description = description;
	}
	
	private String formatCalories(double calories) {
		return String.format("%.2f", calories) + " " + Constants.CALORIES_UNIT_SYMBOL;
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return calories;
	}
	
	public String getCaloriesPretty() {
		return formatCalories(calories);
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}
}