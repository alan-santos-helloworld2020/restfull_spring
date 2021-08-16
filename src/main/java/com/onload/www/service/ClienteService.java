package com.onload.www.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.onload.www.model.Cliente;
import com.onload.www.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService{
	
	
	@Autowired
	private ClienteRepository clr;
	

	public List<Cliente> listar(){
		return clr.findAll();
	}
	
	public Cliente pesquisar(Long id){
		
		return clr.findById(id).orElse(null);
	}
	
	public Cliente salvar(Cliente cl) {
		return clr.save(cl);
	}
	
	public Cliente editar(Cliente cl){
		
		Cliente old = clr.findById(cl.getId()).orElse(null);
		if(old !=null) {
			old.setNome(cl.getNome());
			old.setTelefone(cl.getTelefone());
			old.setEmail(cl.getEmail());
			old.setCep(cl.getCep());
			return clr.save(old);
		}
		return clr.save(new Cliente());
	}
	
	public void deletar(Long id) {
		
		clr.deleteById(id);
	}
	
	

}
