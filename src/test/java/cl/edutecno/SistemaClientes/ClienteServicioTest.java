package cl.edutecno.SistemaClientes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ClienteServicio clienteServicio;
	private String run = "16.777.888-9";
	private String nombre = "Pedro";
	private String apellido = "Picapiedra";
	private int anios = 54;
	private CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
	
	@Before
	public void setUp () {
		clienteServicio = new ClienteServicio(listaClientes);
	}
	
	@Test
	public void agregarClienteTest () {
		clienteServicio.agregarCliente(run, nombre, apellido, anios, nombreCategoria);
		
		ArrayList<Cliente> testListaClientes = new ArrayList<Cliente> (clienteServicio.getListaCliente());
		assertEquals(testListaClientes.get(0).getRunCliente(), run);
	}
	
	@Test
	public void editarClienteAniosTest () {
		int newAnios = 55;
		clienteServicio.agregarCliente(run, nombre, apellido, anios, nombreCategoria);
		
		Cliente clienteTest = clienteServicio.getListaCliente().get(0);
		clienteServicio.editarCliente(clienteTest, newAnios);
		assertEquals(clienteServicio.getListaCliente().get(0).getAniosCliente(), newAnios);
	}
}
