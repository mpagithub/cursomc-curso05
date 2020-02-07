package com.mpa.cursomc.dto;

import java.io.Serializable;

import com.mpa.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{

	 /* Padrão DTO(Data Transfer Object), é um objeto que vai conter apenas os dados que eu preciso para alguma operação que eu fizer no 
        sistema. Para vc exibir apenas aquilo que vc quer. 
     */

	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	
	public CategoriaDTO() {}
	
	public CategoriaDTO(Categoria obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		
	}


	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
}
