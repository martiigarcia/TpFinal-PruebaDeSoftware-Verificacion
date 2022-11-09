
import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test ;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest {

    private Tienda tienda;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private Carrito carrito;
    private String marcaAcme, marcaEco, marcaFrutiloqui;
    private Producto producto1, producto2, producto3, producto4;
    private LocalDate fecha2DiasAntes, fecha2DiasDesp;

    @BeforeEach
    public void before() {

        tienda = new Tienda();
        carrito = new Carrito();

        cliente = new Cliente("Martina", "Garcia", "12345678", "marti@gmail.com");
        tarjeta = new Tarjeta(1111, TipoTarjeta.MERCADOPAGO);

        marcaAcme = "Acme";
        marcaEco = "Eco";
        marcaFrutiloqui = "Frutiloqui";



        producto1 = new Producto("1", 100, "Labial", "Cosmetico", marcaAcme);
        producto2 = new Producto("2", 100, "Rimel", "Cosmetico", marcaAcme);
        producto4 = new Producto("3", 34, "Manzana", "Fruta", marcaEco);
        producto3 = new Producto("4", 6, "Pera", "Fruta", marcaFrutiloqui);


        fecha2DiasAntes = LocalDate.now().minusDays(2);
        fecha2DiasDesp = LocalDate.now().plusDays(2);
    }

    @Test
    public void agregarProductoAlCarrito(){
        carrito.agregarProductoAlCarrito(producto1);
        assertEquals(1, carrito.productos().size());
    }
    @Test
    public void agregarProductoVacio(){
        assertThrows(RuntimeException.class, () ->  carrito.agregarProductoAlCarrito(null));
    }

    @Test
    public void descuentoDeProducto(){
        // Calcular el monto total del carrito con un descuento vigente para los productos marca Acme.
        // no descuento en tarjeta
        carrito.agregarProductoAlCarrito(producto1);
        carrito.agregarProductoAlCarrito(producto2);
        assertEquals(190, carrito.calcularMontoCarrito(
                new PromocionMarca(true,
                        fecha2DiasAntes, fecha2DiasDesp,0.05, marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.08, TipoTarjeta.UALA.getNombre()),
                tarjeta //tarjeta de mp
        ));
    }

    @Test
    public void descuentoDeCompra(){
        // Calcular el monto total del carrito con un descuento vigente del tipo de Medio de pago.
        // no descuento en productos
        carrito.agregarProductoAlCarrito(producto3);
        carrito.agregarProductoAlCarrito(producto4);
        assertEquals(36.8, carrito.calcularMontoCarrito(
                new PromocionMarca(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.05,marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()),
                tarjeta //tarjeta de mp
        ));
    }

    @Test
    public void descuentoDeProductosYCompra(){
        // Calcular el monto total del carrito con dos descuentos vigentes,
        // sobre productos marca Acme y para tarjeta de crédito MP.

        carrito.agregarProductoAlCarrito(producto1);
        carrito.agregarProductoAlCarrito(producto2);
        assertEquals(174.8, carrito.calcularMontoCarrito(
                new PromocionMarca(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.05,marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()),
                tarjeta //tarjeta de mp
        ));
    }

    @Test
    public void descuentosCaducados(){
        // Calcular el monto total del carrito seleccionado sin descuentos vigentes, pero con descuentos que ya caducaron.
        // sobre productos marca Acme y para tarjeta de crédito MP.

        carrito.agregarProductoAlCarrito(producto1);
        carrito.agregarProductoAlCarrito(producto2);
        assertThrows(RuntimeException.class, () -> carrito.calcularMontoCarrito(
                new PromocionMarca(true,
                        fecha2DiasAntes, LocalDate.now().minusDays(1),0.05, marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, LocalDate.now().minusDays(1), 0.08, TipoTarjeta.MERCADOPAGO.getNombre()),
                tarjeta //tarjeta de mp
        ));
    }

    @Test
    public void pagarYRegistrarVenta(){
        // aca registrar la venta desde el pagar del carrito

        assertEquals(Venta.class, carrito.pagar(cliente,
                new PromocionMarca(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.05,marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()),
                tarjeta).getClass());

    }

    @Test
    public void pagarYNoRegistrarVentaConTarjetaNull(){
        // aca registrar la venta desde el pagar del carrito

        assertThrows(RuntimeException.class, () -> carrito.pagar(cliente,
                new PromocionMarca(true,
                        fecha2DiasAntes, fecha2DiasDesp,0.05, marcaAcme),
                new PromocionTarjeta(true,
                        fecha2DiasAntes, fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()),
                null));

    }







}