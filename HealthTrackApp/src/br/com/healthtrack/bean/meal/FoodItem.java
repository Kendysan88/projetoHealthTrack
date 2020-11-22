package br.com.healthtrack.bean.meal;

import br.com.healthtrack.dao.meal.FoodDAO;
import br.com.healthtrack.dao.meal.MealDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai um item alimentício presente
 * em uma refeição, bem como seu valor calórico.
 * @author Afonso de Sousa Costa
 * @version 5.0
 */
public class FoodItem {

	private double amount;
	private double calories;
	private Food food = null;
	private int foodId;
	private Meal meal = null;
	private int mealId;

	/**
	 * Método construtor.
	 */
	public FoodItem() {}

	/**
	 * Método construtor (foodId, mealId e amount são
	 * obrigatórios).
	 * @param foodId Identificador do item alimentício
	 * de referência.
	 * @param mealId Identificador da refeição.
	 * @param amount Quantidade em gramas (ou mililitros)
	 * do item alimentício de referência.
	 */
	public FoodItem(int foodId, int mealId, double amount) {
		setFoodId(foodId);
		setMealId(mealId);
		setAmount(amount);
		calculateCalories(amount);
	}

	/**
	 * Método construtor (foodId, mealId, amount e
	 * calories são obrigatórios).
	 * @param foodId Identificador do item alimentício
	 * de referência.
	 * @param mealId Identificador da refeição.
	 * @param amount Quantidade em gramas (ou mililitros)
	 * do item alimentício de referência.
	 * @param calories Quantidade de calorias do item
	 * alimentício de referência.
	 */
	public FoodItem(int foodId, int mealId,
			double amount, double calories) {
		setFoodId(foodId);
		setMealId(mealId);
		setAmount(amount);
		setCalories(calories);
	}

	/**
	 * Método para se calcular a quantidade de calorias
	 * do item alimentício.
	 * @param amount Quantidade do item alimentício.
	 */
	private void calculateCalories(double amount) {
		if(amount > 0) {
			this.calories = ((amount / getFood().getAmount()) *
					getFood().getCalories());
		} else {
			this.calories = 0;
		}
	}

	/**
	 * Método para se obter a quantidade do item
	 * alimentício.
	 * @return Quantidade em gramas (g) do item
	 * alimentício.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Método para se obter a quantidade do item
	 * alimentício com sufixo de unidade.
	 * @return Quantidade do item alimentício em
	 * gramas (g), ou, em mililitros (ml).
	 */
	public String getAmountPretty() {
		return amount + " " + getFood().getUnitPrefix();
	}

	/**
	 * Método para se obter a quantidade de calorias
	 * do item alimentício.
	 * @return Quantidade de calorias (cal) do item
	 * alimentício.
	 */
	public double getCalories() {
		return calories;
	}
	
	/**
	 * Método para se obter a quantidade de calorias
	 * do item alimentício com sufixo de unidade.
	 * @return Quantidade de calorias (cal) do item
	 * alimentício.
	 */
	public String getCaloriesPretty() {
		return Utils.formatCalories(getCalories());
	}

	/**
	 * Método para se obter o item alimentício
	 * de referência.
	 * @return Item alimentício de referência.
	 */
	public Food getFood() {
		if(food == null && foodId > 0) {
			FoodDAO dao = new FoodDAO();
			food = dao.searchById(foodId);
		}
		return food;
	}

	/**
	 * Método para se obter o identificador do item
	 * alimentício de referência.
	 * @return Identificador do item alimentício
	 * de referência.
	 */
	public int getFoodId() {
		return foodId;
	}

	/**
	 * Método para se obter o nome do item alimentício
	 * de referência.
	 * @return Nome do item alimentício de referência.
	 */
	public String getFoodName() {
		return getFood().getName();
	}

	/**
	 * Método para se obter informações sobre o objeto
	 * instanciado.
	 * @return Texto contendo os valores dos atributos
	 * desse objeto.
	 */
	public String getInfoPretty() {
		StringBuilder info = new StringBuilder();

		info.append(getFoodName())
			.append(" ")
			.append(getAmountPretty())
			.append(" - ")
			.append(getCaloriesPretty());

		return info.toString();
	}

	/**
	 * Método para se obter a refeição.
	 * @return Refeição associada.
	 */
	public Meal getMeal() {
		if(meal == null && mealId > 0) {
			MealDAO dao = new MealDAO();
			meal = dao.searchById(mealId);
		}
		return meal;
	}

	/**
	 * Método para se obter o identificador da
	 * refeição.
	 * @return Identificador da refeição.
	 */
	public int getMealId() {
		return mealId;
	}

	/**
	 * Método para se alterar a quantidade do item
	 * alimentício (apenas para valores maiores do
	 * que zero).
	 * @param amount Quantidade em gramas do item
	 * alimentício.
	 */
	public void setAmount(double amount) {
		this.amount = amount > 0 ? amount : 0;
	}

	/**
	 * Método para se alterar a quantidade de calorias
	 * do item alimentício (apenas para valores maiores
	 * do que zero).
	 * @param calories Quantidade de calorias do item
	 * alimentício.
	 */
	public void setCalories(double calories) {
		this.calories = calories > 0 ? calories : 0;
	}

	/**
	 * Método para se alterar item alimentício de
	 * referência.
	 * @param food Item alimentício de referência.
	 */
	public void setFood(Food food) {
		this.food = food;
	}

	/**
	 * Método para se alterar item alimentício de
	 * referência.
	 * @param food Item alimentício de referência.
	 */
	public void setFoodId(int foodId) {
		if(foodId > 0)
			this.foodId = foodId;
	}

	/**
	 * Método para se alterar a refeição.
	 * @param meal Refeição.
	 */
	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	/**
	 * Método para se alterar o identificador da
	 * refeição.
	 * @param id Identificador da refeição.
	 */
	public void setMealId(int mealId) {
		if(mealId > 0)
			this.mealId = mealId;
	}
}
