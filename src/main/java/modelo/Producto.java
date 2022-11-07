package modelo;


public class Producto {

    private String codigo;
    private String descripcion;
    private String categoria;
    private double precio;
    private String marca;


    public Producto(String codigo, double precio, String descripcion, String categoria, String marca) throws RuntimeException {

        if (codigo == null || codigo.isEmpty())
            throw new RuntimeException("El codigo debe ser valido");

        if (descripcion == null || descripcion.isEmpty())
            throw new RuntimeException("La descripcion debe ser valida");

        if (categoria == null || categoria.isEmpty())
            throw new RuntimeException("La categoria debe ser valida");

        if (marca == null || marca.isEmpty())
            throw new RuntimeException("La marca debe ser valida");

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", " + categoria +
                ", precio=" + precio +
                ", " + marca +
                '}';
    }

}