package com.test.crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.crud.models.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

	Optional<Cidade> findById(Integer id);
}
