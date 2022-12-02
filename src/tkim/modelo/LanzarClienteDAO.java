package tkim.modelo;

import java.util.List;

import tkim.dao.IClienteDAO;

public class LanzarClienteDAO {

public String save(String nif, String nombre, String domi, String mail,String tipoCliente) {
		
		try {
			
			switch (tipoCliente) {
			
			case "1":
				Cliente cliEst = new ClienteEstandar (nif, nombre, domi, mail);
				IClienteDAO dao = (IClienteDAO) FactoryDAOs.getDAO("Cliente");
				return dao.save(cliEst);
				
			case "2":
				Cliente cliPrem = new ClientePremium (nif, nombre, domi, mail);
				IClienteDAO daoP = (IClienteDAO)FactoryDAOs.getDAO("Cliente");
				return daoP.save(cliPrem);
			}
			
		} catch (Exception e) {
			return "El Cliente no ha podido introducirse correctamente";
		}
		
		return "El Cliente se ha anadido correctamente";
		
	}
	
	public Boolean existeCliente(String nif) {
		IClienteDAO dao = (IClienteDAO) FactoryDAOs.getDAO("Cliente");
		return dao.existeCliente(nif);
		
	}


	public List<Cliente> mostrarClientesXtipo(String tipoCliente) {
		IClienteDAO dao = (IClienteDAO) FactoryDAOs.getDAO("Cliente");
		return null;
	}
	
	public List<Cliente> mostrarClientesTodos(){
		IClienteDAO dao = (IClienteDAO) FactoryDAOs.getDAO("Cliente");
		return dao.mostrarCliente();
	}

	public Cliente buscarCliente(String codigo_cliente) {
		IClienteDAO dao = (IClienteDAO) FactoryDAOs.getDAO("Cliente");
		return null;
	}

}
