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
			clientes.salvar(cliente);

			Cliente cliente2 = new Cliente("Alanis");
			clientes.salvar(cliente2);

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.atualizar(c);
			});

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando por nome");
			clientes.buscarPorNome("Nic").forEach(System.out::println);

			System.out.println("Deletando cliente");
			clientes.obterTodos().forEach(c -> {
				clientes.delete(c.getId());
			});

			todosClientes = clientes.obterTodos();
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
