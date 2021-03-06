package logico;

import java.io.Serializable;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codiFactura;
	private String nombreCliente;
	private int codiCliente;
	private float recargo;
	
	private String fechaEmicion;
	private String fechaDevencimiento;
	
	private boolean sinPagar;

	private float precioBase;
	private float totalA_Pagar;
	private int codigoContrato;
	
	
	
	
	





public Factura( String nombreCliente, int codiCliente, float recargo, String fechaEmicion,
			String fechaDevencimiento, float precioBase, float totalA_Pagar,int codigoContrato) {
		super();
		this.nombreCliente = nombreCliente;
		this.codiCliente = codiCliente;
		this.recargo = recargo;
		this.fechaEmicion = fechaEmicion;
		this.fechaDevencimiento = fechaDevencimiento;
		this.sinPagar = true;
		this.precioBase = precioBase;
		this.totalA_Pagar = totalA_Pagar;
		this.codigoContrato=codigoContrato;
		
	}

//this.fechaEmicion=fechaEmicion.toString();


	public int getCodiFactura() {
		return codiFactura;
	}

	public int getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(int codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public void setCodiFactura(int codiFactura) {
		this.codiFactura = codiFactura;
	}



	public int getCodiCliente() {
		return codiCliente;
	}

	public void setCodiCliente(int codiCliente) {
		this.codiCliente = codiCliente;
	}

	public float getRecargo() {
		return recargo;
	}

	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}

	

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getTotalA_Pagar() {
		return totalA_Pagar;
	}

	public void setTotalA_Pagar(float totalA_Pagar) {
		this.totalA_Pagar = totalA_Pagar;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFechaEmicion() {
		return fechaEmicion;
	}

	public void setFechaEmicion(String fechaEmicion) {
		this.fechaEmicion = fechaEmicion;
	}

	public String getFechaDevencimiento() {
		return fechaDevencimiento;
	}

	public void setFechaDevencimiento(String fechaDevencimiento) {
		this.fechaDevencimiento = fechaDevencimiento;
	}

	public boolean getSinPagar() {
		return sinPagar;
	}

	public void setSinPagar(boolean sinPagar) {
		this.sinPagar = sinPagar;
	}


	
	
	
	
	
	
	
	
	
	
	




	
	
}
