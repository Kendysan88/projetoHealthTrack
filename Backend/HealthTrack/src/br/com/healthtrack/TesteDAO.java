package br.com.healthtrack;

import br.com.healthtrack.model.bodyinformation.BodyInformation;
import br.com.healthtrack.model.bodyinformation.BodyInformationDAO;
import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodDAO;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealDAO;
import br.com.healthtrack.model.meal.MealType;
import br.com.healthtrack.model.meal.MealTypeDAO;
import br.com.healthtrack.model.measurementunit.MeasurementUnit;
import br.com.healthtrack.model.measurementunit.MeasurementUnitDAO;
import br.com.healthtrack.model.physicalactivity.PhysicalActivity;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityDAO;

/**
 * Classe que serve para testar as classes DAO que foram criadas.
 * @author Todos os membros do grupo
 * @version 2.0
 */
public class TesteDAO {

	public static void main(String[] args) {
		System.out.println("Unidade de Medida DAO");

		MeasurementUnitDAO unitDAO = new MeasurementUnitDAO();

		MeasurementUnit unit1 = new MeasurementUnit("kg", "quilogramas");
		unitDAO.create(unit1);

		MeasurementUnit unit2 = new MeasurementUnit("m", "metros", "Usada nas medições de altura");
		unitDAO.create(unit2);

		MeasurementUnit unit3 = new MeasurementUnit("cal", "calorias", "Utilizada nas medições de atividade físicas");
		unitDAO.create(unit3);

		MeasurementUnit unit4 = new MeasurementUnit("g", "gramas");
		unitDAO.create(unit4);

		MeasurementUnit unit5 = new MeasurementUnit("ml", "mililitros");
		unitDAO.create(unit5);

		for(MeasurementUnit unitItem : unitDAO.getAll()) {
			System.out.println(unitItem.getInfoPretty());
		}

		System.out.println("\n\nTipos de Refeição DAO");

		MealTypeDAO mealTypeDAO = new MealTypeDAO();

		MealType mealType1 = new MealType("café da manhã");
		mealTypeDAO.create(mealType1);

		MealType mealType2 = new MealType("almoço");
		mealTypeDAO.create(mealType2);

		MealType mealType3 = new MealType("jantar");
		mealTypeDAO.create(mealType3);

		MealType mealType4 = new MealType("lanche");
		mealTypeDAO.create(mealType4);

		for(MealType mealTypeItem : mealTypeDAO.getAll()) {
			System.out.println(mealTypeItem.getInfoPretty());
		}

		System.out.println("\n\nAlimentos DAO");

		FoodDAO foodDAO = new FoodDAO();

		Food food1 = new Food(30, 198, "Bacon frito", unit4, "2 cubos.");
		foodDAO.create(food1);

		Food food2 = new Food(100, 144, "Coxa de frango", unit4, "1 unidade.");
		foodDAO.create(food2);

		Food food3 = new Food(100, 287, "Picanha", unit4, "1 fatia.");
		foodDAO.create(food3);

		Food food4 = new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", unit4, "1 fatia.");
		foodDAO.create(food4);

		Food food5 = new Food(200, 1074, "Chocolate meio-amargo", unit4, "1 unidade.");
		foodDAO.create(food5);

		Food food6 = new Food(100, 68, "Gelatina", unit4, "1 porção.");
		foodDAO.create(food6);

		Food food7 = new Food(350, 230, "Manga", unit4, "1 unidade.");
		foodDAO.create(food7);

		Food food8 = new Food(20, 4, "Alface", unit4, "2 folhas.");
		foodDAO.create(food8);

		Food food9 = new Food(100, 139, "Lasanha", unit4, "1 porção.");
		foodDAO.create(food9);

		Food food10 = new Food(140, 304, "Pizza de mussarela", unit4, "1 fatia.");
		foodDAO.create(food10);

		Food food11 = new Food(250, 161, "Suco de uva", unit5, "1 copo.");
		foodDAO.create(food11);

		for(Food foodItem : foodDAO.getAll()) {
			System.out.println(foodItem.getInfoPretty());
		}
	}
}
