package org.duocuc.model;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadStock;

    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }

    // Método para actualizar el precio del producto
    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    // Método para descripción detallada del producto
    public String obtenerDescripcionDetallada() {
        return "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: $" + precio + "\n" +
                "Cantidad en stock: " + cantidadStock;
    }
}