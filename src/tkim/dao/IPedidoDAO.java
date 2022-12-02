package tkim.dao;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.Pedido;

public interface IPedidoDAO {
	
public Boolean existePedido(Integer codigo);
	
	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente,
			Articulo articulo);
	public String eliminarPedido(int numPedido);
	public List<Pedido> pedidosEnviados(String nif);
	public List<Pedido> pedidosPendientes(String nif);

}
