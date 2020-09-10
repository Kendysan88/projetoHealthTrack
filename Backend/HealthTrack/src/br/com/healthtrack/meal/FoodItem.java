package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai um item aliment�cio presente em uma refei��o, bem como seu valor cal�rico.
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
	 * M�todo para remover um item aliment�cio no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting FoodItem from the database... DONE!");
		return true;
	}
	
	/**
	 * M�todo para se obter a quantidade do item aliment�cio.
	 * @return Quantidade em gramas (g) do item aliment�cio.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * M�todo para se obter o nome do item aliment�cio de refer�ncia.
	 * @return Nome do item aliment�cio de refer�ncia.
	 */
	public String getFoodName() {
		return food.getName();
	}
	
	/**
	 * M�todo para se obter a quantidade de calorias do item aliment�cio.
	 * @return Quantidade de calorias (cal) do item aliment�cio.
	 */
	public double getCalories() {
		return ((amount / food.getAmount()) * food.getCalories());
	}
	
	/**
	 * M�todo para se obter a quantidade de calorias do item aliment�cio com sufixo de unidade.
	 * @return Quantidade de calorias (cal) do item aliment�cio.
	 */
	public String getCaloriesPretty() {
		return Constants.formatCalories(getAmount());
	}
	
	/**
	 * M�todo para persistir as informa��es do item aliment�cio no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		setCalories(getCalories());

		System.out.println("Saving FoodItem in the database... DONE!");
		return true;
	}
	
	/**
	 * M�todo para se alterar a quantidade do item aliment�cio (apenas para valores maiores do que zero).
	 * @param amount Quantidade do item aliment�cio.
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
	}
	
	/**
	 * M�todo para se alterar a quantidade de calorias do item aliment�cio (apenas para valores maiores do que zero).
	 * @return N�o h� retorno.
	 */
	private void setCalories(double calories) {
		if(calories > 0) {
			this.calories = calories;
		}
	}
}
