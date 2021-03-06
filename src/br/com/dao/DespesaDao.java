package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import br.com.modelo.Despesa;

/**
 *Essa classe DespesaDao é utilizada para realizar as interações com o banco de dados.
 *@author Tiago Santos de Lima
 *@since 1.8
 *@version 1.0 
 */
public class DespesaDao implements Assinatura<Despesa> {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	/**
	 * insere a despesa no banco de dados.
	 */
	@Override
	public void adiciona(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO despesa(valor,categoria,data) VALUES (?,?,?)";

			ps = conexao.prepareStatement(sql);
			ps.setDouble(1, despesa.getValor());
			ps.setInt(2, despesa.getIdcategoria());
			ps.setDate(3, new java.sql.Date(despesa.getData().getTime()));
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Erro ao adicionar a despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}

	}

	
	/**
	 * atualiza a despesa no banco de dados.
	 */
	@Override
	public void update(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE despesa SET" + " valor=?," + " categoria=?," + " data=?" + " WHERE id=?";

			ps = conexao.prepareStatement(sql);
			ps.setDouble(1, despesa.getValor());
			ps.setInt(2, despesa.getIdcategoria());
			ps.setDate(3, new java.sql.Date(despesa.getData().getTime()));
			ps.setInt(4, despesa.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar a despesa " + e);
		} finally {
			conexao.close();
			ps.close();
		}
	}

	/**
	 * remove a despesa no banco de dados.
	 */
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

	/**
	 * busca a despesa no banco de dados pelo codigo (id).
	 */
	@Override
	public Despesa buscarPorId(Despesa despesa) throws Exception {
		try {
			conexao = Conexao.getConnection();
			String sql = "select d.id, d.valor, d.data, d.categoria, c.descricao from despesa d inner join categoria_despesa c on d.categoria = c.id WHERE d.id =?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, despesa.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setData(rs.getDate("data"));
				despesa.setIdcategoria(rs.getInt("categoria"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a despesa pelo id " + e);
		} finally {
			conexao.close();
			ps.close();
		}
		return despesa;

	}

	/**
	 * busca no banco de dados todas as despesas.
	 * @return despesas
	 */
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

}
