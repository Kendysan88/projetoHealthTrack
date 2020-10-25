package br.com.healthtrack;

import br.com.healthtrack.model.bodyinformation.BodyInformation;
import br.com.healthtrack.model.bodyinformation.BodyInformationDAO;
import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodDAO;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealDAO;
import br.com.healthtrack.model.meal.MealType;
import br.com.healthtrack.model.meal.MealTypeDAO;
import br.com.healthtrack.model.physicalactivity.PhysicalActivity;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityDAO;

/**
 * Classe que serve para testar as classes DAO que foram criadas.
 * @author Todos os membros do grupo
 * @version 2.0
 */
public class TesteDAO {

	public static void main(String[] args) {
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

		Food food1 = new Food(30, 198, "Bacon frito", "g", "2 cubos.");
		foodDAO.create(food1);

		Food food2 = new Food(100, 144, "Coxa de frango", "g", "1 unidade.");
		foodDAO.create(food2);

		Food food3 = new Food(100, 287, "Picanha", "g", "1 fatia.");
		foodDAO.create(food3);

		Food food4 = new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", "g", "1 fatia.");
		foodDAO.create(food4);

		Food food5 = new Food(200, 1074, "Chocolate meio-amargo", "g", "1 unidade.");
		foodDAO.create(food5);

		Food food6 = new Food(100, 68, "Gelatina", "g", "1 porção.");
		foodDAO.create(food6);

		Food food7 = new Food(350, 230, "Manga", "g", "1 unidade.");
		foodDAO.create(food7);

		Food food8 = new Food(20, 4, "Alface", "g", "2 folhas.");
		foodDAO.create(food8);

		Food food9 = new Food(100, 139, "Lasanha", "g", "1 porção.");
		foodDAO.create(food9);

		Food food10 = new Food(140, 304, "Pizza de mussarela", "g", "1 fatia.");
		foodDAO.create(food10);

		Food food11 = new Food(250, 161, "Suco de uva", "ml", "1 copo.");
		foodDAO.create(food11);

		for(Food foodItem : foodDAO.getAll()) {
			System.out.println(foodItem.getInfoPretty());
		}
	}
}
