package br.com.healthtrack.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma informação/medida corporal.
 * @author Afonso de Sousa Costa
 * @version <h3>1.0</h3>*/

public class BodyInformation {
	private LocalDateTime dateTime;
	private double value;

	public BodyInformation() {
	}

	/**
	 * Método para se obter a data e hora da medição corporal.
	 * @return Data e hora da medição corporal.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Método para se obter a data e hora da medição corporal formatados (dd/mm/yy HH:MM:SS).
	 * @return Data e hora da refeição no formato (dd/mm/yy HH:MM:SS).
	 */
	public String getDateTimePretty() {
		return Constants.formatDateTime(getDateTime());
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
	 * @return Não há retorno.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar o valor da medição corporal (apenas para valores maiores do que zero).
	 * @return Não há retorno.
	 */
	public void setValue(double value) {
		if(value > 0) {
			this.value = value;
		}
	}

}
