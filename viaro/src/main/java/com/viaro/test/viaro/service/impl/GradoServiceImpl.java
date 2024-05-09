package com.viaro.test.viaro.service.impl;

import com.viaro.test.viaro.dto.GradoDTO;
import com.viaro.test.viaro.dto.ResponseDTO;
import com.viaro.test.viaro.entities.Grado;
import com.viaro.test.viaro.exceptions.BusinessException;
import com.viaro.test.viaro.mapper.ViaroObjectMapper;
import com.viaro.test.viaro.repository.GradoRepository;
import com.viaro.test.viaro.repository.ProfesorRepository;
import com.viaro.test.viaro.service.CrudService;
import com.viaro.test.viaro.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service("gradoService")
public class GradoServiceImpl implements GradoService {
    private final GradoRepository gradoRepository;
    private final ProfesorRepository profesorRepository;
    private final ViaroObjectMapper viaroObjectMapper;

    @Autowired
    public GradoServiceImpl(final GradoRepository gradoRepository,
            final ProfesorRepository profesorRepository,
            final ViaroObjectMapper viaroObjectMapper) {
        this.gradoRepository = gradoRepository;
        this.viaroObjectMapper = viaroObjectMapper;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public GradoDTO findById(Long id) {
        return viaroObjectMapper.gradoToGradoDTO(
                gradoRepository.findById(id).orElseThrow(() -> new BusinessException("Alumno no encontrado")));
    }

    @Override
    public List<GradoDTO> list() {
        return StreamSupport.stream(gradoRepository.findAll().spliterator(), true)
                .map(viaroObjectMapper::gradoToGradoDTO).toList();
    }

    @Override
    public ResponseDTO<GradoDTO> save(GradoDTO dto) {
        var profesor = profesorRepository.findById(dto.profesorId());
        if(profesor.isEmpty()) {
            return new ResponseDTO<>(false, "Profesor no encontrado", null);
        }
        boolean existsProfesor = gradoRepository.existsByProfesor(profesor.get());
        if(existsProfesor) {
            return new ResponseDTO<>(false, "Profesor ya asignado", null);
        }
        var grado = Grado.builder().id(dto.id()).profesor(profesor.get()).nombre(dto.nombre()).build();
        return new ResponseDTO<>(true, null, viaroObjectMapper.gradoToGradoDTO(gradoRepository.save(grado)));
    }

    @Override
    public void delete(Long id) {
        gradoRepository.deleteById(id);
    }
}
