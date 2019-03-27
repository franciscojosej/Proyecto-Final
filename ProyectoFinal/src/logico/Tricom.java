package logico;

import java.util.ArrayList;

import logico.Factura;

public class Tricom {
	

	//public static int ClienteCod = 0;
	public static int FacturacionCod = 0;
	public static int PlanesCod = 0;
	public static int EmpleadoCod = 0;
	public static int ContratoCod = 0;
	public static int ClienteCod=0;
	private ArrayList<Contrato> misContrato;
	private ArrayList<Cliente> miCliente;
//	private ArrayList<Factura>tuContrato;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> cliConServicios;
	private ArrayList<Empleado> MiPersonal;
	
	
	private static Tricom tricom=null;
	public static Object getEmpleados;
	

	private Tricom (){
		super();
		MiPersonal = new ArrayList<Empleado>();
		miCliente = new ArrayList<Cliente>();
		cliConServicios=new ArrayList<Cliente>();
		//tuContrato = new ArrayList<>();
		misFacturas = new ArrayList<Factura>();
	}
	
	public static Tricom getInstance(){
		 if(tricom == null){
			 tricom = new Tricom();
		 }
		 return tricom;
	 }



	public ArrayList<Contrato> getMisContrato() {
		return misContrato;
	}

	public void setMisContrato(ArrayList<Contrato> misContrato) {
		this.misContrato = misContrato;
	}

	public ArrayList<Cliente> getCliConServicios() {
		return cliConServicios;
	}

	public void setCliConServicios(ArrayList<Cliente> cliConServicios) {
		this.cliConServicios = cliConServicios;
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
	

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	
	public void insertarCliente(Cliente client){
		miCliente.add(client);
		ClienteCod++;
		client.setCodigo_cliente(ClienteCod);
		
	}
	public void insertarContrato(Contrato contra){
		ContratoCod++;
		contra.setCodigoDeContrato(String.valueOf(ContratoCod));
		misContrato.add(contra);
		
		
	}
	
	public void insertarFactura(Factura fact){
		FacturacionCod++;
		fact.setCodiFactura(FacturacionCod);
		misFacturas.add(fact);	
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
	
	//buscar Contrato por codiog , retorna el contrato si existe de lo contrario null
	private Contrato findCintratoByCode(String id) {
		Contrato contrato=null;
		
		boolean find = false;
		int i=0;
		while (i<misContrato.size()&&!find) {
			if(misContrato.get(i).getCodigoDeContrato().equalsIgnoreCase(id)){
				contrato = misContrato.get(i);
				find = true;
			}
			i++;
		}
		return contrato;
	}
	
	

	

}
