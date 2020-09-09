package br.com.healthtrack.meal;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma por��o de um item aliment�cio, bem como seu valor cal�rico.
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
	 * M�todo para remover um item aliment�cio no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting Food from the database... DONE!");
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
	 * M�todo para se obter a quantidade de calorias do item aliment�cio.
	 * @return Quantidade de calorias (cal) do item aliment�cio.
	 */
	public double getCalories() {
		return calories;
	}
	
	/**
	 * M�todo para se obter a quantidade de calorias do item aliment�cio com sufixo de unidade.
	 * @return Quantidade de calorias (cal) do item aliment�cio.
	 */
	public String getCaloriesPretty() {
		return Constants.formatCalories(calories);
	}

	/**
	 * M�todo para se obter a descri��o dada ao item aliment�cio.
	 * @return Descri��o do item aliment�cio.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * M�todo para se obter o nome do item aliment�cio.
	 * @return Nome do item aliment�cio.
	 */
	public String getName() {
		return name;
	}

	/**
	 * M�todo para persistir as informa��es de do item aliment�cio no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		System.out.println("Saving Food in the database... DONE!");
		return true;
	}

	/**
	 * M�todo para se consultar itens aliment�cios j� persistidos no banco de dados.
	 * @param name Nome do item aliment�cio.
	 * @return Lista de itens aliment�cios.
	 */
	public static Food[] search(String name) {
		Food[] results = {};

		System.out.println("Searching for " + name + " into Foods table in database... DONE!");

		return results;
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

	/**
	 * M�todo para se alterar a quantidade de calorias do item aliment�cio (apenas para valores maiores do que zero).
	 * @return N�o h� retorno.
	 */
	public void setCalories(double calories) {
		if(calories > 0) {
			this.calories = calories;
		}
	}
	
	/**
	 * M�todo para se alterar a descri��o do item aliment�cio (apenas para valores diferentes de vazio).
	 * @return N�o h� retorno.
	 */
	public void setDescription(String description) {
		if(!description.trim().equals("")) {
			this.description = description;
		}
	}

	/**
	 * M�todo para se alterar o nome do item aliment�cio (apenas para valores diferentes de vazio).
	 * @return N�o h� retorno.
	 */
	public void setName(String name) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
	}
}