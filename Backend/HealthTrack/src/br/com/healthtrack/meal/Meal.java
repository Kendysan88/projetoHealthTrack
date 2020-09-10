package br.com.healthtrack.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma refeição bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */

public class Meal {
	public static final Set<String> types = Stream.of(
			"BREAKFAST",
			"DINNER",
			"LUNCH",
			"SNACK"
	).collect(Collectors.toCollection(HashSet::new));

	private LocalDateTime dateTime;
	private String type;
	private List<FoodItem> foodItems = new ArrayList<FoodItem>();

	public Meal() {
	}

	/**
	 * Método para remover uma refeição no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting Meal from the database... DONE!");
		return true;
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
		return Constants.formatCalories(getTotalCalories());
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
		return Constants.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter o tipo da refeição.
	 * @return Tipo da refeição.
	 */
	public String getType() {
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
	 * Método para persistir as informações da refeição no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		for(FoodItem foodItem : foodItems) {
			foodItem.save();
		}

		System.out.println("Saving Meal in the database... DONE!");
		return true;
	}

	/**
	 * Método para se consultar refeições já persistidas no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @param type Tipo da refeição.
	 * @return Lista de refeições.
	 */
	public static Meal[] search(LocalDateTime initialDateTime, LocalDateTime finalDateTime, String type) {
		Meal[] results = {};

		System.out.println(
				"Searching since " +
				Constants.formatDateTime(initialDateTime) +
				" to " +
				Constants.formatDateTime(finalDateTime) +
				" and " +
				type +
				" into Meals table in database... DONE!"
		);

		return results;
	}

	/**
	 * Método para se consultar refeições já persistidas no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @return Lista de refeições.
	 */
	public static Meal[] search(LocalDateTime initialDateTime, LocalDateTime finalDateTime) {
		Meal[] results = {};

		System.out.println(
				"Searching since " +
				Constants.formatDateTime(initialDateTime) +
				" to " +
				Constants.formatDateTime(finalDateTime) +
				" into Meal table in database... DONE!"
		);

		return results;
	}

	/**
	 * Método para se alterar a data e hora da refeição.
	 * @param dateTime Date e hora da reifeção.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar o tipo da refeição (apenas para valores diferentes de vazio e inclusos na lista de tipos).
	 * @param type Tipo da refeição.
	 */
	public void setType(String type) {
		String sanitizedType = type.trim().toLowerCase();

		if(!sanitizedType.equals("")) {
			if(types.contains(sanitizedType)) {
				this.type = sanitizedType;
			}
		}
	}

}
