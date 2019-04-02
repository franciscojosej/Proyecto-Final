package logico;

public class ClaseDePruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		Cliente m= new Cliente("pepe", "gom", " ", " ", " ", " ", " "," ", " ", i);
		
	
		//CableTV meTv = new CableTV("3", "Al Otro Dia",11);
	//	miContrato.agregarServicio(meTv);
	//	m.agrregarcontrato(miContrato);
		
		
		Tricom.getInstance().insertarCliente(m);
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
	
		//Tricom.getInstance().generaFactura();

		for (Factura misFac : Tricom.getInstance().getMisFacturas()) {
			System.out.println("Codigo de Factura "+misFac.getCodiFactura()+" Antes de cargo"
		+misFac.getPrecioBase()+"Carfo por mes"+misFac.getRecargo()
		+"Total a pagar"+misFac.getTotalA_Pagar()+"Estado");
		}
		

	//	CableTV meT = new CableTV("3", "Al Otro Dia",1);
	//	miContrato2.agregarServicio(meT);
	//	m.agrregarcontrato(miContrato2);
	/*
		System.out.println("\n\n");
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().generaFactura();
		Tricom.getInstance().insertarCliente(m);
		
		for (Factura misFac : Tricom.getInstance().getMisFacturas()) {
			System.out.println("Codigo de Factura "+misFac.getCodiFactura()+"Antes de cargo"
		+misFac.getPrecioBase()+"Carfo por mes"+misFac.getRecargo()+"Total a pagar"+misFac.getTotalA_Pagar());
		}
		
		*/
		

	}

}
