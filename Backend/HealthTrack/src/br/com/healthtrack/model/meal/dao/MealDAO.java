package br.com.healthtrack.model.meal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealType;

/**
 * Classe responsável por manipular entidades do
 * tipo refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class MealDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_MEAL";

	/**
	 * Método para se inserir (persistir) uma refeição no
	 * banco de dados.
	 * @param meal Objeto refeição a ser inserido (persistido)
	 * no banco de dados.
	 */
	public void create(Meal meal, int userId) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "INSERT INTO " + TABLE_NAME +
					"(MEAL_ID, " +
					"USER_ID, " +
					"MEAL_TYPE_ID, " +
					"DATE_TIME)" +
					"VALUES (SQ_HT_MEAL.NEXTVAL, ?, ?, ?)";

			stmt = conn.prepareStatement(sql, new String[] { "MEAL_ID" });

			java.sql.Timestamp mealDateTime =
					java.sql.Timestamp.valueOf(meal.getDateTime());

			stmt.setInt(1, userId); // TODO Create User DAO
			stmt.setInt(2, meal.getTypeId());
			stmt.setTimestamp(3, mealDateTime);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if(rs.next()){
				int lastId = rs.getInt(1);
				meal.setId(lastId);

				FoodItemDAO foodItemDAO = new FoodItemDAO();

				for(FoodItem foodItem : meal.getFoodItems()) {
					foodItem.setMealId(lastId);
					foodItemDAO.create(foodItem);
				}
			}


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
	 * Método para se obter uma lista de todas as
	 * refeições persistidas no banco de dados.
	 * @return Lista contendo todas as refeições
	 * persistidas no banco de dados.
	 */
	public List<Meal> getAll(){
		List<Meal> list = new ArrayList<Meal>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "SELECT " +
					"MEAL.MEAL_ID AS MEAL_ID, " +
					"MEAL.USER_ID AS MEAL_USER_ID, " +
					"MEAL.DATE_TIME AS MEAL_DATE_TIME, " +
					"MEAL_TYPE.MEAL_TYPE_ID AS MEAL_TYPE_ID, " +
					"MEAL_TYPE.NAME AS MEAL_TYPE_NAME " +
					"FROM " + TABLE_NAME + " " +
					"MEAL JOIN T_HT_MEAL_TYPE MEAL_TYPE " +
					"ON MEAL.MEAL_TYPE_ID = MEAL_TYPE.MEAL_TYPE_ID " +
					"ORDER BY MEAL.DATE_TIME";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int mealId                 = rs.getInt("MEAL_ID");
				int mealTypeId             = rs.getInt("MEAL_TYPE_ID");
//				int mealUserId             = rs.getInt("MEAL_USER_ID");
				String mealTypeName        = rs.getString("MEAL_TYPE_NAME");
				LocalDateTime mealDateTime =
						rs.getTimestamp("MEAL_DATE_TIME").toLocalDateTime();

				MealType mealType = new MealType(mealTypeId, mealTypeName);
				Meal meal = new Meal(mealId, mealDateTime, mealType);

				list.add(meal);
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

