package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Uc6j0(ym5769";
	
	// Sintaxe do caminho: padrãoDeConexão:tipoDeBanco://localDoBanco:porta/nomeDoDB;
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conexão com o DB
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	};
	
	public static void main(String[] args) throws Exception {
		//Recupera a conexão com o BD
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("Conexão bem sucedida");
			con.close();
		}
		
	}
	
}
