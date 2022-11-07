/*
import modelo2.Categoria;
import modelo2.Cliente;
import modelo2.Marca;
import modelo2.Producto;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test ;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void crearProducto(){
        Marca marca = new Marca("Frutiloqui");
        Categoria categoria = new Categoria("frutas");
        Producto producto = new Producto(1, "manzana", categoria, 34, marca);
    }





}*/

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import modelo.Producto;

class ProductoTest {


    //todos los casos de prueba:
    public static Object[] parametros() {

        return new Object[][]{
        //(String codigo, double precio, String descripcion, String categoria, Marca marca)
                {"" , 1, "descripcion", "frutas",  "Frutiloqui"},    //sin descripcion
                {"1", 1, ""           , "Frutas",  "Frutiloqui"},    //sin descripcion
                {"1", 1, "descripcion",   null  ,  "Frutiloqui"},    //sin categoria
                {"1", 1, "descripcion", "frutas",      null    }     //sin marca

                //como se hace para hacer la prueba de q no tenga precio o codigo?

        };
    }

    @ParameterizedTest
    @MethodSource("parametros")
    void crearProducto(String codigo, double precio, String descripcion, String categoria,  String marca) {
        assertThrows(RuntimeException.class, () -> new Producto(codigo, precio, descripcion, categoria,  marca));
    }

}


