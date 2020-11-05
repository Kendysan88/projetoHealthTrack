package br.com.healthtrack.model.physicalactivity.dao;

import java.util.ArrayList;

import br.com.healthtrack.database.DataBaseManager;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Classe responsável por manupular entidades do tipo atividades físicas, no
 * banco de dados.
 * 
 * @author Richard Kendy
 * @version 2.0
 */
public class PhysicalActivityBySeriesDAOImpl implements PhysicalActivityBySeriesDAO {
	private Connection conn;
	private static String TABLE_NAME = "T_HT_PHYSICAL_ACTIVITY";	

	public PhysicalActivityBySeriesDAOImpl() {

	}
	
	/**
	 * Método para se inserir (persistir) uma atividade física no banco de dados.
	 * @param pa Objeto atividade física a ser inserido (persistido) no banco de dados.
	 */
	@Override
	public void create(PhysicalActivityBySeries pa) {
		PreparedStatement stmt = null;
		String sql = null;
		try {
			conn = DataBaseManager.getConnection();
			
            if(pa.getActivityType() == "Duração") {
                sql = "INSERT INTO " + TABLE_NAME + "(PHYSICAL_ACTIVITY_ID, ACTIVITY_NAME, START_TIME, END_TIME, CALORIES, ACTIVITY_TYPE, DISTANCE) VALUES (SQ_HT_PHYSICAL_ACTIVITY.nextval, ?, ?, ?, ?, ?, ?)";
                System.out.println("Registrando Atividade por Duração");
                //System.out.println(pa.getActivityType());                   
            }else if(pa.getActivityType() == "Série"){
                sql = "INSERT INTO " + TABLE_NAME + "(PHYSICAL_ACTIVITY_ID, ACTIVITY_NAME, START_TIME, END_TIME, CALORIES, ACTIVITY_TYPE, SERIES, REPETITIONS, LIFTED_WEIGHT) VALUES (SQ_HT_PHYSICAL_ACTIVITY.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
                System.out.println("Registrando Atividade por Série");
                //System.out.println(pa.getActivityType());                   
            }else{
                sql = "INSERT INTO " + TABLE_NAME + "(PHYSICAL_ACTIVITY_ID, ACTIVITY_NAME, START_TIME, END_TIME, CALORIES, ACTIVITY_TYPE) VALUES (SQ_HT_PHYSICAL_ACTIVITY.nextval, ?, ?, ?, ?, ?)";
                System.out.println("Registrando Atividade");
                //System.out.println(pa.getActivityType());                    
            }
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, pa.getActivityName());
				stmt.setTimestamp(2, Timestamp.valueOf(pa.getStartTime()));
				stmt.setTimestamp(3, Timestamp.valueOf(pa.getEndTime()));
				stmt.setDouble(4, pa.getCalories());
				stmt.setString(5, pa.getActivityType());
				
			if(pa.getActivityType() == "Duração") {
				stmt.setDouble(6, pa.getDistance());
			}
			
			if(pa.getActivityType() == "Série") {
				stmt.setInt(6, pa.getSeries());
				stmt.setInt(7, pa.getRepetitions());
				stmt.setDouble(8, pa.getLiftedWeight());
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
	 * Método para se obter uma lista de todos as atividades físicas persistidas no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os itens alimentícios persistidas no banco
	 * de dados.
	 */
	@Override
	public ArrayList<PhysicalActivityBySeries> getAll() {
		// Cria uma lista de atividades
		ArrayList<PhysicalActivityBySeries> activitylist = new ArrayList<PhysicalActivityBySeries>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataBaseManager.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " ORDER BY ACTIVITY_NAME");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int physicalActivityId = rs.getInt("PHYSICAL_ACTIVITY_ID");
				String activityName = rs.getString("ACTIVITY_NAME");
				LocalDateTime startTime = rs.getTimestamp("START_TIME").toLocalDateTime();
				LocalDateTime endTime = rs.getTimestamp("END_TIME").toLocalDateTime();
				double calories = rs.getDouble("CALORIES");
				String activityType = rs.getString("ACTIVITY_TYPE");
				double distance = rs.getDouble("DISTANCE");
				int series = rs.getInt("SERIES");
				int repetitions = rs.getInt("REPETITIONS");
				double liftedWeight = rs.getDouble("LIFTED_WEIGHT");
				

				//Cria um objeto PhysicalActivityBySeries com as informações encontradas
				PhysicalActivityBySeries activity = new PhysicalActivityBySeries(physicalActivityId, activityName, startTime, endTime, calories, activityType, distance, series, repetitions, liftedWeight);
				// Adiciona o Atividade Física na lista
				activitylist.add(activity);				
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
		return activitylist;
	}
	
	@Override
	public PhysicalActivityBySeries searchById(int physicalActivityId) {
		// TODO Auto-generated method stub
		return null;
	}
		
	/**
	 * Método para alterar as informações das atividades físicas no banco de dados.
	 * @param pa objeto atividade física a ser atualizada (persistido) no banco de dados.
	 */	
	@Override
	public void update(PhysicalActivityBySeries pa) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Método para remover as atividades físicas no banco de dados.
	 * @param physicalActivityId instância do objeto PhysicalActivity 
	 */
	@Override
	public void destroy(int physicalActivityId) {
		// TODO Auto-generated method stub

	}	

}
