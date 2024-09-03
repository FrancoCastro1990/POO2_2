import org.duocuc.model.Inventario;
import org.duocuc.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InventarioTest {

    private Inventario inventario;
    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
        producto1 = new Producto("001", "Laptop", "Laptop de alta gama", 1200.00, 10);
        producto2 = new Producto("002", "Mouse", "Mouse inalámbrico", 30.00, 50);
    }

    @Test
    public void testAgregarProducto() {
        inventario.agregarProducto(producto1);
        assertNotNull(inventario.buscarProductoPorCodigo("001"));
    }

    @Test
    public void testBuscarProductoPorCodigo() {
        inventario.agregarProducto(producto1);
        Producto encontrado = inventario.buscarProductoPorCodigo("001");
        assertEquals(producto1, encontrado);
    }

    @Test
    public void testBuscarProductosPorNombre() {
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        List<Producto> encontrados = inventario.buscarProductosPorNombre("Laptop");
        assertEquals(1, encontrados.size());
        assertEquals(producto1, encontrados.get(0));
    }

    @Test
    public void testEliminarProducto() {
        inventario.agregarProducto(producto1);
        assertTrue(inventario.eliminarProducto("001"));
        assertNull(inventario.buscarProductoPorCodigo("001"));
    }


    @Test
    public void testListarProductos() {
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        List<Producto> productos = inventario.listarProductos();
        assertEquals(2, productos.size());
        assertTrue(productos.contains(producto1) && productos.contains(producto2));
    }
}