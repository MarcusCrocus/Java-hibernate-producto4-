package tkim.modelo;

import java.time.LocalDateTime;
import java.util.List;

import tkim.dao.IPedidoDAO;

public class LanzarPedidoDAO {
	public Boolean existePedido(Integer codigo) {
		IPedidoDAO dao = (IPedidoDAO) FactoryDAOs.getDAO("Pedido");
		return dao.existePedido(codigo);
	}
	public String addPedido(int numero_pedido, int unidades_pedido, LocalDateTime fecha_hora_pedido, Cliente cliente,
			Articulo articulo) {
		IPedidoDAO dao = (IPedidoDAO) FactoryDAOs.getDAO("Pedido");	
		return dao.addPedido(numero_pedido, unidades_pedido, fecha_hora_pedido, cliente, articulo); 
	}
	
	public String eliminarPedido(int numPedido) {
		IPedidoDAO dao = (IPedidoDAO) FactoryDAOs.getDAO("Pedido");	
		return dao.eliminarPedido(numPedido);
	}
	
	public List<Pedido> mostrarPedidosEnviados(String nif) {
		IPedidoDAO dao = (IPedidoDAO) FactoryDAOs.getDAO("Pedido");	
		return dao.pedidosEnviados(nif);
	}
	
	public List<Pedido> mostrarPedidosPendiente(String nif){
		IPedidoDAO dao = (IPedidoDAO) FactoryDAOs.getDAO("Pedido");
		return dao.pedidosPendientes(nif);
	}

}
