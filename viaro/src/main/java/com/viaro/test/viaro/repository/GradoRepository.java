package com.viaro.test.viaro.repository;

import com.viaro.test.viaro.entities.Grado;
import com.viaro.test.viaro.entities.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends CrudRepository<Grado, Long> {
    boolean existsByProfesor(Profesor profesor);
}
