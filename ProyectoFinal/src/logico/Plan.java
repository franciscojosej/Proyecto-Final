package logico;



public abstract class Plan {

	private String nombre;
	private String tipo;
	
	


	public Plan(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
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
	 abstract public   float CalcularCosto();

	
	
 }
