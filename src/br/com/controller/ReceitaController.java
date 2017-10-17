package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.CategoriaReceitaService;
import br.com.service.ReceitaService;

@WebServlet({ "/adiciona-receita", "/update-receita", "/remove-receita", "/busca-receita", "/todas-receitas",
		"/nova-receita" })
public class ReceitaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReceitaService receitaService = new ReceitaService();
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
			
			if (uri.equalsIgnoreCase(path + "/nova-receita")) {
				categoriaReceitaService.buscaTodos(request, response);
				request.getRequestDispatcher("/receita.jsp").forward(request, response);
			}

			if (uri.equalsIgnoreCase(path + "/adiciona-receita")) {
				if (method.equalsIgnoreCase("post")) {
					receitaService.adiciona(request, response);
					response.sendRedirect(path+"/nova-receita");
					return;
				}
				
			}
			
			if (uri.equalsIgnoreCase(path + "/todas-catagorias-receitas")) {
				receitaService.buscarTodos(request, response);
				
				request.getRequestDispatcher("/geral.jsp").forward(request, response);
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
