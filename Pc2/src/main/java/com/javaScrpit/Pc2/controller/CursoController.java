package com.javaScrpit.Pc2.controller;

import com.javaScrpit.Pc2.model.Curso;
import com.javaScrpit.Pc2.repository.CursoRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/curso", "/api/cursos"})
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll(Sort.by("id"));
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable Long id) {
        return cursoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));
    }
}
