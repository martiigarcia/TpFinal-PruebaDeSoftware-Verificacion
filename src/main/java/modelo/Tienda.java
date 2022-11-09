package modelo;


import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Promocion> promocionesMarca;

    private List<Promocion> promocionesTarjeta;

    private List<Venta> ventaList;


    public Tienda() {
        this.ventaList = new ArrayList<>();
        this.promocionesMarca = new ArrayList<>();
        this.promocionesTarjeta = new ArrayList<>();
    }


    public List<Promocion> getPromocionesMarca() {
        return promocionesMarca;
    }

    public void setPromocionesMarca(List<Promocion> promocionesMarca) {
        this.promocionesMarca = promocionesMarca;
    }

    public List<Promocion> getPromocionesTarjeta() {
        return promocionesTarjeta;
    }

    public void setPromocionesTarjeta(List<Promocion> promocionesTarjeta) {
        this.promocionesTarjeta = promocionesTarjeta;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }


    public void agregarVenta(Venta venta) {
        this.ventaList.add(venta);
    }


    //para actulizar las promociones
    public void setPromocionMarca(PromocionMarca promocionMarca) throws RuntimeException {

        if (promocionMarca == null)
            throw new RuntimeException("La promocion no puede ser vacia");

        if (!promocionMarca.fechaValida())
            throw new RuntimeException("No se puede crear una promocion con una fecha de finalizacion ya expirada.");

        if (this.promocionesMarca.isEmpty()) {
            this.promocionesMarca.add(promocionMarca);
        } else {
            this.promocionesMarca.get(this.promocionesMarca.size() - 1).setEstado();
            this.promocionesMarca.add(promocionMarca);

        }

    }

    public void setPromocionTarjeta(PromocionTarjeta promocionTarjeta) throws RuntimeException {

        if (promocionTarjeta == null)
            throw new RuntimeException("La promocion no puede ser vacia");

        if (!promocionTarjeta.fechaValida())
            throw new RuntimeException("No se puede crear una promocion con una fecha de finalizacion ya expirada.");

        if (this.promocionesTarjeta.isEmpty()) {
            this.promocionesTarjeta.add(promocionTarjeta);
        } else {
            this.promocionesTarjeta.get(this.promocionesTarjeta.size() - 1).setEstado();
            this.promocionesTarjeta.add(promocionTarjeta);
        }
    }


    //retornar la promocion de marca vigente
    public Promocion PromocionMarcaVigente() {
        return this.promocionesMarca.get(promocionesMarca.size() - 1);
    }

    //retornar la promocion de tarjeta vigente
    public Promocion PromocionTarjetaVigente() {
        return this.promocionesTarjeta.get(promocionesTarjeta.size() - 1);
    }


    @Override
    public String toString() {
        return "Tienda{" +
                "marcaPromociones=" + promocionesMarca +
                ", tarjetaPromociones=" + promocionesTarjeta +
                ", ventaList=" + ventaList +
                '}';
    }

}
