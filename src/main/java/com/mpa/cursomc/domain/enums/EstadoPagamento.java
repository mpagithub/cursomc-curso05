package com.mpa.cursomc.domain.enums;

public enum EstadoPagamento {


	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod,String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	
	// Em enum, gerar apenas o Get e não os Set, pois, os campos de um enum são constantes e não tem seus valores alterados.
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod == null) return null;
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
	
	
}
