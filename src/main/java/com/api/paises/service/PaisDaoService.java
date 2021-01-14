package com.api.paises.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.paises.entity.Pais;
import com.api.paises.repository.PaisRepository;

/**
 * @see PaisRepository
 * @author Nelson Zaona Joao Albino
 *
 */
@Component
public class PaisDaoService {

	@Autowired
	private PaisRepository paisRepository;

	/**
	 * @apiNote Elimina um pais com base no ID
	 * @param id
	 */
	public void destroyPaisById(long id) {
		paisRepository.deleteById(id);
	}

	/**
	 * @apiNote Insere um novo pais
	 * @param pais
	 * @return
	 */
	public Pais insert(Pais pais) {
		return paisRepository.saveAndFlush(pais);
	}

	/**
	 * @apiNote Lista todos Paises
	 * @return Lista<Pais>
	 */
	public List<Pais> retriveAllPaises() {
		return paisRepository.findAll();
	}

	/**
	 * @apiNote Filtragem de resultados com base no identificar ID
	 * @param id
	 * @return Pais
	 */
	public Pais retriveOnePaisById(long id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.get();
	}

	/**
	 * @apiNote Actualiza um pais com base no ID
	 * @param pais contendo informacoes actualizada
	 * @return Pais actualizado caso o pais passado exista, caso contrario retorna
	 *         NULL
	 */
	public Pais updatePais(Pais pais) {
		Pais paisFounded = retriveOnePaisById(pais.getId());

		if (paisFounded != null) {
			paisFounded.setCapital(pais.getCapital());
			paisFounded.setNome(pais.getNome());
			return insert(pais);
		}
		return null;
	}

}
