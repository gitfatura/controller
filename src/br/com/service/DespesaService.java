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
import br.com.dao.DespesaDao;
import br.com.modelo.Despesa;

public class DespesaService extends HttpServlet implements AssinaturaService {

	private static final long serialVersionUID = 1L;

	private DespesaDao despesaDao = new DespesaDao();
	private Calcula calcula = new Calcula();

	@Override
	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Despesa despesa = new Despesa();
			
			String valor = request.getParameter("valor");
			String categoria = request.getParameter("categoria");
			String data = request.getParameter("data");
			Date dataformatada = new SimpleDateFormat("yyyy-MM-dd").parse(data);

			despesa.setValor(Double.parseDouble(valor));
			despesa.setIdcategoria(Integer.parseInt(categoria));
			despesa.setData(dataformatada);
			despesaDao.adiciona(despesa);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Despesa despesa = new Despesa();

			String id = request.getParameter("id");
			String valor = request.getParameter("valor").replace("R$", "").replace(",",".");
			String categoria = request.getParameter("categoria");
			String data = request.getParameter("data");
			Date dataformatada = new SimpleDateFormat("yyyy-MM-dd").parse(data);

			despesa.setId(Integer.parseInt(id));
			despesa.setValor(Double.parseDouble(valor));
			despesa.setIdcategoria(Integer.parseInt(categoria));
			despesa.setData(dataformatada);

			despesaDao.update(despesa);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String id = request.getParameter("id");
			Despesa despesa = new Despesa();
			despesa.setId(Integer.parseInt(id));
			despesaDao.remove(despesa);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void buscarPorId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String id = request.getParameter("id");
			
			Despesa despesaObj = new Despesa();
			
			despesaObj.setId(Integer.parseInt(id));
			
			Despesa despesa = despesaDao.buscarPorId(despesaObj);
			
			request.setAttribute("despesa", despesa);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void buscarTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Despesa> despesas = despesaDao.buscarTodos();
			request.setAttribute("despesas", despesas);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public void calculaTodasDespesas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Double somadespesas = calcula.calculaTodasDespesas();
			request.setAttribute("somadespesas", somadespesas);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
