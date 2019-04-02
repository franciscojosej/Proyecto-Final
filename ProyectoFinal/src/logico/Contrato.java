package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Contrato implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean estado;//Habilidado
	private String fecha_de_pago;
	private String fecha_inicio;
	private String fecha_vencimiento;
	private ArrayList<Plan> misPlanes;
	private int codigoDeContrato;
	private int FacturasEmitidas;
	



	
	
	public Contrato( String fecha_de_pago, String fecha_inicio, String fecha_vencimiento,
			 int codigoDeContrato ) {
		super();
		this.estado = true;
		this.fecha_de_pago = fecha_de_pago;
		this.fecha_inicio = fecha_inicio;
		this.fecha_vencimiento = fecha_vencimiento;
		this.misPlanes = new ArrayList<Plan>();
		this.codigoDeContrato = codigoDeContrato;
		FacturasEmitidas = 0;
	}


	public boolean getEstado() {
		return estado;
	}


	public int getFacturasEmitidas() {
		return FacturasEmitidas;
	}
	public void setFacturasEmitidas() {
		
		
		if(FacturasEmitidas==3) {
			setEstado(false);
		}
		FacturasEmitidas++;
			
		
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}


	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}






	public String getFecha_de_pago() {
		return fecha_de_pago;
	}


	public void setFecha_de_pago(String fecha_de_pago) {
		this.fecha_de_pago = fecha_de_pago;
	}


	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public void setFacturasEmitidas(int facturasEmitidas) {
		FacturasEmitidas = facturasEmitidas;
	}



	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	public void agregarServicio(Plan nuevoPlan) {
		misPlanes.add( nuevoPlan);
	}
	public float getPrecioDelPlan() {
		float precio=0;
		for (Plan plan : misPlanes) {
			precio+=plan.CalcularCosto();
		}
		return precio;
		
	}


	public int getCodigoDeContrato() {
		return codigoDeContrato;
	}


	public void setCodigoDeContrato(int codigoDeContrato) {
		this.codigoDeContrato = codigoDeContrato;
	}



	
	
	
	
}
