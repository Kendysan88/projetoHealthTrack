package br.com.healthtrack.dao.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.singleton.DataBaseManager;
import br.com.healthtrack.bean.meal.Food;
import br.com.healthtrack.dao.DAOInterface;
import br.com.healthtrack.exception.DBException;

/**
 * Classe responsável por manipular entidades do tipo item
 * alimentício, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 3.0
 */
public class FoodDAO implements DAOInterface<Food>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_FOOD";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<Food> list = null;

	/**
	 * Método para se inserir (persistir) um item alimentício
	 * no banco de dados.
	 * @param food Objeto item alimentício a ser inserido
	 * (persistido) no banco de dados.
	 */
	@Override
	public void create(Food food) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("FOOD_ID, ")
					.append("UNIT_PREFIX, ")
					.append("AMOUNT, ")
					.append("CALORIES, ")
					.append("NAME, ")
					.append("DESCRIPTION")
					.append(")")
					.append("VALUES (")
					.append("SQ_HT_FOOD.NEXTVAL, ?, ?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setString(1, food.getUnitPrefix());
			stmt.setDouble(2, food.getAmount());
			stmt.setDouble(3, food.getCalories());
			stmt.setString(4, food.getName());
			stmt.setString(5, food.getDescription());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");

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
	 * Método para se remover um item alimentício no banco
	 * de dados.
	 * @param foodId Identificador do item alimentício no
	 * banco de dados.
	 */
	@Override
	public void destroy(int ...foodId) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, foodId[0]);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");

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
	 * todos os itens alimentícios persistidos no banco
	 * de dados.
	 */
	@Override
	public List<Food> getAll() {
		sqlQuery = new StringBuilder();
		list     = new ArrayList<Food>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY NAME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id             = rs.getInt("FOOD_ID");
				double amount      = rs.getDouble("AMOUNT");
				double calories    = rs.getDouble("CALORIES");
				String name        = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				String unitPrefix  = rs.getString("UNIT_PREFIX");

				Food food;

				food = new Food(id, amount, calories,
						name, unitPrefix, description);

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

	/**
	 * Método para pesquisar um item alimentício no banco de dados,
	 * a partir de seu identificador.
	 * @param foodId Identificador do item alimentício no banco
	 * de dados.
	 */
	@Override
	public Food searchById(int ...foodId) {
		Food food = null;

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, foodId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id             = rs.getInt("FOOD_ID");
				double amount      = rs.getDouble("AMOUNT");
				double calories    = rs.getDouble("CALORIES");
				String name        = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				String unitPrefix  = rs.getString("UNIT_PREFIX");

				food = new Food(id, amount, calories,
						name, unitPrefix, description);
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

		return food;
	}

	/**
	 * Método para se atualizar um item alimentício no banco
	 * de dados.
	 * @param food Objeto item alimentício a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(Food food)  throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("UNIT_PREFIX = ?, ")
					.append("AMOUNT = ?, ")
					.append("CALORIES = ?, ")
					.append("NAME = ?, ")
					.append("DESCRIPTION = ? ")
					.append("WHERE FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setString(1, food.getUnitPrefix());
			stmt.setDouble(2, food.getAmount());
			stmt.setDouble(3, food.getCalories());
			stmt.setString(4, food.getName());
			stmt.setString(5, food.getDescription());
			stmt.setInt(6, food.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");

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
