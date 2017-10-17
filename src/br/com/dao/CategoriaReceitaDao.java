package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.modelo.CategoriaReceita;

public class CategoriaReceitaDao implements Assinatura<CategoriaReceita> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	@Override
	public void adiciona(CategoriaReceita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO categoria_receita(descricao) VALUES (?)";

			ps = conexao.prepareStatement(sql);

			ps.setString(1, receita.getDescricao());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao adicionar a categoria_receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}

	}

	@Override
	public List<CategoriaReceita> buscarTodos() throws Exception {
		CategoriaReceita receita = null;
		List<CategoriaReceita> receitas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM categoria_receita";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new CategoriaReceita();
				receita.setId(rs.getInt("id"));
				receita.setDescricao(rs.getString("descricao"));
				receitas.add(receita);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas categoria_receita  " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return receitas;

	}

}
