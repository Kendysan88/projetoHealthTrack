package br.com.healthtrack.model.meal;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma porção de um item alimentício, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class Food implements Comparable<Food> {

	private double amount;
	private double calories;
	private String description;
	private String name;
	
	/**
	 * Método construtor padrão (amount, calories e name são obrigatórios).
	 * @param amount   Quantidade em gramas do item alimentício.
	 * @param calories Quatidade de calorias do item alimentício.
	 * @param name     Nome do item alimentício.
	 */
	public Food(double amount, double calories, String name) {
		this.amount = amount < 0 ? 0 : amount;
		this.calories = calories < 0 ? 0 : calories;

		if(!name.trim().equals("")) {
			this.name = name;
		}
	}

	/**
	 * Método construtor padrão sobrecarregado (amount, calories, name e description são obrigatórios).
	 * @param amount      Quantidade em gramas do item alimentício.
	 * @param calories    Quatidade de calorias do item alimentício.
	 * @param name        Nome do item alimentício.
	 * @param description Descrição/observação do item alimentício.
	 */
	public Food(double amount, double calories, String name, String description) {
		this.amount = amount < 0 ? 0 : amount;
		this.calories = calories < 0 ? 0 : calories;

		if(!name.trim().equals("")) {
			this.name = name;
		}
		if(!description.trim().equals("")) {
			this.description = description;
		}
	}

	@Override
    public int compareTo(Food otherFood) {
        return this.getName().compareToIgnoreCase(otherFood.getName());
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
		return Utils.formatCalories(calories);
	}

	/**
	 * Método para se obter a descrição dada ao item alimentício.
	 * @return Descrição do item alimentício.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = getName() + " ";

		if (getDescription() != null && !getDescription().equals("")){
			info += "(" + getDescription() + ") ";
		}

		info += getAmountPretty() + " - " + getCaloriesPretty();

		return info;
	}

	/**
	 * Método para se obter o nome do item alimentício.
	 * @return Nome do item alimentício.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para se alterar a quantidade do item alimentício (apenas para valores maiores do que zero).
	 * @param amount Quantidade em gramas do item alimentício.
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
	}

	/**
	 * Método para se alterar a quantidade de calorias do item alimentício (apenas para valores maiores do que zero).
	 * @param calories Quantidade de calorias do item alimentício.
	 */
	public void setCalories(double calories) {
		if(calories > 0) {
			this.calories = calories;
		}
	}
	
	/**
	 * Método para se alterar a descrição do item alimentício (apenas para valores diferentes de vazio).
	 * @param description Descrição do item alimentício.
	 */
	public void setDescription(String description) {
		if(!description.trim().equals("")) {
			this.description = description;
		}
	}

	/**
	 * Método para se alterar o nome do item alimentício (apenas para valores diferentes de vazio).
	 * @param name Nome do item alimentício.
	 */
	public void setName(String name) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
	}
}
