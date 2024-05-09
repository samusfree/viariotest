package com.viaro.test.viaro.repository;

import com.viaro.test.viaro.entities.AlumnoGrado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoGradoRepository extends CrudRepository<AlumnoGrado, Long> {
}
