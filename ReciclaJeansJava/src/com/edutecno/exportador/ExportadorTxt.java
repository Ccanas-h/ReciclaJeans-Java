package com.edutecno.exportador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.edutecno.modelo.Producto;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Producto> listaProductos) {
		
		if(listaProductos.size() == 0) {
			System.out.println("La lista esta vacia");
		}else{
			
			System.out.println("Exportar Datos");
			String separador = ",";
			File file = new File(fileName);
			if(file.exists()) {
				file.delete();
			}
			System.out.println("Archivo creado en la ruta: " + file.getAbsolutePath());
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileWriter(file));
				
				for (Producto producto : listaProductos) {
					printWriter
					.append(producto.getArticulo())
					.append(separador)
					.append(producto.getCodigo())
					.append(separador)
					.append(producto.getDescripcion())
					.append(separador)
					.append(producto.getMarca())
					.append(separador)
					.append(producto.getPrecio())
					.append(separador)
					.append(producto.getTalla())
					.append(separador)
					.append(producto.getColor());
				}
				
				printWriter.close();
				System.out.println("Datos exportados correctamente");
				
			}catch(IOException ex) {
				System.out.println("El archivo no pudo ser creado");
			}finally {
				System.out.println("**********************************");
			}
		}
	}
	
}
