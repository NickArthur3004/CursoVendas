package br.vendas.nickart.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
	
	@NotNull(message = "Informe o codigo do cliente.")
	private Integer cliente;
	@NotNull(message = "Campo total do pedido é obrigatorio.")
	private BigDecimal total;
	private List<ItemsPedidoDTO> items;

}
