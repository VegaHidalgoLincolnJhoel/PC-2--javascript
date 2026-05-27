package com.javaScrpit.Pc2.repository;

import com.javaScrpit.Pc2.model.Curso;
import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Curso> findWithLockById(Long id);
}
