package com.api.paises.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @see Pais
 * @author Nelson Zaona Joao Albino
 *
 */
@Entity
@Table(name = "regioes")
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;

	@ManyToOne
	private Pais pais;

	@SuppressWarnings("unused")
	protected Regiao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @apiNote Construtor usavel da Regiao que inicializa os atributos
	 * @param id
	 * @param nome
	 * @param pais
	 */
	public Regiao(long id, String nome, Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	/**
	 * 
	 * @return id da regiao
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return nome da Regiao
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return pais da Regia
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * 
	 * @param id é definido
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param nome é definido
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @param pais é definido para a regiao
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return Regaio e Seu Resppectivo Pais
	 */
	@Override
	public String toString() {
		return String.format("Regiao [id=%s, nome=%s, pais=%s]", id, nome, pais);
	}
}
