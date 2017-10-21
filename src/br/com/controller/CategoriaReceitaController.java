package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.CategoriaReceitaService;

@WebServlet({ "/adiciona-categoria-receita", "/busca-todas-categoria-receita", "/nova-categoria-receita" })
public class CategoriaReceitaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoriaReceitaService categoriaReceitaService = new CategoriaReceitaService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	private void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String uri = request.getRequestURI();
			String path = request.getContextPath();
			String method = request.getMethod();

			if (uri.equalsIgnoreCase(path + "/nova-categoria-receita")) {
				request.getRequestDispatcher("/categoria-receita.jsp").forward(request, response);
			}

			if (uri.equalsIgnoreCase(path + "/adiciona-categoria-receita")) {
				if (method.equalsIgnoreCase("post")) {
					categoriaReceitaService.adiciona(request, response);
					response.sendRedirect(path + "/nova-categoria-receita");
					return;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
