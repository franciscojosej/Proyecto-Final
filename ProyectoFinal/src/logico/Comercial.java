package logico;

import java.io.Serializable;

public class Comercial extends Empleado implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Comercial(String nombre, String apellido, String cedula, String telefono, String direccion, String sexo,
			String ciudad, String telefono_fijo, String estado_social, String codigo_empleado, float sueldo_base,
			String departamento, float sueldo, int dias_trabajados, int horas_extra, String fecha_ingreso,
			String num_seguro_social) {
		super(nombre, apellido, cedula, telefono, direccion, sexo, ciudad, telefono_fijo, estado_social, codigo_empleado,
				sueldo_base, departamento, sueldo, dias_trabajados, horas_extra, fecha_ingreso, num_seguro_social);
		// TODO Auto-generated constructor stub
	}
	


	
	

}
