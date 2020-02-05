package com.mpa.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.mpa.cursomc.domain.enums.EstadoPagamento;

@SuppressWarnings("serial")
@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private Date dataVencimento;
	private Date dataPagamento;	
	
	
	public PagamentoComBoleto( ) {}
	
	
	// Esse construtor como a classe é uma classe filha de Pagamento, gere o construtor :  Generate Constructors From SuperClass, e complete com os campos desta classe.
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}



	// OBS.:  Nesta classe não precisa de HashCode and Equals, pois o ID está na SuperClasse.
	
	

	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	

}
