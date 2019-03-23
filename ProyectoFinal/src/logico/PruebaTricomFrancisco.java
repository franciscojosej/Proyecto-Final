package logico;

import java.util.ArrayList;

public class PruebaTricomFrancisco {
	public static PruebaTricomFrancisco Tricom;
	private ArrayList<Cliente> misCliente;
	private ArrayList<Contrato> misContrato;
	
	
	
	 public PruebaTricomFrancisco() {
		super();
		this.misCliente = new ArrayList<Cliente>();
		this.misContrato = new ArrayList<Contrato>();
	}



	public static PruebaTricomFrancisco getInstance(){
		 if(Tricom == null){
			 Tricom = new PruebaTricomFrancisco();
		 }
		 
		 return Tricom;
	 }



	public static PruebaTricomFrancisco getTricom() {
		return Tricom;
	}



	public static void setTricom(PruebaTricomFrancisco tricom) {
		Tricom = tricom;
	}



	public ArrayList<Cliente> getMisCliente() {
		return misCliente;
	}



	public void setMisCliente(ArrayList<Cliente> misCliente) {
		this.misCliente = misCliente;
	}



	public ArrayList<Contrato> getMisContrato() {
		return misContrato;
	}



	public void setMisContrato(ArrayList<Contrato> misContrato) {
		this.misContrato = misContrato;
	} 
	

}
