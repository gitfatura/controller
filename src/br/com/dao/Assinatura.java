package br.com.dao;

import java.util.List;

/**
 *Assinatura dos metodos daos.
 *@author Tiago Santos de lima
 *@since 1.8
 *@version 1.0 
 *@see DespesaDao
 *@see ReceitaDao
 *@see CategoriaDespesaDao
 *@see CategoriaReceitaDao
 */
public interface Assinatura<T> {
	 default void adiciona(T t)throws Exception{}
	 default void update(T t)throws Exception{}
	 default void remove(T t)throws Exception{}
	 default T buscarPorId(T t)throws Exception{return null;}
	 default List<T> buscarTodos()throws Exception{return null;}
}
