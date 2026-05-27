package com.javaScrpit.Pc2.controller;

import com.javaScrpit.Pc2.model.Curso;
import com.javaScrpit.Pc2.model.Matricula;
import com.javaScrpit.Pc2.repository.CursoRepository;
import com.javaScrpit.Pc2.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins = "*")
public class MatriculaController {

    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;

    public MatriculaController(CursoRepository cursoRepository, MatriculaRepository matriculaRepository) {
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public record MatriculaRequest(
            @NotBlank String nombre,
            @NotBlank String codigoEstudiante,
            Long cursoId,
            @NotBlank String turno
    ) {}

    @PostMapping
    @Transactional
    public ResponseEntity<?> crear(@RequestBody MatriculaRequest req) {
        if (req.cursoId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cursoId es requerido");
        }

        Curso curso = cursoRepository.findById(req.cursoId)
                .orElse(null);

        if (curso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
        }

        if (curso.getVacantes() == null || curso.getVacantes() <= 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El curso no tiene vacantes");
        }

        // descontar vacante
        curso.setVacantes(curso.getVacantes() - 1);
        cursoRepository.save(curso);

        Matricula m = Matricula.builder()
                .nombre(req.nombre)
                .codigoEstudiante(req.codigoEstudiante)
                .curso(curso)
                .turno(req.turno)
                .fecha(Instant.now())
                .build();

        Matricula guardada = matriculaRepository.save(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }
}
