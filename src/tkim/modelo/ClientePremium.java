package tkim.modelo;

public class ClientePremium extends Cliente {
	
	public ClientePremium(String nombre, String domicilio, String nif, String email) {
		super(nombre, domicilio, nif, email);
		
	}

	@Override
	public String tipoCliente() {
		// TODO Auto-generated method stub
		return "Cliente Premium";
	}

	@Override
	public float calcAnual() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public float descuentoEnv() {
		// TODO Auto-generated method stub
		return 20;
	}
	
	
}
