package com.mpa.cursomc.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpa.cursomc.domain.Categoria;
import com.mpa.cursomc.repositories.CategoriaRepository;
import com.mpa.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	   
	
    public Categoria buscar(Integer id) {
    	
	  	Optional<Categoria> obj = repo.findById(id);
	    return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado!  Id: " + id + ", Tipo: " + Categoria.class.getName()) );
	    // Quem vai ter de receber a exceção acima vai ser a camada rest/controller...
	}
	 	
	
    
    
    
    
    
}
