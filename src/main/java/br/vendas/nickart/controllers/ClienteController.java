package br.vendas.nickart.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.vendas.nickart.entities.Cliente;
import br.vendas.nickart.repositories.Clientes;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	Clientes clientes;
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getClienteById(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);
		
		
		return cliente.isPresent() ? ResponseEntity.ok(cliente .get()) : ResponseEntity.notFound().build();
	}
	
}
