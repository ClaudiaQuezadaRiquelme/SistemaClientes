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
			System.out.println("Ingrese una opción:");
			for (int i = 0; i < opcionesLength; i++) {
				System.out.println((i + 1) + " " + opciones[i]);
			}
			opcionElegida = scn.nextInt();
		} while (opcionElegida != 6);
		
	}

	public void listar() {
		
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
		
	}
}
