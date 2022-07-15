package br.vendas.nickart.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@Column(name="data_pedido")
	private LocalDate dataPedido;
	
	//1000.00
	@Column(length = 20, precision = 2)
	private BigDecimal total;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itemPedido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Set<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(Set<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	
	

}
