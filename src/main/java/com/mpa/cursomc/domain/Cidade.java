package com.mpa.cursomc.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends AbstractEntity<Integer> {

	
	private String nome;
		
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="estado_id")  // estado_id nome da chave estrangeira lá no banco de dados
	private Estado estado;
	
	public Cidade() {}
	
	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.setId(id);
		this.nome = nome;
		this.estado = estado;
	}





	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
