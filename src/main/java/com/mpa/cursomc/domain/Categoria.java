package com.mpa.cursomc.domain;

import java.io.Serializable;

public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
    - Precisa implementar Serializable : A interface Serializable diz que os objetos dessa classe poderão ser 
      convertidos numa sequencia de bytes, isso para que possa ser gravados em arquivos, trafegar em redes etc... 
      e toda classe que implementa, precisa ter um número de versão padrão  serialVersionUID = 1L;  */

	
	private Integer id;
	private String nome;
	
		
	
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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


	
	// Em Java, para que 2 objetos possam ser comparados pelo seus conteúdos e não pelo seus endereços de memória, eles 
	// precisam ter a implementação de hashCode e equals; Normalmente criados usando apenas a chave. 
		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
