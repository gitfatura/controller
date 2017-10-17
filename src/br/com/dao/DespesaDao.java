package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import br.com.modelo.Despesa;

public class DespesaDao implements Assinatura<Despesa> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	@Override
	public void adiciona(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO despesa" 
					+ "(valor," 
					+ "categoria," 
					+ "data," 
					+ "nota)" 
					+ "VALUES(?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			ps.setDouble(1, despesa.getValor());
			ps.setInt(2, despesa.getIdcategoria());
			ps.setDate(3, new java.sql.Date(despesa.getData().getTime()));
			ps.setString(4, despesa.getNota());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao adicionar a despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}

	}

	@Override
	public void update(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE despesa SET" 
					+ " valor=?," 
					+ " categoria=?," 
					+ " data=?," 
					+ " nota=? " 
					+ " WHERE id=?";

			ps = conexao.prepareStatement(sql);
			ps.setDouble(1, despesa.getValor());
			ps.setInt(2, despesa.getIdcategoria());
			ps.setDate(3, new java.sql.Date(despesa.getData().getTime()));
			ps.setString(4, despesa.getNota());
			ps.setInt(5, despesa.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar a despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

	@Override
	public void remove(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "DELETE FROM despesa WHERE id =?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, despesa.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao remover a despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

	@Override
	public Despesa buscarPorId(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "select d.id, d.valor, d.data, c.descricao from despesa d inner join categoria_despesa c on d.categoria = c.id WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, despesa.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setData(rs.getDate("data"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a despesa pelo id " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesa;

	}
	
	@Override
	public List<Despesa> buscarTodos() throws Exception {
		Despesa despesa = null;
		List<Despesa> despesas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "select d.id, d.valor, d.data, c.descricao from despesa d inner join categoria_despesa c on d.categoria = c.id";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setData(rs.getDate("data"));
				despesas.add(despesa);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas despesas  " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesas;
		
	}
	
	public List<Despesa> buscarTodosPorData(String inicio, String fim) throws Exception {
		Despesa despesa = null;
		List<Despesa> despesas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM despesa WHERE data BETWEEN ? AND ?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, inicio);
			ps.setString(2, fim);
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getDouble("valor"));
				//despesa.setCategoria(rs.getInt("categoria"));
				despesa.setData(rs.getDate("data"));
				despesa.setNota(rs.getString("nota"));
				despesas.add(despesa);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas despesa por data " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesas;
		
	}
	
	public List<Despesa> buscarTodosDataAtual(String data) throws Exception {
		Despesa despesa = null;
		List<Despesa> despesas = new ArrayList<>();
		try {
			conexao = Conexao.getConnection();
			String sql = "SELECT * FROM despesa WHERE MONTH(data) =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getDouble("valor"));
				//despesa.setCategoria(rs.getInt("categoria"));
				despesa.setData(rs.getDate("data"));
				despesa.setNota(rs.getString("nota"));
				despesas.add(despesa);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas despesa por data atual " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesas;
		
	}
	
	
	
}
