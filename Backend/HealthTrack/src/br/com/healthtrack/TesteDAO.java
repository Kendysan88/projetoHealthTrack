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
 * @version 1.0
 */
public class TesteDAO {

	public static void main(String[] args) {
		System.out.println("Unidade de Medida DAO");

		MeasurementUnitDAO unitDao = new MeasurementUnitDAO();

		MeasurementUnit unit1 = new MeasurementUnit("kg", "quilogramas");
		unitDao.create(unit1);

		MeasurementUnit unit2 = new MeasurementUnit("m", "metros", "Usada nas medições de altura");
		unitDao.create(unit2);

		MeasurementUnit unit3 = new MeasurementUnit("cal", "calorias", "Utilizada nas medições de atividade físicas");
		unitDao.create(unit3);

		for(MeasurementUnit unitItem : unitDao.getAll()) {
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



		System.out.println("\n\n\n");

		System.out.println("Informações Corporais DAO");

		for(BodyInformation item : new BodyInformationDAO().getAll()) {
			System.out.println(item.getInfoPretty());
		}
	}
}
