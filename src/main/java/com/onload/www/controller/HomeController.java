package com.onload.www.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onload.www.model.Cliente;
import com.onload.www.repository.ClienteRepository;
import com.onload.www.service.ClienteService;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ClienteService cls;
	
	
	
	@GetMapping("/")
	public List<Cliente> index() {

		return cls.listar();
		
	}
	
	@GetMapping("/{id}")
	public Cliente pesquisar(@PathVariable Long id) {

		return cls.pesquisar(id);
		
	}
	
	@PostMapping("/")
	public Cliente salvar(@RequestBody Cliente cl) {
		
		return cls.salvar(cl);
	}
	
	@PutMapping("/")
	public Cliente editar(@RequestBody Cliente cl) {
		
		return cls.editar(cl);
	} 
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		cls.deletar(id);
	}

}
