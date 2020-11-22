package br.com.healthtrack.teste;

import java.util.List;

import br.com.healthtrack.bean.PhysicalActivityBySeries;
import br.com.healthtrack.dao.PhysicalActivityDAO;

public class ListDAOTest {

	public static void main(String[] args) {
		
		PhysicalActivityDAO dao = new PhysicalActivityDAO();
		
		List<PhysicalActivityBySeries> physicalActivityList = dao.getAll();
		
		for(PhysicalActivityBySeries item : physicalActivityList) {
			System.out.println("Código: " + item.getPhysicalActivityId() + ", Atividade: " + item.getActivityName() + ", Data: " + item.getDate() +
					", Duração: " + item.getDuration() + ", Calorias gastas: " + item.getCaloriesPretty() + ", Tipo de Atividade: " + item.getActivityType() + ", Distância: " + item.getDistancePretty()
					+ ", Num. Séries: " + item.getSeries() + ", Num Repetições " + item.getRepetitions() + ", Peso Levantado: " + item.getLiftedWeightPretty());
		
		}

	}

}
