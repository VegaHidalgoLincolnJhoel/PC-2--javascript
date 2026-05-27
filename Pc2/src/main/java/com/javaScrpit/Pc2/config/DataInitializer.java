package com.javaScrpit.Pc2.config;

import com.javaScrpit.Pc2.model.Curso;
import com.javaScrpit.Pc2.repository.CursoRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CursoRepository cursoRepository;

    public DataInitializer(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) {
        if (cursoRepository.count() > 0) {
            return;
        }

        List<Curso> cursos = List.of(
            new Curso("CS101", "Programación Web", 4, "Presencial", 15),
            new Curso("CS102", "Base de Datos", 3, "Virtual", 0),
            new Curso("CS103", "Inteligencia Artificial", 5, "Híbrido", 5)
        );

        cursoRepository.saveAll(cursos);
    }
}
