package tkim.modelo;

import java.time.LocalDateTime;
import tkim.modelo.Cliente;
import tkim.modelo.Articulo;

public class Pedido {
	
	private int numeroPedido;
	private int unidadesPedido;
	private LocalDateTime fechaHoraPedido;
	private float totalPedido;
	private Cliente cliente;
	private Articulo articulo;
	/**
	 * @param numeroPedido
	 * @param unidadesPedido
	 * @param fechaHoraPedido
	 * @param totalPedido
	 * @param cliente
	 * @param articulo
	 */
	public Pedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, float totalPedido,
			Cliente cliente, Articulo articulo) {
		super();
		this.numeroPedido = numeroPedido;
		this.unidadesPedido = unidadesPedido;
		this.fechaHoraPedido = fechaHoraPedido;
		this.totalPedido = totalPedido;
		this.cliente = cliente;
		this.articulo = articulo;
	}
	//comentario
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public int getUnidadesPedido() {
		return unidadesPedido;
	}
	public void setUnidadesPedido(int unidadesPedido) {
		this.unidadesPedido = unidadesPedido;
	}
	public LocalDateTime getFechaHoraPedido() {
		return fechaHoraPedido;
	}
	public void setFechaHoraPedido(LocalDateTime fechaHoraPedido) {
		this.fechaHoraPedido = fechaHoraPedido;
	}
	public float getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(float totalPedido) {
		this.totalPedido = totalPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", unidadesPedido=" + unidadesPedido + ", fechaHoraPedido="
				+ fechaHoraPedido + ", totalPedido=" + totalPedido + ", cliente=" + cliente + ", articulo=" + articulo
				+ "]";
	}	
}
