package com.mpa.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpa.cursomc.domain.ItemPedido;

@Repository 
public interface ItemPedidoRepository extends JpaRepository<ItemPedido	, Integer>{
		
}
