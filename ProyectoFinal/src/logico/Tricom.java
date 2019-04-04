package logico;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.GregorianCalendar;




import logico.Factura;

public class Tricom implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public static int ClienteCod = 0;
	public static int FacturacionCod ;
	public static int PlanesCod ;
	public static int EmpleadoCod ;
	public static int ContratoCod ;
	public static int ClienteCod;
	
	private ArrayList<Contrato> misContrato;
	private ArrayList<Plan> miPlan;
	private ArrayList<Cliente> miCliente;

	private ArrayList<Factura> misFacturas;
	
	private ArrayList<Empleado> MiPersonal;
	
	
	private static Tricom tricom=null;

	

	private Tricom (){
		super();
		MiPersonal = new ArrayList<Empleado>();
		miCliente = new ArrayList<Cliente>();
		 misContrato=new ArrayList<Contrato>();
		
		
		miPlan=new ArrayList<Plan>();
		misFacturas = new ArrayList<Factura>();
		
		ClienteCod=0;
		ContratoCod = 0;
		EmpleadoCod = 0;
		PlanesCod = 0;
		FacturacionCod = 0;
	}
	
	public static Tricom getInstance(){
		 if(tricom == null){
			 tricom = new Tricom();
		 }
		 return tricom;
	 }



	public static int getClienteCod() {
		return ClienteCod;
	}

	public static void setClienteCod(int clienteCod) {
		ClienteCod = clienteCod;
	}

	public ArrayList<Contrato> getMisContrato() {
		return misContrato;
	}

	public void setMisContrato(ArrayList<Contrato> misContrato) {
		this.misContrato = misContrato;
	}



	public static int getCode() {
		return ClienteCod;
	}

	public static void setCode(int code) {
		Tricom.ClienteCod = code;
	}

	public ArrayList<Cliente> getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(ArrayList<Cliente> miCliente) {
		this.miCliente = miCliente;
	}
	

	public ArrayList<Empleado> getMiPersonal() {
		return MiPersonal;
	}

	public void setMiPersonal(ArrayList<Empleado> miPersonal) {
		MiPersonal = miPersonal;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	
	public ArrayList<Plan> getMiPlan() {
		return miPlan;
	}

	public void setMiPlan(ArrayList<Plan> miPlan) {
		this.miPlan = miPlan;
	}
	
	public void insertarCliente(Cliente client){
		
		++ClienteCod;
	//	client.setCodigo_cliente(ClienteCod);
		miCliente.add(client);
		
	}
	
	
public void insertarPlan(Plan aux){
		
	
		//++PlanesCod;
		aux.setCodigo(PlanesCod);
		miPlan.add(aux);
	
	}
	
	
	public void insertarContrato(Contrato contra){
		++ContratoCod;
		//contra.setCodigoDeContrato(String.valueOf(ContratoCod));
		misContrato.add(contra);
		
		
	}
	
	public void insertarFactura(Factura fact){
		FacturacionCod++;
		fact.setCodiFactura(FacturacionCod);
		misFacturas.add(fact);	
	}
	public void insertarEmpleado(Empleado nuevoEmpleado) {
		EmpleadoCod++;
		nuevoEmpleado.setCodigo_empleado(String.valueOf(EmpleadoCod));
		MiPersonal.add(nuevoEmpleado);
	}


	public Cliente BuscarByCedula(String cedula) {
		Cliente client=null;
		boolean find = false;
		int i=0;
		while (i<miCliente.size()&&!find) {
			if(miCliente.get(i).getCedula().equalsIgnoreCase(cedula)){
				client = miCliente.get(i);
				find = true;
			}
			i++;
		}
		return client;
	}

	
	public static Tricom getTricom() {
		return tricom;
	}

	public static void setTricom(Tricom tricom) {
		Tricom.tricom = tricom;
	}

	public void CargarDatosCliente(Cliente cli){
		int i=0;
		boolean found = false;
		while (i<miCliente.size() && !found){
			if(miCliente.get(i).getCodigo_cliente() == cli.getCodigo_cliente()){
				miCliente.get(i).setNombre(cli.getNombre());
				miCliente.get(i).setCedula(cli.getCedula());
				miCliente.get(i).setTelefono(cli.getTelefono()); //miCliente.get(i).setCel(cli.getCel());
				miCliente.get(i).setDireccion(cli.getDireccion());
				found = true;
			}else{
				i++;
			}
		}
	}
	
	public void borrarCliente(Cliente cliente){
		miCliente.remove(cliente);
		ClienteCod--;
		cliente.setCodigo_cliente(ClienteCod);
		
	}
	public void generaFactura() {
		
		
		Factura auxFa=null;
		float recargo=0;

			for (Cliente cliente_Aux : miCliente) {
			for (Contrato contrato_Aux : cliente_Aux.getMiscontract()) {
				if(contrato_Aux.getEstado()) {
					//contrato_Aux.getFacturasEmitidas()<4 &&
					cliente_Aux.getMiscontract().get(cliente_Aux.getMiscontract()
							.indexOf(contrato_Aux)).setFacturasEmitidas();//aumento la cantidad de facturas emitidas
					
					auxFa=modeloFactura();//se Cargan fecha de inicio y fecha de pago
					
					auxFa.setNombreCliente(cliente_Aux.getNombre());
					auxFa.setCodiCliente(cliente_Aux.getCodigo_cliente());
					auxFa.setPrecioBase(contrato_Aux.getPrecioDelPlan());
					if(contrato_Aux.getFacturasEmitidas()==1) {
						//recargo=(float) ((contrato_Aux.getPrecioDelPlan())*0.1);
					}
					if(contrato_Aux.getFacturasEmitidas()==2) {
						recargo=(float) ((contrato_Aux.getPrecioDelPlan())*0.1);
					}
					if(contrato_Aux.getFacturasEmitidas()==3) {
						recargo=(float) ((contrato_Aux.getPrecioDelPlan())*0.2);
					}
					if(contrato_Aux.getFacturasEmitidas()==4) {
						recargo=(float) ((contrato_Aux.getPrecioDelPlan())*0.3);
					}
					auxFa.setRecargo(recargo);
					auxFa.setTotalA_Pagar(recargo+contrato_Aux.getPrecioDelPlan());
					
					
					insertarFactura(auxFa);
					
				} 
					
				

				
		
				
			}
			
			
		}
		
	}
	public Factura modeloFactura() {
	
		Factura factura_Aux= new Factura(" ", 1, 0, getFechaInicio() ,
				getFechavencimiento(), 0, 0);
	return factura_Aux;
	}
	public static String getFechaInicio() {
		Calendar fecha =  new GregorianCalendar();
		return String.valueOf((fecha.get(Calendar.MONTH)+1)+"-"+fecha.get(Calendar.DAY_OF_MONTH)+
				"-"+fecha.get(Calendar.YEAR)+" "+fecha.get(Calendar.HOUR_OF_DAY)+ ":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND));
	}
	public static String getFechavencimiento() {
		Calendar fecha =  new GregorianCalendar();
		String fe="/ / /";
		if(fecha.get(Calendar.MONTH)+2<12) {
		fe	= String.valueOf((fecha.get(Calendar.MONTH)+2)+"-"+fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.YEAR)
		+" "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND));
		}else {
			fe	= String.valueOf((fecha.get(Calendar.MONTH)+1)+"-"+fecha.get(Calendar.DAY_OF_MONTH)+
					"-"+fecha.get(Calendar.YEAR)+" "+fecha.get(Calendar.HOUR_OF_DAY)+ ":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND));
		}
			
		return fe;
	}
	
	
	//buscar Contrato por codiog , retorna el contrato si existe de lo contrario null
	private Contrato findC0ntratoByCode(int id) {
		Contrato contrato=null;
		
		boolean find = false;
		int i=0;
		while (i<misContrato.size()&&!find) {
			if(misContrato.get(i).getCodigoDeContrato()==id){
				contrato = misContrato.get(i);
				find = true;
			}
			i++;
		}
		return contrato;
	}
	
	//buscar el cliente por su codiguillo...
	public Cliente BuscarByCodigo(int code){
		Cliente client = null;
		int i = 0;
		boolean found = false;
		while (i<miCliente.size() && !found) {
			if(miCliente.get(i).getCodigo_cliente()== code){
				client = miCliente.get(i);
				found = true;
			}
			 i++;
		}
		
		return client;
		
	}

	//buscar empleado por su codigo.
	public Empleado BuscarPorCodigo(String identifier){
		
        Empleado worker=null;
		boolean find = false;
		int i=0;
		while (i<MiPersonal.size()&&!find) {
			if(MiPersonal.get(i).getCodigo_empleado().equalsIgnoreCase(identifier)){
				worker = MiPersonal.get(i);
				find = true;
			}
			i++;
		}
		return worker;
		
	}
	public ArrayList<Factura> agruparFacturasActivas(){//sin pagar
		ArrayList<Factura> factActivas = new ArrayList<Factura>();
		for (Factura factura : misFacturas) {
			
			if (factura.getSinPagar()) {
				factActivas.add(factura);
				
			}
		}
		return factActivas;
	
	}
	public ArrayList<Factura> agruparFacturasInactiva(){// paga
		ArrayList<Factura> factPagas = new ArrayList<Factura>();
		for (Factura factura : misFacturas) {
			
			if (!factura.getSinPagar()) {
				factPagas.add(factura);
				
			}
		}
		return factPagas;
	
	}
	public ArrayList<Factura> buscarFacturasActivasByCedulaClinte(int code){//

		ArrayList<Factura> fact = new ArrayList<Factura>();
		for (Factura factura : misFacturas) {
			
			if (factura.getCodiCliente()==code &&factura.getSinPagar()==true) {
				fact.add(factura);
				
			}
		}
		return fact;

	}
	
	public ArrayList<Contrato> buscarPlanesEnContratos(int code){
		
		ArrayList<Contrato> cont= new ArrayList<Contrato>();
		ArrayList<Plan> plancillo= new ArrayList<Plan>();
		
		for (Contrato contract : misContrato) {
			
			for (Plan pla : miPlan) {
				
				if(pla.getCodigo()==code) {
					plancillo.add(pla);
					
				}
			}
		cont.add(contract);
		}
		return cont;
	}
	
	public ArrayList<Plan> buscarPlanes(int code){
		
		ArrayList<Plan> plancillo= new ArrayList<Plan>();
		
			for (Plan pla : miPlan) {
				
				if(pla.getCodigo()==code) {
					plancillo.add(pla);
				}
			}
		
		
		return plancillo;
	}
	public Plan buscarPlan(int code){
		
		Plan plancillo= null;
		
			for (Plan pla : miPlan) {
				
				if(pla.getCodigo()==code) {
					plancillo=pla;
				}
				break;
			}
		
		
		return plancillo;
	}


	public static int getPlanesCod() {
		return PlanesCod;
	}

	public static void setPlanesCod(int planesCod) {
		PlanesCod = planesCod;
	}
	
	public float calcularCostopordode(int Code) {
		ArrayList<Plan> planes=Tricom.getInstance().buscarPlanes(Code);
		float costo=0;
	
		
		if(planes!=null)
		for (Plan plan : planes) {
			if (plan instanceof Celular) {
				
				costo+=((Celular)plan).CalcularCosto();
			}
			if (plan instanceof CableTV) {
				
				costo+=(( CableTV)plan).CalcularCosto();
			}
			if (plan instanceof Internet) {
				
				costo+=((  Internet)plan).CalcularCosto();
			}
			
		}
		return costo;
		
	}
	
	
	
	
}
