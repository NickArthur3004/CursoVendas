package br.vendas.nickart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vendas.nickart.entities.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer>{

}
