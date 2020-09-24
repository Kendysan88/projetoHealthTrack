package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma informação/medida de pressão sanguínea corporal.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */

public class BloodPreassure extends BodyInformation {

	private static final BloodPreassureStatus[] status = {
		new BloodPreassureStatus(120, 80, "NORMAL"),
		new BloodPreassureStatus(139, 89, "PRÉ-HIPERTENSÃO"),
		new BloodPreassureStatus(159, 99, "HIPERTENSÃO ESTÁGIO 1"),
		new BloodPreassureStatus(179, 109, "HIPERTENSÃO ESTÁGIO 2"),
		new BloodPreassureStatus(200, 120, "HIPERTENSÃO ESTÁGIO 3")
	};

	private int diastolicValue;
	private int systolicValue;

	/**
	 * Método construtor padrão (diastolicValue, systolicValue e dateTime são obrigatórios).
	 * @param diastolicValue Valor diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor sistólico da medição de pressão corporal.
	 * @param dateTime       Data e hora da medição corporal.
	 */
	public BloodPreassure(int systolicValue, int diastolicValue, LocalDateTime dateTime) {
		super(dateTime);

		this.diastolicValue = diastolicValue < 0 ? 0 : diastolicValue;
		this.systolicValue = systolicValue < 0 ? 0 : systolicValue;
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
	 * Método para se obter o valor de pressão sanguínea da medição corporal com sufixo de unidade.
	 * @return Valor da pressão sanguínea da medição corporal com sufixo de milimetros mercúrio.
	 */
	public String getValuePretty() {
		return diastolicValue + "/" + systolicValue + " " + Utils.CALORIES_UNIT_SYMBOL;
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
