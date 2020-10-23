package br.com.healthtrack.model.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma refeiçãoo bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 3.0
 */
public class Meal implements Comparable<Meal> {

	private LocalDateTime dateTime;
	private MealType type;
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

	/**
	 * Método construtor padrão (dateTime e type).
	 * @param dateTime Data e hora da refeição.
	 * @param type     Tipo de refeição.
	 */
	public Meal(LocalDateTime dateTime, MealType type) {
		setDateTime(dateTime);
		setType(type);
	}

	/**
	 * Método construtor sobrecarregado (dateTime, type e foodItems são obrigatórios).
	 * @param dateTime  Data e hora da refeição.
	 * @param type      Tipo de refeição.
	 * @param foodItems Lista de itens alimentícios.
	 */
	public Meal(LocalDateTime dateTime, MealType type, ArrayList<FoodItem> foodItems) {
		setDateTime(dateTime);
		setType(type);
		this.foodItems = foodItems;
	}

	@Override
    public int compareTo(Meal otherMeal) {
        return this.getDateTime().compareTo(otherMeal.getDateTime());
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
	 * Método para se obter os itens alimentícios da refeição.
	 * @return Itens alimentícios da refeição.
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = getTypeName() +
		  " às " + getDateTimePretty() +
		  " Total de calorias: " + getTotalCaloriesPretty();

		return info;
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
	 * Método para se obter o tipo da refeição.
	 * @return Tipo da refeição.
	 */
	public MealType getType() {
		return type;
	}

	/**
	 * Método para se obter o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getTypeName() {
		return type.getName();
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
