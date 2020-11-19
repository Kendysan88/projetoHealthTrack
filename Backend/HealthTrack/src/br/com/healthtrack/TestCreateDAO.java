package br.com.healthtrack;

import java.time.LocalDateTime;

import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodItem;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealType;
import br.com.healthtrack.model.meal.dao.FoodDAO;
import br.com.healthtrack.model.meal.dao.FoodItemDAO;
import br.com.healthtrack.model.meal.dao.MealDAO;
import br.com.healthtrack.model.meal.dao.MealTypeDAO;
import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;
import br.com.healthtrack.model.physicalactivity.dao.PhysicalActivityBySeriesDAOImpl;

/**
 * Classe que serve para inserir os registros nas tabelas que foram criadas.
 * @author Todos os membros do grupo
 * @version 2.0
 */
public class TestCreateDAO {

	public static void main(String[] args) {
		
		//Instancia PhysicalActivityBySeriesDAO
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
	    
		//Instancia MealTypeDAO
	    MealTypeDAO mealTypeDAO = new MealTypeDAO();
	    
	    //Cadastra no banco de dados
		MealType mealType1 = new MealType("café da manhã");
		mealTypeDAO.create(mealType1);

		MealType mealType2 = new MealType("almoço");
		mealTypeDAO.create(mealType2);

		MealType mealType3 = new MealType("jantar");
		mealTypeDAO.create(mealType3);

		MealType mealType4 = new MealType("lanche");
		mealTypeDAO.create(mealType4);
		
		//Instancia FoodDAo
		FoodDAO foodDAO = new FoodDAO();

	    //Cadastra no banco de dados
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
		
		//Instancia a Meal
		Meal meal1 = new Meal(LocalDateTime.now(), mealType2);
		
		//Instancia MealDAO
		MealDAO mealDAO = new MealDAO();

	    //Adiciona alimentos na refeição
		FoodItem foodItem1 = new FoodItem(food1, 200);
		meal1.addFoodItem(foodItem1);

		FoodItem foodItem2 = new FoodItem(food2, 150);
		meal1.addFoodItem(foodItem2);

		FoodItem foodItem3 = new FoodItem(food3, 100);
		meal1.addFoodItem(foodItem3);

		//Cadastra no banco de dados
		mealDAO.create(meal1, 1);
	    
	}

}
