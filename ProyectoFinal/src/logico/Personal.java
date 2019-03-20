package logico;

import java.sql.Date;

public class Personal extends Persona {
	protected String codigo_empleado;
	protected float sueldo_base;
	protected String Departamento;
	protected float sueldo;
	protected int dias_trabajados;
	protected int horas_extra;
	protected Date fecha_ingreso;
	protected String num_seguro_social;
	
	public Personal(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social, String codigo_empleado, float sueldo_base,
			String departamento, float sueldo, int dias_trabajados, int horas_extra, Date fecha_ingreso,
			String num_seguro_social) {
		super(nombre, apellido, cedula, telefono, direccion, sexo, ciudad, telefono_fijo, estado_social);
		this.codigo_empleado = codigo_empleado;
		this.sueldo_base = sueldo_base;
		Departamento = departamento;
		this.sueldo = sueldo;
		this.dias_trabajados = dias_trabajados;
		this.horas_extra = horas_extra;
		this.fecha_ingreso = fecha_ingreso;
		this.num_seguro_social = num_seguro_social;
	}

	public String getCodigo_empleado() {
		return codigo_empleado;
	}

	public void setCodigo_empleado(String codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public float getSueldo_base() {
		return sueldo_base;
	}

	public void setSueldo_base(float sueldo_base) {
		this.sueldo_base = sueldo_base;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getDias_trabajados() {
		return dias_trabajados;
	}

	public void setDias_trabajados(int dias_trabajados) {
		this.dias_trabajados = dias_trabajados;
	}

	public int getHoras_extra() {
		return horas_extra;
	}

	public void setHoras_extra(int horas_extra) {
		this.horas_extra = horas_extra;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getNum_seguro_social() {
		return num_seguro_social;
	}

	public void setNum_seguro_social(String num_seguro_social) {
		this.num_seguro_social = num_seguro_social;
	}
	
	
	

}
