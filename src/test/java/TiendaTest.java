
import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private Tienda tienda;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private Carrito carrito;
    private String marcaAcme, marcaEco, marcaFrutiloqui;
    private Producto producto1, producto2, producto3, producto4;

    private LocalDate  fecha2DiasAntes, fecha2DiasDesp;


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
        producto2 = new Producto("2", 34, "Manzana", "Cosmetico", marcaEco);
        producto3 = new Producto("3", 6, "Pera", "Fruta", marcaFrutiloqui);
        producto4 = new Producto("4", 100, "Rimel", "Fruta", marcaAcme);

        carrito.agregarProductoAlCarrito(producto1);
        carrito.agregarProductoAlCarrito(producto2);
        carrito.agregarProductoAlCarrito(producto3);
        carrito.agregarProductoAlCarrito(producto4);


        fecha2DiasAntes = LocalDate.now().minusDays(2);
        fecha2DiasDesp = LocalDate.now().plusDays(2);



    }

    @Test
    public void registrarVenta() {
        // aca registrar venta en la tienda

        tienda.setPromocionMarca(new PromocionMarca(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.05, marcaAcme));
        tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()));


        tienda.agregarVenta(carrito.pagar(cliente,
                tienda.PromocionMarcaVigente(), tienda.PromocionTarjetaVigente(), tarjeta));

        assertEquals(1, tienda.getVentaList().size());


    }

    //REGISTRO DE PROMOCION CON FECHAS VALIDAS

    @Test
    public void registrarPromocionMarcaNueva() {
        tienda.setPromocionMarca(new PromocionMarca(true,
                fecha2DiasAntes, fecha2DiasDesp, 0.05, marcaAcme));

        assertEquals(1, tienda.getPromocionesMarca().size());

    }

    @Test
    public void registrarPromocionTarjetaNueva() {
        tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasAntes, fecha2DiasDesp, 0.08,TipoTarjeta.MERCADOPAGO.getNombre()));

        assertEquals(1, tienda.getPromocionesTarjeta().size());
    }

    @Test
    public void registrarPromociones(){
        tienda.setPromocionMarca(new PromocionMarca(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.05,marcaEco));
        tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.08,TipoTarjeta.UALA.getNombre()));

        tienda.setPromocionMarca(new PromocionMarca(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.05,marcaAcme));
        tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.08,TipoTarjeta.MERCADOPAGO.getNombre()));

        assertEquals(2, tienda.getPromocionesMarca().size());
        assertEquals(2, tienda.getPromocionesTarjeta().size());
    }

    //REGISTRO DE PROMOCION INVALIDAS
    @Test
    public void registrarPromocionMarcaNuevaConFechaInvalida() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setPromocionMarca(new PromocionMarca(true,
                fecha2DiasAntes, LocalDate.now().minusDays(1),0.05, marcaAcme)));

    }

    @Test
    public void registrarPromocionTarjetaNuevaConFechaInvalida() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasAntes, LocalDate.now().minusDays(1), 0.08,TipoTarjeta.MERCADOPAGO.getNombre())));

    }

    @Test
    public void registrarPromocionTarjetaNuevaConFechasInvertidas() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setPromocionTarjeta(new PromocionTarjeta(true,
                fecha2DiasDesp, fecha2DiasAntes,0.08, TipoTarjeta.MERCADOPAGO.getNombre())));

    }

    @Test
    public void registrarPromocionMarcaNuevaVacia() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setPromocionMarca(null));

    }

    @Test
    public void registrarPromocionTarjetaNuevaVacia() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setPromocionTarjeta(null));

    }


}