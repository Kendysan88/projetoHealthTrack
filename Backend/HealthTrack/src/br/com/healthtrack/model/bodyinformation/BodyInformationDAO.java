package br.com.healthtrack.model.bodyinformation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsável por manupular entidades do tipo informações corporais, no banco de dados.
 * @author Gabriel Souza Piscinato
 * @version 1.0
 */

public class BodyInformationDAO {
	private ArrayList<BodyInformation> bodyInformationList;

	public BodyInformationDAO() {
		bodyInformationList = new ArrayList<BodyInformation>();
		bodyInformationList.add(new BodyInformation(80.0, LocalDateTime.now()));
		bodyInformationList.add(new BodyInformation(77.0, LocalDateTime.now()));
		bodyInformationList.add(new BodyInformation(65.0, LocalDateTime.now()));
		bodyInformationList.add(new BodyInformation(1.75, LocalDateTime.now()));
		bodyInformationList.add(new BodyInformation(1.55, LocalDateTime.now()));
		bodyInformationList.add(new BodyInformation(1.90, LocalDateTime.now()));
		bodyInformationList.add(new BloodPreassure(120, 80, LocalDateTime.now()));
		bodyInformationList.add(new BloodPreassure(125, 83, LocalDateTime.now()));
		bodyInformationList.add(new BloodPreassure(123, 82, LocalDateTime.now()));
	}

	/**
	 * Método para se obter uma lista de todas as informações corporais persistidas no banco de dados.
	 * @return Lista ordenada cronologicamente, contendo todas as informações corporais persistidas no banco de dados.
	 */
	public ArrayList<BodyInformation> getAll(){
		Collections.sort(bodyInformationList);

		return bodyInformationList;
	}

}
