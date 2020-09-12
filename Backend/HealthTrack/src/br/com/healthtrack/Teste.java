package br.com.healthtrack;

import java.time.LocalDateTime;

import br.com.healthtrack.bodyinformation.BodyInformation;
import br.com.healthtrack.bodyinformation.Height;
import br.com.healthtrack.bodyinformation.Weight;
import br.com.healthtrack.meal.Food;
import br.com.healthtrack.meal.FoodItem;
import br.com.healthtrack.meal.Meal;
import br.com.healthtrack.users.Person;
import br.com.healthtrack.users.User;

public class Teste {

	public static void main(String[] args) {
		Food beef  = new Food();

		beef.setName("Beef");
		beef.setAmount(100);
		beef.setCalories(1000);
		beef.save();

		System.out.println(beef.getName() + ": " + beef.getCaloriesPretty());

		// -------------------------

		Food rice  = new Food();

		rice.setName("Rice");
		rice.setAmount(100);
		rice.setCalories(400);
		rice.save();

		System.out.println(rice.getName() + ": " + rice.getCaloriesPretty());

		// -------------------------

		Food beans = new Food();

		beans.setName("Beans");
		beans.setAmount(100);
		beans.setCalories(350);
		beans.save();

		System.out.println(beans.getName() + ": " + beans.getCaloriesPretty());

		// -------------------------

		Meal lunch = new Meal();

		lunch.setType("LUNCH");
		lunch.setDateTime(LocalDateTime.now());

		// -------------------------

		FoodItem riceItem = new FoodItem(rice);

		riceItem.setAmount(200);

		System.out.println(riceItem.getFoodName() + ": " + riceItem.getCaloriesPretty());

		// -------------------------

		FoodItem beefItem = new FoodItem(beef);

		beefItem.setAmount(50);

		System.out.println(beefItem.getFoodName() + ": " + beefItem.getCaloriesPretty());

		// -------------------------

		FoodItem beansItem = new FoodItem(beans);

		beansItem.setAmount(180);

		System.out.println(beansItem.getFoodName() + ": " + beansItem.getCaloriesPretty());

		// -------------------------

		lunch.getFoodItems().add(riceItem);
		lunch.getFoodItems().add(beefItem);
		lunch.getFoodItems().add(beansItem);

		System.out.println("Total calories: " + lunch.getTotalCaloriesPretty());

		lunch.save();
		
		Height altura = new Height();
		Weight peso = new Weight();
		altura.setValue(1.75);
		peso.setValue(70);
		
		User user = new User();
		user.getAlturas().add(altura);
		user.getPesos().add(peso);
		System.out.println("Seu IMC é: " + user.calculateIMC());
		
	}

}
