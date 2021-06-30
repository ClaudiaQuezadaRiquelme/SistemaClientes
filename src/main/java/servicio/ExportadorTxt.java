package servicio;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {
	private ClienteServicio clienteServicio;
	private BufferedWriter bufferedWriter;
	
	public ExportadorTxt(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		String directorio = "documentosTxt";
		String rutaArchivo = crearArchivo(directorio, fileName);
		
		int listaLength = listaClientes.size();
		for (int i = 0; i < listaLength; i++) {
			escribirArchivo(rutaArchivo, clienteServicio.listarClientes(i));
		}
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error en escribir y cerrar archivo");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error en exportar txt");
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato csv.");
	}

	private String crearDirectorio(String nombre) {
		String ruta = "src/"+nombre;
		File directorio = new File(ruta);
		if (directorio.exists() == false) {
			directorio.mkdir();
		}
		return ruta;
	}
	
	private String crearArchivo(String directorio, String documento) {
		String ruta = crearDirectorio(directorio);
		String rutaArchivo = ruta + "/" + documento + ".txt";
		File archivo = new File(rutaArchivo);
		try {
			archivo.createNewFile();
			return rutaArchivo;
		} catch (IOException e) {
			System.out.println("Error al crear archivo");
			e.printStackTrace();
			return "";
		}
	}
	
	private void escribirArchivo(String ruta, String linea) {
		File archivo = new File(ruta);
		FileWriter fileW;
		try {
			fileW = new FileWriter(archivo);
			if (bufferedWriter == null) {
				bufferedWriter = new BufferedWriter(fileW);
			}
			bufferedWriter.write(linea);
			bufferedWriter.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir archivo");
			e.printStackTrace();
		}
		
	}
}
