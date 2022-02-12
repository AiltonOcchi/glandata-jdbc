package br.com.glandata.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.glanda.factory.ConnectionFactory;

public class InsereDadosPStatement {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.abreConexao();
		
		// PreparedStatemente evita o SQL Injection
		PreparedStatement pstm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		pstm.setString(1, "Samsung Galaxy S10");
		pstm.setString(2, "Tem uma câmera muito boa!");
		
		pstm.execute();

		ResultSet rst = pstm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		rst.close();
		pstm.close();
		connection.close();
	}
}
