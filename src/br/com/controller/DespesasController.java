package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.CategoriaDespesaService;
import br.com.service.DespesaService;

@WebServlet({ "/adiciona-despesa", "/update-despesa", "/remover-despesa", "/busca-despesas","/nova-despesa","/busca-despesa" })
public class DespesasController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
	private DespesaService dservice = new DespesaService();
	private CategoriaDespesaService categoriaDespesaService = new CategoriaDespesaService();

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
			
			if (uri.equalsIgnoreCase(path + "/nova-despesa")) {
				categoriaDespesaService.buscaTodos(request, response);
				request.getRequestDispatcher("/despesa.jsp").forward(request, response);
			}

			if (uri.equalsIgnoreCase(path + "/adiciona-despesa")) {
				if (method.equalsIgnoreCase("post")) {
					dservice.adiciona(request, response);
					response.sendRedirect(path+"/nova-despesa");
					return;
				}
			}
			
			if (uri.equalsIgnoreCase(path + "/busca-despesas")) {
				dservice.buscarTodos(request, response);
				request.getRequestDispatcher("/despesas.jsp").forward(request, response);
			}

			if (uri.equalsIgnoreCase(path + "/remover-despesa")) {
				dservice.remove(request, response);
				response.sendRedirect(path+"/busca-despesas");
			}
			
			if (uri.equalsIgnoreCase(path + "/busca-despesa")) {
				dservice.buscarPorId(request, response);
				categoriaDespesaService.buscaTodos(request, response);
				request.getRequestDispatcher("/update-despesa.jsp").forward(request, response);
			}
			if (uri.equalsIgnoreCase(path + "/update-despesa")) {
				dservice.update(request, response);
				response.sendRedirect(path+"/busca-despesas");
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
