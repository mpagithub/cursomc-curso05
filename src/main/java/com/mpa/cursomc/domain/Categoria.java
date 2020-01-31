package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity   // Entidade do JPA
public class Categoria extends AbstractEntity<Integer> {
	
		

	private String nome;
	
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
