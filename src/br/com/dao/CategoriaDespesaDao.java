package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import br.com.modelo.CategoriaDespesa;


/**
 *Essa classe é utilizada para realizar as interações da categoria e da despesa com o banco de dados.
 *@author Tiago Santos de Lima  
 *@since 1.8
 *@version 1.0
 */
public class CategoriaDespesaDao implements Assinatura<CategoriaDespesa> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;
	
	
	/**
	 * Esse metodo adiciona todas as categorias das despesas no banco de dados.
	 *
	 */
	@Override
	public void adiciona(CategoriaDespesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO categoria_despesa(descricao) VALUES (?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, despesa.getDescricao());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar a categoria_despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

	@Override
	public List<CategoriaDespesa> buscarTodos() throws Exception {
		CategoriaDespesa despesa = null;
		List<CategoriaDespesa> despesas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM categoria_despesa";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new CategoriaDespesa();
				despesa.setId(rs.getInt("id"));
				despesa.setDescricao(rs.getString("descricao"));
				despesas.add(despesa);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas categoria_despesa  " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesas;
	}
}
