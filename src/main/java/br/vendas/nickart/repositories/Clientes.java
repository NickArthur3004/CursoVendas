package br.vendas.nickart.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.vendas.nickart.entities.Cliente;

@Repository
public class Clientes {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		entityManager.merge(cliente);
		
		return cliente;
	}
	
	@Transactional
	public void delete(Integer id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		entityManager.remove(cliente);
	}
	
	@Transactional
	public List<Cliente> buscarPorNome(String nome) {
		
		String jpql = " select c from Cliente c where c.nome like :nome ";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();		
	}
	
	@Transactional
	public List<Cliente> obterTodos(){
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}

}
