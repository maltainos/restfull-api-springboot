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

import com.api.paises.entity.Pais;
import com.api.paises.excepiton.PaisNotFoundException;
import com.api.paises.service.PaisDaoService;

/**
 * @see Pais
 * @see PaisDaoService
 * @see PaisNotFoundException
 * @author Nelson Zaona Joao Albino
 *
 */
@RestController
@RequestMapping(path = "paises")
public class PaisController {

	@Autowired
	private PaisDaoService paisDaoService;

	/**
	 * @apiNote Busca e Elimina um pais especifico e existente {@value id} usado
	 *          para buscar e deletar um pais especifico
	 * @param id o identificador do pais a ser eleminado
	 */
	@DeleteMapping(path = "/{id}")
	public void destroyPaisById(@PathVariable long id) {
		paisDaoService.destroyPaisById(id);
	}

	/**
	 * @apiNote criacao e recuperacao de um pais especifico
	 * @param pais para ser criado
	 * @return url para recuperar o pais inserido
	 */
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Pais pais) {
		Pais savesPais = paisDaoService.insert(pais);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savesPais.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * 
	 * @return Lista de todos paises
	 */
	@GetMapping
	public List<Pais> retriveAllPaises() {
		return paisDaoService.retriveAllPaises();
	}

	/**
	 * @apiNote Busca um Pais especifico existente, caso o pai nao seja encontrado
	 *          lanca uma excecao
	 * @exception PaisNotFoundException {@value id} Sera usado na busca
	 * @param id que sera usado para busca o pais
	 * @return Pais especiificado
	 */
	@GetMapping(path = "/{id}")
	public Pais retriveOnePais(@PathVariable long id) {
		Pais pais = paisDaoService.retriveOnePaisById(id);

		if (pais == null)
			throw new PaisNotFoundException("Id -> " + id);
		return pais;
	}

	/**
	 * @apiNote Busca e actualiza o pais em especifico o ID do Pais mantem-se
	 * @param pais contendo as informcoes a serem actualizadas
	 * @return Pais com informacoes actualizadas
	 */
	@PutMapping()
	public Pais updatePaisById(@RequestBody Pais pais) {
		return paisDaoService.updatePais(pais);
	}

}
