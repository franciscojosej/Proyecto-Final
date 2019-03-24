package logico;

public class Telefono extends Plan {

	private int tiempo_hablado;
	private float constoLineaFija;
	
	
	
	
	public Telefono(String nombre, String tipo, int tiempo_hablado, float constoLineaFija) {
		super(nombre, tipo);
		this.tiempo_hablado = tiempo_hablado;
		this.constoLineaFija = constoLineaFija;
	}


	public int getTiempo_hablado() {
		return tiempo_hablado;
	}


	public void setTiempo_hablado(int tiempo_hablado) {
		this.tiempo_hablado = tiempo_hablado;
	}




	public float getConstoLineaFija() {
		return constoLineaFija;
	}




	public void setConstoLineaFija(float constoLineaFija) {
		this.constoLineaFija = constoLineaFija;
	}




	public float CalcularCosto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
