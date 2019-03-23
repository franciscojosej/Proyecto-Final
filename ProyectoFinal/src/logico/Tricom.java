package logico;

import java.util.ArrayList;

import logico.Facturacion;

public class Tricom {
	

	private ArrayList<Contrato> misContrato;
	private ArrayList<Cliente> miCliente;
	private ArrayList<Facturacion>tuContrato;
	private ArrayList<Facturacion> misFacturas;
	private ArrayList<Cliente> cliConServicios;
	private static int code;
	private static int codeContrato;
	private static Tricom tricom=null;
	

	private Tricom (){
		super();
		
		miCliente = new ArrayList<>();
		cliConServicios=new ArrayList<Cliente>();
		tuContrato = new ArrayList<>();
		misFacturas = new ArrayList<>();
	}
	
	public static Tricom getInstance(){
		 if(tricom == null){
			 tricom = new Tricom();
		 }
		 return tricom;
	 }

	public static int getCodeContrato() {
		return codeContrato;
	}

	public static void setCodeContrato(int codeContrato) {
		Tricom.codeContrato = codeContrato;
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
		return code;
	}

	public static void setCode(int code) {
		Tricom.code = code;
	}

	public ArrayList<Cliente> getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(ArrayList<Cliente> miCliente) {
		this.miCliente = miCliente;
	}
	
	public ArrayList<Facturacion> getTuContrato() {
		return tuContrato;
	}

	public void setTuContrato(ArrayList<Facturacion> tuContrato) {
		this.tuContrato = tuContrato;
	}
	
	public ArrayList<Facturacion> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Facturacion> misFacturas) {
		this.misFacturas = misFacturas;
	}
	
	public void insertarCliente(Cliente client){
		miCliente.add(client);
		code++;
		client.setCodigo_cliente(code);
		
	}
	public void insertarContrato(Contrato contra){
		misContrato.add(contra);
		code++;
		contra.setCodigoDeContrato(String.valueOf(code));
	}
	
	public void insertarFactura(Facturacion fact){
		misFacturas.add(fact);
		
	}
	
	public void insertarContratoCliente(Facturacion con){
		tuContrato.add(con);
		
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
		code--;
		cliente.setCodigo_cliente(code);
		
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
