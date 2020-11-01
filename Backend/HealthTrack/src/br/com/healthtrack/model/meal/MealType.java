package br.com.healthtrack.model.meal;

import br.com.healthtrack.model.meal.dao.MealTypeDAO;

/**
 * Classe que abstrai um tipo de refeição.
 * @author Afonso de Sousa Costa
 * @version 4.0
 */
public class MealType {

	private String description;
	private int id;
	private String name;
	private MealType self = null;

	/**
	 * Método construtor.
	 */
	public MealType() {}

	/**
	 * Método construtor (id é obrigatório).
	 * @param id Identificador do tipo de refeição.
	 */
	public MealType(int id) {
		if (self == null) {
			MealTypeDAO dao = new MealTypeDAO();

			self = dao.searchById(id);

			if (self != null) {
				setId(self.getId());
				setName(self.getName());
				setDescription(self.getDescription());
			}
		}
	}

	/**
	 * Método construtor (name é obrigatório).
	 * @param name Nome do tipo de refeição.
	 */
	public MealType(String name) {
		setName(name);
	}

	/**
	 * Método construtor (name edescription são obrigatórios).
	 * @param name        Nome do tipo de refeição.
	 * @param description Descrição/observação do tipo de refeição.
	 */
	public MealType(String name, String description) {
		setName(name);
		setDescription(description);
	}

	/**
	 * Método construtor (name e id são obrigatórios).
	 * @param id   Identificador do tipo de refeição.
	 * @param name Nome do tipo de refeição.
	 */
	public MealType(int id, String name) {
		setId(id);
		setName(name);
	}

	/**
	 * Método construtor (name, id e description são obrigatórios).
	 * @param name        Nome do tipo de refeição.
	 * @param id   		  Identificador do tipo de refeição.
	 * @param description Descrição/observação do tipo de refeição.
	 */
	public MealType(int id, String name, String description) {
		setId(id);
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
	 * Método para se obter o identificador do tipo de refeição.
	 * @return Identificador do tipo de refeição.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter informações sobre o objeto instanciado.
	 * @return Texto contendo os valores dos atributos desse objeto.
	 */
	public String getInfoPretty() {
		StringBuilder info = new StringBuilder();

		info.append(name);

		if(description != null) {
			info.append(" ")
				.append(description);
		}

		return info.toString();
	}

	/**
	 * Método para se obter o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para se alterar a descrição do tipo de refeição
	 * (apenas para valores diferentes de vazio).
	 * @param description Descrição do tipo de refeição.
	 */
	public void setDescription(String description) {
		if(description == null)
			return;

		description = description.trim();

		if(!description.equals(""))
			this.description = description;
	}

	/**
	 * Método para se alterar o identificador do tipo de refeição.
	 * @param id Identificador do tipo de refeição.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	/**
	 * Método para se alterar o nome do tipo de refeição
	 * (apenas para valores diferentes de vazio).
	 * @param name Nome do tipo de refeição.
	 */
	public void setName(String name) {
		if(name == null)
			return;

		name = name.trim();

		if(!name.equals(""))
			this.name = name;
	}
}
