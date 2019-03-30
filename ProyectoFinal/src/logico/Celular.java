package logico;

import java.io.Serializable;

public class Celular extends Plan implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minutos;
	private float costoCelular;
	


	
	public Celular(int codigo, String nombre, int minutos) {
		super(codigo, nombre);
		this.minutos = minutos;
		//this.costoCelular = costoCelular;
	}

	public float getCostoCelular() {
		return costoCelular;
	}

	public void setCostoCelular(float costoCelular) {
		this.costoCelular = costoCelular;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public float CalcularCosto() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}


