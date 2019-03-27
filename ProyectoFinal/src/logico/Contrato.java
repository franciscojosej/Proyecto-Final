package logico;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {


	private boolean estado;//Habilidado
	private Date fecha_de_pago;
	private Date fecha_inicio;
	private Date fecha_vencimiento;
	private ArrayList<Plan> misPlanes;
	private String codigoDeContrato;
	private int FacturasEmitidas;



	
	
	public Contrato(boolean estado, Date fecha_de_pago, Date fecha_inicio, Date fecha_vencimiento,
			ArrayList<Plan> misPlanes, String codigoDeContrato) {
		super();
		this.estado = true;
		this.fecha_de_pago = fecha_de_pago;
		this.fecha_inicio = fecha_inicio;
		this.fecha_vencimiento = fecha_vencimiento;
		this.misPlanes = misPlanes;
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
		
		
		if(FacturasEmitidas>=3) {
			setEstado(false);
		}else {
			FacturasEmitidas++;
		}
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getCodigoDeContrato() {
		return codigoDeContrato;
	}


	public void setCodigoDeContrato(String codigoDeContrato) {
		this.codigoDeContrato = codigoDeContrato;
	}



	public Date getFecha_de_pago() {
		return fecha_de_pago;
	}

	public void setFecha_de_pago(Date fecha_de_pago) {
		this.fecha_de_pago = fecha_de_pago;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}

	
	
	
	
}
