package com.test.crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.test.crud.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

	Optional<Cliente> findById(Integer id);
	
	@Transactional
	Optional<Cliente> deleteById(Integer id);
	
	public static Cliente createRequestBody(Cliente cliente) {
		
		Cliente clt = new Cliente();
		clt.setNomeCompleto(cliente.getNomeCompleto());
		clt.setDataNascimento(cliente.getDataNascimento());
		clt.setSexo(cliente.getSexo());
		clt.setCidade(cliente.getCidade());
		clt.setIdade(cliente.getIdade());
		return clt;
	}

	public static Object searchByKey(Iterable<Cliente> cdds, String key) {

		Object obj = null;
		for (Cliente cdd : cdds) {
			if (cdd.getNomeCompleto().equals(key))
				obj = cdd;
		}
		return obj;
	}
	
	public static Boolean deleteByKey(Iterable<Cliente> clts, String key, ClienteRepository cltRepository) {
		
		Boolean bool = false;
		for(Cliente clt: clts ) {
			if(clt.getNomeCompleto().equals(key)) {
				Integer del = clt.getId();
				cltRepository.deleteById(del);
				bool = true;
			}
		}
		return bool;
	}
	
	public static Boolean updateName(Iterable<Cliente> clts, String key, Cliente cliente, ClienteRepository cltRepository) {
		
		Boolean bool = false;
		for(Cliente clt: clts ) {
			if(clt.getNomeCompleto().equals(key)) {
				clt.setNomeCompleto(cliente.getNomeCompleto());
				cltRepository.save(clt);
				bool = true;
			}
		}
		return bool;
	}
}
