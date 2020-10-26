package br.com.healthtrack;

import java.time.LocalDateTime;

import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;
import br.com.healthtrack.model.physicalactivity.dao.PhysicalActivityBySeriesDAOImpl;

public class TesteCadastroDAO {

	public static void main(String[] args) {
		
		//Instancia DAO
		PhysicalActivityBySeriesDAOImpl dao = new PhysicalActivityBySeriesDAOImpl();

		
		//Instancia a 1ª Atividade Física 
		PhysicalActivityBySeries physicalActivity = new PhysicalActivityBySeries();
		physicalActivity.setActivityName("Yoga");
		physicalActivity.setStartTime(LocalDateTime.parse("2020-04-26T10:32:56.300"));
		physicalActivity.setEndTime(LocalDateTime.parse("2020-04-26T12:05:56.300"));
		physicalActivity.setCalories(1500);
		physicalActivity.setActivityType(null);
		
		//Cadastra no banco de dados
		//dao.create(physicalActivity);

		
		//Instancia a 2ª Atividade Física 
		PhysicalActivityBySeries physicalActivity2 = new PhysicalActivityBySeries();
		physicalActivity2.setActivityName("Artes Marciais");
		physicalActivity2.setStartTime(LocalDateTime.parse("2020-05-20T09:05:02.300"));
		physicalActivity2.setEndTime(LocalDateTime.parse("2020-05-20T10:06:45.300"));
		physicalActivity2.setCalories(950);
		physicalActivity2.setActivityType(null);
		
		//Cadastra no banco de dados
	    dao.create(physicalActivity2);

		
		//Instancia a 3ª Atividade Física Por Duração 
	    PhysicalActivityBySeries physicalActivity3 = new PhysicalActivityBySeries();
		physicalActivity3.setActivityName("Corrida");
		physicalActivity3.setStartTime(LocalDateTime.parse("2020-06-03T20:00:02.300"));
		physicalActivity3.setEndTime(LocalDateTime.parse("2020-06-03T20:45:54.300"));
		physicalActivity3.setCalories(545);
		physicalActivity3.setActivityType("Duração");
		physicalActivity3.setDistance(5.5);	
		
		//Cadastra no banco de dados
		//dao.create(physicalActivity3);

		
		//Instancia a 4ª Atividade Física Por Duração
		PhysicalActivityBySeries physicalActivity4 = new PhysicalActivityBySeries();
		physicalActivity4.setActivityName("Natação");
		physicalActivity4.setStartTime(LocalDateTime.parse("2020-05-14T12:32:56.300"));
		physicalActivity4.setEndTime(LocalDateTime.parse("2020-05-14T13:32:05.300"));
		physicalActivity4.setCalories(368);
		physicalActivity4.setActivityType("Duração");
		physicalActivity4.setDistance(3);	
		
		//Cadastra no banco de dados
		dao.create(physicalActivity4);

		
		//Instancia a 5ª Atividade Física Por Série
		PhysicalActivityBySeries physicalActivity5 = new PhysicalActivityBySeries();
		physicalActivity5.setActivityName("Supino");
		physicalActivity5.setStartTime(LocalDateTime.parse("2020-03-15T14:00:56.300"));
		physicalActivity5.setEndTime(LocalDateTime.parse("2020-03-15T14:15:00.300"));
		physicalActivity5.setCalories(200);
		physicalActivity5.setActivityType("Série");
		physicalActivity5.setSeries(4);
		physicalActivity5.setRepetitions(20);
		physicalActivity5.setLiftedWeight(55);	
		
		//Cadastra no banco de dados
		//dao.create(physicalActivity5);
		
		//Instancia a 6ª Atividade Física Por Série
		PhysicalActivityBySeries physicalActivity6 = new PhysicalActivityBySeries();
		physicalActivity6.setActivityName("Flexões");
		physicalActivity6.setStartTime(LocalDateTime.parse("2020-02-11T11:45:00.300"));
		physicalActivity6.setEndTime(LocalDateTime.parse("2020-02-11T12:00:15.300"));
		physicalActivity6.setCalories(100);
		physicalActivity6.setActivityType("Série");
		physicalActivity6.setSeries(5);
		physicalActivity6.setRepetitions(20);
		physicalActivity6.setLiftedWeight(0);

		//Cadastra no banco de dados
		dao.create(physicalActivity6);		
	    System.out.println("Cadastrado!");
	    
	}

}
