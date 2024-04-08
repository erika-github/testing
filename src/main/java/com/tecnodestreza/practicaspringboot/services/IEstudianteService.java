package com.tecnodestreza.practicaspringboot.services;

import com.tecnodestreza.practicaspringboot.models.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {
    List<Estudiante> findAll();

    Optional<Estudiante> findById(Long id);

    void eliminarEstudiante(Long id);

    Optional<Estudiante> modifEstudiante(Estudiante estudiante);

    Optional<Estudiante> crearEstudiante(Estudiante estudiante);

}
