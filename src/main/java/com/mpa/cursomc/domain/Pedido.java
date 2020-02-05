package com.mpa.cursomc.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
public class Pedido extends AbstractEntity<Integer> {

	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date instante;

	
	// cascade=CascadeType.ALL é necessário para que não dê o erro de entidade transiente quando vc vai salvar um pedido e o pagamento dele
	// mappedBy="pedido"  informa que este cara foi mapeado do outro lado pelo atributo pedido
	//@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")  
	private Pagamento pagamento;
	
	//@JsonManagedReference  // Os clientes de um pedido serão serializados, mas os pedidos de um cliente não
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
		
	@ManyToOne
	@JoinColumn(name="enderecoDeEntrega_id")
	private Endereco enderecoDeEntrega;
	
	
	@OneToMany(mappedBy = "id.pedido")   // Aqui o id vem do atributo id de ItemPedido e o pedido vem do atributo pedido de ItemPedidoPK 
	private Set<ItemPedido> itens = new HashSet<>();  // O pedido conhece os itens de pedigo associados a ele
	
	
	public Pedido() {}

	public Pedido(Integer id, Date instante,  Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.setId(id);
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	
	
	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
}
