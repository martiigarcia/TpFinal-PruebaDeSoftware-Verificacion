package modelo;


public class ProductoVendido {

    private String codigo;
    private double precioPago;

    public ProductoVendido(String codigo, double precio) {
        this.codigo = codigo;
        this.precioPago = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPrecioPago() {
        return precioPago;
    }

    public void setPrecioPago(double precioPago) {
        this.precioPago = precioPago;
    }

    @Override
    public String toString() {
        return "Producto Vendido{" +
                "codigo=" + codigo +
                ", precio=" + precioPago +
                '}';
    }

}