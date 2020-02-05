package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
public class Estado extends AbstractEntity<Integer> {

	
	private String nome;

	@JsonBackReference	
	@OneToMany(mappedBy="estado")  // estado, porque foi ele o atributo lá do outro lado que mapeou o ManyToOne
	private List<Cidade> cidades = new ArrayList<>();
	
    public Estado() {} 
	
	public Estado(Integer id,String nome) {
		super();
		this.setId(id);
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
}
