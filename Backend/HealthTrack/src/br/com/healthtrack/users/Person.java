package br.com.healthtrack.users;

import br.com.healthtrack.utils.Constants;

/**
 * Classe que abstrai uma pessoa.
 * @author Gabriel Souza Piscinato
 * @version <h3>1.0</h3>*/

public class Person {

    private String email;
    private String password;

    public Person() {
    }

    /**
     * M�todo construtor padrão.
     * @param email Email da pessoa.
     * @param password Senha da pessoa.
     */

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password, String passwordConfirmation) {
        if(!password.trim().equals("") &&
        	password.trim().length() >= Constants.PASSWORD_SIZE &&
        	password.trim().equals(passwordConfirmation.trim())) {
            this.password = password;
        }
    }

    public void setEmail(String email) {
        if(!email.trim().equals("") && email.trim().contains("@")) {
            this.email = email;
        }
    }

    

}