package br.com.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * Essa classe faz a conexao com banco de dados.
 * @author Tiago Santos de Lima.
 * @since 1.8
 * @version 1.0
 */
public class Conexao {

	private static Connection connection;

	/**
	 * faz a conexao com com banco
	 * @return conexao 
	 */
	public static Connection getConnection() throws Exception {

		try {

			if (connection ==null || connection.isClosed()) {
				
				Class.forName("com.mysql.jdbc.Driver");//Força o drive do banco de dados
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/controller", "root", "pcjava#@");//Caminho do bando de dados
			}
			
		} catch (Exception e) {//Captura a exeção
			System.out.println("Erro ao conectar com a mysql :"+e.getMessage());
		}
		return connection;//Retorna a conexao.
	}

}
