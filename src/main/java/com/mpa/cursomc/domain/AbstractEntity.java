package com.mpa.cursomc.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@SuppressWarnings("serial")
@MappedSuperclass   // Vai dizer ao JPA que esta é uma super classe das entidades que iremos implementar
// Obs: o abstract abaixo, vai possibilitar que qualquer classe que queira utilizar esta classe, faça isso por herança e não por instância
public abstract class AbstractEntity<ID extends Serializable> implements Serializable{

	/*
    - Precisa implementar Serializable : A interface Serializable diz que os objetos dessa classe poderão ser 
      convertidos numa sequencia de bytes, isso para que possa ser gravados em arquivos, trafegar em redes etc... 
      e toda classe que implementa, precisa ter um número de versão padrão  serialVersionUID = 1L;  */

	
	//private static final long serialVersionUID = 1L;        Não precisa disso por causa da notação @SuppressWarnings("serial")
		
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	
	
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
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "id= " + id ;
	}
	
	
}
