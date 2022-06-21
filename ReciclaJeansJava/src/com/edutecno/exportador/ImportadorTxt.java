package com.edutecno.exportador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.edutecno.servicios.ProductoServicio;

public class ImportadorTxt extends Importador {
		

		@Override
		public void importar(ProductoServicio pService) {
			
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Ingrese el nombre del archivo a importar");
				
				String nombreArchivo = sc.nextLine();
								
				String ruta = "src/"+nombreArchivo+".csv";
				
				System.out.println("Importando Datos");
				String linea = "";
				
				
				try {
				FileReader fileReader = new FileReader(ruta);
				BufferedReader br = new BufferedReader(fileReader);
				
				while((linea = br.readLine()) != null ) {
					String [] data = linea.split(",");
					pService.agregarProductos(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
					
				}
			
				}catch(IOException ex) {
					System.out.println("El archivo no pudo ser creado");
				}finally {
					System.out.println("**********************************");
				}
			}
		}
		
	

		
		
		
		

