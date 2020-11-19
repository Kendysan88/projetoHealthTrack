package br.com.healthtrack.model.meal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.DAO;
import br.com.healthtrack.model.meal.Meal;

/**
 * Classe responsável por manipular entidades do
 * tipo refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 4.0
 */
public class MealDAO implements DAO<Meal> {
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_MEAL";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<Meal> list = null;

	/**
	 * Método para se inserir (persistir) uma refeição no
	 * banco de dados.
	 * @param meal Objeto refeição a ser inserido (persistido)
	 * no banco de dados.
	 */
	@Override
	public void create(Meal meal) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("MEAL_ID, ")
					.append("USER_ID, ")
					.append("MEAL_TYPE_ID, ")
					.append("DATE_TIME")
					.append(")")
					.append("VALUES (SQ_HT_MEAL.NEXTVAL, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, meal.getUserId());
			stmt.setInt(2, meal.getTypeId());
			stmt.setTimestamp(3, Timestamp.valueOf(meal.getDateTime()));

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
	 * Método para se remover uma refeição no banco de dados.
	 * @param mealId Identificador da refeição no banco de dados.
	 */
	@Override
	public void destroy(int ...mealId) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId[0]);

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
	 * Método para se obter uma lista de todas as
	 * refeições persistidas no banco de dados.
	 * @return Lista contendo todas as refeições
	 * persistidas no banco de dados.
	 */
	public List<Meal> getAll(){
		sqlQuery = new StringBuilder();
		list     = new ArrayList<Meal>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY DATE_TIME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				Meal meal;

				int id                 = rs.getInt("MEAL_ID");
				int typeId             = rs.getInt("MEAL_TYPE_ID");
				int userId             = rs.getInt("USER_ID");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				meal = new Meal(id, typeId, userId, dateTime);

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

	/**
	 * Método para se obter a quantidade total de calorias
	 * de uma refeição.
	 * @return Quantidade total de calorias.
	 */
	public double getTotalCalories(int mealId) {
		double calories = 0.0;

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT ")
					.append("SUM(FOOD_ITEM.CALORIES) AS TOTAL_CALORIES")
					.append(" FROM ")
					.append(TABLE_NAME)
					.append(" MEAL ")
					.append("JOIN T_HT_FOOD_ITEM FOOD_ITEM ")
					.append("ON MEAL.MEAL_ID = FOOD_ITEM.MEAL_ID")
					.append(" WHERE MEAL.MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId);

			rs = stmt.executeQuery();

			while(rs.next()) {
				calories = rs.getDouble("TOTAL_CALORIES");
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

		return calories;
	}

	/**
	 * Método para pesquisar uma refeição no banco de dados,
	 * a partir de seu identificador.
	 * @param mealId Identificador da refeição no banco
	 * de dados.
	 */
	@Override
	public Meal searchById(int ...mealId) {
		Meal meal = null;

		sqlQuery = new StringBuilder();
		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id                 = rs.getInt("MEAL_ID");
				int typeId             = rs.getInt("MEAL_TYPE_ID");
				int userId             = rs.getInt("USER_ID");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				meal = new Meal(id, typeId, userId, dateTime);

			}

		} catch (SQLException e) {
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

		return meal;
	}

	/**
	 * Método para se atualizar uma refeição no banco
	 * de dados.
	 * @param meal Objeto refeição a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(Meal meal) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("MEAL_TYPE_ID = ?, ")
					.append("DATE_TIME = ? ")
					.append("WHERE MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, meal.getTypeId());
			stmt.setTimestamp(2, Timestamp.valueOf(meal.getDateTime()));
			stmt.setInt(3, meal.getId());

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
}

