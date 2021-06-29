package vista;

import java.util.ArrayList;
import java.util.List;
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
	
	private String[] menuOpciones = {
            "Listar Clientes",
            "Agregar Cliente",
            "Editar Cliente",
            "Cargar Datos",
            "Exportar Datos",
            "Salir",
	};
	private String[] editarOpciones = {
            "Cambiar el estado del Cliente",
            "Editar los datos ingresados del Cliente"
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
		int opcionesLength = menuOpciones.length;
		int opcionElegida = 0;
		do {
			try {
				System.out.println("Ingrese una opción:");
				for (int i = 0; i < opcionesLength; i++) {
					System.out.println((i + 1) + " " + menuOpciones[i]);
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

	private void listar() {
		clienteServicio.listarClientes();
	}
	private void agregar() {
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
	private void editar() {
		System.out.println("-------------Editar Cliente-------------");
		boolean salir = false;
		int opcionElegida = 0;
		
		do {
			try {
				System.out.println("Seleccione qué desea hacer:");
				
				int opcionesLength = editarOpciones.length;
				for (int i = 0; i < opcionesLength; i++) {
					System.out.println((i + 1) + ".-" + editarOpciones[i]);
				}
				System.out.println("Ingrese opción:");
				opcionElegida = scn.nextInt();
				
				switch (opcionElegida) {
					case 1:
						salir = editarEstado();
					break;
					case 2:
						salir = editarDatos();
					break;
					default:
						System.out.println("Ingrese por favor caracteres numéricos: 1 ó 2.");
					break;
				}
				System.out.println("----------------------------------------");
				
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Ha ingresado una opción inválida. Por favor, Ingrese sólo caracteres numéricos: 1 ó 2.");
				scn.nextLine(); // evita loop infinito con scanner
			} catch (Exception e) {
				System.out.println("Error en la ejecución");
			}
			System.out.println(" ");
		} while( ((opcionElegida != 1) || (opcionElegida != 2)) && (salir == false));
	}
	private boolean editarEstado() {
		boolean clientExist = false;
		System.out.printf("\nIngrese RUN del Cliente a editar:\n");
		String runCliente = scn.next();
		List<Cliente> listaClientes = clienteServicio.getListaCliente();
		Cliente cliente = new Cliente();
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			String runTemp = listaClientes.get(i).getRunCliente();
			if (runCliente.equals(runTemp)) {
				cliente = listaClientes.get(i);
				clientExist = true;
				break;
			}
		}
		
		if (clientExist) {
			System.out.println("-----Actualizando estado del Cliente----");
			System.out.println("El estado actual es: " + cliente.getNombreCategoria());
			System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2.-Si desea mantener el estado del cliente Activo");
			System.out.printf("\nIngrese opcion:\n----------------------------------------\n");
			int opcionElegida = 0;
			
			do {
				try {
					opcionElegida = scn.nextInt();
					switch (opcionElegida) {
						case 1:
							clienteServicio.editarCliente(cliente, CategoriaEnum.INACTIVO);
							System.out.println("----------------------------------------");
							System.out.println("Datos cambiados con éxito");
							return true; // salir
						// break;
						case 2:
							System.out.println("----------------------------------------");
							System.out.println("Estado del cliente sin cambios.");
							return true; // salir
						// break;
						default:
							System.out.println("Ingrese por favor caracteres numéricos: 1 ó 2.");
						break;
					}
				} catch (java.util.InputMismatchException ime) {
					System.out.println("Ha ingresado una opción inválida. Por favor, Ingrese sólo caracteres numéricos: 1 ó 2.");
					scn.nextLine(); // evita loop infinito con scanner
				} catch (Exception e) {
					System.out.println("Error en la ejecución");
				}
			} while((opcionElegida != 1) || (opcionElegida != 2));
		} else {
			System.out.println("El run ingresado no corresponde con ninguno de nuestros clientes.");
		}
		return true; // salir
	}
	private boolean editarDatos() {
		
		return true; // salir
	}
	private void cargar() {
		
	}
	private void exportar() {
		
	}
	private void salir() {
		System.out.println("Hasta luego.");
	}
}
