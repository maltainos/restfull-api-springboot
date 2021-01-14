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

import com.api.paises.entity.SubRegiao;
import com.api.paises.excepiton.SubRegiaoNotFoundException;
import com.api.paises.service.SubRegiaoDaoService;

/**
 * @see SubRegiao
 * @see SubRegiaoDaoService
 * @see SubRegiaoNotFoundException
 * @author Nelson Zaona Joao Albino
 *
 */
@RestController
@RequestMapping(path = "/subregioes")
public class SubRegiaoController {

	@Autowired
	private SubRegiaoDaoService subRegiaoDaoService;

	/**
	 * @apiNote Busca e Elimina uma SubRegiao especifica e existente {@value id}
	 *          usado para buscar e deletar uma SubRegia especificada
	 * @param id o identificador da SubRegiao a ser eleminada
	 */
	@DeleteMapping(path = "/{id}")
	public void destroySubRegiaoById(@PathVariable long id) {
		subRegiaoDaoService.destroySubRegiaoById(id);
	}

	/**
	 * @apiNote criacao e recuperacao de uma SubRegiao especifica de uma Regiao
	 *          Especifica
	 * @param subRegiao para ser criado
	 * @return url para recuperar da subRegiao inserido
	 */
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody SubRegiao subRegiao) {
		SubRegiao savesSubRegiao = subRegiaoDaoService.insert(subRegiao);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
				.buildAndExpand(savesSubRegiao.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * 
	 * @return Lista de todos SubRegioes
	 */
	@GetMapping
	public List<SubRegiao> retriveAllSubRegioes() {
		return subRegiaoDaoService.retriveAllSubRegioes();
	}

	/**
	 * @apiNote Busca uma SubRegiao especifica existente, caso a subRegiao nao seja
	 *          encontrada lanca uma excecao
	 * @exception SubRegiaoNotFoundException {@value id} Sera usado na busca
	 * @param id que sera usado para busca da SubRegiao, Regiao e Pais
	 * @return SubRegiao especiificada com Regiao e Pais
	 */
	@GetMapping(path = "/{id}")
	public SubRegiao retriveOneSubRegiao(@PathVariable long id) {
		SubRegiao subRegiao = subRegiaoDaoService.retriveOneSubRegiaoById(id);

		if (subRegiao == null)
			throw new SubRegiaoNotFoundException("Id -> " + id);
		return subRegiao;
	}

	/**
	 * @apiNote Busca e actualiza a SubRegiao especifica o ID do SubRegiao mantem-se
	 * @param SubRegiao contendo as informcoes a serem actualizadas
	 * @return SubRegiao com informacoes actualizadas
	 */
	@PutMapping()
	public SubRegiao updateSubRegiaoById(@RequestBody SubRegiao subRegiao) {
		return subRegiaoDaoService.updateSubRegiao(subRegiao);
	}

}
