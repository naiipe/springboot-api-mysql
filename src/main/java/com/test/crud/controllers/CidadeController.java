package com.test.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crud.models.Cidade;
import com.test.crud.repositories.CidadeRepository;
import com.test.crud.services.CidadeService;

@Controller
@RequestMapping(path="/city")
public class CidadeController {

	@Autowired
	private CidadeRepository cddRepository;
	
    @PostMapping(path="/create")
    public @ResponseBody Object addCidade(@RequestBody Cidade cidade) {
    	
    	cddRepository.save(CidadeService.createRequestBody(cidade));
    	return cidade;
    }
    
    @GetMapping(path= "/fetch/cidade/{value}")
    private @ResponseBody Object getByCidade(@PathVariable("value") String name) {
    	Object obj = null;
    	Iterable<Cidade> cdds = cddRepository.findAll();
		obj = CidadeService.searchByKey(cdds, name);
    	if(obj == null) {
    		return "Sorry, no one was found.";
    	}else {
    		return obj;
    	}
    }
    
    @GetMapping(path= "/fetch/estado/{value}")
	private @ResponseBody Object getByEstado(@PathVariable("value") String estado) {
		Object obj = null;
		Iterable<Cidade> cdds = cddRepository.findAll();
		obj = CidadeService.searchByKey(cdds, estado);
		if(obj == null) {
			return "Sorry, no one was found.";
		}else {
		return obj;
		}
	}
    
}
