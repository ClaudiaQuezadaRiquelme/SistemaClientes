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
	public String listarClientes (int index) { // diseñado para recibir el index del cliente y retornar string con la info del cliente. Debe estar dispuesto dentro de un ciclo.
		return listaClientes.get(index).toString();
	}
	public void agregarCliente (String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		listaClientes.add(cliente);
	}
	public void editarCliente (Cliente cliente, String cambio, int opcion) {
		int listaLength = listaClientes.size();
		switch (opcion) {
		case 1:
			cliente.setRunCliente(cambio);
			for (int i = 0; i < listaLength; i++) {
				
				if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) { // Buscar el cliente en la lista clientes
					listaClientes.get(i).setRunCliente(cambio); // Editar los parámetros de ese cliente
				}
			}
			break;
		case 2:
			cliente.setNombreCliente(cambio);
			for (int i = 0; i < listaLength; i++) {
				
				if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) { // Buscar el cliente en la lista clientes
					listaClientes.get(i).setNombreCliente(cambio); // Editar los parámetros de ese cliente
				}
			}
			break;
		case 3:
			cliente.setApellidoCliente(cambio);
			for (int i = 0; i < listaLength; i++) {
				
				if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) { // Buscar el cliente en la lista clientes
					listaClientes.get(i).setApellidoCliente(cambio); // Editar los parámetros de ese cliente
				}
			}
			break;

		default:
			break;
		}
	}
	public void editarCliente (Cliente cliente, int anios) {
		cliente.setAniosCliente(anios);
		
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			
			if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) { // Buscar el cliente en la lista clientes
				listaClientes.get(i).setAniosCliente(anios); // Editar los parámetros de ese cliente
			}
		}
	}
	public void editarCliente (Cliente cliente, CategoriaEnum nombreCategoria) {
		cliente.setNombreCategoria(nombreCategoria);
		
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			
			if (listaClientes.get(i).getRunCliente().equals(cliente.getRunCliente())) { // Buscar el cliente en la lista clientes
				listaClientes.get(i).setNombreCategoria(nombreCategoria); // Editar los parámetros de ese cliente
			}
		}
	}
}
