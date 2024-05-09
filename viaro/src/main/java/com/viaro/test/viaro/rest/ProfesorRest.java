package com.viaro.test.viaro.rest;

import com.viaro.test.viaro.dto.ProfesorDTO;
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
@RequestMapping("/api/v1/profesor")
public class ProfesorRest {
    private final CrudService<Long, ProfesorDTO> profesorService;

    public ProfesorRest(@Qualifier("profesorService") final CrudService<Long, ProfesorDTO> profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping("/")
    public List<ProfesorDTO> list() {
        return this.profesorService.list();
    }

    @GetMapping("/{id}")
    public ProfesorDTO getById(@PathVariable Long id) {
        return this.profesorService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody ProfesorDTO profesorDTO) {
        this.profesorService.save(profesorDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProfesorDTO profesorDTO) {
        var entityToUpdate = new ProfesorDTO(id, profesorDTO.nombre(), profesorDTO.apellidos(),
                profesorDTO.genero());
        this.profesorService.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.profesorService.delete(id);
    }
}
