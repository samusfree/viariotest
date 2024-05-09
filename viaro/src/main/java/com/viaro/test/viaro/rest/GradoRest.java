package com.viaro.test.viaro.rest;

import com.viaro.test.viaro.dto.GradoDTO;
import com.viaro.test.viaro.dto.ResponseDTO;
import com.viaro.test.viaro.service.GradoService;
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
@RequestMapping("/api/v1/grado")
public class GradoRest {
    private final GradoService gradoService;

    public GradoRest(final GradoService gradoService) {
        this.gradoService = gradoService;
    }

    @GetMapping("/")
    public List<GradoDTO> list() {
        return this.gradoService.list();
    }

    @GetMapping("/{id}")
    public GradoDTO getById(@PathVariable Long id) {
        return this.gradoService.findById(id);
    }

    @PostMapping("/")
    public ResponseDTO<GradoDTO> save(@RequestBody GradoDTO gradoDTO) {
        return this.gradoService.save(gradoDTO);
    }

    @PutMapping("/{id}")
    public ResponseDTO<GradoDTO> update(@PathVariable Long id, @RequestBody GradoDTO gradoDTO) {
        var entityToUpdate = new GradoDTO(id, gradoDTO.nombre(), gradoDTO.profesorId(),
                gradoDTO.nombreProfesor(), gradoDTO.apellidoProfesor());
        return this.gradoService.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.gradoService.delete(id);
    }
}
