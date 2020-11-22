package br.com.healthtrack.bean.user;

import java.time.LocalDate;

import br.com.healthtrack.dao.user.UserDAO;
import br.com.healthtrack.utils.Utils;

/**
 * Classe que abstrai um usuário do sistema.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class User extends Person {

	private LocalDate birthDate;
	private int id;
    private String nickname;
    private User self = null;

    /**
	 * Método construtor.
	 */
    public User() {
    }

	/**
	 * Método construtor (id é obrigatório).
	 * @param id Identificador do usuário.
	 */
	public User(int id) {
		if (self == null) {
			UserDAO dao = new UserDAO();

			self = dao.searchById(id);

			if (self != null) {
				setId(self.getId());
				setEmail(self.getEmail());
				setPassword(self.getPassword());
				setBirthDate(self.getBirthDatePretty());
			}
		}
	}

	/**
	 * Método construtor (email, password e birthDate
	 * são obrigatórios).
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
	 */
    public User(String email, String password,
            String birthDate) {
        super(email, password);
        setBirthDate(birthDate);
    }

	/**
	 * Método construtor (email, password, birthDate
	 * e nickname são obrigatórios).
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
     * @param nickname	Apelido do usuário.
	 */
    public User(String email, String password,
            String birthDate, String nickname) {
        super(email, password);
        setBirthDate(birthDate);
        setNickname(nickname);
    }

	/**
	 * Método construtor (id, email, password e birthDate
	 * são obrigatórios).
	 * @param id		Identificador do usuário.
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
	 */
    public User(int id, String email, String password,
            String birthDate) {
        super(email, password);
        setId(id);
        setBirthDate(birthDate);
    }

	/**
	 * Método construtor (id, email, password, birthDate
	 * e nickname são obrigatórios).
	 * @param id		Identificador do usuário.
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
     * @param nickname	Apelido do usuário.
	 */
    public User(int id, String email, String password,
            String birthDate, String nickname) {
        super(email, password);
        setId(id);
        setBirthDate(birthDate);
        setNickname(nickname);
    }

	/**
	 * Método construtor (id, email, password e birthDate
	 * são obrigatórios).
	 * @param id		Identificador do usuário.
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
	 */
    public User(int id, String email, String password,
            LocalDate birthDate) {
        super(email, password);
        setId(id);
        setBirthDate(birthDate);
    }

	/**
	 * Método construtor (id, email, password, birthDate
	 * e nickname são obrigatórios).
	 * @param id		Identificador do usuário.
     * @param email 	Email do usuário.
     * @param password 	Senha do usuário.
     * @param birthDate Data de nascimento do
     * usuário (dd-mm-yyyy).
     * @param nickname	Apelido do usuário.
	 */
    public User(int id, String email, String password,
            LocalDate birthDate, String nickname) {
        super(email, password);
        setId(id);
        setBirthDate(birthDate);
        setNickname(nickname);
    }

	/**
	 * Método para se obter a data de nascimento
	 * do usuário.
	 * @return Data de nascimento do usuário.
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Método para se obter a data de nascimento
	 * do usuário formatados (dd-mm-yy).
	 * @return Data de nascimento do usuário no
	 * formato (dd-mm-yyyy).
	 */
	public String getBirthDatePretty() {
		return Utils.formatDate(getBirthDate());
	}

	/**
	 * Método para se obter o identificador do usuário.
	 * @return Identificador do usuário.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para se obter o apelido do usuário.
	 * @return Apelido do usuário.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Método para se alterar a data de nascimento
	 * do usuário.
	 * @param birthDate Date de nascimento do usuário.
	 */
	public void setBirthDate(LocalDate birthDate) {
		if(birthDate == null)
			return;

		this.birthDate = birthDate;
	}

	/**
	 * Método para se alterar a data de nascimento
	 * do usuário.
	 * @param birthDate Date de nascimento do usuário.
	 */
	public void setBirthDate(String birthDate) {
		if(birthDate == null)
			return;

		this.birthDate = LocalDate.parse(birthDate,
				Utils.dateFormat);
	}

	/**
	 * Método para se alterar o identificador do usuário.
	 * @param id Identificador do usuário.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	/**
	 * Método para se alterar o apelido do usuário.
	 * (apenas para valores diferentes de vazio).
	 * @param nickname Apelido do usuário.
	 */
	public void setNickname(String nickname) {
		if(nickname == null)
			return;

		nickname = nickname.trim();

		if(!nickname.equals("")) {
			this.nickname = nickname;
		}
	}
}
