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
	public CommandLineRunner init(@Autowired Clientes clientes,
								  @Autowired Pedidos pedidos) {
		return args -> {

			System.out.println("Salvando Clientes");
			
			Cliente cliente1 = new Cliente("Nicolas");
			clientes.save(cliente1);

			Cliente cliente2 = new Cliente("Alanis");
			clientes.save(cliente2);
			
			Pedido p = new Pedido();
			p.setCliente(cliente2);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			
			pedidos.save(p);

//			Cliente cliente = clientes.findClienteFetchPedidos(cliente2.getId());
//			System.out.println(cliente);
//			
//			System.out.println(cliente.getPedidos());

			pedidos.findByCliente(cliente2).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasOficialApplication.class, args);
	}

}
