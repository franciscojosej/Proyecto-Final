package logico;

public class Celular extends Servicios {

	private int minutos;

	

	public Celular(float precio_total, String nombre, String tipo, Planes misplanes, int minutos) {
		super(precio_total, nombre, tipo, misplanes);
		this.minutos = minutos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	
}


