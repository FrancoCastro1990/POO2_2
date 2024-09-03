package org.duocuc;

import org.duocuc.model.Inventario;
import org.duocuc.model.Producto;

import java.util.Scanner;
import java.util.List;

public class MenuPrincipal {
    private Inventario inventario;
    private Scanner scanner;

    public MenuPrincipal() {
        inventario = new Inventario();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Generar informe");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void agregarProducto() {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int cantidadStock = scanner.nextInt();

        Producto nuevoProducto = new Producto(codigo, nombre, descripcion, precio, cantidadStock);
        inventario.agregarProducto(nuevoProducto);
        System.out.println("Producto agregado con éxito.");
    }

    private void buscarProducto() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        List<Producto> resultados = inventario.buscarProductosPorNombre(nombre);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron productos con ese nombre.");
        } else {
            for (Producto producto : resultados) {
                System.out.println(producto.obtenerDescripcionDetallada());
            }
        }
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        String codigo = scanner.nextLine();
        if (inventario.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("No se encontró un producto con ese código.");
        }
    }

    private void listarProductos() {
        List<Producto> productos = inventario.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto.obtenerDescripcionDetallada());
                System.out.println("--------------------");
            }
        }
    }

}
