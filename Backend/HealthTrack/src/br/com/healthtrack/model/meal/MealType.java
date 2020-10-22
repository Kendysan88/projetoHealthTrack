package br.com.healthtrack.model.meal;

/**
 * Classe que abstrai um tipo de refeição.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */
public class MealType {

	private String description;
	private String name;

	/**
	 * Método construtor padrão (name é obrigatório).
	 * @param name Nome do tipo de refeição.
	 */
	public MealType(String name) {
		setName(name);
	}

	/**
	 * Método construtor sobrecarregado (name e description obrigatórios).
	 * @param name        Nome do tipo de refeição.
	 * @param description Descrição/observação do tipo de refeição.
	 */
	public MealType(String name, String description) {
		setName(name);
		setDescription(description);
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
		description = description.trim();

		if(!description.equals("")) {
			this.description = description;
		}
	}

	/**
	 * Método para se alterar o nome do tipo de refeição (apenas para valores diferentes de vazio).
	 * @param name Nome do tipo de refeição.
	 */
	public void setName(String name) {
		name = name.trim();

		if(!name.equals("")) {
			this.name = name;
		}
	}
}
