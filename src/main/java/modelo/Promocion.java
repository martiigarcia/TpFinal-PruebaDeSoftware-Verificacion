package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public abstract class Promocion {

    private boolean estado;
    private Date fechaInicio;
    private Date fechaFin;
    private double descuento;


    public Promocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, double descuento) throws RuntimeException {

        if (!this.validarFecha(fechaInicio, fechaFin))
            throw new RuntimeException("Las fechas de la promocion no son validas.");

        this.estado = estado;
        this.descuento = descuento;
        this.fechaInicio = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.fechaFin = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    private boolean validarFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate hoy = LocalDate.now();
        return (fechaInicio.isBefore(fechaFin) && hoy.isBefore(fechaFin));
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }


    public void setEstado() {
        this.estado = !this.estado;
    }


    protected double getDescuento() {
        return this.descuento;
    }

    public abstract double descuento(String tipo);

    public LocalDate getFechaInicio() {
        return fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getFechaFin() {
        return fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    //para hacer la validacion en la Tienda:
    public boolean fechaValida() {
        LocalDate hoy = LocalDate.now();
        LocalDate inicio = this.fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fin = this.fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (inicio.isBefore(fin) && hoy.isBefore(fin)); //si se cumplen ambas y retorna true, es fecha valida
    }


    @Override
    public String toString() {
        return "Datos" + " {" +
                "estado=" + estado +
                ", fechaInicio=" + fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                ", fechaFin=" + fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                '}';
    }


}


