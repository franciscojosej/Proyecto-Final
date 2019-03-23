package logico;

import java.util.ArrayList;

public class Facturacion {

	private ArrayList<Contrato> micontrato;

	public Facturacion(ArrayList<Contrato> micontrato) {
		super();
		this.micontrato = micontrato;
	}

	public ArrayList<Contrato> getMicontrato() {
		return micontrato;
	}

	public void setMicontrato(ArrayList<Contrato> micontrato) {
		this.micontrato = micontrato;
	}
	
	
	
}
