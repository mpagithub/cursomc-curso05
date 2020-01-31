package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity  // Entidade do JPA
public class Produto extends AbstractEntity<Integer> {

		
	private String nome;
	private Double preco;
	
	@ManyToMany   
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	// Ta sendo criado uma terceira tabela PRODUTO_CATEGORIA no banco de dados, que vai fazer o relacionamento e armazenar as chaves das duas tabelas
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	
	
	public Produto() {}

	public Produto(Integer id, String nome, Double preco) {
		this.setId(id); 
		this.nome = nome;
		this.preco = preco;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
	
	
}
