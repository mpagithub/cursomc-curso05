package com.mpa.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")  // /categorias é um end point rest
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)  // GET, PUT, DELETE, POST    são verbos HTTP
	public String listar() {
		return "REST está funcionando";
	}
	
	
}
