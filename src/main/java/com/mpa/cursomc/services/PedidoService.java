package com.mpa.cursomc.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpa.cursomc.domain.Pedido;
import com.mpa.cursomc.repositories.PedidoRepository;
import com.mpa.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	   
	
    public Pedido find(Integer id) {
    	
	  	Optional<Pedido> obj = repo.findById(id);
	    return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado!  Id: " + id + ", Tipo: " + Pedido.class.getName()) );
	    // Quem vai ter de receber a exceção acima vai ser a camada rest/controller...
	}
	 	
	
    
    
    
    
    
}
