package br.com.modelo;

import java.util.Date;

/**
 * Essa classe é responsavel por representar todas Despesas.
 * 
 * @author Tiago Santos de Lima
 * @since 1.8
 * @version 1.0
 */
public class Despesa {

	private int id;
	private double valor;
	private int idcategoria;
	private String descricao;
	private Date data;

	public Despesa() {
	}

	public Despesa(int id, double valor, int idcategoria, String descricao, Date data) {
		super();
		this.id = id;
		this.valor = valor;
		this.idcategoria = idcategoria;
		this.descricao = descricao;
		this.data = data;
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

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
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

}
