package br.com.modelo;

import java.util.Date;

/**
 *Essa classe é responsavel por representar todas Receitas. 
 *@author Tiago Santos de Lima
 *@since 1.8
 *@version 1.0
 */
public class Receita {

	private int id;
	private double valor;
	private int idCategoria;
	private String descricao;
	private Date data;
	private String nota;

	public Receita() {
	}

	public Receita(int id, double valor, int idCategoria, String descricao, Date data, String nota) {
		super();
		this.id = id;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.descricao = descricao;
		this.data = data;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	
}
