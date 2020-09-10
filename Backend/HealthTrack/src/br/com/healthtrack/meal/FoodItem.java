package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai um item alimentício presente em uma refeição, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */

public class FoodItem {
	private Food food;
	private double amount;
	private double calories;
	
	public FoodItem() {
	}

	/**
	 * Método para remover um item alimentício no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting FoodItem from the database... DONE!");
		return true;
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
	 * Método para persistir as informações do item alimentício no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		setCalories(getCalories());

		System.out.println("Saving FoodItem in the database... DONE!");
		return true;
	}
	
	/**
	 * Método para se alterar a quantidade do item alimentício (apenas para valores maiores do que zero).
	 * @param amount Quantidade do item alimentício.
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
	}
	
	/**
	 * Método para se alterar a quantidade de calorias do item alimentício (apenas para valores maiores do que zero).
	 * @return Não há retorno.
	 */
	private void setCalories(double calories) {
		if(calories > 0) {
			this.calories = calories;
		}
	}
}
