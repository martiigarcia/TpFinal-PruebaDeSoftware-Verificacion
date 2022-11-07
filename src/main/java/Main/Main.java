package Main;

import modelo.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDate fecha2DiasAntes = LocalDate.now().minusDays(2);
        LocalDate fecha2DiasDesp = LocalDate.now().plusDays(2);
        Cliente cliente1 = new Cliente("Martina", "Garcia", "56784252", "marti@gmai.com");
        Cliente cliente2 = new Cliente("Emilia", "Mernes", "65895341", "emi@gmail.com");
        Tarjeta tarjeta1 = new Tarjeta(1, TipoTarjeta.MERCADOPAGO);
        Tarjeta tarjeta2 = new Tarjeta(2, TipoTarjeta.UALA);
        Tarjeta tarjeta3 = new Tarjeta(3, TipoTarjeta.MERCADOPAGO);
        cliente1.agregarTarjeta(tarjeta1);
        cliente1.agregarTarjeta(tarjeta2);
        cliente2.agregarTarjeta(tarjeta3);
        Marca marca1 = new Marca("Eco");
        Marca marca2 = new Marca("Frutiloqui");
        Producto producto1 = new Producto("1", 34, "Manzana", "Fruta", marca1);
        Producto producto2 = new Producto("1", 6, "Pera", "Fruta", marca2);
        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();
        carrito1.agregarProductoAlCarrito(producto1);
        carrito1.agregarProductoAlCarrito(producto2);
        carrito2.agregarProductoAlCarrito(producto2);
        Tienda tienda = new Tienda();
        tienda.setMarcaPromocion(new MarcaPromocion(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.05, marca1.getNombre()));
        tienda.setTarjetaPromocion(new TarjetaPromocion(true,
                fecha2DiasAntes,
                fecha2DiasDesp, 0.08, TipoTarjeta.MERCADOPAGO.getNombre()));
        Scanner lectura = new Scanner(System.in);
        System.out.println("----------Seleccionar tarjeta: ----------");
        int indice = 0;
        for (Tarjeta tarjeta : cliente1.getTarjetas()) {
            // System.out.println(indice + "- Numero de tarjeta: " + tarjeta.getNumero() + " . Tipo tarjeta: " + tarjeta.tipoTarjeta());
            indice++;
        }
        System.out.println("Elegir tarjeta: ");
        int opcion = lectura.nextInt();
        //   System.out.println("Opcion elegida: " + opcion + " - Numero de tarjeta: " + cliente1.getTarjetas().get(opcion).getNumero());
        double precio = carrito1.calcularMontoCarrito(tienda.MarcaPromocionVigente(), tienda.TarjetaPromocionVigente(), cliente1.getTarjetas().get(opcion));
        // System.out.println("Precio calculado con promociones de marca y tarjeta: " + precio);
        tienda.agregarVenta(carrito1.pagar(cliente1, tienda.MarcaPromocionVigente(), tienda.TarjetaPromocionVigente(), cliente1.getTarjetas().get(opcion)));
        tienda.verVentasRealizadas().forEach(venta -> System.out.println(venta.toString()));
        //System.out.println(tienda.verVentasRealizadas());
        //probar agregar promocion nueva a las listas de promociones
       /* tienda.setMarcaPromocion(
                new MarcaPromocion(true,
                        LocalDate.of(2022, 8, 30), LocalDate.of(2022, 9, 1),
                        marca2)
        );
        tienda.promocionList().forEach(marcaPromocion -> System.out.println(marcaPromocion.marca() + ", " + marcaPromocion.estado()));
        */

    }
}
