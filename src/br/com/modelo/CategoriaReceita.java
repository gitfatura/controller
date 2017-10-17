package br.com.modelo;


/**
 *Essa classe é responsavel por representar todas categorias das receitas.
 *@author Tiago Santos de Lima
 *@since 1.8
 *@version 1.0
 */
public class CategoriaReceita {

	private int id;
	private String descricao;

	public CategoriaReceita() {
	}

	public CategoriaReceita(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
