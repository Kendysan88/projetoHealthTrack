package br.com.healthtrack.model.physicalactivity;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que herda da classe atividade física e permite realizar exercícios com séries, repetições e pesos.
 * @author Richard Kendy Tanaka
 * @version 2.0
 */

public class PhysicalActivityBySeries extends PhysicalActivity {

	// Attributes
	private int series;
	private int repetitions;
	private double liftedWeight;
	
	

	// Constructor
	public PhysicalActivityBySeries() {

	}
	
	public PhysicalActivityBySeries(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories,String activityType) {
		super(physicalActivityId, activityName, startTime, endTime, calories, activityType);

	}	
	public PhysicalActivityBySeries(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories,String activityType, double distance) {
		super(physicalActivityId, activityName, startTime, endTime, calories, activityType, distance);

	}	
	
	/**
	 * Método construtor padrão.
	 * @param series			Quantidade de séries necessárias para realizar a atividade.
	 * @param repetions 		Quantidade de repetições necessárias para realizar a atividade.
	 * @param liftedWeight		Quantidade de peso necessário para realizar a atividade. 
	 */
	public PhysicalActivityBySeries(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories,String activityType,int series, int repetitions, double liftedWeight) {
		super(physicalActivityId, activityName, startTime, endTime, calories, activityType);
		this.series = series;
		this.repetitions = repetitions;
		this.liftedWeight = liftedWeight;
	}	
	
	/**
	 * Método construtor padrão.
	 * @param distance			Distância percorrida. 
	 * @param series			Quantidade de séries necessárias para realizar a atividade.
	 * @param repetions 		Quantidade de repetições necessárias para realizar a atividade.
	 * @param liftedWeight		Quantidade de peso necessário para realizar a atividade. 
	 */
	public PhysicalActivityBySeries(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories,String activityType,double distance, int series, int repetitions, double liftedWeight) {
		super(physicalActivityId, activityName, startTime, endTime, calories, activityType, distance);
		this.series = series;
		this.repetitions = repetitions;
		this.liftedWeight = liftedWeight;
	}
	
	
	
	
	// Getters And Setters
	/**
	 * Método para se obter a quantidade de séries necessárias para realizar a atividade física.
	 * @return Quantidade de séries necessárias para realizar a atividade física.
	 */
	public int getSeries() {
		return series;
	}
	
	/**
	 * Método para se alterar a quantidade de séries necessárias para realizar a atividade física.(apenas para valores maiores do que zero).
	 * @param series Quantidade de séries necessárias para realizar a atividade física.
	 */
	public void setSeries(int series) {
		if (series > 0) {
			this.series = series;
		}
	}

	/**
	 * Método para se obter a quantidade de repetições necessárias para realizar a atividade física.
	 * @return Quantidade de repetições necessárias para realizar a atividade física.
	 */
	public int getRepetitions() {
		return repetitions;
	}
	
	/**
	 * Método para se alterar a quantidade de repetições necessárias para realizar a atividade física.(apenas para valores maiores do que zero).
	 * @param repetions Quantidade de repetições necessárias para realizar a atividade física.
	 */
	public void setRepetitions(int repetitions) {
		if (repetitions > 0) {
			this.repetitions = repetitions;
		}
	}

	/**
	 * Método para se obter a quantidade de peso necessário para realizar a atividade física.
	 * @return Quantidade de peso necessário para realizar a atividade física.
	 */
	public double getLiftedWeight() {
		return liftedWeight;
	}

	/**
	 * Método para se alterar a quantidade de peso necessário para realizar a atividade física.(apenas para valores maiores do que zero).
	 * @param weight Quantidade de peso necessário para realizar a atividade física.
	 */
	public void setLiftedWeight(double liftedWeight) {
		if (liftedWeight > 0) {
			this.liftedWeight = liftedWeight;
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
	
	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	@Override
	public String getInfoPretty() {
		String info = "Atividade: " + getActivityName() +
				  ", Início: " + getStartTimePretty() + ", Fim: " + getEndTimePretty() + 
				  ", Calorias Queimadas: " + getCaloriesPretty() + 
				  ", Tipo: " + getActivityType() +
				  ", Séries: " + getSeries() + ", Repetições: " + getRepetitions() + 
				  ", Peso: " + getLiftedWeightPretty();

		return info;
	}
	
	/**
	 * Método para se obter a quantidade de peso levantado com sufixo de unidade.
	 * @return Quantidade de peso levantado (kg)  
	 */
	public String getLiftedWeightPretty() {
		return Utils.formatKilograms(liftedWeight);
	}

}
