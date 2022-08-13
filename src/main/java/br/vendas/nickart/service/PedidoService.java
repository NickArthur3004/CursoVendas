package br.vendas.nickart.service;

import java.util.Optional;

import br.vendas.nickart.entities.Pedido;
import br.vendas.nickart.enums.StatusPedido;
import br.vendas.nickart.rest.dto.PedidoDTO;

public interface PedidoService {

	Pedido salvar(PedidoDTO dto);
	
	Optional<Pedido> obterPedidoCompleto(Integer id);
	
	void atualizaStatus(Integer id, StatusPedido statusPedido);
}
