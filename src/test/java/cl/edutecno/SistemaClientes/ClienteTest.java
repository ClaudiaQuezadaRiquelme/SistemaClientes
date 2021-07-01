package cl.edutecno.SistemaClientes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteTest {
	private Cliente cliente;
	
	@Before
	public void setUp () {
		cliente = new Cliente();
	}
	
	@Test
	public void toStringClienteTest () {
		String run = "16.777.888-9";
		String nombre = "Pedro";
		String apellido = "Picapiedra";
		int anios = 54;
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		
		cliente.setRunCliente(run);
		cliente.setNombreCliente(nombre);
		cliente.setApellidoCliente(apellido);
		cliente.setAniosCliente(anios);
		cliente.setNombreCategoria(nombreCategoria);
		
		assertEquals(cliente.toString(), "RUN del Cliente: " + run 
				+ "\nNombre del Cliente: " + nombre 
				+ "\nApellido del Cliente: " + apellido 
				+ "\nAños como Cliente: " + anios 
				+ "\nCategoría del Cliente: " + nombreCategoria 
				+ "\n");
	}
}
