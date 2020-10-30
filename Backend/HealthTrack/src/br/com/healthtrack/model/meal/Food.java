package br.com.healthtrack.model.meal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.healthtrack.model.meal.dao.FoodDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma porção de um item alimentício, bem como seu
 * valor calórico.
 * @author Afonso de Sousa Costa
 * @version 5.0
 */
public class Food {

	private double amount;
	private double calories;
	private String description;
	private int id;
	private String name;
	private Food self = null;
	private String unit;
	private static List<String> validUnits = new ArrayList<String>(
			Arrays.asList( "g", "ml" ));

	/**
	 * Método construtor.
	 */
	public Food() {}

	/**
	 * Método construtor (id é obrigatório).
	 * @param id Identificador do item alimentício.
	 */
	public Food(int id) {
		if (self == null) {
			FoodDAO dao = new FoodDAO();

			self = dao.searchById(id);

			if (self != null) {
				setId(self.getId());
				setAmount(self.getAmount());
				setCalories(self.getCalories());
				setName(self.getName());
				setDescription(self.getDescription());
				setUnit(self.getUnitPrefix());
			}
		}
	}

	/**
	 * Método construtor (amount, calories, unidade de medida
	 * e name são obrigatórios).
	 * @param amount   Quantidade em gramas do item alimentício.
	 * @param calories Quatidade de calorias do item alimentício.
	 * @param name     Nome do item alimentício.
	 * @param unit     Unidade de medida do item alimentício.
	 */
	public Food(double amount, double calories,
			String name, String unit) {
		setAmount(amount);
		setCalories(calories);
		setName(name);
		setUnit(unit);
	}

	/**
	 * Método construtor (amount, calories, unidade de medida, name
	 * e description são obrigatórios).
	 * @param amount      Quantidade em gramas do item alimentício.
	 * @param calories    Quatidade de calorias do item alimentício.
	 * @param name        Nome do item alimentício.
	 * @param unit        Unidade de medida do item alimentício.
	 * @param description Descrição/observação do item alimentício.
	 */
	public Food(double amount, double calories, String name,
			String unit, String description) {
		setAmount(amount);
		setCalories(calories);
		setName(name);
		setUnit(unit);
		setDescription(description);
	}

	/**
	 * Método construtor (amount, calories, unidade de medida
	 * e name são obrigatórios).
	 * @param amount   Quantidade em gramas do item alimentício.
	 * @param calories Quatidade de calorias do item alimentício.
	 * @param id       Identificador do item alimentício.
	 * @param name     Nome do item alimentício.
	 * @param unit     Unidade de medida do item alimentício.
	 */
	public Food(int id, double amount, double calories,
			String name, String unit) {
		setId(id);
		setAmount(amount);
		setCalories(calories);
		setName(name);
		setUnit(unit);
	}

	/**
	 * Método construtor padrão (amount, calories, unidade de medida,
	 * name e description são obrigatórios).
	 * @param amount      Quantidade em gramas do item alimentício.
	 * @param calories    Quatidade de calorias do item alimentício.
	 * @param id          Identificador do item alimentício.
	 * @param name        Nome do item alimentício.
	 * @param unit        Unidade de medida do item alimentício.
	 * @param description Descrição/observação do item alimentício.
	 */
	public Food(int id, double amount, double calories,
			String name, String unit, String description) {
		setId(id);
		setAmount(amount);
		setCalories(calories);
		setName(name);
		setUnit(unit);
		setDescription(description);
	}

	/**
	 * Método para se obter a quantidade do item alimentício.
	 * @return Quantidade em gramas (g) do item alimentício.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Método para se obter a quantidade do item alimentício
	 * com sufixo de unidade.
	 * @return Quantidade do item alimentício em gramas (g),
	 * ou, em mililitros (ml).
	 */
	public String getAmountPretty() {
		return amount + " " + unit;
	}

	/**
	 * Método para se obter a quantidade de calorias do item
	 * alimentício.
	 * @return Quantidade de calorias (cal) do item alimentício.
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * Método para se obter a quantidade de calorias do item
	 * alimentício com sufixo de unidade.
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
	 * Método para se obter o identificador do item alimentício.
	 * @return Identificador do item alimentício.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info;

		if (getDescription() != null){
			info = getName() +
					" (" + getDescription() + ") "
					+ getAmountPretty() + " - "
					+ getCaloriesPretty();
		} else {
			info = getName() +
					" " + getAmountPretty() + " - "
					+ getCaloriesPretty();
		}

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
	 * Método para se obter a unidade de medida do item alimentício.
	 * @return Unidade de medida do item alimentício.
	 */
	public String getUnitPrefix() {
		return unit;
	}

	/**
	 * Método para se alterar a quantidade do item alimentício
	 * (apenas para valores maiores do que zero).
	 * @param amount Quantidade em gramas do item alimentício.
	 */
	public void setAmount(double amount) {
		this.amount = amount > 0 ? amount : 0;
	}

	/**
	 * Método para se alterar a quantidade de calorias do item
	 * alimentício (apenas para valores maiores do que zero).
	 * @param calories Quantidade de calorias do item alimentício.
	 */
	public void setCalories(double calories) {
		this.calories = calories > 0 ? calories : 0;
	}
	
	/**
	 * Método para se alterar a descrição do item alimentício
	 * (apenas para valores diferentes de vazio).
	 * @param description Descrição do item alimentício.
	 */
	public void setDescription(String description) {
		if(description == null)
			return;

		description = description.trim();

		if(!description.equals(""))
			this.description = description;
	}

	/**
	 * Método para se alterar o identificador do item alimentício.
	 * @param id Identificador do item alimentício.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	/**
	 * Método para se alterar o nome do item alimentício
	 * (apenas para valores diferentes de vazio).
	 * @param name Nome do item alimentício.
	 */
	public void setName(String name) {
		if(name == null)
			return;

		name = name.trim();

		if(!name.equals("")) {
			this.name = name;
		}
	}

	/**
	 * Método para se alterar a unidade de medida do item
	 * alimentício (apenas para valores diferentes de vazio,
	 * e que estejam dentro da lista de unidades válidas).
	 * @param unit Unidade de medida do item alimentício.
	 */
	public void setUnit(String unit) {
		if(unit == null)
			return;

		unit = unit.trim();

		if(!unit.equals("") &&
				validUnits.contains(unit.toLowerCase()))
			this.unit = unit;
	}
}
