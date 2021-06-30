package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorCsv extends Exportador { // ME LLAMO EXPORTADOR PERO ESTOY IMPORTANDO D;
	private BufferedReader br;
	private ClienteServicio clienteServicio;
	
	public ExportadorCsv(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	@Override
	public void exportar(String ruta, List<Cliente> listaClientes) {
		cargarArchivo(ruta);
		String data;
		try {
			data = br.readLine();
			while (data != null) {
				String[] parts = data.split(",");
				
				if (parts.length > 1) {
					String run = parts[0];
					String nombre = parts[1];
					String apellido = parts[2];
					String aniosPre = parts[3];
					String categoriaPre = parts[4];
					CategoriaEnum categoria = CategoriaEnum.ACTIVO; // Valor por defecto
					
					// obtener numero de anios y enum de categoria
					int anios = Integer.parseInt(aniosPre.split(" ")[0]);
					
					if ((categoriaPre.equals("Inactivo")) || (categoriaPre.equals("inactivo")) || (categoriaPre.equals("INACTIVO"))) {
						categoria = CategoriaEnum.INACTIVO;
					}
					
					clienteServicio.agregarCliente(run, nombre, apellido, anios, categoria);
				}
				data = br.readLine();
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error en lectura de líneas del documento.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error en exportar csv");
			e.printStackTrace();
		}
		
		
	}
	private void cargarArchivo(String ruta) {
		File archivo = new File(ruta);
		try {
			FileReader fr = new FileReader(archivo);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.out.println("Error en carga para lectura de archivo.");
			e.printStackTrace();
		}
	}

}
