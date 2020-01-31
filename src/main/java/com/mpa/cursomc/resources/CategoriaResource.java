package com.mpa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpa.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")  // /categorias é um end point rest
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)  // GET, PUT, DELETE, POST    são verbos HTTP
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<Categoria>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
	
	
}
