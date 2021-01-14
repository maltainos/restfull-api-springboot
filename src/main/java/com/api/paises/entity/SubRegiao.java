package com.api.paises.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @see Regiao
 * @see Pais
 * @author Nelson Zaona Joao Albino
 *
 */
@Entity
@Table(name = "sub_regioes")
public class SubRegiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;

	@ManyToOne
	private Regiao regiao;

	/**
	 * @see SubRegiao nao usado
	 */
	@SuppressWarnings("unused")
	protected SubRegiao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see SubRegiao usavel para criacao de instancias definindo as parametros
	 *      abaixo
	 * @param id
	 * @param nome
	 * @param regiao
	 */
	public SubRegiao(long id, String nome, Regiao regiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.regiao = regiao;
	}

	/**
	 * 
	 * @return id da SubRegiao
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return nome da SubRegiao
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return regiao da SubRegiao
	 */
	public Regiao getRegiao() {
		return regiao;
	}

	/**
	 * 
	 * @param id define o id da SubRegiao
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param nome da SubRegiao
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @param regiao da SubRegiao
	 */
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	/**
	 * @return informacoes da SubRegiao includiio a Regiao e o Pais
	 */
	@Override
	public String toString() {
		return String.format("SubRegiao [id=%s, nome=%s, regiao=%s]", id, nome, regiao);
	}
}
