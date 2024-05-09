package com.viaro.test.viaro.repository;

import com.viaro.test.viaro.entities.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}
