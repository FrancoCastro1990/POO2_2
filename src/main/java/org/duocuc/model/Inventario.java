package org.duocuc.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private HashMap<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    // Método para agregar productos al inventario
    public void agregarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
    }

    // Método para buscar productos por código
    public Producto buscarProductoPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    // Método para buscar productos por nombre
    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos.values()) {
            if (producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    // Método para eliminar un producto del inventario
    public boolean eliminarProducto(String codigo) {
        return productos.remove(codigo) != null;
    }

    // Método para listar todos los productos
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

}