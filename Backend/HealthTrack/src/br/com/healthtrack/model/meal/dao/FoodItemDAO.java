package br.com.healthtrack.model.meal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.Meal;

/**
 * Classe responsável por manipular entidades do tipo item
 * alimentício de uma refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class FoodItemDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_FOOD_ITEM";

	/**
	 * Método para se inserir (persistir) um item alimentício
	 * de uma refeição no banco de dados.
	 * @param foodItem Objeto item alimentício de uma refeição
	 * a ser inserido (persistido) no banco de dados.
	 */
	public void create(FoodItem foodItem) {
		PreparedStatement stmt = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "INSERT INTO " + TABLE_NAME +
					"(FOOD_ID, " +
					"MEAL_ID, " +
					"AMOUNT, " +
					"CALORIES)" +
					"VALUES (?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, foodItem.getFoodId());
			stmt.setInt(2, foodItem.getMealId());
			stmt.setDouble(3, foodItem.getAmount());
			stmt.setDouble(4, foodItem.getCalories());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método para se obter uma lista de todos os itens
	 * alimentícios de refeições persistidos no banco de dados.
	 * @param meal Refeição de referência.
	 * @return Lista  contendo todos os itens alimentícios
	 * de refeições persistidas no banco de dados.
	 */
	public List<FoodItem> getAll(Meal meal){
		List<FoodItem> list = new ArrayList<FoodItem>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "SELECT " +
					"FOOD_ITEM.AMOUNT AS FOOD_ITEM_AMOUNT," +
					"FOOD_ITEM.CALORIES AS FOOD_ITEM_CALORIES," +
					"FOOD.FOOD_ID AS FOOD_ID," +
					"FOOD.AMOUNT AS FOOD_AMOUNT," +
					"FOOD.CALORIES AS FOOD_CALORIES," +
					"FOOD.NAME AS FOOD_NAME," +
					"FOOD.UNIT_PREFIX AS FOOD_UNIT_PREFIX " +
					"FROM " + TABLE_NAME + " " +
					"FOOD_ITEM JOIN T_HT_FOOD FOOD " +
					"ON FOOD_ITEM.FOOD_ID = FOOD.FOOD_ID " +
					"WHERE FOOD_ITEM.MEAL_ID = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, meal.getId());

			rs = stmt.executeQuery();

			while(rs.next()) {
				int foodId          = rs.getInt("FOOD_ID");
				double foodAmount   = rs.getDouble("FOOD_AMOUNT");
				double foodCalories = rs.getDouble("FOOD_CALORIES");
				String foodName     = rs.getString("FOOD_NAME");
				String unitPrefix   = rs.getString("FOOD_UNIT_PREFIX");
				double amount       = rs.getDouble("FOOD_ITEM_AMOUNT");
				double calories     = rs.getDouble("FOOD_ITEM_CALORIES");

				Food food = new Food(foodId, foodAmount, foodCalories,
						foodName, unitPrefix);

				FoodItem foodItem = new FoodItem(meal.getId(), food,
						amount, calories);

				list.add(foodItem);
			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				rs.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
