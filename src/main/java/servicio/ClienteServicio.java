package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	private List<Cliente> listaClientes;
	
	public ClienteServicio (ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<Cliente> getListaCliente () {
		return listaClientes;
	}
	
	public void listarClientes () {
		// recorrer lista clientes y mostrar información
	}
	public void agregarCliente (String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		listaClientes.add(cliente);
	}
	public void editarCliente (String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		// Buscar el cliente en la lista clientes
		
		// Editar los parámetros de ese cliente
	}
}
