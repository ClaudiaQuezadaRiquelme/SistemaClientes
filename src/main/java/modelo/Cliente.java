package modelo;

public class Cliente {
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private int aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	public Cliente (String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	
	public Cliente () {}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(int aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	@Override
	public String toString() {
		return "RUN del Cliente: " + runCliente 
				+ "\nNombre del Cliente: " + nombreCliente 
				+ "\nApellido del Cliente: " + apellidoCliente 
				+ "\nAños como Cliente: " + aniosCliente 
				+ "\nCategoría del Cliente: " + nombreCategoria 
				+ "\n";
	}
	
}
