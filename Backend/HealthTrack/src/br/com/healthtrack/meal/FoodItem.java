package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai um item alimentício presente em uma refeição, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class FoodItem {
	private Food food;
	private double amount;
	private double calories;
	
	public FoodItem() {
	}
	
	/**
	 * Método construtor padrão.
	 * @param amount Quantidade em gramas (g).
	 * @param food Item alimentício de referência.
	 */
	public FoodItem(double amount, Food food) {
		this.amount = amount;
		this.food = food;
	}
	
	/**
	 * Método para se obter a quantidade do item alimentício.
	 * @return Quantidade em gramas (g) do item alimentício.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Método para se obter o nome do item alimentício de referência.
	 * @return Nome do item alimentício de referência.
	 */
	public String getFoodName() {
		return food.getName();
	}
	
	/**
	 * Método para se obter a quantidade de calorias do item alimentício.
	 * @return Quantidade de calorias (cal) do item alimentício.
	 */
	public double getCalories() {
		return ((amount / food.getAmount()) * food.getCalories());
	}
	
	/**
	 * Método para se obter a quantidade de calorias do item alimentício com sufixo de unidade.
	 * @return Quantidade de calorias (cal) do item alimentício.
	 */
	public String getCaloriesPretty() {
		return Constants.formatCalories(getAmount());
	}
	
	/**
	 * Método para se alterar a quantidade do item alimentício (apenas para valores maiores do que zero).
	 * @param amount Quantidade do item alimentício.
	 * @return Não há retorno.
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
	}
}
