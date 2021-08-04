package ar.org.centro8.curso.java.aplicaciones.entities;

import ar.org.centro8.curso.java.aplicaciones.enums.tipoDocumento;
import java.time.LocalDate;

public class Cliente {
    /*
	id int auto_increment primary key,
	nombre varchar(20) not null,
	apellido varchar(20) not null,
	edad int,
	direccion varchar(50),
	email varchar(30),
	telefono varchar(25),
	tipoDocumento enum('DNI','LIBRETA_CIVICA','LIBRETA_ENROLAMIENTO','PASS'),
	numeroDocumento char(8)    
    */
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fenaci;
    private String direccion;
    private String email;
    private String telefono;
    private tipoDocumento tipoDocumento;
    private int dni;

    public Cliente() {}

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String nombre, String apellido, LocalDate fenaci, String direccion, String email, String telefono, tipoDocumento tipoDocumento, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fenaci = fenaci;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
        this.dni = dni;
    }

    public Cliente(int id, String nombre, String apellido, LocalDate fenaci, String direccion, String email, String telefono, tipoDocumento tipoDocumento, int dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fenaci = fenaci;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fenaci=" + fenaci + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", tipoDocumento=" + tipoDocumento + ", dni=" + dni + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFenaci() {
        return fenaci;
    }

    public void setFenaci(LocalDate fenaci) {
        this.fenaci = fenaci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(tipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
