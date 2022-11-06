package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class MarcaPromocion extends Promocion {

    private String marca;


    public MarcaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, double porcentaje, String marca) throws RuntimeException {
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
    public double descuento(String tipo) {
        LocalDate hoy = LocalDate.now();

        if (!this.marca.equals(tipo))
            return 0;

        if (hoy.isAfter(this.fechaFin()) || hoy.isBefore(this.fechaInicio())) {
            return 0;
        }
        return super.getDescuento();

    }


    @Override
    public String toString() {
        return "MarcaPromocion{ " + marca + " }";
    }
}
