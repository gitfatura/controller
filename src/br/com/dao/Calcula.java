package br.com.dao;

import java.util.List;

import br.com.modelo.Despesa;
import br.com.modelo.Receita;

/**
 *Essa classe realiza calculos da despesa e da receita.
 *@author Tiago Santos de Lima.
 *@since 1.8
 *@version 1.0 
 */
public class Calcula {
	
	private DespesaDao despesaDao = new DespesaDao();
	private ReceitaDao receitaDao = new ReceitaDao();

	/**
	 * Calcula todas receitas.
	 * @return a soma de todas receitas - as dispesas
	 */
	public Double calculaReceitaFinal() throws Exception {
		double receitas = calculaTodasReceitas();
		double despesas = calculaTodasDespesas();
		return receitas - despesas;
	}
	
	/**
	 * Calcula todas receitas.
	 * @return a soma de todas receitas.
	 */
	public double calculaTodasReceitas() throws Exception {
		double soma = 0;
		List<Receita> receitas = receitaDao.buscarTodos();
		for (Receita receita : receitas) {
			soma += receita.getValor();
		}
		return soma;
	}
	
	/**
	 * Calcula todas despesas.
	 * @return a soma de todas despesas.
	 */
	public Double calculaTodasDespesas() throws Exception {
		double soma = 0;
		List<Despesa> despesas = despesaDao.buscarTodos();
		for (Despesa despesa : despesas) {
			soma += despesa.getValor();
		}
		return soma;
	}
	
	 
}
