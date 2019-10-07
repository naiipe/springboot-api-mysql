package com.test.crud.services;

import com.test.crud.models.Cidade;

public class CidadeService {

	public static Cidade createRequestBody(Cidade cidade) {
		
		Cidade cdd = new Cidade();
    	cdd.setNome(cidade.getNome());
    	cdd.setEstado(cidade.getEstado());
		return cdd;
	}
	
	public static Object searchByKey(Iterable<Cidade> cdds, String key) {
		Object obj = null;
    	for(Cidade cdd: cdds) {
    		if(cdd.getNome().equals(key))
    			obj = cdd;
    	}
    	return obj;
	}
}
