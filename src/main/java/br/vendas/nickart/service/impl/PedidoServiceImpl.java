package br.vendas.nickart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.vendas.nickart.repositories.Pedidos;
import br.vendas.nickart.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	Pedidos repository;

}
