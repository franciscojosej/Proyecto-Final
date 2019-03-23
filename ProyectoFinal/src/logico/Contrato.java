package logico;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {

	private boolean vencida;
	private Date fecha_de_pago;
	private Date fecha_inicio;
	private Date fecha_vencimiento;
	private ArrayList<Plan> misPlanes;
	



	

	public Contrato(boolean vencida, Date fecha_de_pago, Date fecha_inicio, Date fecha_vencimiento,
			ArrayList<Plan> misPlanes) {
		super();
		this.vencida = vencida;
		this.fecha_de_pago = fecha_de_pago;
		this.fecha_inicio = fecha_inicio;
		this.fecha_vencimiento = fecha_vencimiento;
		this.misPlanes = misPlanes;
	}

	public boolean isVencida() {
		return vencida;
	}

	public void setVencida(boolean vencida) {
		this.vencida = vencida;
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
