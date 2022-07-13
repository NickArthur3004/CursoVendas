package br.vendas.nickart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.vendas.nickart.entities.Cliente;
import br.vendas.nickart.repositories.Clientes;

@SpringBootApplication
public class VendasOficialApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {

			System.out.println("Salvando Clientes");
			Cliente cliente = new Cliente("Nicolas");
			clientes.save(cliente);

			Cliente cliente2 = new Cliente("Alanis");
			clientes.save(cliente2);

			boolean existe = clientes.existsByNome("Nicolas");
			System.out.println(existe);

			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasOficialApplication.class, args);
	}

}
