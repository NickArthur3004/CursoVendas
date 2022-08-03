package br.vendas.nickart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.vendas.nickart.service.PedidoService;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService service;

}
