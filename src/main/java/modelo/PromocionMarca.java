package modelo;

import java.time.LocalDate;

public class PromocionMarca extends Promocion {

    private String marca;


    public PromocionMarca(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, double porcentaje, String marca) throws RuntimeException {
        super(estado, fechaInicio, fechaFin, porcentaje);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @Override
    public double descuento(String nombre) {
        LocalDate hoy = LocalDate.now();

        if (!this.marca.equals(nombre))
            return 0;

        if (hoy.isAfter(this.getFechaFin()) || hoy.isBefore(this.getFechaInicio())) {
            return 0;
        }
        return super.getDescuento();

    }


    @Override
    public String toString() {
        return (super.toString() + "MarcaPromocion{ " + marca + " }");
    }
}
