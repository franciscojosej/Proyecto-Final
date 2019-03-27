package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	
	private int codigo_cliente;
	
	private ArrayList<Contrato> miscontract;
	
	
	
	



	public Cliente(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social, int codigo_cliente,
			ArrayList<Contrato> miscontract) {
		super(nombre, apellido, cedula, telefono, direccion, sexo);
		this.codigo_cliente = codigo_cliente;
		this.miscontract = miscontract;
	}

	public ArrayList<Contrato> getMiscontract() {
		return miscontract;
	}

	public void setMiscontract(ArrayList<Contrato> miscontract) {
		this.miscontract = miscontract;
	}
	

	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	
	
	
	

}
