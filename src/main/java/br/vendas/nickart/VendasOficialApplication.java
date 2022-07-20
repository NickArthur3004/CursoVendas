package br.vendas.nickart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.vendas.nickart.entities.Cliente;
import br.vendas.nickart.entities.Pedido;
import br.vendas.nickart.repositories.Clientes;
import br.vendas.nickart.repositories.Pedidos;

@SpringBootApplication
public class VendasOficialApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
		return args ->{
			Cliente c = new Cliente(null, "Nicolas");
			clientes.save(c);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasOficialApplication.class, args);
	}

}
