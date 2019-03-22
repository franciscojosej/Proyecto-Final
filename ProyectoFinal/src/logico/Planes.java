package logico;

import java.util.ArrayList;
import java.util.Date;

public class Planes {

	private String nombre;
	private String tipo;
	private Date fecha_contrato;
	private ArrayList<Servicios> miservi;
	
	public Planes(String nombre, String tipo, Date fecha_contrato, ArrayList<Servicios> miservi) {
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

	public ArrayList<Servicios> getMiservi() {
		return miservi;
	}

	public void setMiservi(ArrayList<Servicios> miservi) {
		this.miservi = miservi;
	}
	
	
 }
