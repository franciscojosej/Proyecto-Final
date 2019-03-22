package logico;

import java.util.ArrayList;
import java.util.Date;

public class Plan {

	private String nombre;
	private String tipo;
	private Date fecha_contrato;
	private ArrayList<Servicio> miservi;
	
	public Plan(String nombre, String tipo, Date fecha_contrato, ArrayList<Servicio> miservi) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha_contrato = fecha_contrato;
		this.miservi = miservi;
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

	public Date getFecha_contrato() {
		return fecha_contrato;
	}

	public void setFecha_contrato(Date fecha_contrato) {
		this.fecha_contrato = fecha_contrato;
	}

	public ArrayList<Servicio> getMiservi() {
		return miservi;
	}

	public void setMiservi(ArrayList<Servicio> miservi) {
		this.miservi = miservi;
	}
	
	
 }
