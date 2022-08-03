package br.vendas.nickart.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsPedidoDTO {
	
	private Integer Produto;
	private Integer quantidade;

}
