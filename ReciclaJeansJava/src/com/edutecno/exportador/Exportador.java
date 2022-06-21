package com.edutecno.exportador;

import java.util.List;

import com.edutecno.modelo.Producto;

/**
 * 
 * @author jorge
 * Clase abstracta que solo define un metodo con atributos pero sin implementacion.
 */
public abstract class Exportador {
	
	public abstract void exportar(String fileName, List<Producto> listaProductos);
	
}
