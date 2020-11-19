package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.model.user.User;
import br.com.healthtrack.model.user.dao.UserDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma informação/medida corporal.
 * @author Afonso de Sousa Costa e Gabriel Souza Piscinato
 * @version 3.0
 */
public abstract class BodyInformation {

	private LocalDateTime dateTime;
	private int id;
	private String unit;
	private User user = null;
	private int userId;
	private double value;

	/**
	 * Método construtor.
	 */
	public BodyInformation() {}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * corporal.
	 */
	public BodyInformation(LocalDateTime dateTime, String unit) {
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * corporal.
	 */
	public BodyInformation(int id, int userId, LocalDateTime dateTime, String unit) {
		setId(id);
		setUserId(userId);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação
	 */
	public BodyInformation(int id, int userId, String dateTime, String unit) {
		setId(id);
		setUserId(userId);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * corporal.
	 */
	public BodyInformation(int userId, LocalDateTime dateTime, String unit) {
		setUserId(userId);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação
	 */
	public BodyInformation(int userId, String dateTime, String unit) {
		setUserId(userId);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 */
	public BodyInformation(double value, LocalDateTime dateTime,
			String unit) {
		setValue(value);
		setDateTime(dateTime);
	}

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação
	 */
	public BodyInformation(String dateTime, String unit) {
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 */
	public BodyInformation(double value, String dateTime,
			String unit) {
		setValue(value);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BodyInformation(int id, int userId, double value,
			LocalDateTime dateTime, String unit) {
		setId(id);
		setUserId(userId);
		setValue(value);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BodyInformation(int id, int userId, double value,
			String dateTime, String unit) {
		setId(id);
		setUserId(userId);
		setValue(value);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BodyInformation(int userId, double value,
			LocalDateTime dateTime, String unit) {
		setUserId(userId);
		setValue(value);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BodyInformation(int userId, double value,
			String dateTime, String unit) {
		setUserId(userId);
		setValue(value);
		setDateTime(dateTime);
		setUnit(unit);
	}

	/**
	 * Método para se obter a data e hora da medição corporal.
	 * @return Data e hora da medição corporal.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Método para se obter a data e hora da medição corporal
	 * formatados (dd/mm/yy HH:MM:SS).
	 * @return Data e hora da refeição no formato (dd/mm/yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Utils.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter o identificador da medição corporal.
	 * @return Identificador da medição corporal.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		StringBuilder info = new StringBuilder();

		info.append(getDateTimePretty())
			.append(" ")
			.append(getValue())
			.append(" ")
			.append(getUnit());

		return info.toString();
	}


	/**
	 * Método para se obter a unidade de medida
	 * da medição corporal.
	 * @return Unidade de medida da medição corporal.
	 */
	public String getUnit() {
		return unit;
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
	 * Método para se obter o valor da medição corporal.
	 * @return Valor da medição corporal.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Método para se alterar a data e hora da medição corporal.
	 * @param dateTime Date e hora da medição corporal.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar a data e hora da medição corporal.
	 * @param dateTime Date e hora da medição corporal.
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = LocalDateTime.parse(dateTime,
				Utils.dateTimeFormat);
	}

	/**
	 * Método para se alterar o identificador da
	 * medição corporal.
	 * @param id Identificador da medição corporal.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	/**
	 * Método para se alterar a unidade de medida
	 * da medição corporal.
	 * @param unit Unidade de medida da medição corporal
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Método para se alterar o identificador do
	 * usuário da medição corporal.
	 * @param userId Identificador do usuário da
	 * medição corporal.
	 */
	public void setUserId(int userId) {
		if(userId > 0)
			this.userId = userId;
	}

	/**
	 * Método para se alterar o valor da medição corporal
	 * (apenas para valores maiores do que zero).
	 * @param value Valor da medição corporal.
	 */
	public void setValue(double value) {
		this.value = value < 0 ? 0 : value;
	}
}
