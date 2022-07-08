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

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.save(c);
			});

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando por nome");
			clientes.findByNome("Nic").forEach(System.out::println);

			System.out.println("Deletando cliente");
			clientes.findAll().forEach(c -> {
				clientes.deleteById(c.getId());
			});

			todosClientes = clientes.findAll();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum cliente encontrado");
			} else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasOficialApplication.class, args);
	}

}
