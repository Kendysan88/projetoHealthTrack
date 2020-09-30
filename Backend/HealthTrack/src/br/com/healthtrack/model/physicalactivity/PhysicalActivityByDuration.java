package br.com.healthtrack.model.physicalactivity;

/**
 * Classe que herda da classe atividade física e permite realizar exercícios com distância e duração.
 * @author Richard Kendy Tanaka
 * @version 1.0
 */

public class PhysicalActivityByDuration extends PhysicalActivity {

	// Attributes
	private double distance;

	// Constructor
	/**
	 * Método construtor padrão.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 * @param distance	A distância percorrida durante a atividade realizada.
	 */
	public PhysicalActivityByDuration(double calories, int beginHour, int endHour, String type, double distance) {
		super(calories, beginHour, endHour, type);
		this.distance = distance;
	}

	// Getters And Setters
	/**
	 * Método para se obter a distância percorrida durante a atividade realizada.
	 * @return A distância percorrida
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * Método para se alterar a distância percorrida durante a atividade realizada.(apenas para valores maiores do que zero).
	 * @param distance A distância percorrida durante a atividade realizada.
	 */
	public void setDistance(double distance) {
		if (distance > 0) {
			this.distance = distance;
		}
	}

	// Methods
	/**
	 * Método sobrescrito para calcular a quantidade calorias gastas
	 * @return A quantidade calorias gastas na atividade
	 */
	@Override
	public double calculateCalories(double calories) {
		return super.calculateCalories(calories);
	}

	/**
	 * Método para calcular o tempo total da atividade realizada.
	 * @return O tempo gasto.
	 */
	public int CalculateDuration() {
		int duration = endHour - beginHour;
		if (duration > 0) {
			return duration;
		} else {
			System.out.println("A hora inicial não pode ser maior que a hora final.");
			return 0;
		}
	}

}
