package br.com.healthtrack;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealType;
import br.com.healthtrack.model.physicalactivity.PhysicalActivity;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityByDuration;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;

/**
 * Classe que serve para testar as classes que foram criadas.
 * @author Todos os membros do grupo
 * @version 2.0
 */
public class Teste {
	public static void main(String[] args) {

		System.out.println("Alimentos");

		Food beef  = new Food(100, 1000, "Bife");
		System.out.println(beef.getInfoPretty());

		Food rice  = new Food(100, 400, "Arroz");
		System.out.println(rice.getInfoPretty());

		Food beans = new Food(100, 350, "Feijão");
		System.out.println(beans.getInfoPretty());

		// -------------------------

		System.out.println("\nItems Alimentícios");

		FoodItem riceItem = new FoodItem(rice, 200);
		System.out.println(riceItem.getInfoPretty());

		FoodItem beefItem = new FoodItem(beef, 50);
		System.out.println(beefItem.getInfoPretty());

		FoodItem beansItem = new FoodItem(beans, 180);
		System.out.println(beansItem.getInfoPretty());
		
		// -------------------------

		System.out.println("\nRefeição");

		MealType lunchType = new MealType("Almoço");
		Meal lunch = new Meal(LocalDateTime.now(), lunchType, new ArrayList<FoodItem>() {{
			add(riceItem);
			add(beefItem);
			add(beansItem);
		}}
		);

		System.out.println(lunch.getInfoPretty());

		System.out.println("\n\n\n");

		// -------------------------

		System.out.println("MOSTRANDO ATIVIDADES F�SICAS");
		PhysicalActivity atividadeFisica = new PhysicalActivity(2000, 14, 16, "Corrida");
		System.out.println(atividadeFisica.calculateCalories(2000));
		System.out.println(atividadeFisica.getBeginHour());
		System.out.println(atividadeFisica.getEndHour());
		System.out.println(atividadeFisica.getType());
		
		System.out.println("MOSTRANDO ATIVIDADES F�SICAS POR S�RIE");
		PhysicalActivityBySeries atividadeSeries = new PhysicalActivityBySeries(2000, 16, 14, "Muscula��o", 3, 15, 20);
		System.out.println(atividadeSeries.calculateCalories(2000));
		System.out.println(atividadeSeries.getBeginHour());
		System.out.println(atividadeSeries.getEndHour());
		System.out.println(atividadeSeries.getType());
		System.out.println(atividadeSeries.getSeries());
		System.out.println(atividadeSeries.getRepetions());
		System.out.println(atividadeSeries.getWeight());
		
		System.out.println("MOSTRANDO ATIVIDADES F�SICAS POR DURA��O");
		PhysicalActivityByDuration atividadePorDuracao = new PhysicalActivityByDuration(2000, 16, 14, "Ciclismo", 5);
		System.out.println(atividadePorDuracao.calculateCalories(2000));
		System.out.println(atividadePorDuracao.getBeginHour());
		System.out.println(atividadePorDuracao.getEndHour());
		System.out.println(atividadePorDuracao.getType());
		System.out.println(atividadePorDuracao.CalculateDuration());
		System.out.println(atividadePorDuracao.getDistance());
	}

}
