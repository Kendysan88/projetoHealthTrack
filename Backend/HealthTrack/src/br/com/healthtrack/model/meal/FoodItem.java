package br.com.healthtrack.model.meal;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai um item alimentício presente em uma refeição, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 3.0
 */
public class FoodItem {

	private double amount;
	private double calories;
	private Food food;

	/**
	 * Método construtor padrão (food e amount são obrigatórios).
	 * @param food Item alimentício de referência.
	 * @param amount Quantidade em gramas do item alimentício de referência.
	 */
	public FoodItem(Food food, double amount) {
		this.food = food;
		setAmount(amount);
		calculateCalories(food, amount);
	}

	/**
	 * Método para se calcular a quantidade de calorias do item alimentício.
	 * @param amount Quantidade do item alimentício.
	 */
	private void calculateCalories(Food food, double amount) {
		if(amount > 0) {
			this.calories = ((amount / food.getAmount()) * food.getCalories());
		} else {
			this.calories = 0;
		}
	}

	/**
	 * Método para se obter a quantidade do item alimentício.
	 * @return Quantidade em gramas (g) do item alimentício.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Método para se obter a quantidade do item alimentício com sufixo de unidade.
	 * @return Quantidade do item alimentício em gramas (g).
	 */
	public String getAmountPretty() {
		return Utils.formatGrams(amount);
	}

	/**
	 * Método para se obter a quantidade de calorias do item alimentício.
	 * @return Quantidade de calorias (cal) do item alimentício.
	 */
	public double getCalories() {
		return calories;
	}
	
	/**
	 * Método para se obter a quantidade de calorias do item alimentício com sufixo de unidade.
	 * @return Quantidade de calorias (cal) do item alimentício.
	 */
	public String getCaloriesPretty() {
		return Utils.formatCalories(getCalories());
	}

	/**
	 * Método para se obter o nome do item alimentício de referência.
	 * @return Nome do item alimentício de referência.
	 */
	public String getFoodName() {
		return food.getName();
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = getFoodName() +
		  " " + getAmountPretty() +
		  " - " + getCaloriesPretty();

		return info;
	}
	
	/**
	 * Método para se alterar a quantidade do item alimentício (apenas para valores maiores do que zero).
	 * @param amount Quantidade em gramas do item alimentício.
	 */
	public void setAmount(double amount) {
		this.amount = amount > 0 ? amount : 0;
	}
}
