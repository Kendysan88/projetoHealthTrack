package br.com.healthtrack.model.meal;

/**
 * Classe que abstrai um tipo de refeição.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MealType {

	private String description;
	private String name;

	/**
	 * Método construtor padrão (name é obrigatório).
	 * @param name Nome do tipo de refeição.
	 */
	public MealType(String name) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
	}

	/**
	 * Método construtor sobrecarregado (name e description obrigatórios).
	 * @param name        Nome do tipo de refeição.
	 * @param description Descrição/observação do tipo de refeição.
	 */
	public MealType(String name, String description) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
		if(!description.trim().equals("")) {
			this.description = description;
		}
	}

	/**
	 * Método para se obter a descrição do tipo de refeição.
	 * @return Descrição do tipo de refeição.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método para se obter o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para se alterar a descrição do tipo de refeição (apenas para valores diferentes de vazio).
	 * @param description Descrição do tipo de refeição.
	 */
	public void setDescription(String description) {
		if(!name.trim().equals("")) {
			this.description = description;
		}
	}

	/**
	 * Método para se alterar o nome do tipo de refeição (apenas para valores diferentes de vazio).
	 * @param name Nome do tipo de refeição.
	 */
	public void setName(String name) {
		if(!name.trim().equals("")) {
			this.name = name;
		}
	}
}
