package br.com.healthtrack;

import java.sql.Connection;
import java.sql.SQLException;


public class TesteDeConexao {

	  public static void main(String[] args) {
		  try {
			  Connection conn = DataBaseManager.getConnection();
			  System.out.println("Conectou!");
			  
			  conn.close();
			  
		  }catch (SQLException e) {
		      System.err.println("Não foi possível conectar no Banco de Dados");
		      e.printStackTrace();
		  }
	 }
}

/*
   try {
		      //Registra o Driver
		      Class.forName("oracle.jdbc.driver.OracleDriver");

		      //Abre uma conexão
		      Connection conexao = DriverManager.getConnection(
		          "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM85337", "110288");
		      
		      System.out.println("Conectado!");
		      
		      //Fecha a conexão
		      conexao.close();
		      
		    //Tratamento de erro  
		    } catch (SQLException e) {
		      System.err.println("Não foi possível conectar no Banco de Dados");
		      e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		      System.err.println("O Driver JDBC não foi encontrado!");
		      e.printStackTrace();
		    }
		  }
*/




