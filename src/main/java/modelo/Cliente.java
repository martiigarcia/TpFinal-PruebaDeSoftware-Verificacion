package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {


    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private List<Tarjeta> tarjetas;

    private static final Pattern VALID_DNI_REGEX =
            Pattern.compile("^[0-9]{8,8}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public Cliente(String nombre, String apellido, String dni, String email) throws RuntimeException {

        if ((nombre == null || nombre.isEmpty()))
            throw new RuntimeException("El nombre debe ser valido");

        if ((apellido == null || apellido.isEmpty()))
            throw new RuntimeException("El apellido debe ser valido");

        if (!validarDNI(dni))
            throw new RuntimeException("El DNI debe ser valido");

        if (!validarEmail(email))
            throw new RuntimeException("El email debe ser valido");

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.tarjetas = new ArrayList<>();
    }


    private boolean validarEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private boolean validarDNI(String dni) {
        Matcher matcher = VALID_DNI_REGEX.matcher(dni);
        return matcher.find();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!validarDNI(dni))
            throw new RuntimeException("El DNI debe ser valido");
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validarEmail(email))
            throw new RuntimeException("El email debe ser valido");
        this.email = email;
    }


    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void agregarUnaTarjetaALista(Tarjeta tarjeta) {
        this.tarjetas.add(tarjeta);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", tarjetas=" + tarjetas +
                '}';
    }
}
