package com.mpa.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mpa.cursomc.domain.Categoria;
import com.mpa.cursomc.dto.CategoriaDTO;
import com.mpa.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")  // /categorias é um end point rest
public class CategoriaResource {

	@Autowired
	CategoriaService service;
	
	
	@RequestMapping(method=RequestMethod.POST)    // POST é um verbo HTTP, que é usado para incluir algo no banco
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {  
		// Void, significa que vai ser uma resposta HTTP, porém não vai ter corpo
		// Para que este obj categoria do argumento seja construído a partir do json recebido da página, precisamos do @RequestBody
		
		obj = service.insert(obj);  // Estamos retornando para o próprio objeto, porque a operação save do repository retorna o objeto. Assim mantemos esse padrão.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	/* O protocolo HTTP, quando vc está inserindo alguma coisa, ele tem um código de resposta para esta operaçao. Pesquise no google  http status code
		   Então devemos retornar este código e tbm a URI do novo recurso criado. Exemplo : localhost:8080/categoria/3, onde o 3 é o id do novo objeto 
		   gravado no banco. O método fromCurrentRequest() pega a parte da uri sem o id Exemplo: localhost:8080/categoria
		*/
		return ResponseEntity.created(uri).build();  // Este created() já gera o código de resposta da inserçãocom sucesso, que no caso é o 201;
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)   // PUT é um verbo HTTP, que é usado para alterar algo no banco
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();   // noContent  = Conteúdo vazio
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)   // GET, PUT, DELETE, POST  são verbos   o GET é usado para buscar algo no banco
	public ResponseEntity<?> find(@PathVariable Integer id) {  
		/*  ResponseEntity<?>   ResponseEntity é um tipo especial do Spring que vai encapsular várias informações de uma resposta HTTP para um serviço REST. Já a ? 
		    significa que pode ser qualquer tipo, pois pode encontrar ou não uma Categoria na pesquisa.  Mas, neste caso poderia ser categoria tbm ao invés do ? */
		       
		Categoria obj = service.find(id);
		/* Aqui vamos ter de implementar a captura da exceção vinda do método buscar da camada de serviço e mandar um json apropriado como resposta http.
		   Poderíamos cria um try catch aqui, porém, não é muito elegante e apropriado usá-lo aqui nesta camada, então vamos utilizar um Handler, que é 
		   um objeto especial que vai interceptar a exception e vai lançar a resposta http adequada, no caso 404. Então, quando uma exception do tipo
		   ObjectNotFoundException for lançada, nosso Handler vai interceptar e dar a resposta.
		 */
		return ResponseEntity.ok().body(obj); // ok significa que a pesquisa foi bem sucedida
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)   // DELETE é um verbo HTTP, que é usado para excluir algo no banco
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.delete(id);	// Aqui criamos um Handle para capturar uma possível exception, conforme no método find acima.
		
		return ResponseEntity.noContent().build();   // noContent  = Conteúdo vazio
		
	}

	
	@RequestMapping(method=RequestMethod.GET)   
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		
		 /* Padrão DTO(Data Transfer Object), é um objeto que vai conter apenas os dados que eu preciso para alguma operação que eu fizer no 
		    sistema. Para vc exibir apenas aquilo que vc quer. 
		 */
		
		List<Categoria> lista = service.findAll();
		List<CategoriaDTO> listaDTO = new ArrayList<>();
		
		lista.forEach(n -> listaDTO.add(new CategoriaDTO(n)));
		
		/*  Ou Assim:
		
			listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
			
		*/
		
		/*  Ou Assim
		
			for (Categoria categoria : lista) {
				listaDTO.add(new CategoriaDTO(categoria));
			}
		  
		*/
		
		return ResponseEntity.ok().body(listaDTO); 
	}

	
	
	
	
	
}
