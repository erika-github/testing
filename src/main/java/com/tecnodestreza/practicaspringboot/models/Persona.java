package com.tecnodestreza.practicaspringboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;


@MappedSuperclass
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String dni;

    @NotEmpty
    private String correo;

    @NotEmpty
    private String telefono;


    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String dni, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
