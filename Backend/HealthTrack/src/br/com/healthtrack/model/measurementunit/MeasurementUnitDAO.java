package br.com.healthtrack.model.measurementunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.DataBaseManager;

/**
 * Classe responsável por manipular entidades do tipo unidade de medida, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MeasurementUnitDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_MEASUREMENT_UNIT";

	/**
	 * Método para se inserir (persistir) uma unidade de medida no banco de dados.
	 * @param unit Objeto unidade de medida a ser inserido (persistido) no banco de dados.
	 */
	public void create(MeasurementUnit unit) {
		boolean descriptionIsPresent = unit.getDescription() != null;
		PreparedStatement stmt = null;
		String sql = null;

		try {
			conn = DataBaseManager.getConnection();

			if (descriptionIsPresent) {
				sql = "INSERT INTO " + TABLE_NAME + "(UNIT_PREFIX, NAME, DESCRIPTION) VALUES (?, ?, ?)";
			} else {
				sql = "INSERT INTO " + TABLE_NAME + "(UNIT_PREFIX, NAME) VALUES (?, ?)";
			}

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, unit.getUnitPrefix());
			stmt.setString(2, unit.getName());

			if (descriptionIsPresent) {
				stmt.setString(3, unit.getDescription());
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
	 * Método para se obter uma lista de todos as unidade de medida persistidas no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos as unidade de medida persistidas no banco de dados.
	 */
	public List<MeasurementUnit> getAll(){
		List<MeasurementUnit> list = new ArrayList<MeasurementUnit>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DataBaseManager.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " ORDER BY UNIT_PREFIX, NAME");
			rs = stmt.executeQuery();

			while(rs.next()) {
				MeasurementUnit unit;

				String unitPrefix = rs.getString("UNIT_PREFIX");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");

				if (description != null) {
					unit = new MeasurementUnit(unitPrefix, name, description);

				} else {
					unit = new MeasurementUnit(unitPrefix, name);
				}

				list.add(unit);
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
