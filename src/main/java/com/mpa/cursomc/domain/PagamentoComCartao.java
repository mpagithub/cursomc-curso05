package com.mpa.cursomc.domain;

import javax.persistence.Entity;

import com.mpa.cursomc.domain.enums.EstadoPagamento;


@SuppressWarnings("serial")
@Entity
public class PagamentoComCartao extends Pagamento	{

	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas ) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	// OBS.:  Nesta classe não precisa de HashCode and Equals, pois o ID está na SuperClasse.
	
	
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
	
}
