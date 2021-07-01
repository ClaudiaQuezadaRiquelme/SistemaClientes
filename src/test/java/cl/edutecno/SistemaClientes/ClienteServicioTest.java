package cl.edutecno.SistemaClientes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {
	private Cliente cliente;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ClienteServicio clienteServicio;
	
	@Before
	public void setUp () {
		clienteServicio = new ClienteServicio(listaClientes);
	}
	
	@Test
	public void agregarClienteTest () {
		String run = "16.777.888-9";
		String nombre = "Pedro";
		String apellido = "Picapiedra";
		int anios = 54;
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		clienteServicio.agregarCliente(run, nombre, apellido, anios, nombreCategoria);
		
		ArrayList<Cliente> testListaClientes = new ArrayList<Cliente> (clienteServicio.getListaCliente());
		assertEquals(testListaClientes.get(0).getRunCliente(), run);
	}
}
