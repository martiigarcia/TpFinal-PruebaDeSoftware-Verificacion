package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Venta {

    private double montoAbonado;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private List<ProductoVendido> productosVendidos;


    public Venta(Cliente cliente, Tarjeta tarjeta, List<Producto> productosVendidos, double montoAbonado) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.productosVendidos = new ArrayList<>();
        this.agregarProductos(productosVendidos);
        this.montoAbonado = montoAbonado;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<ProductoVendido> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<ProductoVendido> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }




    private void agregarProductos(List<Producto> productos) {
        productos.forEach(producto ->
                this.productosVendidos.add(
                        new ProductoVendido(producto.getCodigo(), producto.getPrecio()
                        )));

    }

    /*
       @Override
        public String toString() {
            return "Venta{" +
                    "cliente=" + cliente +
                    ", estadoVenta=" + estadoVenta +
                    ", tarjeta=" + tarjeta +
                    ", productosVendidos=" + productosVendidos +
                    ", montoAbonado=" + montoAbonado +
                    '}';
        }*/


    @Override
    public String toString() {
        return "Venta{" +
                "cliente=" + cliente +
                ", productosVendidos=" + productosVendidos +
                ", montoAbonado=" + montoAbonado +
                '}';
    }
}
