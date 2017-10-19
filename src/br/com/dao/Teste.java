package br.com.dao;

import br.com.modelo.Receita;

public class Teste {

	public static void main(String[] args) {

		try {

			Receita receita;
			receita = new Receita();
			receita.setId(7);
			Receita buscarPorId = new ReceitaDao().buscarPorId(receita);
			System.out.println(buscarPorId.getId());
			System.out.println(buscarPorId.getIdCategoria());
			System.out.println(buscarPorId.getValor());
			System.out.println(buscarPorId.getDescricao());
			System.out.println(buscarPorId.getData());
			System.out.println(buscarPorId.getNota());
			
			
			// String data = "2017-10-12";

			// String[] pega = data.split("-");
			//
			// double calculaTodasReceitas = calcula.calculaTodasReceitas();
			// System.out.println(calculaTodasReceitas);
			//
			// Double calculaTodasDespesas = calcula.calculaTodasDespesas();
			// System.out.println(calculaTodasDespesas);
			//
			// Double calculaReceitaFinal = calcula.calculaReceitaFinal();
			// System.out.println(calculaReceitaFinal);
			//
			//
			// String data ="2017-10-10";
			// String[] nova = data.split("-");
			//
			// List<Receita> buscarTodos = dao.buscarTodosDataAtual(nova[1]);
			//
			// buscarTodos.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
