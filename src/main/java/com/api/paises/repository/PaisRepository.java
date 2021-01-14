package com.api.paises.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.paises.entity.Pais;

/**
 * @see JpaRepository
 * @author Nelson Zaona Joao Albino
 *
 */
public interface PaisRepository extends JpaRepository<Pais, Long> {

	@Query("SELECT * FROM `regioes` WHERE nome LIKE %%")
	public List<Pais> findPaisByNameOrCapital(String search);
}
