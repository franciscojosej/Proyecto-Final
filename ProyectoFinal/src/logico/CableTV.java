package logico;

public class CableTV extends Plan {

	private int cantidadCanales;
	private float consto;
	
	
	









	public CableTV(int codigo, String nombre, int cantidadCanales) {
		super(codigo, nombre);
		this.cantidadCanales = cantidadCanales;
		//this.consto = 100;
	}
		

	public float CalcularCosto() {
		// TODO Auto-generated method stub
		return cantidadCanales*consto;
	}

}
