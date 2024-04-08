package com.tecnodestreza.practicaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Table(name="estudiante")
public class Estudiante extends Persona implements Serializable {

    private static final long serialVersionUid=1L;

    @NotEmpty
    private String anio;

    @NotEmpty
    private String curso;

    @NotEmpty
    private String seccion;

    public Estudiante(Long id, String nombre, String apellido, String dni, String correo, String telefono, String anio, String curso, String seccion) {
        super(id, nombre, apellido, dni, correo, telefono);
        this.anio = anio;
        this.curso = curso;
        this.seccion = seccion;
    }

    public Estudiante() {
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
