package com.mpa.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpa.cursomc.domain.Categoria;
import com.mpa.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")  // /categorias é um end point rest
public class CategoriaResource {

	@Autowired
	CategoriaService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)   // GET, PUT, DELETE, POST    são verbos HTTP
	public ResponseEntity<?> find(@PathVariable Integer id) {  
		/*  ResponseEntity<?>   ResponseEntity é um tipo especial do Spring que vai encapsular várias informações de uma resposta HTTP para um serviço REST. Já a ? 
		    significa que pode ser qualquer tipo, pois pode encontrar ou não uma Categoria na pesquisa.  */
		       
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj); // ok significa que a pesquisa foi bem sucedida
		
	}
	
	
}
