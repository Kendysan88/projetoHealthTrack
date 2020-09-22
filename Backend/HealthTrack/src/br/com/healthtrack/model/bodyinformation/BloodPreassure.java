package br.com.healthtrack.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma informação/medida de pressão sanguínea corporal.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */

public class BloodPreassure extends BodyInformation {
	private int diastolicValue;
	private int systolicValue;

	/**
	 * Método para remover uma medição de pressão sanguínea no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting BloodPreassure from the database... DONE!");
		return true;
	}

	/**
	 * Método para se obter o valor diastólico da medição de pressão corporal.
	 * @return Valor diastólico da medição de pressão corporal.
	 */
	public int getDiastolicValue() {
		return diastolicValue;
	}

	/**
	 * Método para se obter o valor sistólico da medição de pressão corporal.
	 * @return Valor sistólico da medição de pressão corporal
	 */
	public int getSystolicValue() {
		return systolicValue;
	}

	/**
	 * Método para se obter o valor de pressão sanguínea da medição corporal com sufixo de unidade.
	 * @return Valor da pressão sanguínea da medição corporal com sufixo de milimetros mercúrio.
	 */
	public String getValuePretty() {
		return diastolicValue + "/" + systolicValue + " " + Constants.CALORIES_UNIT_SYMBOL;
	}

	/**
	 * Método para persistir as informações de uma medição de pressão sanguínea no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		System.out.println("Saving BloodPreassures in the database... DONE!");
		return true;
	}

	/**
	 * Método para se consultar medições de pressão sanguínea já persistidos no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @return Lista de medições de pressão sanguínea.
	 */
	public static BloodPreassure[] search(LocalDateTime initialDateTime, LocalDateTime finalDateTime) {
		BloodPreassure[] results = {};

		System.out.println(
				"Searching since " +
				Constants.formatDateTime(initialDateTime) +
				" to " +
				Constants.formatDateTime(finalDateTime) +
				" into BloodPreassures table in database... DONE!"
		);

		return results;
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
