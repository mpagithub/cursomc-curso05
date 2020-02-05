package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity  // Entidade do JPA
public class Produto extends AbstractEntity<Integer> {

		
	private String nome;
	private Double preco;
	
	//@JsonBackReference  // Significa que do outro lado já foram serializados os objetos produtos, e aqui, a lista de categorias de cada produto deve ser omitida.
	@JsonIgnore
	@ManyToMany   
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	// Ta sendo criado uma terceira tabela PRODUTO_CATEGORIA no banco de dados, que vai fazer o relacionamento e armazenar as chaves das duas tabelas
	private List<Categoria> categorias = new ArrayList<Categoria>();
		
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();   // O produto conhece os itens de pedigo associados a ele
	
	
	public Produto() {}
	
	public Produto(Integer id, String nome, Double preco) {
		this.setId(id); 
		this.nome = nome;
		this.preco = preco;
	}

	@JsonIgnore
	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
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

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
	
	
}
