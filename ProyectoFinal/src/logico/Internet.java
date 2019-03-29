package logico;

public class Internet extends Plan {

	
	private int velocidad_conexion;
	private float constoInternet;
	
	
	

	public Internet(int codigo, String nombre, int velocidad_conexion) {
		super(codigo, nombre);
		this.velocidad_conexion = velocidad_conexion;
		//this.constoInternet = constoInternet;
	}

	public int getVelocidad_conexion() {
		return velocidad_conexion;
	}

	public void setVelocidad_conexion(int velocidad_conexion) {
		this.velocidad_conexion = velocidad_conexion;
	}

	public float getConstoInternet() {
		return constoInternet;
	}

	public void setConstoInternet(float constoInternet) {
		this.constoInternet = constoInternet;
	}

	public float CalcularCosto() {
		// TODO Auto-generated method stub
		return constoInternet*100 +velocidad_conexion;
	}

}
