package com.tecnodestreza.practicaspringboot.services;

import com.tecnodestreza.practicaspringboot.models.Estudiante;
import com.tecnodestreza.practicaspringboot.repository.IDaoEstudiante;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteServiceImplTest {

    @Test
    void findAll() {

        //IEstudianteService estud= new EstudianteServiceImpl();
        IEstudianteService estud = Mockito.mock(IEstudianteService.class);

        List<Estudiante> datos = List.of(new Estudiante(1L, "Verónica", "Sanchez", "25421560", "veronicaS_1111@gmail.com", "04241568721", "primero", "Ciclo básico", "B"));
        //List<Estudiante> datos= Collections.emptyList();
        Mockito.when(estud.findAll()).thenReturn(datos);

        List<Estudiante> listaEstudiante = estud.findAll();
        assertNotNull(listaEstudiante);
        assertFalse(listaEstudiante.isEmpty());
        assertEquals("Verónica", listaEstudiante.get(0).getNombre());
        assertEquals(1, listaEstudiante.size());
    }

    @Test
    void findById_exist_returnEstudiante() {

        IEstudianteService estud = Mockito.mock(IEstudianteService.class);

        Estudiante estudianteEsperado = new Estudiante(1L, "Verónica", "Sanchez", "25421560", "veronicaS_1111@gmail.com", "04241568721", "primero", "Ciclo básico", "B");

        Mockito.when(estud.findById(1L)).thenReturn(Optional.of(estudianteEsperado));

        Estudiante estudianteActual= estud.findById(1L).orElse(null);

        assertEquals(estudianteEsperado, estudianteActual);
    }

    @Test
    void findById_notExist_returnOptionalEmpty(){
        IEstudianteService estud = Mockito.mock(IEstudianteService.class);
        Mockito.when(estud.findById(1L)).thenReturn(Optional.empty());
        Optional<Estudiante> estudianteActual = estud.findById(2L);

        assertEquals(Optional.empty(),estudianteActual);

    }


}