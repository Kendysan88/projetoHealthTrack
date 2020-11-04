package br.com.healthtrack.model.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.model.meal.dao.MealDAO;
import br.com.healthtrack.model.meal.dao.MealTypeDAO;
import br.com.healthtrack.model.user.User;
import br.com.healthtrack.model.user.dao.UserDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma refeição bem como seu valor
 * calórico.
 * @author Afonso de Sousa Costa
 * @version 5.0
 */
public class Meal {

	private LocalDateTime dateTime;
	private List<FoodItem> foodItems;
	private int id;
	private Meal self = null;
	private User user = null;
	private int userId;
	private MealType type = null;
	private int typeId;

	/**
	 * Método construtor.
	 */
	public Meal() {}

	/**
	 * Método construtor (id é obrigatório).
	 * @param id Identificador da refeição.
	 */
	public Meal(int id) {
		if (self == null) {
			MealDAO dao = new MealDAO();

			self = dao.searchById(id);

			if (self != null) {
				foodItems = new ArrayList<FoodItem>();
				setId(self.getId());
				setDateTime(self.getDateTime());
				setTypeId(self.getTypeId());
				setUserId(self.getUserId());
			}
		}
	}

	/**
	 * Método construtor (typeId e dateTime são obrigatórios).
	 * @param typeId   Identificador do tipo de refeição.
	 * @param dateTime Data e hora da refeição (dd-mm-yyyy HH:MM:SS).
	 */
	public Meal(int typeId, String dateTime) {
		foodItems = new ArrayList<FoodItem>();

		setDateTime(dateTime);
		setTypeId(typeId);
	}

	/**
	 * Método construtor (typeId e dateTime são obrigatórios).
	 * @param typeId   Identificador do tipo de refeição.
	 * @param userId   Identificador do usuário.
	 * @param dateTime Data e hora da refeição (dd-mm-yyyy HH:MM:SS).
	 */
	public Meal(int typeId, int userId, String dateTime) {
		foodItems = new ArrayList<FoodItem>();

		setDateTime(dateTime);
		setTypeId(typeId);
		setUserId(userId);
	}

	/**
	 * Método construtor (id, typeId, userId e dateTime são obrigatórios).
	 * @param id	   Identificador da refeição.
	 * @param typeId   Identificador do tipo de refeição.
	 * @param userId   Identificador do usuário.
	 * @param dateTime Data e hora da refeição (dd-mm-yyyy HH:MM:SS).
	 */
	public Meal(int id, int typeId, int userId, String dateTime) {
		foodItems = new ArrayList<FoodItem>();

		setId(id);
		setDateTime(dateTime);
		setTypeId(typeId);
		setUserId(userId);
	}

	/**
	 * Método construtor (id, typeId, userId e dateTime são obrigatórios).
	 * @param id	   Identificador da refeição.
	 * @param typeId   Identificador do tipo de refeição.
	 * @param userId   Identificador do usuário.
	 * @param dateTime Data e hora da refeição (dd-mm-yyyy HH:MM:SS).
	 */
	public Meal(int id, int typeId, int userId, LocalDateTime dateTime) {
		foodItems = new ArrayList<FoodItem>();

		setId(id);
		setDateTime(dateTime);
		setTypeId(typeId);
		setUserId(userId);
	}

	/**
	 * Método para se adicionar um item alimentício
	 * à refeição.
	 * @param foodItem Item alimentício a ser
	 * adicionado.
	 */
	public void addFoodItem(FoodItem foodItem) {
		foodItem.setMealId(this.id);
		foodItems.add(foodItem);
	}

	/**
	 * Método para se obter a data e hora da refeição.
	 * @return Data e hora da refeição.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Método para se obter a data e hora da refeição
	 * formatados (dd-mm-yyyy HH:MM:SS).
	 * @return Data e hora da refeição no formato
	 * (dd-mm-yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Utils.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter a lista de itens alimentícios
	 * da refeição.
	 * @return Lista de itens alimentícios da refeição.
	 */
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * Método para se obter o identificador da refeição.
	 * @return Identificador da refeição.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter informações sobre o objeto
	 * instanciado.
	 * @return Texto contendo os valores dos atributos
	 * desse objeto.
	 */
	public String getInfoPretty() {
		StringBuilder info = new StringBuilder();

		info.append(getTypeName())
			.append(" às ")
			.append(getDateTimePretty())
			.append(" Total de calorias: ")
			.append(getTotalCaloriesPretty());

		return info.toString();
	}

	/**
	 * Método para se obter a quantidade total de calorias
	 * da refeição.
	 * @return Quantidade de calorias (cal) da refeição.
	 */
	public double getTotalCalories() {
		double totalCalories = 0.0;

		for(FoodItem foodItem : foodItems) {
			totalCalories += foodItem.getCalories();
		}

		return totalCalories;
	}

	/**
	 * Método para se obter a quantidade total de calorias
	 * da refeição com sufixo de unidade.
	 * @return Quantidade de calorias (cal) da refeição.
	 */
	public String getTotalCaloriesPretty() {
		return Utils.formatCalories(getTotalCalories());
	}

	/**
	 * Método para se obter o tipo de refeição.
	 * @return Tipo de refeição associada.
	 */
	public MealType getType() {
		if(type == null && typeId > 0) {
			MealTypeDAO dao = new MealTypeDAO();
			type = dao.searchById(typeId);
		}
		return type;
	}

	/**
	 * Método para se obter o identificador do tipo
	 * da refeição.
	 * @return Identificador do tipo da refeição.
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * Método para se obter o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getTypeName() {
		return getType().getName();
	}

	/**
	 * Método para se obter o usuário da refeição.
	 * @return Usuário da refeição.
	 */
	public User getUser() {
		if(user == null && userId > 0) {
			UserDAO dao = new UserDAO();
			user = dao.searchById(userId);
		}
		return user;
	}

	/**
	 * Método para se obter o identificador do usuário.
	 * @return Identificador do usuário.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Método para se remover um item alimentício da
	 * refeição.
	 * @param foodItem Nome do item alimentício a ser
	 * removido.
	 */
	public void removeFoodItem(String foodItemName) {
		FoodItem foodItemToRemove = null;

		for (FoodItem foodItem : foodItems) {
			if (foodItem.getFoodName()
					.equalsIgnoreCase(foodItemName)) {
				foodItemToRemove = foodItem;
				break;
			}
		}

		if(foodItemToRemove != null) {
			foodItems.remove(foodItemToRemove);
		}
	}

	/**
	 * Método para se alterar o identificador da
	 * refeição.
	 * @param id Identificador da reifeção.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	/**
	 * Método para se alterar a data e hora da refeição.
	 * @param dateTime Date e hora da reifeção.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar a data e hora da refeição.
	 * @param dateTime Date e hora da reifeção.
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = LocalDateTime.parse(dateTime,
				Utils.dateTimeFormat);
	}

	/**
	 * Método para se alterar o tipo da refeição.
	 * @param type Tipo da refeição.
	 */
	public void setType(MealType type) {
		this.type = type;
	}

	/**
	 * Método para se alterar o identificador do
	 * tipo da refeição.
	 * @param typeId Identificador do tipo da refeição.
	 */
	public void setTypeId(int typeId) {
		if(typeId > 0)
			this.typeId = typeId;
	}

	/**
	 * Método para se alterar o identificador do
	 * usuário da refeição.
	 * @param userId Identificador do usuário da refeição.
	 */
	public void setUserId(int userId) {
		if(typeId > 0)
			this.userId = userId;
	}
}
