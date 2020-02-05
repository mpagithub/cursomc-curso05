package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity   // Entidade do JPA
public class Categoria extends AbstractEntity<Integer> {
	
		

	private String nome;
	
	
	@JsonManagedReference  
	/* Quando se tem relacionamentos bidirecionais, pode ocorrer o problema de referência cíclica, quando vc busca uma categoria, a busca
	   tenta trazer a lista de produtos dela, só que cada produto tbm tem sua lista de categoria. Gera erro  - Expected ',' instead of ''  -- ~[jackson-databind-;
	   Para que os produtos sejam serializados ao pesquisar uma categoria, sem que aconteça referência cíclica, use @JsonManagedReference.
	   Do outro lado vc deve anotar como @JsonBackReference
	   
       JsonManagedReference indica que o atributo deve ser serializado
       JsonBackReference cria uma dependência lógica do atributo, mas não o serializa.
	 */
	@ManyToMany(mappedBy="categorias") // categorias aqui e o nome da lista de categoria na tab produto
	private List<Produto> produtos = new ArrayList<Produto>();  // O nome e produtos porque no diagrama esta especificado assim.
	
	/*
	  Le-se no diagrama :  1 categoria tem varios produtos   -   1 produto tem 1 ou mais categorias  Relacionamento many to many
	*/
	
	public Categoria() {}
	
	public Categoria(Integer id,  String nome) {
		this.setId(id); 
		this.nome = nome;
	}
		
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
