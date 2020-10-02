package br.com.healthtrack.model.physicalactivity;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Classe responsável por manupular entidades do tipo atividades físicas, no banco de dados.
 * @author Richard Kendy
 * @version 1.0
 */
public class PhysicalActivityDAO {

	public PhysicalActivityDAO() {
		
	}

	private ArrayList<PhysicalActivity> activitylist = new ArrayList<PhysicalActivity>() {{
		add(new PhysicalActivity("Pilates", 14, 15, 2000));
		add(new PhysicalActivity("Artes Marciais", 15, 16, 1250));
		add(new PhysicalActivity("Crossfit", 16, 17, 2000));
		add(new PhysicalActivity("Yoga", 12, 13, 1500));
		add(new PhysicalActivityBySeries("Supino", 8, 9, 500, 4, 20, 80));
		add(new PhysicalActivityBySeries("Pulley", 9, 10, 300, 3, 10, 20));
		add(new PhysicalActivityBySeries("Flexões", 10, 11, 350, 3, 30, 0));
		add(new PhysicalActivityByDuration("Natação", 18, 19, 550, 3));
		add(new PhysicalActivityByDuration("Corrida", 19, 20, 545, 6));
		add(new PhysicalActivityByDuration("Caminhada", 19, 22, 2250, 15));
	}};
	
	/**
	 * Método para se obter uma lista de todas as atividades físicas persistidas no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todas as atividades físicas persistidas no banco de dados.
	 */
	public ArrayList<PhysicalActivity> getAll(){
		Collections.sort(activitylist);

		return activitylist;
	}
}
