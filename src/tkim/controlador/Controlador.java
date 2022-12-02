package tkim.controlador;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;

import tkim.modelo.LanzarArticuloDAO;
import tkim.modelo.Pedido;

public class Controlador {
	
	
	LanzarArticuloDAO lad = new LanzarArticuloDAO();
	
	public String addCliente(String nombre, String domi, String nif, String mail, String tipoCliente) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	public String addArticulo(String codigo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion) {
		try {
			return lad.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "hola";
		
	}
	
	public List<Articulo> mostrarArticulos(){
		return lad.mostrarArticulos();
	}
	
	public List<Cliente> mostrarClientesEstandar(){
		return null;
	}
	
	public List<Cliente> mostrarClientesPremium(){
		return null;
		
	}
	
	public Boolean existeArticulo(String codigo) {
		return lad.existeArticulo(codigo);
		
	}
	
	public Boolean existeCliente(String nif) {
		return null;
		
	}
	
	public Boolean existePedido(int codigoPedido) {
		return null;
		
	}
	
	public String eliminarPedido(int codigoPedido) {
		return null;
	}
	
	public List<Pedido> mostrarPedEnviados(int numeroOrdenArray) {
		return null;
	}
	
	public List<Pedido> mostrarPedPendientes(int numeroOrdenArray) {
		return null;
	}
	
	
}
