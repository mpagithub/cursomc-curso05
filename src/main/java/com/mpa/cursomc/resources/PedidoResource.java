package com.mpa.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpa.cursomc.domain.Pedido;
import com.mpa.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")  // /categorias é um end point rest
public class PedidoResource {

	@Autowired
	PedidoService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)   // GET, PUT, DELETE, POST    são verbos HTTP
	public ResponseEntity<?> find(@PathVariable Integer id) {  
		/*  ResponseEntity<?>   ResponseEntity é um tipo especial do Spring que vai encapsular várias informações de uma resposta HTTP para um serviço REST. Já a ? 
		    significa que pode ser qualquer tipo, pois pode encontrar ou não uma Pedido na pesquisa.  */
		       
		Pedido obj = service.find(id);
		/* Aqui vamos ter de implementar a captura da exceção vinda do método buscar da camada de serviço e mandar um json apropriado como resposta http.
		   Poderíamos cria um try catch aqui, porém, não é muito elegante e apropriado usá-lo aqui nesta camada, então vamos utilizar um Handler, que é 
		   um objeto especial que vai interceptar a exception e vai lançar a resposta http adequada, no caso 404. Então, quando uma exception do tipo
		   ObjectNotFoundException for lançada, nosso Handler vai interceptar e dar a resposta.
		 */
		return ResponseEntity.ok().body(obj); // ok significa que a pesquisa foi bem sucedida
	}
	
	
}
