package com.tecnodestreza.practicaspringboot.repository;

import com.tecnodestreza.practicaspringboot.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoEstudiante extends JpaRepository<Estudiante, Long> {
}
