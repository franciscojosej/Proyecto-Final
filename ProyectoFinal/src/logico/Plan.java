package logico;

import java.io.Serializable;

public abstract class Plan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	




	


	
	public Plan(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
	abstract public float CalcularCosto();
	




}