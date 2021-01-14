package com.api.paises.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Nelson Zaonna Joao Albino
 * @apiNote Cricao de Uma entidade a ser Mapeada bo banco de dados como tabela
 *          Paises
 *
 */
@Entity
@Table(name = "paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String capital;

	/**
	 * @apiNote Construtor padrao protegido nao usado
	 */
	@SuppressWarnings("unused")
	protected Pais() {
	}

	/**
	 * @apiNote Construtor usado para criacao de instancias
	 * @param id
	 * @param nome
	 * @param capital
	 */
	public Pais(long id, String nome, String capital) {
		super();
		this.id = id;
		this.nome = nome;
		this.capital = capital;
	}

	/**
	 * 
	 * @return capital do pais
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * 
	 * @return id do pais
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return o nome do pais
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param capital define capital do pais
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * 
	 * @param id define o id do pais
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param nome o nome do pais
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return retorna as informacoes do pais
	 */
	@Override
	public String toString() {
		return String.format("Pais [id=%s, nome=%s, capital=%s]", id, nome, capital);
	}
}
