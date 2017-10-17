package br.com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.CategoriaReceitaDao;
import br.com.modelo.CategoriaReceita;

public class CategoriaReceitaService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoriaReceitaDao dao = new CategoriaReceitaDao();

	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String categoria = request.getParameter("categoria");
			CategoriaReceita receita = new CategoriaReceita();
			receita.setDescricao(categoria);
			dao.adiciona(receita);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void buscaTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CategoriaReceita> categoriasreceitas = dao.buscarTodos();
			request.setAttribute("categoriasreceitas", categoriasreceitas);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
