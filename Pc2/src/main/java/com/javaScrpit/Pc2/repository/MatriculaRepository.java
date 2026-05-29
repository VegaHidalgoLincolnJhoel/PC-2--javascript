package com.javaScrpit.Pc2.repository;

import com.javaScrpit.Pc2.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    @Query("select m from Matricula m join fetch m.curso order by m.id desc")
    List<Matricula> findAllWithCurso();
}
