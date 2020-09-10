package br.com.healthtrack.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma informa��o/medida corporal.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class BodyInformation {
	private LocalDateTime dateTime;
	private double value;

	public BodyInformation() {
	}

	/**
	 * M�todo para se obter a data e hora da medi��o corporal.
	 * @return Data e hora da medi��o corporal.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * M�todo para se obter a data e hora da medi��o corporal formatados (dd/mm/yy HH:MM:SS).
	 * @return Data e hora da refei��o no formato (dd/mm/yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Constants.formatDateTime(getDateTime());
	}

	/**
	 * M�todo para se obter o valor da medi��o corporal.
	 * @return Valor da medi��o corporal.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * M�todo para se alterar a data e hora da medi��o corporal.
	 * @param dateTime Date e hora da medi��o corporal.
	 * @return N�o h� retorno.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * M�todo para se alterar o valor da medi��o corporal (apenas para valores maiores do que zero).
	 * @return N�o h� retorno.
	 */
	public void setValue(double value) {
		if(value > 0) {
			this.value = value;
		}
	}

}
