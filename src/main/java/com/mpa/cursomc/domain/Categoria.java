package com.mpa.cursomc.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Categoria extends AbstractEntity<Integer> {
	
		

	private String nome;
	
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
	
	
}
