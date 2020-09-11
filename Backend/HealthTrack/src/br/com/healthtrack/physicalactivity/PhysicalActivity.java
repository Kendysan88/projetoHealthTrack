package br.com.healthtrack.physicalactivity;

import java.util.Calendar;

/**
 * Classe que abstrai uma atividade f�sica.
 * @author Richard Kendy Tanaka
 * @version
 * <h3>1.0</h3>*/

public class PhysicalActivity {

	// Attributes
	private double calories;
	private String type;
	protected int beginHour;
	protected int endHour;

	// Constructor
	public PhysicalActivity() {

	}

	/**
	 * M�todo construtor padr�o.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 */
	public PhysicalActivity(double calories, int beginHour, int endHour, String type) {
		this.calories = calories;
		if (beginHour > endHour) {
			System.out.println("A hora inicial n�o pode ser maior que a hora final.");
			this.beginHour = 0;
			this.endHour = 0;
		} else {
			this.beginHour = beginHour;
			this.endHour = endHour;
		}
		this.type = type;
	}

	// Getters And Setters
	/**
	 * M�todo para se obter a quantidade de calorias gastas durante a atividade.
	 * @return Quantidade de calorias (cal) gastas durante a atividade.
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * M�todo para se alterar a quantidade de calorias gastas durante a atividade.(apenas para valores maiores do que zero).
	 * @param calories Quantidade de calorias gastas durante a atividade.
	 * @return N�o h� retorno.
	 */
	public void setCalories(double calories) {
		if (calories > 0) {
			this.calories = calories;
		}
	}

	/**
	 * M�todo para se obter o tipo de atividade f�sica realizada.
	 * @return O tipo de atividade f�sica realizada.
	 */
	public String getType() {
		return type;
	}

	/**
	 * M�todo para se alterar o tipo de atividade f�sica realizada. (apenas para valores diferentes de vazio).
	 * @param type Tipo de atividade f�sica realizada.
	 * @return N�o h� retorno.
	 */
	public void setType(String type) {
		if (!type.trim().equals("")) {
			this.type = type;
		}

	}

	/**
	 * M�todo para se obter a hora inicial da atividade (horas).
	 * @return Hora inicial da atividade
	 */
	public int getBeginHour() {
		return beginHour;
	}

	/**
	 * M�todo para se alterar a hora inicial da atividade (horas). (apenas para valores diferentes de zero).
	 * @param beginHour Hora inicial da atividade
	 * @return N�o h� retorno.
	 */
	public void setBeginHour(int beginHour) {
		Calendar dateTime = Calendar.getInstance();
		if (beginHour > 0) {
			this.beginHour = dateTime.get(Calendar.HOUR);
		}
	}

	/**
	 * M�todo para se obter a hora final da atividade (horas).
	 * @return Hora final da atividade
	 */
	public int getEndHour() {
		return endHour;
	}

	/**
	 * M�todo para se alterar a hora final da atividade (horas). (apenas para valores diferentes de zero).
	 * @param endHour Hora final da atividade
	 * @return N�o h� retorno.
	 */
	public void setEndHour(int endHour) {
		Calendar dateTime = Calendar.getInstance();
		if (endHour > 0) {
			this.endHour = dateTime.get(Calendar.HOUR);
		}
	}

	// Methods
	/**
	 * M�todo para calcular a quantidade calorias gastas
	 * @return A quantidade calorias gastas na atividade
	 */
	public double calculateCalories(double calories) {
		System.out.println("Voc� queimou " + calories + " kcal.");
		return calories;
	}

	/**
	 * M�todo para persistir as informa��es das atividades f�sicas no banco de dados.
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save(PhysicalActivity physicalActivity) {
		System.out.println("Salvando uma nova atividade f�sica.");
		return true;
	}

	/**
	 * M�todo para alterar as informa��es das atividades f�sicas no banco de dados.
	 * 
	 * @return Se o objeto foi atualizado corretamente no banco de dados.
	 */
	public boolean update(PhysicalActivity physicalActivity) {
		System.out.println("Atualizando uma atividade f�sica.");
		return true;

	}

	/**
	 * M�todo para remover as atividades f�sicas no banco de dados.
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy(PhysicalActivity physicalActivity) {
		System.out.println("Deletando uma atividade f�sica.");
		return true;

	}

	/**
	 * M�todo para se consultar as atividades f�sicas j� persistidos no banco de dados. 
	 * @param type      Nome do item aliment�cio.
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @return Lista de atividades f�sicas
	 */
	public static PhysicalActivity[] search(String type, int beginHour, int endHour) {
		PhysicalActivity[] results = {};

		System.out.println("Procurado por " + type + " na tabela PhysicalActivities no banco de dados... FEITO!");

		return results;

	}

}
