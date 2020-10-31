package br.com.healthtrack.model.physicalactivity;

import java.time.LocalDateTime;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma atividade fÃ­sica.
 * @author Richard Kendy Tanaka
 * @version 2.0
 */

public class PhysicalActivity implements Comparable<PhysicalActivity> {

	// Attributes
	private int physicalActivityId;
	private String activityName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double calories;
	private String activityType;
	private double distance;

	


	// Constructor
	public PhysicalActivity() {

	}

	/**
	 * Método construtor padrão.
	 * @param activityName      Tipo de atividade realizada.
	 * @param startTime 		Hora inicial da atividade (horas).
	 * @param endTime   		Hora final da atividade (horas).
	 * @param calories  		Quantidade de calorias gastas durante a atividade (cal).
	 * @param activityType		Tipo de Atividade realizada. Exemplo: Duração, Série e etc.

	 */
	public PhysicalActivity(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories, String activityType) {
		this.physicalActivityId = physicalActivityId;
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.calories = calories;
		this.activityType = activityType;
		
	}
	
	/**
	 * Método construtor padrão.
	 * @param physicalActivityId  Código da Atividade física realizada
	 * @param activityName        Tipo de atividade física realizada.
	 * @param startTime 		  Hora inicial da atividade física (horas).
	 * @param endTime   		  Hora final da atividade física (horas).
	 * @param calories  		  Quantidade de calorias gastas durante a atividade física (cal).
	 * @param activityType		  Tipo de Atividade física realizada. Exemplo: Duração, Série e etc.
	 * @param distance			  Distância percorrida. 
	 */
	public PhysicalActivity(int physicalActivityId, String activityName, LocalDateTime startTime, LocalDateTime endTime, double calories, String activityType, double distance) {
		this.physicalActivityId = physicalActivityId;
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.calories = calories;
		this.activityType = activityType;
		this.distance = distance;
		
	}

	// Getters And Setters	
	/**
	 * Método para se obter o código da atividade física realizada.
	 * @return O código da atividade física realizada.
	 */
	public int getPhysicalActivityId() {
		return physicalActivityId;
	}
	
	/**
	 * Método para se alterar o código da atividade física realizada. (apenas para valores diferentes de vazio).
	 * @param physicalActivityId o código da atividade física realizada.
	 */
	public void setPhysicalActivityId(int physicalActivityId) {
		this.physicalActivityId = physicalActivityId;
	}
	
	/**
	 * Método para se obter o nome da atividade física realizada.
	 * @return O nome da atividade física realizada
	 */
	public String getActivityName() {
		return activityName;
	}
	
	/**
	 * Método para se alterar o nome da atividade física realizada. (apenas para valores diferentes de vazio).
	 * @param activityName O nome da atividade física realizada
	 */
	public void setActivityName(String activityName) {
		if (!activityName.trim().equals("")) {
			this.activityName = activityName;
		}		
	}
	
	/**
	 * Método para se obter a data e a hora inicial da atividade física (hh:mm:ss).
	 * @return Data e Hora inicial da atividade física
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	/**
	 * Método para se alterar a data e a hora inicial da atividade física (dd-mm-aaaa hh:mm:ss).
	 * @param startTime Data e Hora inicial da atividade física
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Método para se obter a data e a hora final da atividade física (dd-mm-aaaa hh:mm:ss).
	 * @return Data e Hora final da atividade física
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	/**
	 * Método para se alterar a data e a hora final da atividade física (dd-mm-aaaa hh:mm:ss).
	 * @param endTime Data e Hora final da atividade
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Método para se obter a quantidade de calorias gastas durante a atividade física.
	 * @return Quantidade de calorias (cal) gastas durante a atividade física.
	 */
	public double getCalories() {
		return calories;
	}
	
	/**
	 * Método para se alterar a quantidade de calorias gastas durante a atividade física.(apenas para valores maiores do que zero).
	 * @param calories Quantidade de calorias gastas durante a atividade física.
	 */
	public void setCalories(double calories) {
		if (calories > 0) {
			this.calories = calories;
		}
	}

	/**
	 * Método para se obter o tipo de Atividade física realizada. Exemplo: Duração, Série e etc.
	 * @return Tipo de Atividade física realizada.
	 */	
	public String getActivityType() {
		return activityType;
	}	
	
	/**
	 * Método para se alterar o tipo de Atividade física realizada. Exemplo: Duração, Série e etc.
	 * @param typeActivity tipo de Atividade física realizada.
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
	/**
	 * Método para se obter a distância percorrida durante a atividade física realizada.
	 * @return A distância percorrida
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * Método para se alterar a distância percorrida durante a atividade física realizada.(apenas para valores maiores do que zero).
	 * @param distance A distância percorrida durante a atividade física realizada.
	 */
	public void setDistance(double distance) {
		if (distance > 0) {
			this.distance = distance;
		}
	}

	// Methods
	/**
	 * Método para calcular a quantidade calorias gastas
	 * @param calories Quantidade de calorias gastas durante a atividade física (cal).
	 * @return A quantidade calorias gastas na atividade física.
	 */
	public double calculateCalories(double calories) {
		System.out.println("Você queimou " + calories + " kcal.");
		return calories;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		String info = "Atividade: " + getActivityName() +
		  ", Início: " + getStartTimePretty() + ", Fim: " + getEndTimePretty() + 
		  ", Calorias Queimadas: " + getCaloriesPretty() + 
		  ", Tipo: " + getActivityType() +
		  ", Distância percorrida: " + getDistancePretty();

		return info;
	}
	

	/**
	 * Método para se obter a data e a hora inicial da Atividade Física formatados (DD-MM-AAAA HH:MM:SS).
	 * @return Data e Hora inicial da Atividade Física no formato (DD-MM-AAAA HH:MM:SS).
	 */
	public String getStartTimePretty() {
		return Utils.formatDateTime(getStartTime());
	}
	
	/**
	 * Método para se obter a data e a hora final da Atividade Física formatados (DD-MM-AAAA HH:MM:SS).
	 * @return Data e Hora final da Atividade Física no formato (DD-MM-AAAA HH:MM:SS).
	 */
	public String getEndTimePretty() {
		return Utils.formatDateTime(getEndTime());
	}
	
	/**
	 * Método para se obter a quantidade de calorias gastas com sufixo de unidade.
	 * @return Quantidade de calorias gastas (cal)  
	 */
	public String getCaloriesPretty() {
		return Utils.formatCalories(calories);
	}	
	
	/**
	 * Método para se obter a quantidade de calorias gastas com sufixo de unidade.
	 * @return Quantidade de calorias gastas (cal)  
	 */
	public String getDistancePretty() {
		return Utils.formatKilometers(distance);
	}
	

	@Override
	public int compareTo(PhysicalActivity otherActivitySerie) {
        return this.getActivityName().compareToIgnoreCase(otherActivitySerie.getActivityName());

	}
}
