package com.javaScrpit.Pc2.controller;

import com.javaScrpit.Pc2.dto.MatriculaRequest;
import com.javaScrpit.Pc2.model.Curso;
import com.javaScrpit.Pc2.model.Matricula;
import com.javaScrpit.Pc2.repository.CursoRepository;
import com.javaScrpit.Pc2.repository.MatriculaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;

    public MatriculaController(CursoRepository cursoRepository, MatriculaRepository matriculaRepository) {
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> crearMatricula(@RequestBody MatriculaRequest request) {
        if (request == null || request.cursoId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cursoId requerido");
        }

        Curso curso = cursoRepository.findById(request.cursoId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));

        if (curso.getVacantes() <= 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Sin vacantes");
        }

        curso.setVacantes(curso.getVacantes() - 1);

        Matricula matricula = new Matricula();
        matricula.setNombre(request.nombre());
        matricula.setCodigoEstudiante(request.codigoEstudiante());
        matricula.setTurno(request.turno());
        matricula.setCurso(curso);

        matriculaRepository.save(matricula);
        cursoRepository.save(curso);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
