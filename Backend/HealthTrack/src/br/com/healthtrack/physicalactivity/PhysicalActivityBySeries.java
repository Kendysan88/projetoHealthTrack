package br.com.healthtrack.physicalactivity;

/**
 * Classe que herda da classe atividade f�sica e permite realizar exerc�cios com s�ries, repeti��es e pesos.
 * @author Richard Kendy Tanaka
 * @version
 * <h3>1.0</h3>*/

public class PhysicalActivityBySeries extends PhysicalActivity {

	// Attributes
	private int series;
	private int repetions;
	private double weight;

	// Constructor
	/**
	 * M�todo construtor padr�o.
	 * @param calories  Quantidade de calorias gastas durante a atividade (cal).
	 * @param beginHour Hora inicial da atividade (horas).
	 * @param endHour   Hora final da atividade (horas).
	 * @param type      Tipo de atividade realizada.
	 * @param series	Quantidade de s�ries necess�rias para realizar a atividade.
	 * @param repetions Quantidade de repeti��es necess�rias para realizar a atividade.
	 * @param weight	Quantidade de peso necess�rio para realizar a atividade. 
	 */
	public PhysicalActivityBySeries(double calories, int beginHour, int endHour, String type, int series, int repetions,
			double weight) {
		super(calories, beginHour, endHour, type);
		this.series = series;
		this.repetions = repetions;
		this.weight = weight;
	}

	// Getters And Setters
	/**
	 * M�todo para se obter a quantidade de s�ries necess�rias para realizar a atividade.
	 * @return Quantidade de s�ries necess�rias para realizar a atividade.
	 */
	public int getSeries() {
		return series;
	}
	
	/**
	 * M�todo para se alterar a quantidade de s�ries necess�rias para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param series Quantidade de s�ries necess�rias para realizar a atividade.
	 * @return N�o h� retorno.
	 */
	public void setSeries(int series) {
		if (series > 0) {
			this.series = series;
		}
	}

	/**
	 * M�todo para se obter a quantidade de repeti��es necess�rias para realizar a atividade.
	 * @return Quantidade de repeti��es necess�rias para realizar a atividade.
	 */
	public int getRepetions() {
		return repetions;
	}
	
	/**
	 * M�todo para se alterar a quantidade de repeti��es necess�rias para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param repetions Quantidade de repeti��es necess�rias para realizar a atividade.
	 * @return N�o h� retorno.
	 */
	public void setRepetions(int repetions) {
		if (repetions > 0) {
			this.repetions = repetions;
		}
	}

	/**
	 * M�todo para se obter a quantidade de peso necess�rio para realizar a atividade.
	 * @return Quantidade de peso necess�rio para realizar a atividade.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * M�todo para se alterar a quantidade de peso necess�rio para realizar a atividade.(apenas para valores maiores do que zero).
	 * @param weight Quantidade de peso necess�rio para realizar a atividade.
	 * @return N�o h� retorno.
	 */
	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
	
	/**
	 * M�todo sobrescrito para calcular a quantidade calorias gastas
	 * @return A quantidade calorias gastas na atividade
	 */
	@Override
	public double calculateCalories(double calories) {
		return super.calculateCalories(calories);
	}

}
