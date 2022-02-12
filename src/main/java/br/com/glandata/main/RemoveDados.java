package br.com.glandata.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.glanda.factory.ConnectionFactory;

public class RemoveDados {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.abreConexao();

		PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		pstm.setInt(1, 2);
		pstm.execute();

		Integer linhasModificadas = pstm.getUpdateCount();

		System.out.println("Registros removidos: " + linhasModificadas);
		pstm.close();
		connection.close();
	}

}
