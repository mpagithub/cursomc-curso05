package com.mpa.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.mpa.cursomc.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)    
// @Inheritance para mapeamento de herança, pois, Pagamento é pai de PagamentoComBoleto e PagamentoComCartao
/* Para mapear uma herança, temos 2 estratégias, ou faço um tabelão com todos os campos de PagamentoComBoleto e PagamentoComCartao e quando vc instanciar 
   um PagamentoComBoleto, vc colocar null nos atributos de  PagamentoComCartao e vice versa. É uma estratégia boa porque tem mais performanse, porém,
   vc começa gerar uma tab cheia de valores nulos. Outra estratégia é gerar uma tab para cada subclasse. Geralmente quando existe muitos atributos nas 
   subclasses, a gente usa tabelas independentes, do contrário, um tabelão. Para tabelão : strategy=InheritanceType.JOINED  e para classes separadas
   strategy=InheritanceType.SINGLE_TABLE */ 
public abstract class Pagamento implements Serializable {

	// Colocamos o abstract, para que a classe pagamento nunca venha a ser instanciada diretamente, e sim as classes filhas 
	// PagamentoComBoleto e PagamentoComCartao
	
	
	private static final long serialVersionUID = 1L;

	// OBS.: Esta classe não foi possível extender AbstractEntity, porque o ID dela não pode ser auto incremento, tem de ser o mesmo ID da tabela Pedido
	
	@Id
	private Integer id;   // Esse Id tem de ser o do pedido corespondente...
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name="pedido_id")   // Gera um mapeamento com o atributo Id da tabela pedido   
	@MapsId  // Vai mapear o Id de Pedido, como tbm sendo o Id de Pagamento.  --  A chave primária desta tabela será tbm a chave estrangeira PEDIDO_ID
	private Pedido pedido;
	
	
	public Pagamento() {}

	public Pagamento(Integer id,EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
