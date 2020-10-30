package br.com.healthtrack.model.meal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.meal.MealType;

/**
 * Classe responsável por manipular entidades do tipo categorias
 * (tipos) de refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class MealTypeDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_MEAL_TYPE";

	/**
	 * Método para se inserir (persistir) um tipo de refeição no
	 * banco de dados.
	 * @param type Objeto tipo de refeição a ser inserido (persistido)
	 * no banco de dados.
	 */
	public void create(MealType type) {
		boolean descriptionIsPresent = type.getDescription() != null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();

			if (descriptionIsPresent) {
				sql = "INSERT INTO " + TABLE_NAME +
						"(MEAL_TYPE_ID, " +
						"NAME, " +
						"DESCRIPTION) " +
						"VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, ?, ?)";
			} else {
				sql = "INSERT INTO " + TABLE_NAME +
						"(MEAL_TYPE_ID, " +
						"NAME) " +
						"VALUES (SQ_HT_MEAL_TYPE.NEXTVAL, ?)";
			}

			stmt = conn.prepareStatement(sql,  new String[] { "MEAL_TYPE_ID" });
			stmt.setString(1, type.getName());

			if (descriptionIsPresent) {
				stmt.setString(2, type.getDescription());
			}

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if(rs.next()){
				int lastId = rs.getInt(1);
				type.setId(lastId);
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
	 * Método para se obter uma lista de todos os tipos de refeição
	 * persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os
	 * tipos de refeição persistidas no banco de dados.
	 */
	public List<MealType> getAll(){
		List<MealType> list = new ArrayList<MealType>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();
			sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY NAME";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()) {
				MealType type;

				int id = rs.getInt("MEAL_TYPE_ID");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");

				if (description != null) {
					type = new MealType(id, name, description);

				} else {
					type = new MealType(id, name);
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
