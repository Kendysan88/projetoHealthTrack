package br.com.healthtrack.model.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma refeiçãoo bem como seu valor
 * calórico.
 * @author Afonso de Sousa Costa
 * @version 4.0
 */
public class Meal implements Comparable<Meal> {

	private LocalDateTime dateTime;
	private int id;
	private MealType type;
	private List<FoodItem> foodItems;

	/**
	 * Método construtor (dateTime e type são obrigatórios).
	 * @param dateTime Data e hora da refeição.
	 * @param type     Tipo de refeição.
	 */
	public Meal(LocalDateTime dateTime, MealType type) {
		foodItems = new ArrayList<FoodItem>();

		setDateTime(dateTime);
		setType(type);
	}

	/**
	 * Método construtor (dateTime, id e type são obrigatórios).
	 * @param dateTime Data e hora da refeição.
	 * @param id	   Identificador da refeição.
	 * @param type     Tipo de refeição.
	 */
	public Meal(int id, LocalDateTime dateTime, MealType type) {
		foodItems = new ArrayList<FoodItem>();

		setId(id);
		setDateTime(dateTime);
		setType(type);
	}

	/**
	 * Método para se adicionar um item alimentício
	 * à refeição.
	 * @param foodItem Item alimentício a ser
	 * adicionado.
	 */
	public void addFoodItem(FoodItem foodItem) {
		foodItem.setMealId(this.id);
		foodItems.add(foodItem);
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
	 * Método para se obter a data e hora da refeição
	 * formatados (dd-mm-yy HH:MM:SS).
	 * @return Data e hora da refeição no formato
	 * (dd-mm-yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Utils.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter a lista de itens alimentícios
	 * da refeição.
	 * @return Lista de itens alimentícios da refeição.
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * Método para se obter o identificador da refeição.
	 * @return Identificador da refeição.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter informações sobre o objeto
	 * instanciado.
	 * @return Texto contendo os valores dos atributos
	 * desse objeto.
	 */
	public String getInfoPretty() {
		String info = getTypeName() +
		  " às " + getDateTimePretty() +
		  " Total de calorias: " + getTotalCaloriesPretty();

		return info;
	}

	/**
	 * Método para se obter a quantidade total de calorias
	 * da refeição.
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
	 * Método para se obter a quantidade total de calorias
	 * da refeição com sufixo de unidade.
	 * @return Quantidade de calorias (cal) da refeição.
	 */
	public String getTotalCaloriesPretty() {
		return Utils.formatCalories(getTotalCalories());
	}

	/**
	 * Método para se obter o identificador do tipo
	 * da refeição.
	 * @return Identificador do tipo da refeição.
	 */
	public int getTypeId() {
		return type.getId();
	}

	/**
	 * Método para se obter o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getTypeName() {
		return type.getName();
	}

	/**
	 * Método para se remover um item alimentício da
	 * refeição.
	 * @param foodItem Nome do item alimentício a ser
	 * removido.
	 */
	public void removeFoodItem(String foodItemName) {
		FoodItem foodItemToRemove = null;

		for (FoodItem foodItem : foodItems) {
			if (foodItem.getFoodName().equalsIgnoreCase(foodItemName)) {
				foodItemToRemove = foodItem;
				break;
			}
		}

		if(foodItemToRemove != null) {
			foodItems.remove(foodItemToRemove);
		}
	}

	/**
	 * Método para se alterar o identificador da
	 * refeição.
	 * @param id Identificador da reifeção.
	 */
	public void setId(int id) {
		this.id = id;
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
