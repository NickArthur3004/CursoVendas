package br.vendas.nickart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vendas.nickart.entities.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
