package br.com.healthtrack.model.meal;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsável por manupular entidades do tipo item alimentício, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class FoodDAO {

	private ArrayList<Food> foodList = new ArrayList<Food>() {{
		add(new Food(30, 198, "Bacon frito", "2 cubos."));
		add(new Food(100, 144, "Coxa de frango", "1 unidade."));
		add(new Food(100, 287, "Picanha", "1 fatia."));
		add(new Food(50, 371, "Bolo de cenoura com cobertura de chocolate", "1 fatia."));
		add(new Food(200, 1074, "Chocolate meio-amargo", "1 unidade."));
		add(new Food(100, 68, "Gelatina", "1 porção."));
		add(new Food(350, 230, "Manga", "1 unidade."));
		add(new Food(20, 4, "Alface", "2 folhas."));
		add(new Food(100, 139, "Lasanha", "1 porção."));
		add(new Food(140, 304, "Pizza de mussarela", "1 fatia."));
	}};

	public FoodDAO() {
	}

	/**
	 * Método para se obter uma lista de todos os alimentos persistidos no banco de dados.
	 * @return Lista ordenada alfabeticamente, contendo todos os alimentos persistidos no banco de dados.
	 */
	public ArrayList<Food> getAll(){
		Collections.sort(foodList);

		return foodList;
	}
}