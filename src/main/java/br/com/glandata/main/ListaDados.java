package br.com.glandata.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.glanda.factory.ConnectionFactory;

public class ListaDados {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.abreConexao();

		PreparedStatement pstm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		pstm.execute();
		ResultSet rst = pstm.getResultSet();
		while(rst.next()) {
			
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			
			System.out.println("ID: "+id);
			System.out.println("Nome: "+nome);
			System.out.println("Descrição: "+descricao);
			System.out.println("\n");
		}
		rst.close();
		pstm.close();
		connection.close();
	}
}
