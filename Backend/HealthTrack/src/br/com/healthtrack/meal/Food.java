package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma porção de um item alimentício, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class Food {

	private double amount;
	private double calories;
	private String description;
	private String name;
	
	public Food() {
	}
	
	/**
	 * Método para remover um item alimentício no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting Food from the database... DONE!");
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
		return Constants.formatCalories(calories);
	}

	/**
	 * Método para se obter a descrição dada ao item alimentício.
	 * @return Descrição do item alimentício.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método para se obter o nome do item alimentício.
	 * @return Nome do item alimentício.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para persistir as informações de do item alimentício no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		System.out.println("Saving Food in the database... DONE!");
		return true;
	}

	/**
	 * Método para se consultar itens alimentícios já persistidos no banco de dados.
	 * @param name Nome do item alimentício.
	 * @return Lista de itens alimentícios.
	 */
	public static Food[] search(String name) {
		Food[] results = {};

		System.out.println("Searching for " + name + " into Foods table in database... DONE!");

		return results;
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

	/**
	 * Método para se alterar a quantidade de calorias do item alimentício (apenas para valores maiores do que zero).
	 * @return Não há retorno.
	 */
	public void setCalories(double calories) {
		if(calories > 0) {
			this.calories = calories;
		}
	}
	
	/**
	 * Método para se alterar a descrição do item alimentício (apenas para valores diferentes de vazio).
	 * @return Não há retorno.
	 */
	public void setDescription(String description) {
		if(!description.trim().equals("")) {
			this.description = description;
		}
	}

	/**
	 * Método para se alterar o nome do item alimentício (apenas para valores diferentes de vazio).
	 * @return Não há retorno.
	 */
	public void setName(String name) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
	}
}