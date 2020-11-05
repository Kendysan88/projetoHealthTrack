package br.com.healthtrack.model.bodyinformation.dao;

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
import br.com.healthtrack.model.bodyinformation.Height;

/**
 * Classe responsável por manipular entidades do tipo
 * informações corporais, no banco de dados.
 * @author Afonso de Sousa Costa e Gabriel Souza Piscinato
 * @version 2.0
 */
public class HeightDAO implements DAO<Height>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_HEIGHT";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<Height> list = null;

	/**
	 * Método para se inserir (persistir) uma mediçãs de altura
	 *  no banco de dados.
	 * @param height Objeto altura a ser inserido (persistido)
	 * no banco de dados.
	 */
	@Override
	public void create(Height height) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("HEIGHT_ID, ")
					.append("USER_ID, ")
					.append("UNIT_PREFIX, ")
					.append("VALUE, ")
					.append("DATE_TIME")
					.append(")")
					.append("VALUES (SQ_HT_HEIGHT.NEXTVAL, ?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, height.getUserId());
			stmt.setString(2, height.getUnit());
			stmt.setDouble(3, height.getValue());
			stmt.setTimestamp(4, Timestamp.valueOf(height.getDateTime()));

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
	 * Método para se remover uma medição de altura no
	 * banco de dados.
	 * @param mealId Identificador da medição de altura
	 * no banco de dados.
	 */
	@Override
	public void destroy(int... heightId) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE HEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, heightId[0]);

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
	 * medições de altura persistidas no banco de dados.
	 * @return Lista contendo todas as medições de altura
	 * persistidas no banco de dados.
	 */
	@Override
	public List<Height> getAll() {
		sqlQuery = new StringBuilder();
		list     = new ArrayList<Height>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY DATE_TIME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				Height height;

				int id                 = rs.getInt("HEIGHT_ID");
				int userId             = rs.getInt("USER_ID");
				double value           = rs.getDouble("VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				height = new Height(id, userId, value, dateTime, unit);

				list.add(height);
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
	 * Método para pesquisar uma medição de altura no
	 * banco de dados, a partir de seu identificador.
	 * @param heightId Identificador da medição de altura
	 * no banco de dados.
	 */
	@Override
	public Height searchById(int... heightId) {
		Height height = null;

		sqlQuery = new StringBuilder();
		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE HEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, heightId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id                 = rs.getInt("HEIGHT_ID");
				int userId             = rs.getInt("USER_ID");
				double value           = rs.getDouble("VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				height = new Height(id, userId, value, dateTime, unit);

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

		return height;
	}

	/**
	 * Método para se atualizar uma medição de altura
	 * no banco de dados.
	 * @param height Objeto altura a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(Height height) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("VALUE = ?, ")
					.append("DATE_TIME = ? ")
					.append("WHERE HEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setDouble(1, height.getValue());
			stmt.setTimestamp(2, Timestamp.valueOf(height.getDateTime()));
			stmt.setInt(3, height.getId());

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
