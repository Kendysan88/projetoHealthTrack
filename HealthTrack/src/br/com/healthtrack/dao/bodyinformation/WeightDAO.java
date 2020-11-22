package br.com.healthtrack.dao.bodyinformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.singleton.DataBaseManager;
import br.com.healthtrack.dao.DAOInterface;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.bean.bodyinformation.Weight;

/**
 * Classe responsável por manipular entidades do tipo
 * informações corporais, no banco de dados.
 * @author Gabriel Souza Piscinato
 * @version 1.0
 */
public class WeightDAO implements DAOInterface<Weight>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_WEIGHT";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<Weight> list = null;

	/**
	 * Método para se inserir (persistir) uma mediçãs de peso
	 *  no banco de dados.
	 * @param weight Objeto peso a ser inserido (persistido)
	 * no banco de dados.
	 */
	@Override
	public void create(Weight weight) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("WEIGHT_ID, ")
					.append("USER_ID, ")
					.append("UNIT_PREFIX, ")
					.append("VALUE, ")
					.append("DATE_TIME")
					.append(")")
					.append("VALUES (SQ_HT_WEIGHT.NEXTVAL, ?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, weight.getUserId());
			stmt.setString(2, weight.getUnit());
			stmt.setDouble(3, weight.getValue());
			stmt.setTimestamp(4, Timestamp.valueOf(weight.getDateTime()));

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
	 * Método para se remover uma medição de peso no
	 * banco de dados.
	 * @param weightId Identificador da medição de peso
	 * no banco de dados.
	 */
	@Override
	public void destroy(int... weightId) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE WEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, weightId[0]);

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
	 * Método para se obter uma lista de todas as
	 * medições de peso persistidas no banco de dados.
	 * @return Lista contendo todas as medições de peso
	 * persistidas no banco de dados.
	 */
	@Override
	public List<Weight> getAll() {
		sqlQuery = new StringBuilder();
		list     = new ArrayList<Weight>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY DATE_TIME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				Weight weight;

				int id                 = rs.getInt("WEIGHT_ID");
				int userId             = rs.getInt("USER_ID");
				double value           = rs.getDouble("VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				weight = new Weight(id, userId, value, dateTime, unit);

				list.add(weight);
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
	 * Método para pesquisar uma medição de peso no
	 * banco de dados, a partir de seu identificador.
	 * @param weightId Identificador da medição de peso
	 * no banco de dados.
	 */
	@Override
	public Weight searchById(int... weightId) {
		Weight weight = null;

		sqlQuery = new StringBuilder();
		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE WEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, weightId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id                 = rs.getInt("WEIGHT_ID");
				int userId             = rs.getInt("USER_ID");
				double value           = rs.getDouble("VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				weight = new Weight(id, userId, value, dateTime, unit);

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

		return weight;
	}

	/**
	 * Método para se atualizar uma medição de peso
	 * no banco de dados.
	 * @param weight Objeto peso a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(Weight weight) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("VALUE = ?, ")
					.append("DATE_TIME = ? ")
					.append("WHERE WEIGHT_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setDouble(1, weight.getValue());
			stmt.setTimestamp(2, Timestamp.valueOf(weight.getDateTime()));
			stmt.setInt(3, weight.getId());

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
