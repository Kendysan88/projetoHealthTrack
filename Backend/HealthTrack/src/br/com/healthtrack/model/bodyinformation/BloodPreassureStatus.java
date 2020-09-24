package br.com.healthtrack.model.bodyinformation;

/**
 * Classe que abstrai um status com base nas medições de pressão sanguínea corporal.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */

public class BloodPreassureStatus {

	private int diastolicValue;
	private int systolicValue;
	private String message;

	/**
	 * Método construtor padrão (diastolicValue, systolicValue e message são obrigatórios).
	 * @param diastolicValue Valor mínimo diastólico da medição de pressão corporal.
	 * @param systolicValue  Valor mínimo sistólico da medição de pressão corporal.
	 * @param message        Mensagem de status.
	 */
	public BloodPreassureStatus(int systolicValue, int diastolicValue, String message) {
		this.systolicValue = systolicValue < 0 ? 0 : systolicValue;
		this.diastolicValue = diastolicValue < 0 ? 0 : diastolicValue;
		
		if(!message.trim().equals("")) {
			this.message = message;
		}
	}

	/**
	 * Método para se obter a mensagem de status.
	 * @return Mensagem de status.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Método para se obter o valor diastólico do status da medição de pressão corporal.
	 * @return Valor diastólico do staus da medição de pressão corporal.
	 */
	public int getDiastolicValue() {
		return diastolicValue;
	}

	/**
	 * Método para se obter o valor sistólico do status da medição de pressão corporal.
	 * @return Valor sistólico do staus da medição de pressão corporal.
	 */
	public int getSystolicValue() {
		return systolicValue;
	}
}
