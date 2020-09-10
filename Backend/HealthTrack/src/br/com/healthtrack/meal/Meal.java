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
 * Classe que abstrai uma refei��o bem como seu valor cal�rico.
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
	 * M�todo para remover uma refei��o no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting Meal from the database... DONE!");
		return true;
	}

	/**
	 * M�todo para se obter a quantidade total de calorias da refei��o.
	 * @return Quantidade de calorias (cal) da refei��o.
	 */
	public double getTotalCalories() {
		double totalCalories = 0.0;

		for(FoodItem foodItem : foodItems) {
			totalCalories += foodItem.getCalories();
		}

		return totalCalories;
	}

	/**
	 * M�todo para se obter a quantidade total de calorias da refei��o com sufixo de unidade.
	 * @return Quantidade de calorias (cal) da refei��o.
	 */
	public String getTotalCaloriesPretty() {
		return Constants.formatCalories(getTotalCalories());
	}

	/**
	 * M�todo para se obter a data e hora da refei��o.
	 * @return Data e hora da refei��o.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * M�todo para se obter a data e hora da refei��o formatados (dd-mm-yy HH:MM:SS).
	 * @return Data e hora da refei��o no formato (dd-mm-yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Constants.formatDateTime(getDateTime());
	}

	/**
	 * M�todo para se obter o tipo da refei��o.
	 * @return Tipo da refei��o.
	 */
	public String getType() {
		return type;
	}

	/**
	 * M�todo para se obter os itens aliment�cios da refei��o.
	 * @return Itens aliment�cios da refei��o.
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * M�todo para persistir as informa��es da refei��o no banco de dados.
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
	 * M�todo para se consultar refei��es j� persistidas no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @param type Tipo da refei��o.
	 * @return Lista de refei��es.
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
	 * M�todo para se consultar refei��es j� persistidas no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @return Lista de refei��es.
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
	 * M�todo para se alterar a data e hora da refei��o.
	 * @param dateTime Date e hora da reife��o.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * M�todo para se alterar o tipo da refei��o (apenas para valores diferentes de vazio e inclusos na lista de tipos).
	 * @param type Tipo da refei��o.
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
