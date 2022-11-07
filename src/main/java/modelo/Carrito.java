package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> productos() {
        return productos;
    }

    public void agregarProductoAlCarrito(Producto producto) throws RuntimeException {
        if (producto == null)
            throw new RuntimeException("El producto a agregar no puede ser vacio.");
        this.productos.add(
                new Producto(producto.getCodigo(), producto.getPrecio(),
                        producto.getDescripcion(), producto.getCategoria(),
                        producto.getMarca()));
    }

    public double calcularMontoCarrito(Promocion marcaPromocion, Promocion tarjetaPromocion, Tarjeta tarjeta) throws RuntimeException {

        if (tarjeta == null)
            throw new RuntimeException("La tarjeta para calcular el monto no puede ser vacia.");

        if (productos == null)
            throw new RuntimeException("Debe existir como minimo un producto en el carrito.");


        if (marcaPromocion == null || tarjetaPromocion == null)
            throw new RuntimeException("Las promociones no pueden ser vacias.");

        double precio = 0;
        for (Producto producto : this.productos) {

            precio = precio + (producto.getPrecio() -
                    (producto.getPrecio() * marcaPromocion.descuento(producto.getMarca())));

        }

        precio = precio - (precio * tarjetaPromocion.descuento(tarjeta.getTipoTarjeta().getNombre()));

        return precio;
    }

    public Venta pagar(Cliente cliente, Promocion marcaPromocion, Promocion tarjetaPromocion, Tarjeta tarjeta) throws RuntimeException {

        if (productos == null)
            throw new RuntimeException("Debe existir como minimo un producto en el carrito.");

        if (tarjeta != null) {
            return new Venta(cliente, tarjeta, productos, calcularMontoCarrito(marcaPromocion, tarjetaPromocion, tarjeta));
        }
        return new Venta(cliente, tarjeta, productos, 0);
    }

   /* @Override
    public String toString() {
        return "Carrito{ " + productos +
                " }";
    }*/
}
