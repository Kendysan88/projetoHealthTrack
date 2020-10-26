package br.com.healthtrack;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodDAO;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.FoodItemDAO;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealDAO;
import br.com.healthtrack.model.meal.MealType;
import br.com.healthtrack.model.meal.MealTypeDAO;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;
import br.com.healthtrack.model.physicalactivity.dao.PhysicalActivityBySeriesDAOImpl;

/**
 * Classe que serve para mostrar os registros que foram criados nas tabelas.
 * @author Todos os membros do grupo
 * @version 2.0
 */
public class TestGetAllDAO {

	public static void main(String[] args) {
		
		System.out.println("Atividades Físicas DAO");

		PhysicalActivityBySeriesDAOImpl dao = new PhysicalActivityBySeriesDAOImpl();
		
		ArrayList<PhysicalActivityBySeries> physicalActivityList = dao.getAll();
		
		for(PhysicalActivityBySeries item : physicalActivityList) {
			System.out.println("Código: " + item.getPhysicalActivityId() + ", Atividade: " + item.getActivityName() + ", Início: " + item.getStartTimePretty() +
					", Fim: " + item.getEndTimePretty() + ", Calorias gastas: " + item.getCaloriesPretty() + ", Tipo de Atividade: " + item.getActivityType() + ", Distância: " + item.getDistancePretty()
					+ ", Num. Séries: " + item.getSeries() + ", Num Repetições " + item.getRepetitions() + ", Peso Levantado: " + item.getLiftedWeightPretty());
		
		}
		
		System.out.println("\n\nTipos de Refeição DAO");
		
		MealTypeDAO mealTypeDAO = new MealTypeDAO();

		for(MealType mealTypeItem : mealTypeDAO.getAll()) {
			System.out.println(mealTypeItem.getInfoPretty());
		}
		
		System.out.println("\n\nAlimentos DAO");

		FoodDAO foodDAO = new FoodDAO();
		
		for(Food foodItem : foodDAO.getAll()) {
			System.out.println(foodItem.getInfoPretty());
		}
		
		
		System.out.println("\n\nRefeições DAO");
		
		MealDAO mealDAO = new MealDAO();
		FoodItemDAO foodItemDAO = new FoodItemDAO();

		for(Meal mealItem : mealDAO.getAll()) {
			for(FoodItem foodItem : foodItemDAO.getAll(mealItem)) {
				mealItem.addFoodItem(foodItem);

				System.out.println(foodItem.getInfoPretty());
			}
			System.out.println(mealItem.getInfoPretty());
		}
		
		
	}

}
