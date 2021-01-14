package com.api.paises.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.paises.entity.Regiao;
import com.api.paises.repository.RegiaoRepository;

/**
 * @see RegiaoRepository
 * @author Nelson Zaona Joao Albino
 *
 */
@Component
public class RegiaoDaoService {

	@Autowired
	private RegiaoRepository regiaoRepository;

	/**
	 * @apiNote Elimina uma Regiao com base no ID
	 * @param id
	 */
	public void destroyRegiaoById(long id) {
		regiaoRepository.deleteById(id);
	}

	/**
	 * @apiNote Insere uma nova regiao
	 * @param regiao
	 * @return Regiao
	 */
	public Regiao insert(Regiao regiao) {
		return regiaoRepository.saveAndFlush(regiao);
	}

	/**
	 * @apiNote Lista todas regioes
	 * @return Lista<Regiao>
	 */
	public List<Regiao> retriveAllRegioes() {
		return regiaoRepository.findAll();
	}

	/**
	 * @apiNote Filtragem de resultados com base no identificar ID
	 * @param id
	 * @return Regiao
	 */
	public Regiao retriveOneRegiaoById(long id) {
		Optional<Regiao> regiao = regiaoRepository.findById(id);
		return regiao.get();
	}

	/**
	 * @apiNote Actualiza uma Regiao com base no ID
	 * @param regiao contendo informacoes actualizada
	 * @return Regiao actualizado caso a regiao passado exista, caso contrario
	 *         retorna NULL
	 */
	public Regiao updateRegiao(Regiao regiao) {
		Regiao regiaoFounded = retriveOneRegiaoById(regiao.getId());

		if (regiaoFounded != null) {
			regiaoFounded.setPais(regiao.getPais());
			regiaoFounded.setNome(regiao.getNome());
			return insert(regiao);
		}
		return null;
	}
}
