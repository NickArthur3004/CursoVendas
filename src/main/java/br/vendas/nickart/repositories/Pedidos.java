package br.vendas.nickart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vendas.nickart.entities.Cliente;
import br.vendas.nickart.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
	
	List<Pedido>findByCliente(Cliente cliente);

}
