package br.com.healthtrack.bean.meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.user.User;
import br.com.healthtrack.dao.meal.FoodItemDAO;
import br.com.healthtrack.dao.meal.MealDAO;
import br.com.healthtrack.dao.meal.MealTypeDAO;
import br.com.healthtrack.dao.user.UserDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma refeição bem como seu valor
 * calórico.
 * @author Afonso de Sousa Costa
 * @version 5.0
 */
public class Meal {

	private LocalDateTime dateTime;
	private int id;
	private User user = null;
	private int userId;
	private MealType type = null;
	private int typeId;

	/**
	 * Método construtor.
	 */
	public Meal() {}

	/**
	 * Método construtor (typeId e dateTime são obrigatórios).
	 * @param typeId   Identificador do tipo de refeição.
	 * @param dateTime Data e hora da refeição (dd-mm-yyyy HH:MM:SS).
	 */
	public Meal(int typeId, String dateTime) {
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
		setId(id);
		setDateTime(dateTime);
		setTypeId(typeId);
		setUserId(userId);
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
		List<FoodItem> foodItems = new ArrayList<FoodItem>();

		if(id > 0) {
			FoodItemDAO dao = new FoodItemDAO();
			foodItems = dao.getAll(id);
		}

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

		if(id > 0) {
			MealDAO dao = new MealDAO();
			totalCalories = dao.getTotalCalories(id);
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
		if(userId > 0)
			this.userId = userId;
	}
}
