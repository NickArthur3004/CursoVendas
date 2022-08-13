package br.vendas.nickart.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.vendas.nickart.entities.Cliente;
import br.vendas.nickart.entities.ItemPedido;
import br.vendas.nickart.entities.Pedido;
import br.vendas.nickart.entities.Produto;
import br.vendas.nickart.enums.StatusPedido;
import br.vendas.nickart.exception.PedidoNaoEncontradoException;
import br.vendas.nickart.exception.RegraNegocioException;
import br.vendas.nickart.repositories.Clientes;
import br.vendas.nickart.repositories.ItemsPedido;
import br.vendas.nickart.repositories.Pedidos;
import br.vendas.nickart.repositories.Produtos;
import br.vendas.nickart.rest.dto.ItemsPedidoDTO;
import br.vendas.nickart.rest.dto.PedidoDTO;
import br.vendas.nickart.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	Pedidos repository;
	@Autowired
	Clientes clientesRepository;
	@Autowired
	Produtos produtosRepository;
	@Autowired
	ItemsPedido itemspedidoRepository;
	
	@Override
	@Transactional
	public Pedido salvar(PedidoDTO dto) {

		Integer idCliente = dto.getCliente();
		Cliente cliente = clientesRepository
							.findById(idCliente)
							.orElseThrow(() -> new RegraNegocioException("Codigo de cliente invalido."));
		
		Pedido pedido = new Pedido();
		pedido.setTotal(dto.getTotal());
		pedido.setDataPedido(LocalDate.now());
		pedido.setCliente(cliente);
		pedido.setItemPedido(null);
		pedido.setStatus(StatusPedido.REALIZADO);
		
		List<ItemPedido> itemsPedidos = ConverterItems(pedido, dto.getItems());
		repository.save(pedido);
		itemspedidoRepository.saveAll(itemsPedidos);
		pedido.setItemPedido(itemsPedidos);
		return pedido;
	}
	
	private List<ItemPedido> ConverterItems(Pedido pedido, List<ItemsPedidoDTO> items) {
		
		if(items.isEmpty()) {
			throw new RegraNegocioException("Não é possivel realizar um pedido sem items.");
		}
		
		return items
				.stream()
				.map(dto -> {
					Integer idProduto = dto.getProduto();
					Produto produto = produtosRepository
							.findById(idProduto)
							.orElseThrow(() -> new RegraNegocioException("Codigo do Produto invalido: " + idProduto));
					
					ItemPedido itemPedido = new ItemPedido();
					itemPedido.setQuantidade(dto.getQuantidade());
					itemPedido.setPedido(pedido);
					itemPedido.setProduto(produto);
					return itemPedido;
					
				}).collect(Collectors.toList());
		
	}

	@Override
	public Optional<Pedido> obterPedidoCompleto(Integer id) {
		
		return repository.findByIdFetchItens(id);
	}

	@Override
	@Transactional
	public void atualizaStatus(Integer id, StatusPedido statusPedido) {
		
		repository.findById(id)
				  .map(pedido -> {
					  pedido.setStatus(statusPedido);
					  return repository.save(pedido);
				  }).orElseThrow(() -> new PedidoNaoEncontradoException() );
		
		
	}
	
	

}
