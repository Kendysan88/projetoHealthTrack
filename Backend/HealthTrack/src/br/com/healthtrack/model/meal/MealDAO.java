package br.com.healthtrack.model.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsável por manipular entidades do tipo refeição, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MealDAO {

	private ArrayList<FoodItem> foodItems;
	private ArrayList<Meal> mealList = new ArrayList<Meal>() {{

		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", "1 fatia."), 100));
		}};

		add(new Meal(LocalDateTime.parse("2020-04-26T10:32:56.300"), new MealType("Café da manhã"), foodItems));

        //-------------------------------------------------------------------------------------------------------------------

		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(100, 287, "Picanha", "1 fatia."), 200));
			add(new FoodItem(new Food(100, 139, "Lasanha", "1 porção."), 200));
		}};
		add(new Meal(LocalDateTime.parse("2020-04-26T12:32:56.300"), new MealType("Almoço"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(140, 304, "Pizza de mussarela", "1 fatia."), 280));
		}};

		add(new Meal(LocalDateTime.parse("2020-04-26T20:32:56.300"), new MealType("Jantar"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", "1 fatia."), 100));
			add(new FoodItem(new Food(100, 68, "Gelatina", "1 porção."), 100));
		}};

		add(new Meal(LocalDateTime.parse("2020-02-26T10:32:56.300"), new MealType("Café da manhã"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(100, 287, "Picanha", "1 fatia."), 200));
			add(new FoodItem(new Food(100, 139, "Lasanha", "1 porção."), 200));
		}};

		add(new Meal(LocalDateTime.parse("2020-02-26T12:32:56.300"), new MealType("Almoço"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(140, 304, "Pizza de mussarela", "1 fatia."), 210));
		}};

		add(new Meal(LocalDateTime.parse("2020-02-26T21:32:56.300"), new MealType("Jantar"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", "1 fatia."), 100));
			add(new FoodItem(new Food(100, 68, "Gelatina", "1 porção."), 100));
			add(new FoodItem(new Food(30, 198, "Bacon frito", "2 cubos."), 90));
		}};

		add(new Meal(LocalDateTime.parse("2020-03-26T08:32:56.300"), new MealType("Café da manhã"), foodItems));

		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(100, 144, "Coxa de frango", "1 unidade."), 300));
			add(new FoodItem(new Food(100, 139, "Lasanha", "1 porção."), 200));
		}};

		add(new Meal(LocalDateTime.parse("2020-03-26T13:32:56.300"), new MealType("Almoço"), foodItems));
		
		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(350, 230, "Manga", "1 unidade."), 700));
		}};

		add(new Meal(LocalDateTime.parse("2020-03-26T17:32:56.300"), new MealType("Lanche"), foodItems));
		
		//-------------------------------------------------------------------------------------------------------------------
		
		foodItems = new ArrayList<FoodItem>() {{
			add(new FoodItem(new Food(140, 304, "Pizza de mussarela", "1 fatia."), 280));
		}};

		add(new Meal(LocalDateTime.parse("2020-03-26T22:32:56.300"), new MealType("Jantar"), foodItems));
	}};
	
	public MealDAO() {
	}
	
	/**
	 * Método para se obter uma lista de todas as refeições persistidos no banco de dados.
	 * @return Lista ordenada cronologicamente, contendo todas as refeições persistidos no banco de dados.
	 */
	public ArrayList<Meal> getAll(){
		Collections.sort(mealList);

		return mealList;
	}
}
