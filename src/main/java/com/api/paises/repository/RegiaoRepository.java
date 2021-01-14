package com.api.paises.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.paises.entity.Regiao;

/**
 * @see JpaRepository
 * @author Nelson Zaona Joao Albino
 *
 */
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

}
