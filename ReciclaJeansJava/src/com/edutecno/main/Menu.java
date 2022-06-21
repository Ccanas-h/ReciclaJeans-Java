package com.edutecno.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edutecno.exportador.ExportadorTxt;
import com.edutecno.exportador.ImportadorTxt;
import com.edutecno.modelo.Producto;
import com.edutecno.servicios.ProductoServicio;
import com.edutecno.utilidades.Utilidades;

public class Menu {

	ProductoServicio productoServicio = new ProductoServicio();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	ImportadorTxt importarTxt = new ImportadorTxt();
	String fileName = "productos.txt";
	Scanner scanner = new Scanner(System.in);

	public void iniciarMenu() {
		List<String> opcionesMenu = new ArrayList<String>();
		opcionesMenu.add("Listar Producto");
		opcionesMenu.add("Agregar Producto");
		opcionesMenu.add("Exportar Datos");
		opcionesMenu.add("Importar Datos");
		opcionesMenu.add("Salir");

		Menu menu = new Menu();
		menu.seleccionOpcion(opcionesMenu);
	}

	private void seleccionOpcion(List<String> opcionesMenu) {
		boolean continuar = false;
		int resultado;

		do {
			resultado = construirMenu(opcionesMenu);

			switch (resultado) {
			case 1:
				listarProductos();
				break;
			case 2:
				agregarProductos();
				break;
			case 3:
				exportarDatos();
				break;
			case 4:
				importarDatos();
				break;
			case 5:
				salirSistema();
				break;
			default:
				System.out.println("opcion no valida");
			}

		} while (!continuar);
	}

	private void importarDatos() {
			importarTxt.importar(productoServicio);
			Utilidades.stopAndContinue();
	}

	private void salirSistema() {
		System.out.println("Gracias por usar el sistema, nos vemos !");
		Utilidades.stopAndContinue();
		System.out.println("Sistema terminado de forma correcta");
		Utilidades.stopAndContinue();
		System.exit(0);
	}

	private void exportarDatos() {
		System.out.println("Exportar Datos");
		System.out.println("Ingrese la opcion 1 para exportar:");
		int opcion = scanner.nextInt();

		List<Producto> listaProductos = productoServicio.getListaProductos();

		switch (opcion) {
		case 1:
			// llamar al metodo exportar de la clase ExportarTxt
			exportarTxt.exportar(fileName, listaProductos);
			Utilidades.stopAndContinue();
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
	}

	private void agregarProductos() {
		System.out.println("Crear producto");
		scanner.nextLine();
		System.out.println("Ingrese el nombre del articulo: ");
		String articulo = scanner.nextLine();
		System.out.println("Ingrese precio");
		String precio = scanner.nextLine();
		System.out.println("Ingrese descripcion: ");
		String descripcion = scanner.nextLine();
		System.out.println("Ingrese codigo: ");
		String codigo = scanner.nextLine();
		System.out.println("Ingrese Talla: ");
		String talla = scanner.nextLine();
		System.out.println("Ingrese color: ");
		String color = scanner.nextLine();
		System.out.println("Ingrese marca: ");
		String marca = scanner.nextLine();

		productoServicio.agregarProductos(articulo, precio, descripcion, codigo, talla, marca, color);
		Utilidades.stopAndContinue();
	}

	private void listarProductos() {
		productoServicio.listarProductos();
		Utilidades.stopAndContinue();
	}

	private int construirMenu(List<String> opcionesMenu) {

		List<String> opMenu = opcionesMenu;
		int largo = opMenu.size();

		for (int i = 0; i < largo; i++) {
			System.out.println(i + 1 + " " + opMenu.get(i));
		}

		int opcion = 0;
		System.out.println("Ingrese una opcion: ");

		opcion = scanner.nextInt();

		if (opcion < 1 || opcion >= largo + 1) {
			System.out.println("Seleccion no permitida");
		}

		return opcion;

	}

}
