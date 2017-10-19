package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.modelo.Receita;

public class ReceitaDao implements Assinatura<Receita> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	@Override
	public void adiciona(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO receita" + "(valor," + "categoria," + "data," + "nota)" + "VALUES(?,?,?,?)";

			ps = conexao.prepareStatement(sql);

			ps.setDouble(1, receita.getValor());
			ps.setInt(2, receita.getIdCategoria());
			ps.setDate(3, new java.sql.Date(receita.getData().getTime()));
			ps.setString(4, receita.getNota());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao adicionar a receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}

	}

	@Override
	public void update(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE receita SET" 
						+ " valor=?," 
						+ " categoria=?," 
						+ " data=?," 
						+ " nota=? " 
						+ " WHERE id=?";

			ps = conexao.prepareStatement(sql);

			ps.setDouble(1, receita.getValor());
			ps.setInt(2, receita.getIdCategoria());
			ps.setDate(3, new java.sql.Date(receita.getData().getTime()));
			ps.setString(4, receita.getNota());
			ps.setInt(5, receita.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar a receita " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

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

	@Override
	public Receita buscarPorId(Receita receita) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "select r.id, r.valor, r.data, r.nota, r.categoria, c.descricao from receita r inner join categoria_receita c on r.categoria = c.id where r.id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, receita.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new Receita();
				receita.setId(rs.getInt("r.id"));
				receita.setValor(rs.getDouble("valor"));
				receita.setDescricao(rs.getString("descricao"));
				receita.setData(rs.getDate("data"));
				receita.setNota(rs.getString("nota"));
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
	
	public List<Receita> buscarTodosPorData(String inicio, String fim) throws Exception {
		Receita receita = null;
		List<Receita> receitas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM receita WHERE data BETWEEN ? AND ?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, inicio);
			ps.setString(2, fim);
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new Receita();
				receita.setId(rs.getInt("id"));
				receita.setValor(rs.getDouble("valor"));
				receita.setDescricao(rs.getString("categoria"));
				receita.setData(rs.getDate("data"));
				receita.setNota(rs.getString("nota"));
				receitas.add(receita);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas receita por data " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return receitas;


		
	}

	
	public List<Receita> buscarTodosDataAtual(String data) throws Exception {
		Receita receita = null;
		List<Receita> receitas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM receita WHERE MONTH(data) =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			while (rs.next()) {
				receita = new Receita();
				receita.setId(rs.getInt("id"));
				receita.setValor(rs.getDouble("valor"));
				receita.setDescricao(rs.getString("categoria"));
				receita.setData(rs.getDate("data"));
				receita.setNota(rs.getString("nota"));
				receitas.add(receita);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas receita por data atual " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return receitas;


		
	}

	 

}
