package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.CategoriaReceitaService;
import br.com.service.ReceitaService;

@WebServlet({ "/adiciona-receita", "/update-receita", "/remover-receita", "/busca-receita", "/receitas",
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
			
			if (uri.equalsIgnoreCase(path + "/receitas")) {
				receitaService.buscarTodos(request, response);
				request.getRequestDispatcher("/receitas.jsp").forward(request, response);
			}
			
			if (uri.equalsIgnoreCase(path + "/busca-receita")) {
				receitaService.buscarPorId(request, response);
				categoriaReceitaService.buscaTodos(request, response);
				request.getRequestDispatcher("/update-receita.jsp").forward(request, response);
			}
			
			if (uri.equalsIgnoreCase(path + "/update-receita")) {
				receitaService.update(request, response);
				request.getRequestDispatcher("/receitas.jsp").forward(request, response);
			}
			
			if (uri.equalsIgnoreCase(path + "/remover-receita")) {
				receitaService.remove(request, response);
				response.sendRedirect(path+"/receitas");
			}



			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
