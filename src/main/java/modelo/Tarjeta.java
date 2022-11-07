package modelo;

import java.util.HashMap;
import java.util.Map;

public class Tarjeta {

    private int numero;
    TipoTarjeta tipoTarjeta;

    public Tarjeta(int numero, TipoTarjeta tipo) {
        this.numero = numero;
        this.tipoTarjeta = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoTarjeta getTipo() {
        return tipoTarjeta;
    }

    public void setTipo(TipoTarjeta tipo) {
        this.tipoTarjeta = tipo;
    }


    public TipoTarjeta tipoTarjeta(){
        return tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", tipo=" + tipoTarjeta.getNombre() +
                '}';
    }
}
