package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;

/**
 * Classe que abstrai uma informação/medida de pressão sanguínea corporal.
 * @author Gabriel Souza Piscinato
 * @version 3.0
 */
public class BloodPreassure extends BodyInformation {

	private static final BloodPreassureStatus[] status = {
		new BloodPreassureStatus(120, 80, "NORMAL"),
		new BloodPreassureStatus(139, 89, "PRÉ-HIPERTENSÃO"),
		new BloodPreassureStatus(159, 99, "HIPERTENSÃO ESTÁGIO 1"),
		new BloodPreassureStatus(179, 109, "HIPERTENSÃO ESTÁGIO 2"),
		new BloodPreassureStatus(200, 120, "HIPERTENSÃO ESTÁGIO 3")
	};

	private static final String validUnit = "mmHg";
	private int diastolicValue;
	private int systolicValue;

	/**
	 * Método construtor padrão (diastolicValue, systolicValue e dateTime são obrigatórios).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor sistólico da medição de pressão corporal.
	 * @param dateTime       Data e hora da medição corporal.
	 * @param unit	   		 Unidade de medida da medidação.
	 * @param userId   		 Identificador do usuário.
	 */
	public BloodPreassure(int userId, int systolicValue,
			int diastolicValue, LocalDateTime dateTime) {
		super(userId, dateTime, validUnit);

		setDiastolicValue(diastolicValue);
		setSystolicValue(systolicValue);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor sistólico da medição de pressão corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */

	public BloodPreassure(int id, int userId,
			int systolicValue, int diastolicValue,
			LocalDateTime dateTime, String unit) {
		super(id, userId, dateTime, unit);

		setDiastolicValue(diastolicValue);
		setSystolicValue(systolicValue);

	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor sistólico da medição de pressão corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BloodPreassure(int userId, int systolicValue,
			int diastolicValue, String dateTime) {
		super(userId, dateTime, validUnit);

		setDiastolicValue(diastolicValue);
		setSystolicValue(systolicValue);
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime
	 * são obrigatórios).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor sistólico da medição de pressão corporal.
	 * @param dateTime Data e hora da medição corporal.
	 * @param unit	   Unidade de medida da medidação.
	 * @param userId   Identificador do usuário.
	 */
	public BloodPreassure(int id, int userId, int systolicValue,
			int diastolicValue, String dateTime, String unit) {
		super(id, userId, dateTime, unit);

		setDiastolicValue(diastolicValue);
		setSystolicValue(systolicValue);
		
	}

	/**
	 * Método para se obter o valor diastólico da medição de pressão corporal.
	 * @return Valor diastólico da medição de pressão corporal.
	 */
	public int getDiastolicValue() {
		return diastolicValue;
	}

	/**
	 * Método para se obter o status da medição de pressão corporal.
	 * @return Mensagem de acordo com os valores aferidos na medição de pressão corporal.
	 */
	public String getStatus() {
		for(BloodPreassureStatus currentStatus : status) {
			if (systolicValue <= currentStatus.getSystolicValue() ||
				diastolicValue <= currentStatus.getDiastolicValue()) {
				return currentStatus.getMessage();
			}
		}
		return "";
	}

	/**
	 * Método para se obter o valor sistólico da medição de pressão corporal.
	 * @return Valor sistólico da medição de pressão corporal.
	 */
	public int getSystolicValue() {
		return systolicValue;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getSystolicPretty() {
		StringBuilder info = new StringBuilder();

		info.append(getDateTimePretty())
			.append(" ")
			.append(getSystolicValue())
			.append(" ")
			.append(getUnit());

		return info.toString();
	}

	public String getDiastolicPretty() {
		StringBuilder info = new StringBuilder();

		info.append(getDateTimePretty())
			.append(" ")
			.append(getDiastolicValue())
			.append(" ")
			.append(getUnit());

		return info.toString();
	}

	/**
	 * Método para se alterar o valor diastólico da medição de pressão corporal (apenas para valores maiores do que zero).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 */
	public void setDiastolicValue(int diastolicValue) {
		if(diastolicValue > 0) {
			this.diastolicValue = diastolicValue;
		}
	}

	/**
	 * Método para se alterar o valor sistólico da medição de pressão corporal (apenas para valores maiores do que zero).
	 * @param systolicValue Valor sistólico da medição de pressão corporal.
	 */
	public void setSystolicValue(int systolicValue) {
		if(diastolicValue > 0) {
			this.systolicValue = systolicValue;
		}
	}
}
