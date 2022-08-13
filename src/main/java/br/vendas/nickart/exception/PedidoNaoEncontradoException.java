package br.vendas.nickart.exception;

public class PedidoNaoEncontradoException extends RuntimeException{

	public PedidoNaoEncontradoException() {
		super("Pedido não encontrado");
	}
}
