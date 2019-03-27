package logico;


import java.util.Date;

public class Factura {
	private int codiFactura;
	private String NombreCliente;
	private int codiCliente;
	private float recargo;
	private Date fechaDeEmicion;
	private Date fechaDevencimiento;
	
	private float precioBase;
	private float totalA_Pagar;
	
	private Cliente factCliente;

	public Factura(int codiFactura, String nombreCliente, int codiCliente, float recargo, Date fechaDeEmicion,
			Date fechaDevencimiento, float precioBase, float totalA_Pagar, Cliente factCliente) {
		super();
		this.codiFactura = codiFactura;
		NombreCliente = nombreCliente;
		this.codiCliente = codiCliente;
		this.recargo = recargo;
		this.fechaDeEmicion = fechaDeEmicion;
		this.fechaDevencimiento = fechaDevencimiento;
		this.precioBase = precioBase;
		this.totalA_Pagar = totalA_Pagar;
		this.factCliente = factCliente;
	}

	public int getCodiFactura() {
		return codiFactura;
	}

	public void setCodiFactura(int codiFactura) {
		this.codiFactura = codiFactura;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
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

	public Date getFechaDeEmicion() {
		return fechaDeEmicion;
	}

	public void setFechaDeEmicion(Date fechaDeEmicion) {
		this.fechaDeEmicion = fechaDeEmicion;
	}

	public Date getFechaDevencimiento() {
		return fechaDevencimiento;
	}

	public void setFechaDevencimiento(Date fechaDevencimiento) {
		this.fechaDevencimiento = fechaDevencimiento;
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

	public Cliente getFactCliente() {
		return factCliente;
	}

	public void setFactCliente(Cliente factCliente) {
		this.factCliente = factCliente;
	}
	
	
	
	
	
	
	
	
	
	
	




	
	
}
