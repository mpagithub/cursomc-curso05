package com.mpa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpa.cursomc.domain.Cliente;
import com.mpa.cursomc.repositories.ClienteRepository;
import com.mpa.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CLienteService {

	@Autowired
	private ClienteRepository repo;
	   
		
    public Cliente buscar(Integer id) {
    	
	  	Optional<Cliente> obj = repo.findById(id);
	    return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado!  Id: " + id + ", Tipo: " + Cliente.class.getName()) );
	    // Quem vai ter de receber a exceção acima vai ser a camada rest/controller...
	}
	 	
    
}
