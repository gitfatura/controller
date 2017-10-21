package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.Calcula;
import br.com.service.DespesaService;
import br.com.service.ReceitaService;

@WebServlet({"/geral","/grafico-despesa","/grafico-receita"})
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DespesaService despesaService = new DespesaService();
	private ReceitaService receitaService = new ReceitaService();

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

			if (uri.equalsIgnoreCase(path+"/geral")) {
				despesaService.buscarTodos(request, response);
				despesaService.calculaTodasDespesas(request, response);
				receitaService.calculaReceitaFinal(request, response);
				receitaService.buscarTodos(request, response);
				request.getRequestDispatcher("/geral.jsp").forward(request, response);
			} 
			
			if(uri.equalsIgnoreCase(path+"/grafico-despesa")) {
				despesaService.buscarTodos(request, response);
				request.getRequestDispatcher("/grafico-despesa.jsp").forward(request, response);
			}
			
			if(uri.equalsIgnoreCase(path+"/grafico-receita")) {
				receitaService.buscarTodos(request, response);
				request.getRequestDispatcher("/grafico-receita.jsp").forward(request, response);
			} 

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
