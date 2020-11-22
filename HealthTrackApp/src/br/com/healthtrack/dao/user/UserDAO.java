package br.com.healthtrack.dao.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.healthtrack.singleton.DataBaseManager;
import br.com.healthtrack.bean.user.User;
import br.com.healthtrack.dao.DAOInterface;

/**
 * Classe responsável por manipular entidades do tipo
 * usuário, no banco de dados.
 * @author Afonso de Sousa Costa
 * @version 1.0
 */
public class UserDAO implements DAOInterface<User>{
	private Connection conn;
	private static final String TABLE_NAME = "T_HT_USER";
	private StringBuilder sqlQuery = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	/**
	 * Método para se inserir (persistir) um usuário no
	 * banco de dados.
	 * @param user Objeto tipo usuário a ser inserido
	 * (persistido) no banco de dados.
	 */
	@Override
	public void create(User user) {
		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("INSERT INTO ")
					.append(TABLE_NAME)
					.append("(")
					.append("USER_ID, ")
					.append("EMAIL, ")
					.append("PASSWORD, ")
					.append("NICKNAME, ")
					.append("BIRTH_DATE")
					.append(")")
					.append("VALUES (SQ_HT_USER.NEXTVAL, ?, ?, ?, ?)");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNickname());
			stmt.setDate(4, Date.valueOf(user.getBirthDate()));

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy(int... userId) {
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	/**
	 * Método para pesquisar um usuário no banco de dados,
	 * a partir de seu identificador.
	 * @param userId Identificador do usuário no banco
	 * de dados.
	 */
	@Override
	public User searchById(int... userId) {
		User user = null;

		sqlQuery = new StringBuilder();

		try {
			conn = DataBaseManager.getConnection();

			sqlQuery.append("SELECT * FROM ")
					.append(TABLE_NAME)
					.append(" WHERE USER_ID = ?");

			stmt = conn.prepareStatement(sqlQuery.toString());

			stmt.setInt(1, userId[0]);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int id               = rs.getInt("USER_ID");
				String email         = rs.getString("EMAIL");
				String password      = rs.getString("PASSWORD");
				String nickname      = rs.getString("NICKNAME");
				LocalDate birthDate  = rs.getDate("BIRTH_DATE").toLocalDate();

				user = new User(id, email, password, birthDate, nickname);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				rs.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public void update(User record) {
		// TODO Auto-generated method stub
	}
}
