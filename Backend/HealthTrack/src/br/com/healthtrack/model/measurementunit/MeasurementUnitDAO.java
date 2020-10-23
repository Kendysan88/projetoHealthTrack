package br.com.healthtrack.model.measurementunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.healthtrack.DataBaseManager;

/**
 * Classe responsável por manipular entidades do tipo unidade de medida, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MeasurementUnitDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_MEASUREMENT_UNIT";

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
}
