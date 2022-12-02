package tkim.modelo;

public class ClienteEstandar extends Cliente{
	
	public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
		super(nombre, domicilio, nif, email);	
	}

	@Override
	public String tipoCliente() {
		// TODO Auto-generated method stub
		return "Cliente Estandar";
	}



	@Override
	public float calcAnual() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public float descuentoEnv() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
