package br.com.healthtrack;

import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodDAO;

public class TesteDAO {

	public static void main(String[] args) {
		System.out.println("Alimentos DAO");

		for(Food item : new FoodDAO().getAll()) {
			System.out.println(item.getInfoPretty());
		}
		
		System.out.println("\n");
	}
}
