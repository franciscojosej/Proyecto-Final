package logico;

public class Telefono extends Servicio {

	private int tiempo_hablado;

	


	public Telefono(float precio_total, String nombre, String tipo, int tiempo_hablado) {
		super(precio_total, nombre, tipo);
		this.tiempo_hablado = tiempo_hablado;
	}

	public int getTiempo_hablado() {
		return tiempo_hablado;
	}

	public void setTiempo_hablado(int tiempo_hablado) {
		this.tiempo_hablado = tiempo_hablado;
	}

	
	
}
