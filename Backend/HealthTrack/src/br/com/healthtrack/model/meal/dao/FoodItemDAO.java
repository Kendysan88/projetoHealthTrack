package br.com.healthtrack.model.meal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.DAO;
import br.com.healthtrack.model.meal.FoodItem;

/**
 * Classe responsável por manipular entidades do tipo item
 * alimentício de uma refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 3.0
 */
public class FoodItemDAO implements DAO<FoodItem> {
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_FOOD_ITEM";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<FoodItem> list = null;

	/**
	 * Método para se inserir (persistir) um item alimentício
	 * de uma refeição no banco de dados.
	 * @param foodItem Objeto item alimentício de uma refeição
	 * a ser inserido (persistido) no banco de dados.
	 */
	@Override
	public void create(FoodItem foodItem) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("FOOD_ID, ")
					.append("MEAL_ID, ")
					.append("AMOUNT, ")
					.append("CALORIES")
					.append(")")
					.append("VALUES (?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

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
	 * Método para se remover um item alimentício no banco de dados.
	 * @param foodId Identificador do item alimentício no banco de dados.
	 * @param mealId Identificador da refeição no banco de dados.
	 */
	@Override
	public void destroy(int ...associationIds) {
		if(associationIds.length < 2)
			return;

		int mealId = associationIds[0];
		int foodId = associationIds[1];

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE ")
					.append("MEAL_ID = ?")
					.append(" AND ")
					.append("FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId);
			stmt.setInt(2, foodId);

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
	 * @return Lista  contendo todos os itens alimentícios
	 * de refeições persistidas no banco de dados.
	 */
	@Override
	public List<FoodItem> getAll(){
		sqlQuery = new StringBuilder();
		list     = new ArrayList<FoodItem>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME);

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				int foodId      = rs.getInt("FOOD_ID");
				int mealId      = rs.getInt("MEAL_ID");
				double amount   = rs.getDouble("AMOUNT");
				double calories = rs.getDouble("CALORIES");

				FoodItem foodItem = new FoodItem(foodId, mealId,
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

	/**
	 * Método para se obter uma lista de todos os itens
	 * alimentícios de refeições persistidos no banco de dados.
	 * @return Lista  contendo todos os itens alimentícios
	 * de refeições persistidas no banco de dados.
	 */
	public List<FoodItem> getAll(int mealId){
		sqlQuery = new StringBuilder();
		list     = new ArrayList<FoodItem>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE ")
					.append(" MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int foodId      = rs.getInt("FOOD_ID");
				double amount   = rs.getDouble("AMOUNT");
				double calories = rs.getDouble("CALORIES");

				FoodItem foodItem = new FoodItem(foodId, mealId,
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

	/**
	 * Método para pesquisar um item alimentício no banco de dados,
	 * a partir de seu identificador.
	 * @param foodId Identificador do item alimentício no banco de dados.
	 * @param mealId Identificador da refeição no banco de dados.
	 */
	@Override
	public FoodItem searchById(int ...associationIds) {
		FoodItem foodItem = null;

		if(associationIds.length < 2)
			return foodItem;

		int mealId = associationIds[0];
		int foodId = associationIds[1];

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE ")
					.append("MEAL_ID = ?")
					.append(" AND ")
					.append("FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealId);
			stmt.setInt(2, foodId);

			rs = stmt.executeQuery();

			while(rs.next()) {
				double amount   = rs.getDouble("AMOUNT");
				double calories = rs.getDouble("CALORIES");

				foodItem = new FoodItem(foodId, mealId,	amount, calories);

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

		return foodItem;
	}

	/**
	 * Método para se atualizar um item alimentício no banco
	 * de dados.
	 * @param foodItem Objeto item alimentício de uma refeição
	 * a ser atualizado no banco de dados.
	 */
	@Override
	public void update(FoodItem foodItem) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("AMOUNT = ?, ")
					.append("CALORIES = ? ")
					.append(" WHERE ")
					.append("MEAL_ID = ?")
					.append(" AND ")
					.append("FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setDouble(1, foodItem.getAmount());
			stmt.setDouble(2, foodItem.getCalories());
			stmt.setInt(3, foodItem.getMealId());
			stmt.setInt(4, foodItem.getFoodId());

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
