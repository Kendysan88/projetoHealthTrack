package br.com.healthtrack.bean.bodyinformation;

import java.time.LocalDateTime;

/**
 * Classe que abstrai uma informação/medida corporal
 * do tipo peso.
 * @author Gabriel Souza Piscinato
 * @version 1.0
 */
public class Weight extends BodyInformation {

	private static final String validUnit = "kg";

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public Weight(int userId, double value,
			LocalDateTime dateTime) {
		super(userId, value, dateTime, validUnit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public Weight(int id, int userId, double value,
			LocalDateTime dateTime, String unit) {
		super(id, userId, value, dateTime, unit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public Weight(int userId, double value,
			String dateTime) {
		super(userId, value, dateTime, validUnit);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public Weight(int id, int userId, double value,
			String dateTime, String unit) {
		super(id, userId, value, dateTime, unit);
	}
}
