package logico;

public class Internet extends Servicio {

	private int velocidad_conexion;

	
	public Internet(float precio_total, String nombre, String tipo, Plan misplanes, int velocidad_conexion) {
		super(precio_total, nombre, tipo, misplanes);
		this.velocidad_conexion = velocidad_conexion;
	}

	public int getVelocidad_conexion() {
		return velocidad_conexion;
	}

	public void setVelocidad_conexion(int velocidad_conexion) {
		this.velocidad_conexion = velocidad_conexion;
	}

	
	
	

}
