package vista;

import java.util.Scanner;

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
						System.out.println("===== Editar datos =====");
						System.out.println("Ingrese código del producto:");
						//String codigo = sc.next();
						//productoServicio.setListaProductos(archivoServicio.editarDatos​(codigo, productoServicio.getListaProductos(), sc));
	
						System.out.println("===== Fin editar datos =====");
					break;
					case 3: // Editar Cliente
						System.out.println("===== Importar datos =====");
						//productoServicio.setListaProductos(archivoServicio.cargarDatos​());
						System.out.println("===== Fin importar datos =====");
					break;
					case 4: // Cargar Datos
						System.out.println("Abandonando el sistema de productos...");
						//utilidad.salirSistema();
					break;
					case 5: // Exportar Datos
						System.out.println("Abandonando el sistema de productos...");
						//utilidad.salirSistema();
					break;
					case 6: // Salir
						salir();
					break;
					default:
						System.out.println("Ingrese por favor caracteres numéricos de 1 a 6.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Ha ingresado una opción inválida. Por favor, Ingrese sólo caracteres numéricos de 1 a 6.");
			}
			System.out.println(" ");
		} while (opcionElegida != 6);
		
	}

	public void listar() {
		clienteServicio.listarClientes();
	}
	public void agregar() {
		
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
