package br.com.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.Calcula;
import br.com.dao.ReceitaDao;
import br.com.modelo.Receita;

public class ReceitaService extends HttpServlet implements AssinaturaService {

	private static final long serialVersionUID = 1L;

	private ReceitaDao dao = new ReceitaDao();
	private Calcula calcula = new Calcula();

	@Override
	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Receita receita = new Receita();

			String valor = request.getParameter("valor");
			String categoria = request.getParameter("categoria");
			String data = request.getParameter("data");
			Date dataformatada = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			receita.setValor(Double.parseDouble(valor));
			receita.setIdCategoria(Integer.parseInt(categoria));
			receita.setData(dataformatada);
			dao.adiciona(receita);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Receita receita = new Receita();

			String id = request.getParameter("id");
			String valor = request.getParameter("valor").replace("R$", "").replace(",", ".");
			String categoria = request.getParameter("categoria");
			String data = request.getParameter("data");
			Date dataformatada = new SimpleDateFormat("yyyy-MM-dd").parse(data);

			receita.setId(Integer.parseInt(id));
			receita.setValor(Double.parseDouble(valor));
			receita.setIdCategoria(Integer.parseInt(categoria));
			receita.setData(dataformatada);

			dao.update(receita);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String id = request.getParameter("id");
			Receita receita = new Receita();
			receita.setId(Integer.parseInt(id));
			dao.remove(receita);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void buscarPorId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String id = request.getParameter("id");
			
			Receita receitaObj = new Receita();
			
			receitaObj.setId(Integer.parseInt(id));

			Receita receita = dao.buscarPorId(receitaObj);
			
			request.setAttribute("receita", receita);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void buscarTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Receita> receitas = dao.buscarTodos();
			request.setAttribute("receitas", receitas);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void calculaReceitaFinal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Double somareceitas = calcula.calculaReceitaFinal();
			request.setAttribute("somareceitas", somareceitas);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

}
