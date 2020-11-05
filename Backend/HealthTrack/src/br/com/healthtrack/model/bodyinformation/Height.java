package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.model.bodyinformation.dao.HeightDAO;

/**
 * Classe que abstrai uma informação/medida corporal
 * do tipo altura.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class Height extends BodyInformation {

	private static final String validUnit = "m";

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param value    Valor da medição corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public Height(int userId, double value,
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
	public Height(int id, int userId, double value,
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
	public Height(int userId, double value,
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
	public Height(int id, int userId, double value,
			String dateTime, String unit) {
		super(id, userId, value, dateTime, unit);
	}

	/**
	 * Método construtor (id é obrigatório).
	 * @param id Identificador da medição corporal.
	 */
	public Height(int id) {
		if (self == null) {
			HeightDAO dao = new HeightDAO();

			self = dao.searchById(id);

			if (self != null) {
				setId(self.getId());
				setUserId(self.getUserId());
				setValue(self.getValue());
				setDateTime(self.getDateTime());
				setUnit(self.getUnit());
			}
		}
	}
}
