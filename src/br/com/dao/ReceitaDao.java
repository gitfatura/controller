package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.modelo.Receita;

/**
 *Essa classe ReceitaDao é utilizada para realizar as interações com o banco de dados.
 *@author Tiago Santos de Lima
 *@since 1.8
 *@version 1.0 
 */
public class ReceitaDao implements Assinatura<Receita> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	/**
	 * insere a receita no banco de dados.
	 */
	@Override
	public void adiciona(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO receita(valor, categoria, data) VALUES(?,?,?)";

			ps = conexao.prepareStatement(sql);

			ps.setDouble(1, receita.getValor());
			ps.setInt(2, receita.getIdCategoria());
			ps.setDate(3, new java.sql.Date(receita.getData().getTime()));
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao adicionar a receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}

	}
	/**
	 * atualiza a receita no banco de dados.
	 */
	@Override
	public void update(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE receita SET" 
						+ " valor=?," 
						+ " categoria=?," 
						+ " data=?" 
						+ " WHERE id=?";

			ps = conexao.prepareStatement(sql);

			ps.setDouble(1, receita.getValor());
			ps.setInt(2, receita.getIdCategoria());
			ps.setDate(3, new java.sql.Date(receita.getData().getTime()));
			ps.setInt(4, receita.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar a receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}
	
	/**
	 * remove a receita do banco de dados.
	 */
	@Override
	public void remove(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM receita WHERE id =?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, receita.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao remover a receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

	/**
	 * busca a receita no banco de dados pelo id (codigo).
	 */
	@Override
	public Receita buscarPorId(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "select r.id, r.valor, r.data, r.categoria, c.descricao from receita r inner join categoria_receita c on r.categoria = c.id where r.id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, receita.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new Receita();
				receita.setId(rs.getInt("r.id"));
				receita.setValor(rs.getDouble("valor"));
				receita.setDescricao(rs.getString("descricao"));
				receita.setData(rs.getDate("data"));
				receita.setIdCategoria(rs.getInt("categoria"));
					
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a receita pelo id " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return receita;

	}
	/**
	 * busca todas receitas no banco de dados.
	 */
	@Override
	public List<Receita> buscarTodos() throws Exception {
		Receita receita = null;
		List<Receita> receitas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select r.valor, r.data, r.id, c.descricao from receita r inner join categoria_receita c on r.categoria = c.id";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new Receita();
				receita.setId(rs.getInt("id"));
				receita.setValor(rs.getDouble("valor"));
				receita.setDescricao(rs.getString("descricao"));
				receita.setData(rs.getDate("data"));
				receitas.add(receita);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas receita  " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return receitas;
		
	}
	 
}
