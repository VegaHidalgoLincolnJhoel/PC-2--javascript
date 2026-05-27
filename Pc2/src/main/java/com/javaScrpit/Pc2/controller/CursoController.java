package com.javaScrpit.Pc2.controller;

import com.javaScrpit.Pc2.model.Curso;
import com.javaScrpit.Pc2.repository.CursoRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll(Sort.by("id"));
    }
}
