package logico;



public abstract class Plan {

	private int codigo;
	private String nombre;
	private int  unidades_Plan;




	

	public Plan(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;

	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getUnidades_Plan() {
		return unidades_Plan;
	}

	public void setUnidades_Plan(int unidades_Plan) {
		this.unidades_Plan = unidades_Plan;
	}
	
	abstract public float CalcularCosto();
	




}