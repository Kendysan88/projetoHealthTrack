package br.com.healthtrack.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma informa��o/medida de press�o sangu�nea corporal.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class BloodPreassure extends BodyInformation {
	private int diastolicValue;
	private int systolicValue;

	/**
	 * M�todo para remover uma medi��o de press�o sangu�nea no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting BloodPreassure from the database... DONE!");
		return true;
	}

	/**
	 * M�todo para se obter o valor diast�lico da medi��o de press�o corporal.
	 * @return Valor disst�lico da medi��o corporal.
	 */
	public int getDiastolicValue() {
		return diastolicValue;
	}

	/**
	 * M�todo para se obter o valor sist�lico da medi��o de press�o corporal.
	 * @return Valor disst�lico da medi��o corporal.
	 */
	public int getSystolicValue() {
		return systolicValue;
	}

	/**
	 * M�todo para se obter o valor de press�o sangu�nea da medi��o corporal com sufixo de unidade.
	 * @return Valor da press�o sangu�nea da medi��o corporal com sufixo de milimetros merc�rio.
	 */
	public String getValuePretty(int diastolicValue, int systolicValue) {
		return diastolicValue + "/" + systolicValue + " " + Constants.CALORIES_UNIT_SYMBOL;
	}

	/**
	 * M�todo para persistir as informa��es de uma medi��o de press�o sangu�nea no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		System.out.println("Saving BloodPreassures in the database... DONE!");
		return true;
	}

	/**
	 * M�todo para se consultar medi��es de press�o sangu�nea j� persistidos no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @return Lista de medi��es de press�o sangu�nea.
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
	 * M�todo para se alterar o valor diast�lico da medi��o de press�o corporal (apenas para valores maiores do que zero).
	 * @return N�o h� retorno.
	 */
	public void setDiastolicValue(int diastolicValue) {
		if(diastolicValue > 0) {
			this.diastolicValue = diastolicValue;
		}
	}

	/**
	 * M�todo para se alterar o valor sist�lico da medi��o de press�o corporal (apenas para valores maiores do que zero).
	 * @return N�o h� retorno.
	 */
	public void setSystolicValue(int systolicValue) {
		if(diastolicValue > 0) {
			this.systolicValue = systolicValue;
		}
	}
}
