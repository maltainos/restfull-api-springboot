package com.api.paises.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.paises.entity.SubRegiao;
import com.api.paises.repository.SubRegiaoRepository;

/**
 * @see SubRegiaoRepository
 * @author Nelson Zaona Joao Albino
 *
 */
@Component
public class SubRegiaoDaoService {

	@Autowired
	private SubRegiaoRepository subRegiaoRepository;

	/**
	 * @apiNote Elimina uma SubRegiao com base no ID
	 * @param id
	 */
	public void destroySubRegiaoById(long id) {
		subRegiaoRepository.deleteById(id);
	}

	/**
	 * @apiNote Insere uma nova SubRegiao
	 * @param regiao
	 * @return SubRegiao
	 */
	public SubRegiao insert(SubRegiao subRegiao) {
		return subRegiaoRepository.saveAndFlush(subRegiao);
	}

	/**
	 * @apiNote Lista todas SubRegioes
	 * @return Lista<SubRegiao>
	 */
	public List<SubRegiao> retriveAllSubRegioes() {
		return subRegiaoRepository.findAll();
	}

	/**
	 * @apiNote Filtragem de resultados com base no identificar ID
	 * @param id
	 * @return SubRegiao
	 */
	public SubRegiao retriveOneSubRegiaoById(long id) {
		Optional<SubRegiao> subRegiao = subRegiaoRepository.findById(id);
		return subRegiao.get();
	}

	/**
	 * @apiNote Actualiza uma SubRegiao com base no ID
	 * @param regiao contendo informacoes actualizada
	 * @return SubRegiao actualizado caso a SubRegiao passado exista, caso contrario
	 *         retorna NULL
	 */
	public SubRegiao updateSubRegiao(SubRegiao subRegiao) {
		SubRegiao subRegiaoFounded = retriveOneSubRegiaoById(subRegiao.getId());

		if (subRegiaoFounded != null) {
			subRegiaoFounded.setRegiao(subRegiao.getRegiao());
			subRegiaoFounded.setNome(subRegiao.getNome());
			return insert(subRegiao);
		}
		return null;
	}
}
