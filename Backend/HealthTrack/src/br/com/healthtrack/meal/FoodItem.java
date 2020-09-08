package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai um item aliment�cio presente em uma refei��o, bem como seu valor cal�rico.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class FoodItem {
	private Food food;
	private double amount;
	private double calories;
	
	public FoodItem() {
	}
	
	/**
	 * M�todo construtor padr�o.
	 * @param amount Quantidade em gramas (g).
	 * @param food Item aliment�cio de refer�ncia.
	 */
	public FoodItem(double amount, Food food) {
		this.amount = amount;
		this.food = food;
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
	 * M�todo para se alterar a quantidade do item aliment�cio (apenas para valores maiores do que zero).
	 * @param amount Quantidade do item aliment�cio.
	 * @return N�o h� retorno.
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
	}
}
