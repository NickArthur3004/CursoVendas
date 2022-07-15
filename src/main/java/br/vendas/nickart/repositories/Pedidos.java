package br.vendas.nickart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vendas.nickart.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

}
