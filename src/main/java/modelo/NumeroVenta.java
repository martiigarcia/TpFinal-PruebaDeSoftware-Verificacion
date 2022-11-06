package modelo;

import java.time.LocalDate;

public class NumeroVenta {


    private int numeroActual;
    private int anio;


    public NumeroVenta(int numero, int anio) {
        this.anio = anio;
        this.numeroActual = numero;
    }


    public int getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(int numActual) {
        this.numeroActual = numActual;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String crearCodigo() { //N-AÑO
        return (this.numeroActual + "-" + this.anio);
    }

    public String getNumeroSiguiente() {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.getYear() != this.anio)
            this.numeroActual = 0;

         this.numeroActual += 1;
         return crearCodigo();
    }

    public int numeroSiguiente(){
        this.numeroActual += 1;
        return this.numeroActual;
    }

}
