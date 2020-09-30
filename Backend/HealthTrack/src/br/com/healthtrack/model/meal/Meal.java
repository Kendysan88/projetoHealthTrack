package br.com.healthtrack.model.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma refeiçãoo bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */

public class Meal {

	private LocalDateTime dateTime;
	private MealType type;
	private List<FoodItem> foodItems = new ArrayList<FoodItem>();

	/**
	 * Método construtor padrão.
	 * @param dateTime Data e hora da refeição.
	 * @param type     Tipo de refeição.
	 */
	public Meal(LocalDateTime dateTime, MealType type) {
		this.dateTime = dateTime;
		this.type = type;
	}

	/**
	 * Método para se obter a quantidade total de calorias da refeição.
	 * @return Quantidade de calorias (cal) da refeição.
	 */
	public double getTotalCalories() {
		double totalCalories = 0.0;

		for(FoodItem foodItem : foodItems) {
			totalCalories += foodItem.getCalories();
		}

		return totalCalories;
	}

	/**
	 * Método para se obter a quantidade total de calorias da refeição com sufixo de unidade.
	 * @return Quantidade de calorias (cal) da refeição.
	 */
	public String getTotalCaloriesPretty() {
		return Utils.formatCalories(getTotalCalories());
	}

	/**
	 * Método para se obter a data e hora da refeição.
	 * @return Data e hora da refeição.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Método para se obter a data e hora da refeição formatados (dd-mm-yy HH:MM:SS).
	 * @return Data e hora da refeição no formato (dd-mm-yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Utils.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter o tipo da refeição.
	 * @return Tipo da refeição.
	 */
	public MealType getType() {
		return type;
	}

	/**
	 * Método para se obter os itens alimentícios da refeição.
	 * @return Itens alimentícios da refeição.
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * Método para se alterar a data e hora da refeição.
	 * @param dateTime Date e hora da reifeção.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar o tipo da refeição.
	 * @param type Tipo da refeição.
	 */
	public void setType(MealType type) {
		this.type = type;
	}
}
