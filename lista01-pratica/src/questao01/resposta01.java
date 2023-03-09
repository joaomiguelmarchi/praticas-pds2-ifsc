package questao01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class resposta01 {
	final static String databaseName = "lista01";

	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ "?serverTimezone=UTC","root","aluno");
			String queryCreateDatabase = "CREATE DATABASE"+ databaseName;
			String queryCreateTable = "CREATE TABLE IF NOT EXISTS pessoa (\r\n"
					+ " idpessoa int AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ " name VARCHAR(45) NOT NULL, \r\n"
					+ " cpf VARCHAR(45) NOT NULL, \r\n"
					+ ")";
			Statement stm = conexao.createStatement();
			stm.executeQuery(queryCreateDatabase);
			
			conexao.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}
}
