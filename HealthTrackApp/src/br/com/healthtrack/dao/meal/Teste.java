package br.com.healthtrack.dao.meal;

import br.com.healthtrack.bean.meal.Food;

public class Teste {

	public static void main(String[] args) {
		FoodDAO dao = new FoodDAO();

		for(Food food : dao.getAll()) {
			System.out.println(food.getInfoPretty());
		}
	}
}
