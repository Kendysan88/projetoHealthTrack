package br.com.healthtrack.model.physicalactivity;

/**
 * Classe que herda da classe atividade física e permite realizar exercícios com séries, repetições e pesos.
 * @author Richard Kendy Tanaka
 * @version 1.0
 */

public class PhysicalActivityBySeries extends PhysicalActivity {

	// Attributes
	private int series;
	private int repetions;
	private double weight;

	// Constructor
	/**
	 * Método construtor padrão.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 * @param series	Quantidade de séries necessárias para realizar a atividade.
	 * @param repetions Quantidade de repetições necessárias para realizar a atividade.
	 * @param weight	Quantidade de peso necessário para realizar a atividade. 
	 */
	public PhysicalActivityBySeries(String type, int beginHour, int endHour, double calories, int series, int repetions,
			double weight) {
		super(type, beginHour, endHour, calories );
		this.series = series;
		this.repetions = repetions;
		this.weight = weight;
	}

	// Getters And Setters
	/**
	 * Método para se obter a quantidade de séries necessárias para realizar a atividade.
	 * @return Quantidade de séries necessárias para realizar a atividade.
	 */
	public int getSeries() {
		return series;
	}
	
	/**
	 * Método para se alterar a quantidade de séries necessárias para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param series Quantidade de séries necessárias para realizar a atividade.
	 */
	public void setSeries(int series) {
		if (series > 0) {
			this.series = series;
		}
	}

	/**
	 * Método para se obter a quantidade de repetições necessárias para realizar a atividade.
	 * @return Quantidade de repetições necessárias para realizar a atividade.
	 */
	public int getRepetions() {
		return repetions;
	}
	
	/**
	 * Método para se alterar a quantidade de repetições necessárias para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param repetions Quantidade de repetições necessárias para realizar a atividade.
	 */
	public void setRepetions(int repetions) {
		if (repetions > 0) {
			this.repetions = repetions;
		}
	}

	/**
	 * Método para se obter a quantidade de peso necessário para realizar a atividade.
	 * @return Quantidade de peso necessário para realizar a atividade.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Método para se alterar a quantidade de peso necessário para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param weight Quantidade de peso necessário para realizar a atividade.
	 */
	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
	
	/**
	 * Método sobrescrito para calcular a quantidade calorias gastas
	 * @return A quantidade calorias gastas na atividade
	 */
	@Override
	public double calculateCalories(double calories) {
		return super.calculateCalories(calories);
	}
	
	@Override
	public String getInfoPretty() {
		String info = "Atividade: " + getType() +
				  ", Início: " + getBeginHour() + ", Fim: " + getEndHour() + 
				  ", Calorias Queimadas: " + getCalories() + ", Séries: " + getSeries() + ", Repetições: " 
				  + getRepetions() + ", Peso: " + getWeight();
		return info;
	}

}
