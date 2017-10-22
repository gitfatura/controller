package br.com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.CategoriaDespesaDao;
import br.com.modelo.CategoriaDespesa;


public class CategoriaDespesaService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoriaDespesaDao dao = new CategoriaDespesaDao();

	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String categoria = request.getParameter("categoria");
			CategoriaDespesa despesa = new CategoriaDespesa();
			despesa.setDescricao(categoria);
			dao.adiciona(despesa);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void buscaTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CategoriaDespesa> categoriasdespesas = dao.buscarTodos();
			request.setAttribute("categoriasdespesas", categoriasdespesas);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
