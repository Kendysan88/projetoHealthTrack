package br.com.healthtrack.users;

import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bodyinformation.Height;
import br.com.healthtrack.bodyinformation.Weight;

public class User extends Person {
	
	private String dataNascimento;
	private List<Height> alturas = new ArrayList<Height>();
	private List<Weight> pesos= new ArrayList<Weight>();
	
	public double calculateIMC() {
		double alturaAtual = alturas.get(alturas.size() - 1).getValue();
		double pesoAtual = pesos.get(pesos.size() - 1).getValue();
		return (pesoAtual / (Math.pow(alturaAtual, 2)));
	}
	

	public List<Height> getAlturas() {
		return alturas;
	}

	public List<Weight> getPesos() {
		return pesos;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	}