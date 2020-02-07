package com.mpa.cursomc.services;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mpa.cursomc.domain.Categoria;
import com.mpa.cursomc.repositories.CategoriaRepository;
import com.mpa.cursomc.services.exceptions.DataIntegrityException;
import com.mpa.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	   
	
    public Categoria find(Integer id) {
    	
	  	Optional<Categoria> obj = repo.findById(id);
	    return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado!  Id: " + id + ", Tipo: " + Categoria.class.getName()) );
	 // Criamos um Handle em : ResourceExceptionHandler, para interceptar esta excetion
	    
	}
	 	
	public Categoria insert(Categoria obj) {
		
		obj.setId(null);  // Apenas para garantir que estamos inserindo um objeto novo, porque se viesse algum valor no id, o jpa iria fazer um update.
		return repo.save(obj);
		
	}
    
    
    public Categoria update(Categoria obj) {
    	
    	find(obj.getId());     // Vamos verificar se o objeto realmente existe no banco. Assim vamos utilizar a construção do find acima.
    	return repo.save(obj);
    	
    }
    

    public void delete(Integer id) {
    	
    	find(id);     // Vamos verificar se o objeto realmente existe no banco. Assim vamos utilizar a construção do find acima.
   	
   		repo.deleteById(id);
   		// Criamos um Handle em : ResourceExceptionHandler, para interceptar exceptions esta excetions DataIntegrityException, que são lançadas
   		// quando tentamos deletar um registro de uma tabela que tem relacionamento com outra e dados nas duas tabelas relacionados.                  
    		
    }

    
    
    public List<Categoria> findAll() {
    	
    	return repo.findAll();
    	
    }
    
    
}
