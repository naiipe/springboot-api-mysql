package com.test.crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.test.crud.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

	Optional<Cliente> findById(Integer id);
	
	@Transactional
	Optional<Cliente> deleteById(Integer id);
}
