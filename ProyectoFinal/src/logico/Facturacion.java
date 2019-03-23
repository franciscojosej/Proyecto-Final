package logico;

import java.util.ArrayList;

public class Facturacion {

	private Contrato micontrato;
	private Cliente miCliente;

	public Facturacion(Contrato micontrato, Cliente miCliente) {
		super();
		this.micontrato = micontrato;
		this.miCliente = miCliente;
	}

	public Contrato getMicontrato() {
		return micontrato;
	}

	public void setMicontrato(Contrato micontrato) {
		this.micontrato = micontrato;
	}
	
	
	
}
