package logico;

public class Cliente extends Persona {
	
	private String cargo;
	private String codigo_cliente;
	private String codigo_tarjeta;
	private Contrato miscontract;
	
	
	public Contrato getMiscontract() {
		return miscontract;
	}

	public void setMiscontract(Contrato miscontract) {
		this.miscontract = miscontract;
	}

	public Cliente(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social, String cargo, String codigo_cliente,
			String codigo_tarjeta) {
		super(nombre, apellido, cedula, telefono, direccion, sexo, ciudad, telefono_fijo, estado_social);
		this.cargo = cargo;
		this.codigo_cliente = codigo_cliente;
		this.codigo_tarjeta = codigo_tarjeta;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(String codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	public String getCodigo_tarjeta() {
		return codigo_tarjeta;
	}
	public void setCodigo_tarjeta(String codigo_tarjeta) {
		this.codigo_tarjeta = codigo_tarjeta;
	}
	
	
	
	

}
