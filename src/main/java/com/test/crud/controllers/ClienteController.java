package com.test.crud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crud.models.Cliente;
import com.test.crud.repositories.ClienteRepository;

@Controller
@RequestMapping(path="/client")
public class ClienteController {
	
	@Autowired
	private ClienteRepository cltRepository;

	@PostMapping(path="/create")
	public @ResponseBody Object addClient (@RequestBody Cliente cliente) {

		Cliente clt = new Cliente();
		clt.setNomeCompleto(cliente.getNomeCompleto());
		clt.setDataNascimento(cliente.getDataNascimento());
		clt.setSexo(cliente.getSexo());
		clt.setCidade(cliente.getCidade());
		clt.setIdade(cliente.getIdade());
		cltRepository.save(clt);
		return cliente;
	}

	@GetMapping(path= "/fetch/id/{value}")
	private @ResponseBody Optional<Cliente> getById(@PathVariable("value") Integer id) {
		return cltRepository.findById(id);
	}
	
	@GetMapping(path= "/fetch/name/{value}")
	private @ResponseBody Object getByName(@PathVariable("value") String name) {
		Object obj = null;
		Iterable<Cliente> clts = cltRepository.findAll();
		for(Cliente clt: clts ) {
			if(clt.getNomeCompleto().equals(name)) {
				obj = clt;
			}
		}
		if(obj == null) {
			return "Sorry, no one was found.";
		}else {
		return obj;
		}
	}
	
	@DeleteMapping(path= "/delete/name/{value}")
	private @ResponseBody String deleteByName(@PathVariable("value") String name) {
		Boolean bool = false;
		Iterable<Cliente> clts = cltRepository.findAll();
		for(Cliente clt: clts ) {
			if(clt.getNomeCompleto().equals(name)) {
				Integer del = clt.getId();
				cltRepository.deleteById(del);
				bool = true;
			}
		}
		if(bool == false) {
			return "Sorry, no one was found.";
		}else {
		return "deleted.";
		}
	}
	
	@PutMapping(path= "/update/name/{value}")
	private @ResponseBody String updateByName(@PathVariable("value") String name, @RequestBody Cliente cliente) {
		Boolean bool = false;
		Iterable<Cliente> clts = cltRepository.findAll();
		for(Cliente clt: clts ) {
			if(clt.getNomeCompleto().equals(name)) {
				clt.setNomeCompleto(cliente.getNomeCompleto());
				cltRepository.save(clt);
				bool = true;
			}
		}
		if(bool == false) {
			return "Sorry, no one was found.";
		}else {
		return "Changed.";
		}
	}
	
	@GetMapping(path="/fetchAll")
	public @ResponseBody Iterable<Cliente> getAllUsers() {
		return cltRepository.findAll();
	}
	
	
}
