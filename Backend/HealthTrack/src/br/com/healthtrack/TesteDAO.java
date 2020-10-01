package br.com.healthtrack;

import br.com.healthtrack.model.bodyinformation.BodyInformation;
import br.com.healthtrack.model.bodyinformation.BodyInformationDAO;
import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.FoodDAO;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.model.meal.MealDAO;

/**
 * Classe que serve para testar as classes DAO que foram criadas.
 * @author Todos os membros do grupo
 * @version 1.0
 */
public class TesteDAO {

	public static void main(String[] args) {
		System.out.println("Alimentos DAO");

		for(Food item : new FoodDAO().getAll()) {
			System.out.println(item.getInfoPretty());
		}
		
		System.out.println("\n\n\n");

		System.out.println("Refeições DAO");

		for(Meal item : new MealDAO().getAll()) {
			System.out.println(item.getInfoPretty());
		}

		System.out.println("\n\n\n");

		System.out.println("Informações Corporais DAO");

		for(BodyInformation item : new BodyInformationDAO().getAll()) {
			System.out.println(item.getInfoPretty());
		}
	}
}
