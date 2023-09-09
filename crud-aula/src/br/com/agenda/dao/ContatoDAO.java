package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	/*
	 * Aqui é feito o CRUD. Aqui é onde o JAVA se molda à estrutura do BD.
	 * c: CREATE
	 * r: READ
	 * u: UPDATE
	 * d: DELETE
	 */
	
	// MÉTODO USADO PARA SALVAR UM OBJETO NO BANCO DE DADOS
	
	// mapeamento da assinatura do método com os parâmetros e passando a importação da classe contato
	public void save(Contato contato) {
		// os pontos de ? são anotações que serão substituidos quando forem passados parâmetros
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?,?,?)";
		
		//Ainda não existe a conexão
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//tentativa de conexão com o banco
		try {
			// Cria a conexão com o BD chamando a classe Connection Factory
			conn = ConnectionFactory.createConnectionToMySQL();
			// passando a string de execução sql 
			pstm = conn.prepareStatement(sql);
			
			// Adiciona os 3 valores esperados pela Query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			java.util.Date dataUtil = contato.getDataCadastro();
			java.sql.Date dataSQL = new java.sql.Date(dataUtil.getTime());
			pstm.setDate(3, dataSQL);
			
			//Execução da query
			pstm.execute();
		} catch(Exception e) {
			// Caso der alguma exception, ele mostra no console
			e.printStackTrace();
		} finally {
			try {
				// Fecha as conexões caso for != de null
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
