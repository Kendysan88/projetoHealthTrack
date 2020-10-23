package br.com.healthtrack.model.measurementunit;

/**
 * Classe que abstrai uma unidade de medida (sistema métrico).
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class MeasurementUnit implements Comparable<MeasurementUnit> {

	private String description;
	private String name;
	private String unitPrefix;

	/**
	 * Método construtor padrão (unit_prefix e name são obrigatórios).
	 * @param unitPrefix  Abreviatura da unidade de medida (prefixo).
	 * @param name     	  Nome da unidade de medida.
	 */
	public MeasurementUnit(String unitPrefix, String name) {
		setUnitPrefix(unitPrefix);
		setName(name);
	}

	/**
	 * Método construtor sobrecarregado (unit_prefix, description e name são obrigatórios).
	 * @param unitPrefix  Abreviatura da unidade de medida (prefixo).
	 * @param name     	  Nome da unidade de medida.
	 * @param description Descrição/observação da unidade de medida.
	 */
	public MeasurementUnit(String unitPrefix, String name, String description) {
		setUnitPrefix(unitPrefix);
		setName(name);
		setDescription(description);
	}

	@Override
    public int compareTo(MeasurementUnit otherUnit) {
        return this.getName().compareToIgnoreCase(otherUnit.getName());
    }

	public String formatValueToUnit(double value) {
		return String.format("%.2f", value) + " " + unitPrefix;
	}

	/**
	 * Método para se obter a descrição da unidade de medida.
	 * @return Descrição da unidade de medida.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método para se obter o nome da unidade de medida.
	 * @return Nome da unidade de medida.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para se obter o prefixo da unidade de medida.
	 * @return Prefixo da unidade de medida.
	 */
	public String getUnitPrefix() {
		return unitPrefix;
	}

	/**
	 * Método para se alterar a descrição da unidade de medida (apenas para valores diferentes de vazio).
	 * @param description Descrição da unidade de medida.
	 */
	public void setDescription(String description) {
		description = description.trim();

		if(!description.equals("")) {
			this.description = description;
		}

	}

	/**
	 * Método para se alterar a nome da unidade de medida (apenas para valores diferentes de vazio).
	 * @param name Nome da unidade de medida.
	 */
	public void setName(String name) {
		name = name.trim();

		if(!name.equals("")) {
			this.name = name;
		}
	}

	/**
	 * Método para se alterar o prefixo da unidade de medida (apenas para valores diferentes de vazio).
	 * @param unitPrefix Prefixo da unidade de medida.
	 */
	public void setUnitPrefix(String unitPrefix) {
		unitPrefix = unitPrefix.trim();

		if(!unitPrefix.equals("")) {
			this.unitPrefix = unitPrefix;
		}
	}
}
