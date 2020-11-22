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
import br.com.healthtrack.bean.bodyinformation.BloodPressure;

/**
 * Classe responsável por manipular entidades do tipo
 * informações corporais, no banco de dados.
 * @author Gabriel Souza Piscinato
 * @version 1.0
 */
public class BloodPressureDAO implements DAOInterface<BloodPressure>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_BLOOD_PREASSURE";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<BloodPressure> list = null;

	/**
	 * Método para se inserir (persistir) uma mediçãs de pressao arterial
	 *  no banco de dados.
	 * @param blood_preassure Objeto pressao arterial a ser inserido (persistido)
	 * no banco de dados.
	 */
	@Override
	public void create(BloodPressure bloodPreassure) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("BLOOD_PREASSURE_ID, ")
					.append("USER_ID, ")
					.append("UNIT_PREFIX, ")
                    .append("DIASTOLIC_VALUE, ")
                    .append("SYSTOLIC_VALUE, ")
					.append("DATE_TIME")
					.append(")")
					.append("VALUES (SQ_HT_BLOOD_PREASSURE.NEXTVAL, ?, ?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, bloodPreassure.getUserId());
			stmt.setString(2, bloodPreassure.getUnit());
            stmt.setDouble(3, bloodPreassure.getDiastolicValue());
            stmt.setDouble(4, bloodPreassure.getSystolicValue());
			stmt.setTimestamp(5, Timestamp.valueOf(bloodPreassure.getDateTime()));

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
	 * Método para se remover uma medição de pressao arterial no
	 * banco de dados.
	 * @param bloodPreassureId Identificador da medição de pressao arterial
	 * no banco de dados.
	 */
	@Override
	public void destroy(int... bloodPreassureId) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE BLOOD_PREASSURE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, bloodPreassureId[0]);

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
	 * medições de pressao arterial persistidas no banco de dados.
	 * @return Lista contendo todas as medições de pressao arterial
	 * persistidas no banco de dados.
	 */
	@Override
	public List<BloodPressure>getAll() {
		sqlQuery = new StringBuilder();
		list     = new ArrayList<BloodPressure>();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY DATE_TIME");

			stmt = conn.prepareStatement(sqlQuery.toString());

			rs = stmt.executeQuery();

			while(rs.next()) {
				BloodPressure bloodPreassure;

				int id                 = rs.getInt("BLOOD_PREASSURE_ID");
                int userId             = rs.getInt("USER_ID");
                int diastolicValue     = rs.getInt("DIASTOLIC_VALUE");
                int systolicValue      = rs.getInt("SYSTOLIC_VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				bloodPreassure = new BloodPressure(id, userId, diastolicValue, systolicValue, dateTime, unit);

				list.add(bloodPreassure);
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
	 * Método para pesquisar uma medição de pressao arterial no
	 * banco de dados, a partir de seu identificador.
	 * @param bloodPreassureId Identificador da medição de pressao arterial
	 * no banco de dados.
	 */
	@Override
	public BloodPressure searchById(int... bloodPreassureId) {
		BloodPressure bloodPreassure = null;

		sqlQuery = new StringBuilder();
		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE BLOOD_PREASSURE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, bloodPreassureId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id                 = rs.getInt("HEIGHT_ID");
				int userId             = rs.getInt("USER_ID");
                int diastolicValue     = rs.getInt("DIASTOLIC_VALUE");
                int systolicValue      = rs.getInt("SYSTOLIC_VALUE");
				String unit            = rs.getString("UNIT_PREFIX");
				LocalDateTime dateTime = rs.getTimestamp("DATE_TIME")
						.toLocalDateTime();

				bloodPreassure = new BloodPressure(id, userId, diastolicValue, systolicValue, dateTime, unit);

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

		return bloodPreassure;
	}

	/**
	 * Método para se atualizar uma medição de pressao arterial
	 * no banco de dados.
	 * @param bloodPreassure Objeto altura a ser atualizado
	 * no banco de dados.
	 */
	@Override
	public void update(BloodPressure bloodPreassure) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
                    .append("DIASTOLIC_VALUE = ?, ")
                    .append("SYSTOLIC_VALUE = ?, ")
					.append("DATE_TIME = ? ")
					.append("WHERE BLOOD_PREASSURE_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

            stmt.setDouble(1, bloodPreassure.getDiastolicValue());
            stmt.setDouble(2, bloodPreassure.getSystolicValue());
			stmt.setTimestamp(3, Timestamp.valueOf(bloodPreassure.getDateTime()));
			stmt.setInt(4, bloodPreassure.getId());

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
