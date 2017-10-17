package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.CategoriaDespesaService;
import br.com.service.DespesaService;

@WebServlet({ "/adiciona-categoria-despesa", "/busca-todas-categoria-despesa","/nova-categoria-despesa" })
public class CategoriaDespesaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
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
			
			if (uri.equalsIgnoreCase(path + "/nova-categoria-despesa")) {
				request.getRequestDispatcher("/categoria-despesa.jsp").forward(request, response);
			}

			if (uri.equalsIgnoreCase(path + "/adiciona-categoria-despesa")) {
				if (method.equalsIgnoreCase("post")) {
					categoriaDespesaService.adiciona(request, response);
					response.sendRedirect(path+"/nova-categoria-despesa");
					return;
				}
			}
			
			 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
