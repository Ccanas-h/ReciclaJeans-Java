package com.edutecno.servicios;

import java.util.ArrayList;
import java.util.List;
import com.edutecno.modelo.Producto;
import com.edutecno.utilidades.Utilidades;

public class ProductoServicio {

	List<Producto> listaProductos;

	public ProductoServicio() {
		listaProductos = new ArrayList<Producto>();	
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void listarProductos() {
		if(listaProductos.size() != 0) {
			
			for (Producto producto : listaProductos) {
				System.out.println("Datos del producto: ");
				System.out.println("Nombre articulo: " + producto.getArticulo());
				System.out.println("Código: " + producto.getCodigo());
				System.out.println("Marca: " + producto.getMarca());
				System.out.println("Color: " + producto.getColor());
				System.out.println("Descripción: " + producto.getDescripcion());
				System.out.println("Talla: " + producto.getTalla());
			}
			
		}else {
			System.out.println("No se pueden listar los productos, lista vacia");
		}
			Utilidades.stopAndContinue();
	}
	
	public void agregarProductos(String articulo, String precio, String descripcion, 
									String codigo, String talla, String marca, String color) {
		//crear un producto
		Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
		
		//agregar producto a la lista
		if(listaProductos != null) {
			listaProductos.add(producto);
		}else {
			System.out.println("El producto o la lista estan nulos, no se puede agregar");
		}
	}
}
