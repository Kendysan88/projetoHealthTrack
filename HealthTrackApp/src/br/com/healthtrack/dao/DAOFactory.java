package br.com.healthtrack.dao;

import br.com.healthtrack.dao.meal.FoodDAO;
import br.com.healthtrack.dao.meal.FoodItemDAO;
import br.com.healthtrack.dao.meal.MealDAO;
import br.com.healthtrack.dao.meal.MealTypeDAO;
import br.com.healthtrack.dao.user.UserDAO;

/**
 * Classe responsável por fornecer instâncias de DAOs.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class DAOFactory {

	public static FoodDAO getFoodDAO() {
		return new FoodDAO();
	}

	public static FoodItemDAO getFoodItemDAO() {
		return new FoodItemDAO();
	}

	public static MealDAO getMealDAO() {
		return new MealDAO();
	}

	public static MealTypeDAO getMealTypeDAO() {
		return new MealTypeDAO();
	}

	public static UserDAO getUserDAO() {
		return new UserDAO();
	}
}
