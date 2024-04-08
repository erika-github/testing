package com.tecnodestreza.practicaspringboot.services;

import com.tecnodestreza.practicaspringboot.models.Estudiante;
import com.tecnodestreza.practicaspringboot.repository.IDaoEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IDaoEstudiante daoEstudiante;

    @Override
    public List<Estudiante> findAll() {

        return daoEstudiante.findAll();
        //return List.of(new Estudiante(1L, "Verónica", "Sanchez", "25421560", "veronicaS_1111@gmail.com", "04241568721", "primero", "Ciclo básico", "B"));
        //return Collections.emptyList();
    }

    @Override
    public Optional<Estudiante> findById(Long id) {
        return daoEstudiante.findById(id);
    }

    @Override
    public void eliminarEstudiante(Long id) {

        daoEstudiante.deleteById(id);
    }

    @Override
    public Optional<Estudiante> modifEstudiante(Estudiante estudiante) {
        return Optional.of(daoEstudiante.save(estudiante));
    }

    @Override
    public Optional<Estudiante> crearEstudiante(Estudiante estudiante) {
        return Optional.of(daoEstudiante.save(estudiante));
    }


}
