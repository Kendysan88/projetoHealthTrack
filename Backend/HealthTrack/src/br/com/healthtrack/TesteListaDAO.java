package br.com.healthtrack;

import java.util.ArrayList;

import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;
import br.com.healthtrack.model.physicalactivity.dao.PhysicalActivityBySeriesDAOImpl;

public class TesteListaDAO {

	public static void main(String[] args) {
		
		PhysicalActivityBySeriesDAOImpl dao = new PhysicalActivityBySeriesDAOImpl();
		
		ArrayList<PhysicalActivityBySeries> physicalActivityList = dao.getAll();
		
		for(PhysicalActivityBySeries item : physicalActivityList) {
			System.out.println("Código: " + item.getPhysicalActivityId() + ", Atividade: " + item.getActivityName() + ", Início: " + item.getStartTimePretty() +
					", Fim: " + item.getEndTimePretty() + ", Calorias gastas: " + item.getCaloriesPretty() + ", Tipo de Atividade: " + item.getActivityType() + ", Distância: " + item.getDistancePretty()
					+ ", Num. Séries: " + item.getSeries() + ", Num Repetições " + item.getRepetitions() + ", Peso Levantado: " + item.getLiftedWeightPretty());
		
		}
		
	}

}
