package com.api.paises.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.paises.entity.Regiao;
import com.api.paises.excepiton.RegiaoNotFoundException;
import com.api.paises.service.RegiaoDaoService;

/**
 * @see Regiao
 * @see RegiaoDaoService
 * @see RegiaoNotFoundException
 * @author Nelson Zaona Joao Albino
 *
 */
@RestController
@RequestMapping(path = "regioes")
public class RegiaoController {

	@Autowired
	private RegiaoDaoService regiaoDaoService;

	/**
	 * @apiNote Busca e Elimina uma regiao especifica e existente {@value id} usado
	 *          para buscar e deletar uma regia especifica
	 * @param id o identificador da regiao a ser eleminado
	 */
	@DeleteMapping(path = "/{id}")
	public void destroyRegiaoById(@PathVariable long id) {
		regiaoDaoService.destroyRegiaoById(id);
	}

	/**
	 * @apiNote criacao e recuperacao de uma regiao especifico de um pais
	 * @param regiao para ser criado
	 * @return url para recuperar da regiao inserido
	 */
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Regiao regiao) {
		Regiao savesRegiao = regiaoDaoService.insert(regiao);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
				.buildAndExpand(savesRegiao.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * 
	 * @return Lista de todos regiao
	 */
	@GetMapping
	public List<Regiao> retriveAllRegioes() {
		return regiaoDaoService.retriveAllRegioes();
	}

	/**
	 * @apiNote Busca uma Regiao especifica existente, caso o pai nao seja
	 *          encontrado lanca uma excecao
	 * @exception RegiaoNotFoundException {@value id} Sera usado na busca
	 * @param id que sera usado para busca da Regiao e o seu respectivo Pais
	 * @return Regiao especiificado com Pais
	 */
	@GetMapping(path = "/{id}")
	public Regiao retriveOneRegiao(@PathVariable long id) {
		Regiao regiao = regiaoDaoService.retriveOneRegiaoById(id);

		if (regiao == null)
			throw new RegiaoNotFoundException("Id -> " + id);
		return regiao;
	}

	/**
	 * @apiNote Busca e actualiza a regiao especifica o ID do Regiao mantem-se
	 * @param Regiao contendo as informcoes a serem actualizadas
	 * @return Regiao com informacoes actualizadas
	 */
	@PutMapping()
	public Regiao updateRegiaoById(@RequestBody Regiao regiao) {
		return regiaoDaoService.updateRegiao(regiao);
	}

}
