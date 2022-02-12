package br.com.glandata.main;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.glanda.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		System.out.println("Conectando com o banco...");
		Connection connection = connectionFactory.abreConexao();
		System.out.println("Abriu a conexão");

		System.out.println("Fechando a conexão..");
		connection.close();
		System.out.println("Fechou a conexão");
	}

}
