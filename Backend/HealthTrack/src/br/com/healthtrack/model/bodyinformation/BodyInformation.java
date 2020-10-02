package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;

import br.com.healthtrack.model.meal.Food;
import br.com.healthtrack.model.meal.Meal;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma informação/medida corporal.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */

public class BodyInformation implements Comparable<BodyInformation>  {

	private LocalDateTime dateTime;
	private double value;

	/**
	 * Método construtor padrão (dateTime é obrigatório).
	 * @param dateTime Data e hora da medição corporal.
	 */
	public BodyInformation(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método construtor sobrecarregado (value e dateTime são obrigatórios).
	 * @param value    Valor da medição corporal (quilogramas, ou kg, para peso, e metros, ou m, para altura).
	 * @param dateTime Data e hora da medição corporal.
	 */
	public BodyInformation(double value, LocalDateTime dateTime) {
		this.value = value < 0 ? 0 : value;
		this.dateTime = dateTime;
	}

	@Override
    public int compareTo(BodyInformation otherBodyInformation) {
        return this.getDateTime().compareTo(otherBodyInformation.getDateTime());
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
		return Utils.formatDateTime(getDateTime());
	}

	/**
	 * Método para se obter o valor da medição corporal com sufixo de unidade.
	 * @return Valor da medição corporal com sufixo de metros.
	 */
	public String getHeightValuePretty() {
		return Utils.formatMeters(getValue());
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = getDateTimePretty() + " " + getValue();
		return info;
	}

	/**
	 * Método para se obter o valor da medição corporal.
	 * @return Valor da medição corporal.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Método para se obter o valor da medição corporal com sufixo de unidade.
	 * @return Valor da medição corporal com sufixo de quilograma.
	 */
	public String getWeightValuePretty() {
		return Utils.formatKilograms(getValue());
	}

	/**
	 * Método para se alterar a data e hora da medição corporal.
	 * @param dateTime Date e hora da medição corporal.
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Método para se alterar o valor da medição corporal (apenas para valores maiores do que zero).
	 * @param value Valor da medição corporal (quilogramas, ou kg, para peso, e metros, ou m, para altura).
	 */
	public void setValue(double value) {
		if(value > 0) {
			this.value = value;
		}
	}
}
