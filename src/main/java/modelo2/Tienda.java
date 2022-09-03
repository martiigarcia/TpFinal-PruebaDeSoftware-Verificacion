package modelo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tienda {

    //se hacen dos listas para mantener el registro historico de cada tipo de promociones
    private List<MarcaPromocion> marcaPromociones;

    private List<TarjetaPromocion> tarjetaPromociones;

    private List<Venta> ventaList;

    public Tienda() {
        this.ventaList = new ArrayList<>();
        this.marcaPromociones = new ArrayList<>();
        this.tarjetaPromociones = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        this.ventaList.add(venta);
    }

    public List<Venta> verVentasRealizadas() {
        return ventaList;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "marcaPromociones=" + marcaPromociones +
                ", tarjetaPromociones=" + tarjetaPromociones +
                ", ventaList=" + ventaList +
                '}';
    }

    //para actulizar las promociones
    public void setMarcaPromocion(MarcaPromocion marcaPromocion) {

        if (marcaPromocion == null)
            throw new RuntimeException("La promocion no puede ser vacia");

        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(marcaPromocion.fechaFin()))
            throw new RuntimeException("No se puede crear una promocion con una fecha de finalizacion ya expirada.");

        if (marcaPromociones.isEmpty()) {
            this.marcaPromociones.add(marcaPromocion);
        } else {
            this.marcaPromociones.get(marcaPromociones.size() - 1).setEstado();
            this.marcaPromociones.add(marcaPromocion);

        }


    }

    public void setTarjetaPromocion(TarjetaPromocion tarjetaPromocion) {
        if (tarjetaPromocion == null)
            throw new RuntimeException("La promocion no puede ser vacia");

        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(tarjetaPromocion.fechaFin()))
            throw new RuntimeException("No se puede crear una promocion con una fecha de finalizacion ya expirada.");

        if (this.tarjetaPromociones.isEmpty()) {
            this.tarjetaPromociones.add(tarjetaPromocion);
        } else {
            this.tarjetaPromociones.get(tarjetaPromociones.size() - 1).setEstado();
            this.tarjetaPromociones.add(tarjetaPromocion);
        }
    }


    //retornar la promocion de marca vigente
    public MarcaPromocion MarcaPromocion() {
        return this.marcaPromociones.get(marcaPromociones.size() - 1);
    }

    //retornar la promocion de tarjeta vigente
    public TarjetaPromocion TarjetaPromocion() {
        return this.tarjetaPromociones.get(tarjetaPromociones.size() - 1);
    }

    public List<MarcaPromocion> marcaPromocionList() {
        return marcaPromociones;
    }

    public List<TarjetaPromocion> tarjetaPromocionList() {
        return tarjetaPromociones;
    }

}
