package br.com.healthtrack.dao.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.singleton.DataBaseManager;
import br.com.healthtrack.bean.meal.MealType;
import br.com.healthtrack.dao.DAOInterface;

/**
 * Classe responsável por manipular entidades do tipo categorias
 * (tipos) de refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 3.0
 */
public class MealTypeDAO implements DAOInterface<MealType>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_MEAL_TYPE";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<MealType> list = null;

	/**
	 * Método para se inserir (persistir) um tipo de refeição no
	 * banco de dados.
	 * @param mealType Objeto tipo de refeição a ser inserido
	 * (persistido) no banco de dados.
	 */
	@Override
	public void create(MealType mealType) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("MEAL_TYPE_ID, ")
					.append("NAME, ")
					.append("DESCRIPTION")
					.append(")")
					.append("VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setString(1, mealType.getName());
			stmt.setString(2, mealType.getDescription());

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
	 * Método para se remover um tipo de refeição no banco de dados.
	 * @param mealTypeId Identificador do tipo de refeição no banco
	 * de dados.
	 */
	@Override
	public void destroy(int ...mealTypeId) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE MEAL_TYPE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealTypeId[0]);

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
	 * Método para se obter uma lista de todos os tipos de refeição
	 * persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os
	 * tipos de refeição persistidos no banco de dados.
	 */
	public List<MealType> getAll(){
		sqlQuery = new StringBuilder();
		list     = new ArrayList<MealType>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY NAME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				MealType type;

				int id             = rs.getInt("MEAL_TYPE_ID");
				String name        = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");

				type = new MealType(id, name, description);

				list.add(type);
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

		return list;
	}

	/**
	 * Método para pesquisar um tipo de refeição no banco de dados,
	 * a partir de seu identificador.
	 * @param mealTypeId Identificador do tipo de refeição no banco
	 * de dados.
	 */
	@Override
	public MealType searchById(int ...mealTypeId) {
		MealType type = null;

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE MEAL_TYPE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, mealTypeId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id             = rs.getInt("MEAL_TYPE_ID");
				String name        = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");

				type = new MealType(id, name, description);

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

		return type;
	}

	/**
	 * Método para se atualizar um tipo de refeição no banco
	 * de dados.
	 * @param mealType Objeto tipo de refeição a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(MealType mealType) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("NAME = ?, ")
					.append("DESCRIPTION = ? ")
					.append("WHERE MEAL_TYPE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setString(1, mealType.getName());
			stmt.setString(2, mealType.getDescription());
			stmt.setInt(3, mealType.getId());

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
