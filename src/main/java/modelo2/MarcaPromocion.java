package modelo2;

import java.time.LocalDate;

public class MarcaPromocion extends Promocion<Marca> {

    private Marca marca;

    public MarcaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, Marca marca) {
        super(estado, fechaInicio, fechaFin, marca);
        this.marca = marca;
    }



    @Override
    public double descuento() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(this.fechaFin()) || hoy.isBefore(this.fechaInicio())){
            return 0;
        }
        return 0.05;
    }

    public Marca marca(){
        return marca;
    }

    public void setEstado(){
        super.setEstado();
    }
    /*public boolean estado(){ return super.estado(); }*/

    @Override
    public String toString() {
        return "MarcaPromocion{ " + marca +" }";
    }
}
