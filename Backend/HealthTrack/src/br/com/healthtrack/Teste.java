package br.com.healthtrack;

import java.time.LocalDateTime;

import br.com.healthtrack.model.bodyinformation.BloodPreassure;
import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.physicalactivity.PhysicalActivity;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityByDuration;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;

/**
 * Classe que serve para testar as classes que foram criadas.
 * @author Todos os membros do grupo
 * @version 1.0
 */
public class Teste {
//	Nesta classe iremos testar as classes que foram criadas para o projeto.
	public static void main(String[] args) {
// TODO: fix it!
//		Food beef  = new Food();
//		beef.setName("Beef");
//		beef.setAmount(100);
//		beef.setCalories(1000);
//		beef.save();
//
//		System.out.println(beef.getName() + ": " + beef.getCaloriesPretty());
//
//		// -------------------------
//
//		Food rice  = new Food();
//
//		rice.setName("Rice");
//		rice.setAmount(100);
//		rice.setCalories(400);
//		rice.save();
//
//		System.out.println(rice.getName() + ": " + rice.getCaloriesPretty());
//
//		// -------------------------
//
//		Food beans = new Food();
//
//		beans.setName("Beans");
//		beans.setAmount(100);
//		beans.setCalories(350);
//		beans.save();
//
//		System.out.println(beans.getName() + ": " + beans.getCaloriesPretty());
//
//		// -------------------------
//
////		Meal lunch = new Meal();
//
////		lunch.setType("LUNCH");
////		lunch.setDateTime(LocalDateTime.now());
//
//		// -------------------------
//
//		FoodItem riceItem = new FoodItem(rice);
//
//		riceItem.setAmount(200);
//
//		System.out.println(riceItem.getFoodName() + ": " + riceItem.getCaloriesPretty());
//
//		// -------------------------
//
//		FoodItem beefItem = new FoodItem(beef);
//
//		beefItem.setAmount(50);
//
//		System.out.println(beefItem.getFoodName() + ": " + beefItem.getCaloriesPretty());
//
//		// -------------------------
//
//		FoodItem beansItem = new FoodItem(beans);
//
//		beansItem.setAmount(180);
//
//		System.out.println(beansItem.getFoodName() + ": " + beansItem.getCaloriesPretty());
//
//		// -------------------------
//
////		lunch.getFoodItems().add(riceItem);
////		lunch.getFoodItems().add(beefItem);
////		lunch.getFoodItems().add(beansItem);
//
////		System.out.println("Total calories: " + lunch.getTotalCaloriesPretty());
		
		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS");
		PhysicalActivity atividadeFisica = new PhysicalActivity(2000, 14, 16, "Corrida");
		System.out.println(atividadeFisica.calculateCalories(2000));
		System.out.println(atividadeFisica.getBeginHour());
		System.out.println(atividadeFisica.getEndHour());
		System.out.println(atividadeFisica.getType());
		
		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS POR SÉRIE");
		PhysicalActivityBySeries atividadeSeries = new PhysicalActivityBySeries(2000, 16, 14, "Musculação", 3, 15, 20);
		System.out.println(atividadeSeries.calculateCalories(2000));
		System.out.println(atividadeSeries.getBeginHour());
		System.out.println(atividadeSeries.getEndHour());
		System.out.println(atividadeSeries.getType());
		System.out.println(atividadeSeries.getSeries());
		System.out.println(atividadeSeries.getRepetions());
		System.out.println(atividadeSeries.getWeight());
		
		System.out.println("MOSTRANDO ATIVIDADES FÍSICAS POR DURAÇÃO");
		PhysicalActivityByDuration atividadePorDuracao = new PhysicalActivityByDuration(2000, 16, 14, "Ciclismo", 5);
		System.out.println(atividadePorDuracao.calculateCalories(2000));
		System.out.println(atividadePorDuracao.getBeginHour());
		System.out.println(atividadePorDuracao.getEndHour());
		System.out.println(atividadePorDuracao.getType());
		System.out.println(atividadePorDuracao.CalculateDuration());
		System.out.println(atividadePorDuracao.getDistance());


	}

}
