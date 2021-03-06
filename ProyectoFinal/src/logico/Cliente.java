package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo_cliente;
	
	private ArrayList<Contrato> miscontract;
	
	
	
	



	public Cliente(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social, int codigo_cliente
			) {
		super(nombre, apellido, cedula, telefono, direccion, sexo);
		this.codigo_cliente = codigo_cliente;
		this.miscontract = new ArrayList<Contrato>();
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
	
	public void agrregarcontrato( Contrato nuevoContrato) {
		miscontract.add(nuevoContrato);
		
	}

	
	
	
	

}
