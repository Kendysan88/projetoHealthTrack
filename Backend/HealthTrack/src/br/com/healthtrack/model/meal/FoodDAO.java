package br.com.healthtrack.model.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.DataBaseManager;
import br.com.healthtrack.model.measurementunit.MeasurementUnit;

/**
 * Classe responsável por manipular entidades do tipo item alimentício, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class FoodDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_FOOD";

	/**
	 * Método para se inserir (persistir) um item alimentício no banco de dados.
	 * @param food Objeto item alimentício a ser inserido (persistido) no banco de dados.
	 */
	public void create(Food food) {
		boolean descriptionIsPresent = food.getDescription() != null;
		PreparedStatement stmt = null;
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

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food.getUnitPrefix());
			stmt.setDouble(2, food.getAmount());
			stmt.setDouble(3, food.getCalories());
			stmt.setString(4, food.getName());

			if (descriptionIsPresent) {
				stmt.setString(5, food.getDescription());
			}

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
	 * Método para se obter uma lista de todos os itens alimentícios persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os itens alimentícios persistidas no banco de dados.
	 */
	public List<Food> getAll(){
		List<Food> list = new ArrayList<Food>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DataBaseManager.getConnection();
			stmt = conn.prepareStatement("SELECT " +
					"FOOD.AMOUNT AS FOOD_AMOUNT," +
					"FOOD.CALORIES AS FOOD_CALORIES," +
					"FOOD.NAME AS FOOD_NAME," +
					"FOOD.DESCRIPTION AS FOOD_DESCRIPTION," +
					"FOOD.UNIT_PREFIX AS FOOD_UNIT_PREFIX," +
					"UNIT.NAME AS UNIT_PREFIX_NAME FROM " +
					TABLE_NAME + " " +
					"FOOD JOIN T_HT_MEASUREMENT_UNIT UNIT " +
					"ON FOOD.UNIT_PREFIX = UNIT.UNIT_PREFIX " +
					"ORDER BY FOOD.NAME");

			rs = stmt.executeQuery();

			while(rs.next()) {
				double amount      = rs.getDouble("FOOD_AMOUNT");
				double calories    = rs.getDouble("FOOD_CALORIES");
				String name        = rs.getString("FOOD_NAME");
				String description = rs.getString("FOOD_DESCRIPTION");
				String unitPrefix  = rs.getString("FOOD_UNIT_PREFIX");
				String unitName    = rs.getString("UNIT_PREFIX_NAME");

				Food food;
				MeasurementUnit unit = new MeasurementUnit(unitPrefix, unitName);

				if (description != null) {
					food = new Food(amount, calories, name, unit, description);

				} else {
					food = new Food(amount, calories, name, unit);
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