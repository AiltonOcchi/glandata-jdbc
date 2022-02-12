package br.com.glandata.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.glanda.factory.ConnectionFactory;

public class InsereDadosControleTransacao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.abreConexao()){
			
			// desabilita o commit automatico 
			connection.setAutoCommit(false);

			try (PreparedStatement pstm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);){
			
				adicionaProduto("Fonde de Ovido", "Super Bass", pstm);
				adicionaProduto("Apple", "Smart Watch", pstm);

				// commita tudo caso a transação não possua erro
				connection.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("EXECUTOU ROLLBACK ");
				connection.rollback();
			}finally {
				connection.close();
			}
		}
	}

	private static void adicionaProduto(String nome, String descricao, PreparedStatement pstm) throws SQLException {
		pstm.setString(1, nome);
		pstm.setString(2, descricao);

		if(nome.equals("Xiaomi")) {
			throw new RuntimeException("Não foi possível adicionar o produto, não temos permissão pra vender Xiaomi");
		}
		
		// executa o pstatemente
		pstm.execute();

		try(ResultSet rst = pstm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
}


