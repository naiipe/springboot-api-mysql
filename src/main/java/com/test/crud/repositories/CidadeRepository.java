package com.test.crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.crud.models.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

	Optional<Cidade> findById(Integer id);
	
	public static Cidade createRequestBody(Cidade cidade) {

		Cidade cdd = new Cidade();
		cdd.setNome(cidade.getNome());
		cdd.setEstado(cidade.getEstado());
		return cdd;
	}

	public static Object searchByKey(Iterable<Cidade> cdds, String key) {

		Object obj = null;
		for (Cidade cdd : cdds) {
			if (cdd.getNome().equals(key))
				obj = cdd;
		}
		return obj;
	}
}
