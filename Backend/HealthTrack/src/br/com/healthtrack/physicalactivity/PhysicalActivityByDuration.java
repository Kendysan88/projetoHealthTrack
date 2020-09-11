package br.com.healthtrack.physicalactivity;

/**
 * Classe que herda da classe atividade f�sica e permite realizar exerc�cios com dist�ncia e dura��o.
 * @author Richard Kendy Tanaka
 * @version
 * <h3>1.0</h3>*/

public class PhysicalActivityByDuration extends PhysicalActivity {

	// Attributes
	private double distance;

	// Constructor
	/**
	 * M�todo construtor padr�o.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 * @param distance	A dist�ncia percorrida durante a atividade realizada.
	 */
	public PhysicalActivityByDuration(double calories, int beginHour, int endHour, String type, double distance) {
		super(calories, beginHour, endHour, type);
		this.distance = distance;
	}

	// Getters And Setters
	/**
	 * M�todo para se obter a dist�ncia percorrida durante a atividade realizada.
	 * @return A dist�ncia percorrida
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * M�todo para se alterar a dist�ncia percorrida durante a atividade realizada.(apenas para valores maiores do que zero).
	 * @param distance A dist�ncia percorrida durante a atividade realizada.
	 * @return N�o h� retorno.
	 */
	public void setDistance(double distance) {
		if (distance > 0) {
			this.distance = distance;
		}
	}

	// Methods
	/**
	 * M�todo sobrescrito para calcular a quantidade calorias gastas
	 * @return A quantidade calorias gastas na atividade
	 */
	@Override
	public double calculateCalories(double calories) {
		return super.calculateCalories(calories);
	}

	/**
	 * M�todo para calcular o tempo total da atividade realizada.
	 * @return O tempo gasto.
	 */
	public int CalculateDuration() {
		int duration = endHour - beginHour;
		if (duration > 0) {
			return duration;
		} else {
			System.out.println("A hora inicial n�o pode ser maior que a hora final.");
			return 0;
		}
	}

}
