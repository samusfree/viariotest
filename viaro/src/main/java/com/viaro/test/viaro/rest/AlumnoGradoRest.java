package com.viaro.test.viaro.rest;

import com.viaro.test.viaro.dto.AlumnoGradoDTO;
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
@RequestMapping("/api/v1/alumno-grado")
public class AlumnoGradoRest {
    private final CrudService<Long, AlumnoGradoDTO> alumnoGradoService;

    public AlumnoGradoRest(
            @Qualifier("alumnoGradoService") final CrudService<Long, AlumnoGradoDTO> alumnoGradoService) {
        this.alumnoGradoService = alumnoGradoService;
    }

    @GetMapping("/")
    public List<AlumnoGradoDTO> list() {
        return this.alumnoGradoService.list();
    }

    @GetMapping("/{id}")
    public AlumnoGradoDTO getById(@PathVariable Long id) {
        return this.alumnoGradoService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody AlumnoGradoDTO alumnoGradoDTO) {
        this.alumnoGradoService.save(alumnoGradoDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AlumnoGradoDTO alumnoGradoDTO) {
        var entityToUpdate = new AlumnoGradoDTO(id, alumnoGradoDTO.alumnoId(), alumnoGradoDTO.nombreAlumno(),
                alumnoGradoDTO.apellidoAlumno(), alumnoGradoDTO.gradoId(), alumnoGradoDTO.nombreGrado(),
                alumnoGradoDTO.seccion());
        this.alumnoGradoService.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.alumnoGradoService.delete(id);
    }
}