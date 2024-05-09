package com.viaro.test.viaro.service.impl;

import com.viaro.test.viaro.dto.AlumnoDTO;
import com.viaro.test.viaro.exceptions.BusinessException;
import com.viaro.test.viaro.mapper.ViaroObjectMapper;
import com.viaro.test.viaro.repository.AlumnoRepository;
import com.viaro.test.viaro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service("alumnoService")
public class AlumnoServiceImpl implements CrudService<Long, AlumnoDTO> {
    private final AlumnoRepository alumnoRepository;
    private final ViaroObjectMapper viaroObjectMapper;

    @Autowired
    public AlumnoServiceImpl(final AlumnoRepository alumnoRepository,
            final ViaroObjectMapper viaroObjectMapper) {
        this.alumnoRepository = alumnoRepository;
        this.viaroObjectMapper = viaroObjectMapper;
    }

    @Override
    public AlumnoDTO findById(Long id) {
        return viaroObjectMapper.alumnoToAlumnoDTO(
                alumnoRepository.findById(id).orElseThrow(() -> new BusinessException("Alumno no encontrado")));
    }

    @Override
    public List<AlumnoDTO> list() {
        return StreamSupport.stream(alumnoRepository.findAll().spliterator(), true)
                .map(viaroObjectMapper::alumnoToAlumnoDTO).toList();
    }

    @Override
    public void save(AlumnoDTO alumnoDTO) {
        alumnoRepository.save(viaroObjectMapper.alumnoDTOToAlumno(alumnoDTO));
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }
}
