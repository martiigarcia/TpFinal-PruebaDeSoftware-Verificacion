package modelo;

public class Tarjeta {

    private int numero;
    private TipoTarjeta tipoTarjeta;

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


    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", tipo=" + tipoTarjeta.getNombre() +
                '}';
    }
}
