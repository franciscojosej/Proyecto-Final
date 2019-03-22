package logico;

public class Servicio {
	
	private float precio_total;
	private String nombre;
	private String tipo;
	
	


	public Servicio(float precio_total, String nombre, String tipo) {
		super();
		this.precio_total = precio_total;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	

}
