package com.viaro.test.viaro.rest;

import com.viaro.test.viaro.dto.AlumnoDTO;
import com.viaro.test.viaro.service.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumno")
public class AlumnoRest {
    private final CrudService<Long, AlumnoDTO> alumnoService;

    public AlumnoRest(@Qualifier("alumnoService") final CrudService<Long, AlumnoDTO> alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    public List<AlumnoDTO> list() {
        return this.alumnoService.list();
    }

    @GetMapping("/{id}")
    public AlumnoDTO getById(@PathVariable Long id) {
        return this.alumnoService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody AlumnoDTO alumnoDTO) {
        this.alumnoService.save(alumnoDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO) {
        var entityToUpdate = new AlumnoDTO(id, alumnoDTO.nombre(), alumnoDTO.apellidos(),
                alumnoDTO.genero(), alumnoDTO.fechaNacimiento());
        this.alumnoService.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.alumnoService.delete(id);
    }
}
