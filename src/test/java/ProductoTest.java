import org.duocuc.model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void testCreacionProducto() {
        Producto p = new Producto("001", "Laptop", "Laptop de alta gama", 1200.00, 10);

        assertEquals("001", p.getCodigo());
        assertEquals("Laptop", p.getNombre());
        assertEquals("Laptop de alta gama", p.getDescripcion());
        assertEquals(1200.00, p.getPrecio(), 0.001);
        assertEquals(10, p.getCantidadStock());
    }

    @Test
    public void testActualizacionAtributos() {
        Producto p = new Producto("001", "Laptop", "Laptop de alta gama", 1200.00, 10);

        p.actualizarPrecio(1300.00);
        p.setCantidadStock(15);

        assertEquals(1300.00, p.getPrecio(), 0.001);
        assertEquals(15, p.getCantidadStock());
    }

    @Test
    public void testObtencionDescripcionDetallada() {
        Producto p = new Producto("001", "Laptop", "Laptop de alta gama", 1200.00, 10);
        String descripcionEsperada = "Código: 001\n" +
                "Nombre: Laptop\n" +
                "Descripción: Laptop de alta gama\n" +
                "Precio: $1200.0\n" +
                "Cantidad en stock: 10";
        assertEquals(descripcionEsperada, p.obtenerDescripcionDetallada());
    }
}