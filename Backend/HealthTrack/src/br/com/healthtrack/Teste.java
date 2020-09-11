package br.com.healthtrack;

import br.com.healthtrack.physicalactivity.PhysicalActivity;
import br.com.healthtrack.physicalactivity.PhysicalActivityByDuration;
import br.com.healthtrack.physicalactivity.PhysicalActivityBySeries;

public class Teste {
	
//	Nesta classe iremos testar as classes que foram criadas para o projeto.
	public static void main(String[] args) {
		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS");
		PhysicalActivity atividadeFisica = new PhysicalActivity(2000, 14, 16, "Corrida");
		System.out.println(atividadeFisica.calculateCalories(2000));
		System.out.println(atividadeFisica.getBeginHour());
		System.out.println(atividadeFisica.getEndHour());
		System.out.println(atividadeFisica.getType());
		
//		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS POR SÉRIE");
//		PhysicalActivityBySeries atividadeSeries = new PhysicalActivityBySeries(2000, 16, 14, "Musculação", 3, 15, 20);
//		System.out.println(atividadeSeries.calculateCalories(2000));
//		System.out.println(atividadeSeries.getBeginHour());
//		System.out.println(atividadeSeries.getEndHour());
//		System.out.println(atividadeSeries.getType());
//		System.out.println(atividadeSeries.getSeries());
//		System.out.println(atividadeSeries.getRepetions());
//		System.out.println(atividadeSeries.getWeight());
//		
//		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS POR DURAÇÃO");
//		PhysicalActivityByDuration atividadePorDuracao = new PhysicalActivityByDuration(2000, 16, 14, "Ciclismo", 5);
//		System.out.println(atividadePorDuracao.calculateCalories(2000));
//		System.out.println(atividadePorDuracao.getBeginHour());
//		System.out.println(atividadePorDuracao.getEndHour());
//		System.out.println(atividadePorDuracao.getType());
//		System.out.println(atividadePorDuracao.CalculateDuration());
//		System.out.println(atividadePorDuracao.getDistance());

		
		
		

	}

}
