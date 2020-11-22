package br.com.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.PhysicalActivityBySeries;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.DataBaseManager;

public class PhysicalActivityDAO implements DAOInterface<PhysicalActivityBySeries> {
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_PHYSICAL_ACTIVITY";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private List<PhysicalActivityBySeries> list = null;

	@Override
	public void create(PhysicalActivityBySeries pa) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();
			
				sqlQuery.append("INSERT INTO ")
						.append(TABLE_NAME)
						.append("(")
						.append("PHYSICAL_ACTIVITY_ID, ")
						.append("ACTIVITY_NAME, ")
						.append("DATE_TIME, ")
						.append("START_TIME, ")
						.append("END_TIME")
						.append("CALORIES")
						.append("ACTIVITY_TYPE")
						.append("DISTANCE")
						.append("SERIES")
						.append("REPETITIONS")
						.append("LIFTED_WEIGHT")
						.append(")")
						.append("VALUES (SQ_HT_MEAL.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		    
				System.out.println("Registrando Atividades");

				stmt = conn.prepareStatement(sqlQuery.toString());
				
				stmt.setString(1, pa.getActivityName());
				stmt.setTimestamp(2, Timestamp.valueOf(pa.getDate()));
				stmt.setTimestamp(3, Timestamp.valueOf(pa.getStartTime()));
				stmt.setTimestamp(4, Timestamp.valueOf(pa.getEndTime()));
				stmt.setDouble(5, pa.getCalories());
				stmt.setString(6, pa.getActivityType());
				stmt.setDouble(7, pa.getDistance());
				stmt.setInt(8, pa.getSeries());
				stmt.setInt(9, pa.getRepetitions());
				stmt.setDouble(10, pa.getLiftedWeight());
			
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

	@Override
	public void destroy(int... paId) throws DBException {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("DELETE FROM ")
					.append(TABLE_NAME)
					.append(" WHERE MEAL_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, paId[0]);

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

	@Override
	public List<PhysicalActivityBySeries> getAll() {
		sqlQuery = new StringBuilder();
		list     = new ArrayList<PhysicalActivityBySeries>();
		
		try {
			conn = DataBaseManager.getConnection();
			
			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" ORDER BY ACTIVITY_NAME");
			
			stmt = conn.prepareStatement(sqlQuery.toString());
			
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int physicalActivityId 		= rs.getInt("PHYSICAL_ACTIVITY_ID");
				String activityName 		= rs.getString("ACTIVITY_NAME");
				LocalDateTime date		 	= rs.getTimestamp("DATE_TIME").toLocalDateTime();
				LocalDateTime startTime 	= rs.getTimestamp("START_TIME").toLocalDateTime();
				LocalDateTime endTime 		= rs.getTimestamp("END_TIME").toLocalDateTime();
				double calories 			= rs.getDouble("CALORIES");
				String activityType 		= rs.getString("ACTIVITY_TYPE");
				double distance 			= rs.getDouble("DISTANCE");
				int series 					= rs.getInt("SERIES");
				int repetitions 			= rs.getInt("REPETITIONS");
				double liftedWeight 		= rs.getDouble("LIFTED_WEIGHT");
				
				PhysicalActivityBySeries activity;
				
				//Cria um objeto PhysicalActivityBySeries com as informações encontradas
				activity = new PhysicalActivityBySeries(physicalActivityId, activityName, date, startTime, endTime, calories, activityType, distance, series, repetitions, liftedWeight);
				// Adiciona o Atividade Física na lista
				list.add(activity);				
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

	@Override
	public PhysicalActivityBySeries searchById(int... paId) {
		
		PhysicalActivityBySeries activity = null;

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE FOOD_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, paId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int physicalActivityId 		= rs.getInt("PHYSICAL_ACTIVITY_ID");
				String activityName 		= rs.getString("ACTIVITY_NAME");
				LocalDateTime date		 	= rs.getTimestamp("DATE_TIME").toLocalDateTime();
				LocalDateTime startTime 	= rs.getTimestamp("START_TIME").toLocalDateTime();
				LocalDateTime endTime 		= rs.getTimestamp("END_TIME").toLocalDateTime();
				double calories 			= rs.getDouble("CALORIES");
				String activityType 		= rs.getString("ACTIVITY_TYPE");
				double distance 			= rs.getDouble("DISTANCE");
				int series 					= rs.getInt("SERIES");
				int repetitions 			= rs.getInt("REPETITIONS");
				double liftedWeight 		= rs.getDouble("LIFTED_WEIGHT");
				
				activity = new PhysicalActivityBySeries(physicalActivityId, activityName, date, startTime, endTime, calories, activityType, distance, series, repetitions, liftedWeight);

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

		return activity;
	}

	@Override
	public void update(PhysicalActivityBySeries pa) throws DBException {
		
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("UPDATE ")
					.append(TABLE_NAME)
					.append(" SET ")
					.append("ACTIVITY_NAME = ?, ")
					.append("DATE_TIME = ?, ")
					.append("START_TIME = ?, ")
					.append("END_TIME = ?, ")
					.append("CALORIES = ?, ")
					.append("ACTIVITY_TYPE = ?, ")
					.append("DISTANCE = ?, ")
					.append("SERIES = ?, ")
					.append("REPETITIONS = ?, ")
					.append("LIFTED_WEIGHT = ?, ")
					.append("WHERE PHYSICAL_ACTIVITY_ID, ");


			stmt = conn.prepareStatement(sqlQuery.toString());
			
			stmt.setString(1, pa.getActivityName());
			stmt.setTimestamp(2, Timestamp.valueOf(pa.getDate()));
			stmt.setTimestamp(3, Timestamp.valueOf(pa.getStartTime()));
			stmt.setTimestamp(4, Timestamp.valueOf(pa.getEndTime()));
			stmt.setDouble(5, pa.getCalories());
			stmt.setString(6, pa.getActivityType());
			stmt.setDouble(7, pa.getDistance());
			stmt.setInt(8, pa.getSeries());
			stmt.setInt(9, pa.getRepetitions());
			stmt.setDouble(10, pa.getLiftedWeight());
			stmt.setInt(11, pa.getPhysicalActivityId());

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
