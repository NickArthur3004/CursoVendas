package br.vendas.nickart.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.vendas.nickart.entities.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{
	
	
  //@Query(value= " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
	@Query(value= " select c from Cliente c where c.nome like :nome ")
	List<Cliente> encontrarPorNome( @Param("nome") String nome );
	
	List<Cliente> findByNomeOrId(String nome, Integer id);
	
	boolean existsByNome(String nome);
	
  //@Query(" delete from Cliente c where c.nome = :nome ")	
  //@Modifying	
	void deleteByNome(String nome);
	
	@Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id );
	
	
	
}
