package br.com.healthtrack.model.user;

import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai uma pessoa.
 * @author Afonso de Sousa Costa
 * @version 2.0
 */

public abstract class Person {

    private String email;
    private String password;

    /**
	 * Método construtor.
	 */
    public Person() {
    }

	/**
	 * Método construtor (email e password são obrigatórios).
     * @param email 	Email da pessoa.
     * @param password 	Senha da pessoa.
	 */
    public Person(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

	/**
	 * Método para se obter o email da pessoa.
	 * @return Email da pessoa.
	 */
    public String getEmail() {
        return this.email;
    }

    /**
	 * Método para se alterar a senha da pessoa.
	 * (apenas para valores diferentes de vazio).
	 * @param password Senha da pessoa.
	 */
	public void setPassword(String password) {
		password = password.trim();

		if(!password.equals("") && password.length() >=
				Utils.PASSWORD_SIZE) {
			this.password = password;
		}
    }

	/**
	 * Método para se alterar o email da pessoa.
	 * (apenas para valores diferentes de vazio).
	 * @param email Email da pessoa.
	 */
    public void setEmail(String email) {
		email = email.trim();

		if(!email.equals("")) {
			this.email = email;
		}
    }

    /**
	 * Método para se validar a senha da pessoa.
	 * @param password Senha a ser comparada à da pessoa.
	 * @return Verdadeiro se ambas as senha coincidem.
	 */
    public boolean validatePassword(String password) {
        return this.password.equalsIgnoreCase(password.trim());
    }
}
