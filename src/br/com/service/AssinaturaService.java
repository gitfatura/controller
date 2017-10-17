package br.com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *Assinatura dos metodos services
 *@author Tiago Santos de lima
 *@since 1.8
 *@version 1.0 
 *@see DespesaService
 *@see ReceitaService
 */
public interface AssinaturaService {

	default void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	default void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	default void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	default void buscarPorId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	default void buscarTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
