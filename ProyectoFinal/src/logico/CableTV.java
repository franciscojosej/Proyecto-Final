package logico;

import java.io.Serializable;

public class CableTV extends Plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidadCanales;
	private float consto;
	
	
	




	public CableTV(int codigo, String nombre, int cantidadCanales) {
		super(codigo, nombre);
		this.cantidadCanales = cantidadCanales;
		//this.consto = 100;
	}
		

	
	
	public int getCantidadCanales() {
		return cantidadCanales;
	}




	public void setCantidadCanales(int cantidadCanales) {
		this.cantidadCanales = cantidadCanales;
	}




	public float CalcularCosto() {
		// TODO Auto-generated method stub
		return cantidadCanales*consto;
	}

}
