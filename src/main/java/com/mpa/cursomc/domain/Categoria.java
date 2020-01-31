package com.mpa.cursomc.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Categoria extends AbstractEntity<Integer> {
	
		
	/*
    - Precisa implementar Serializable : A interface Serializable diz que os objetos dessa classe poderão ser 
      convertidos numa sequencia de bytes, isso para que possa ser gravados em arquivos, trafegar em redes etc... 
      e toda classe que implementa, precisa ter um número de versão padrão  serialVersionUID = 1L;  */

	private String nome;
	
	
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
