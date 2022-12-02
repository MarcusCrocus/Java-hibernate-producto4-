package tkim.dao;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.Pedido;

public class PedidoDAO implements IPedidoDAO{

	@Override
	public Boolean existePedido(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente,
			Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarPedido(int numPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> pedidosEnviados(String nif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> pedidosPendientes(String nif) {
		// TODO Auto-generated method stub
		return null;
	}

}
