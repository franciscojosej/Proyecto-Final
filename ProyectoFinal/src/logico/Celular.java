package logico;

public class Celular extends Plan {

	private int minutos;
	private float costoCelular;
	


	public Celular(String nombre, String tipo) {
		super(nombre, tipo);
	
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


