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
	
	public void listarClientes () { // recorrer lista clientes y mostrar información
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			System.out.println("-------------Datos del Cliente-------------");
			System.out.printf("\n" + listaClientes.get(i).toString());
			System.out.println("-------------------------------------------");
		}
	}
	public void agregarCliente (String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		listaClientes.add(cliente);
	}
	public void editarCliente (Cliente cliente, String runCliente) {
		// Buscar el cliente en la lista clientes
		
		// Editar los parámetros de ese cliente
	}
	public void editarCliente (Cliente cliente, CategoriaEnum nombreCategoria) {
		cliente.setNombreCategoria(nombreCategoria);
		// Buscar el cliente en la lista clientes
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			// Editar los parámetros de ese cliente
			if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) {
				listaClientes.get(i).setNombreCategoria(nombreCategoria);
			}
		}
	}
}
