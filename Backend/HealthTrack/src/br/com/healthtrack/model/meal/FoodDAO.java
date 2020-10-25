package br.com.healthtrack.model.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.DataBaseManager;

/**
 * Classe responsável por manipular entidades do tipo item
 * alimentício, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class FoodDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_FOOD";

	/**
	 * Método para se inserir (persistir) um item alimentício
	 * no banco de dados.
	 * @param food Objeto item alimentício a ser inserido
	 * (persistido) no banco de dados.
	 */
	public void create(Food food) {
		boolean descriptionIsPresent = food.getDescription() != null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();

			if (descriptionIsPresent) {
				sql = "INSERT INTO " + TABLE_NAME +
						"(FOOD_ID, " +
						"UNIT_PREFIX, " +
						"AMOUNT, " +
						"CALORIES, " +
						"NAME, " +
						"DESCRIPTION) " +
						"VALUES (SQ_HT_FOOD.NEXTVAL, ?, ?, ?, ?, ?)";
			} else {
				sql = "INSERT INTO " + TABLE_NAME +
						"(FOOD_ID, " +
						"UNIT_PREFIX, " +
						"AMOUNT, " +
						"CALORIES, " +
						"NAME) " +
						"VALUES (SQ_HT_FOOD.NEXTVAL, ?, ?, ?, ?)";
			}

			stmt = conn.prepareStatement(sql, new String[] { "FOOD_ID" });
			stmt.setString(1, food.getUnitPrefix());
			stmt.setDouble(2, food.getAmount());
			stmt.setDouble(3, food.getCalories());
			stmt.setString(4, food.getName());

			if (descriptionIsPresent) {
				stmt.setString(5, food.getDescription());
			}

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if(rs.next()){
				int lastId = rs.getInt(1);
				food.setId(lastId);
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
	 * Método para se obter uma lista de todos os itens
	 * alimentícios persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo
	 * todos os itens alimentícios persistidas no banco
	 * de dados.
	 */
	public List<Food> getAll(){
		List<Food> list = new ArrayList<Food>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY NAME";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()) {
				int id             = rs.getInt("FOOD_ID");
				double amount      = rs.getDouble("AMOUNT");
				double calories    = rs.getDouble("CALORIES");
				String name        = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				String unitPrefix  = rs.getString("UNIT_PREFIX");

				Food food;

				if (description != null) {
					food = new Food(id, amount, calories,
							name, unitPrefix, description);

				} else {
					food = new Food(id, amount, calories,
							name, unitPrefix);
				}

				list.add(food);
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