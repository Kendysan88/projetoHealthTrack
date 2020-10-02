package br.com.healthtrack.model.physicalactivity;

import java.util.Calendar;

/**
 * Classe que abstrai uma atividade fÃ­sica.
 * @author Richard Kendy Tanaka
 * @version 1.0
 */

public class PhysicalActivity implements Comparable<PhysicalActivity> {

	// Attributes
	private String type;
	protected int beginHour;
	protected int endHour;
	private double calories;


	// Constructor
	public PhysicalActivity() {

	}

	/**
	 * MÃ©todo construtor padrÃ£o.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 */
	public PhysicalActivity(String type, int beginHour, int endHour, double calories) {
		this.calories = calories;
		if (beginHour > endHour) {
			System.out.println("A hora inicial nÃ£o pode ser maior que a hora final.");
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
	 * MÃ©todo para se obter a quantidade de calorias gastas durante a atividade.
	 * @return Quantidade de calorias (cal) gastas durante a atividade.
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * MÃ©todo para se alterar a quantidade de calorias gastas durante a atividade.(apenas para valores maiores do que zero).
	 * @param calories Quantidade de calorias gastas durante a atividade.
	 */
	public void setCalories(double calories) {
		if (calories > 0) {
			this.calories = calories;
		}
	}

	/**
	 * MÃ©todo para se obter o tipo de atividade fÃ­sica realizada.
	 * @return O tipo de atividade fÃ­sica realizada.
	 */
	public String getType() {
		return type;
	}

	/**
	 * MÃ©todo para se alterar o tipo de atividade fÃ­sica realizada. (apenas para valores diferentes de vazio).
	 * @param type Tipo de atividade fÃ­sica realizada.
	 */
	public void setType(String type) {
		if (!type.trim().equals("")) {
			this.type = type;
		}

	}

	/**
	 * MÃ©todo para se obter a hora inicial da atividade (horas).
	 * @return Hora inicial da atividade
	 */
	public int getBeginHour() {
		return beginHour;
	}

	/**
	 * MÃ©todo para se alterar a hora inicial da atividade (horas). (apenas para valores diferentes de zero).
	 * @param beginHour Hora inicial da atividade
	 */
	public void setBeginHour(int beginHour) {
		Calendar dateTime = Calendar.getInstance();
		if (beginHour > 0) {
			this.beginHour = dateTime.get(Calendar.HOUR);
		}
	}

	/**
	 * MÃ©todo para se obter a hora final da atividade (horas).
	 * @return Hora final da atividade
	 */
	public int getEndHour() {
		return endHour;
	}

	/**
	 * MÃ©todo para se alterar a hora final da atividade (horas). (apenas para valores diferentes de zero).
	 * @param endHour Hora final da atividade
	 */
	public void setEndHour(int endHour) {
		Calendar dateTime = Calendar.getInstance();
		if (endHour > 0) {
			this.endHour = dateTime.get(Calendar.HOUR);
		}
	}

	// Methods
	/**
	 * MÃ©todo para calcular a quantidade calorias gastas
	 * @param calories Quantidade de calorias gastas durante a atividade (cal).
	 * @return A quantidade calorias gastas na atividade
	 */
	public double calculateCalories(double calories) {
		System.out.println("Você queimou " + calories + " kcal.");
		return calories;
	}

	/**
	 * MÃ©todo para persistir as informaÃ§Ãµes das atividades fÃ­sicas no banco de dados.
	 * @param physicalActivity instÃ¢ncia do objeto PhysicalActivity 
	 * @return Se o objeto foi salvo corretamente no banco de dados.
	 */
	public boolean save(PhysicalActivity physicalActivity) {
		System.out.println("Salvando uma nova atividade física.");
		return true;
	}

	/**
	 * MÃ©todo para alterar as informaÃ§Ãµes das atividades fÃ­sicas no banco de dados.
	 * @param physicalActivity instÃ¢ncia do objeto PhysicalActivity 
	 * @return Se o objeto foi atualizado corretamente no banco de dados.
	 */
	public boolean update(PhysicalActivity physicalActivity) {
		System.out.println("Atualizando uma atividade física.");
		return true;

	}

	/**
	 * MÃ©todo para remover as atividades fÃ­sicas no banco de dados.
	 * @param physicalActivity instÃ¢ncia do objeto PhysicalActivity 
	 * @return Se o objeto foi removido corretamente no banco de dados.
	 */
	public boolean destroy(PhysicalActivity physicalActivity) {
		System.out.println("Deletando uma atividade fÃ­sica.");
		return true;

	}
	
	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = "Atividade: " + getType() +
		  ", Início: " + getBeginHour() + ", Fim: " + getEndHour() + 
		  ", Calorias Queimadas: " + getCalories();

		return info;
	}

	@Override
	public int compareTo(PhysicalActivity otherActivitySerie) {
        return this.getType().compareToIgnoreCase(otherActivitySerie.getType());

	}
}
