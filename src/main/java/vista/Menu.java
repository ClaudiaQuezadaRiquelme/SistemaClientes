package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class Menu {
	private ClienteServicio clienteServicio;
	//private ArchivoServicio archivoServicio;
//	private ExportarCsv exportarCsv;
//	private ExportarTxt exportarTxt;
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	private Scanner scn;
	
	private String[] opciones = {
            "Listar Clientes",
            "Agregar Cliente",
            "Editar Cliente",
            "Cargar Datos",
            "Exportar Datos",
            "Salir",
	};
	
	private static Menu menu;
	private Menu () {}
	
	public static Menu getMenu () {
		if (menu == null) {
			synchronized (Menu.class) {
				if (menu == null) {
					menu = new Menu();
					
					ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
					menu.clienteServicio = new ClienteServicio(listaClientes);
				}
			}
		}
		return menu;
	}
	
	public void iniciarMenu() {
		scn = new Scanner(System.in);
		scn.useDelimiter("\n"); // para que pueda guardar strings con espacios
		int opcionesLength = opciones.length;
		int opcionElegida = 0;
		do {
			try {
				System.out.println("Ingrese una opción:");
				for (int i = 0; i < opcionesLength; i++) {
					System.out.println((i + 1) + " " + opciones[i]);
				}
				opcionElegida = scn.nextInt();
				
				switch (opcionElegida) {
					case 1: // Listar Clientes
						listar();
					break;
					case 2: // Agregar Cliente
						agregar();
					break;
					case 3: // Editar Cliente
						editar();
					break;
					case 4: // Cargar Datos
						cargar();
					break;
					case 5: // Exportar Datos
						exportar();
					break;
					case 6: // Salir
						salir();
					break;
					default:
						System.out.println("Ingrese por favor caracteres numéricos de 1 a 6.");
					break;
				}
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Ha ingresado una opción inválida. Por favor, Ingrese sólo caracteres numéricos de 1 a 6.");
				scn.nextLine(); // evita loop infinito con scanner
			} catch (Exception e) {
				System.out.println("Error en la ejecución");
			}
			System.out.println(" ");
		} while (opcionElegida != 6);
		
	}

	public void listar() {
		clienteServicio.listarClientes();
	}
	public void agregar() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente:");
		String runCliente = scn.next();
		System.out.println("Ingresa Nombre del Cliente:");
		String nombreCliente = scn.next();
		System.out.println("Ingresa Apellido del Cliente:");
		String apellidoCliente = scn.next();
		System.out.println("Ingresa años como Cliente:");
		int aniosCliente = scn.nextInt();
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		
		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		System.out.println("---------------------------------------");
	}
	public void editar() {
		
	}
	public void cargar() {
		
	}
	public void exportar() {
		
	}
	public void salir() {
		System.out.println("Hasta luego.");
	}
}
