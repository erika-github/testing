package com.tecnodestreza.practicaspringboot.controllers;


import com.tecnodestreza.practicaspringboot.models.Estudiante;
import com.tecnodestreza.practicaspringboot.services.IEstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    IEstudianteService estudianteServ;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        Map<String, Object> response = new HashMap<>();

        List<Estudiante> estudiantes = estudianteServ.findAll();

        if (estudiantes.isEmpty()) {

            response.put("mensaje", "Listado vacío");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        } else {

            response.put("listado", estudiantes);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }

    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultar(@PathVariable Long id) {

        Map<String, Object> response= new HashMap<>();

        Optional<Estudiante> estudiante= estudianteServ.findById(id);


        if(estudiante.isPresent()){

            response.put("Estudiante", estudiante);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else {

            response.put("mensaje", "Estudiante no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }



    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Estudiante estudiante, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

       /* if(result.hasErrors()){

            List<String>errors=result.getFieldErrors().stream().map(error->"El campo "
                    .concat(error.getField()).concat(" ")
                    .concat(Objects.requireNonNull(error.getDefaultMessage())
                            .concat(" "))).toList();

            errors.forEach(error->response.put("mensaje", error));

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }*/

        if(result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream().map(error->"Error con el campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()).concat(" ")).collect(Collectors.toList());
           /* errors.stream().forEach(error->{
                response.put("mensaje",error);
                //log.error(error);
            });*/

            for(int i=0; i<errors.size(); i++){

                response.put("mensaje"+i,errors.get(i));

            }

            //errors.forEach(System.out::println);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        Optional<Estudiante> alumno = estudianteServ.crearEstudiante(estudiante);

        return new ResponseEntity<>(alumno, HttpStatus.CREATED);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {

        Optional<Estudiante> e = estudianteServ.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (e.isPresent()) {

            //System.out.println("lo encontró");
            estudiante.setId(id);
            Optional<Estudiante> a = estudianteServ.modifEstudiante(estudiante);

            return new ResponseEntity<>(estudiante, HttpStatus.OK);

        } else {

            response.put("Mensaje", "Registro no encontrado" );

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }



    }




}
