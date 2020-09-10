package br.com.healthtrack.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma informa��o/medida de peso corporal.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class Weight extends BodyInformation {
	/**
	 * M�todo para se obter o valor da medi��o corporal com sufixo de unidade.
	 * @return Valor da medi��o corporal com sufixo de metro.
	 */
	public String getValuePretty() {
		return  Constants.formatMeters(getValue());
	}

	/**
	 * M�todo para remover uma medi��o de peso no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy() {
		System.out.println("Deleting Weight from the database... DONE!");
		return true;
	}

	/**
	 * M�todo para persistir as informa��es de uma medi��o de peso no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save() {
		System.out.println("Saving Weight in the database... DONE!");
		return true;
	}

	/**
	 * M�todo para se consultar medi��es de peso j� persistidos no banco de dados.
	 * @param initialDateTime Data e hora inicial do intervalo.
	 * @param finalDateTime Data e hora final do intervalo.
	 * @return Lista de medi��es de peso.
	 */
	public static Weight[] search(LocalDateTime initialDateTime, LocalDateTime finalDateTime) {
		Weight[] results = {};

		System.out.println(
				"Searching since " +
				Constants.formatDateTime(initialDateTime) +
				" to " +
				Constants.formatDateTime(finalDateTime) +
				" into Weights table in database... DONE!"
		);

		return results;
	}
}
