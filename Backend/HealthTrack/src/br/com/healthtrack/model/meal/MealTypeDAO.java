package br.com.healthtrack.model.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.DataBaseManager;

/**
 * Classe responsável por manipular entidades do tipo categorias (tipos) de refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MealTypeDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_MEAL_TYPE";

	/**
	 * Método para se inserir (persistir) um tipo de refeição no banco de dados.
	 * @param type Objeto tipo de refeição a ser inserido (persistido) no banco de dados.
	 */
	public void create(MealType type) {
		boolean descriptionIsPresent = type.getDescription() != null;
		PreparedStatement stmt = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();

			if (descriptionIsPresent) {
				sql = "INSERT INTO " + TABLE_NAME + "(MEAL_TYPE_ID, NAME, DESCRIPTION) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, ?, ?)";
			} else {
				sql = "INSERT INTO " + TABLE_NAME + "(MEAL_TYPE_ID, NAME) VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, ?)";
			}

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, type.getName());

			if (descriptionIsPresent) {
				stmt.setString(2, type.getDescription());
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
	 * Método para se obter uma lista de todos os tipos de refeição persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os tipos de refeição persistidas no banco de dados.
	 */
	public List<MealType> getAll(){
		List<MealType> list = new ArrayList<MealType>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DataBaseManager.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " ORDER BY NAME");
			rs = stmt.executeQuery();

			while(rs.next()) {
				MealType type;

				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");

				if (description != null) {
					type = new MealType(name, description);

				} else {
					type = new MealType(name);
				}

				list.add(type);
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
