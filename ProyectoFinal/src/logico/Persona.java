package logico;

public class Persona {
	protected String nombre;
	protected String apellido;
	protected String cedula;
	protected String telefono;
	protected String direccion;
	protected String sexo;
	protected String ciudad;
	protected String telefono_fijo;
	protected String estado_social;
	
	public Persona(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.direccion = direccion;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.telefono_fijo = telefono_fijo;
		this.estado_social = estado_social;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono_fijo() {
		return telefono_fijo;
	}

	public void setTelefono_fijo(String telefono_fijo) {
		this.telefono_fijo = telefono_fijo;
	}

	public String getEstado_social() {
		return estado_social;
	}

	public void setEstado_social(String estado_social) {
		this.estado_social = estado_social;
	}
	
	
	

}
