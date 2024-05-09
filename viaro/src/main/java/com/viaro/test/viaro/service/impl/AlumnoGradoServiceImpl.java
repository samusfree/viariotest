package com.viaro.test.viaro.service.impl;

import com.viaro.test.viaro.dto.AlumnoGradoDTO;
import com.viaro.test.viaro.entities.Alumno;
import com.viaro.test.viaro.entities.AlumnoGrado;
import com.viaro.test.viaro.entities.Grado;
import com.viaro.test.viaro.exceptions.BusinessException;
import com.viaro.test.viaro.mapper.ViaroObjectMapper;
import com.viaro.test.viaro.repository.AlumnoGradoRepository;
import com.viaro.test.viaro.repository.AlumnoRepository;
import com.viaro.test.viaro.repository.GradoRepository;
import com.viaro.test.viaro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service("alumnoGradoService")
public class AlumnoGradoServiceImpl implements CrudService<Long, AlumnoGradoDTO> {
    private final AlumnoGradoRepository alumnoGradoRepository;
    private final GradoRepository gradoRepository;
    private final AlumnoRepository alumnoRepository;
    private final ViaroObjectMapper viaroObjectMapper;

    @Autowired
    public AlumnoGradoServiceImpl(final AlumnoGradoRepository alumnoGradoRepository,
            final ViaroObjectMapper viaroObjectMapper, final GradoRepository gradoRepository,
            final AlumnoRepository alumnoRepository) {
        this.viaroObjectMapper = viaroObjectMapper;
        this.alumnoGradoRepository = alumnoGradoRepository;
        this.gradoRepository = gradoRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoGradoDTO findById(Long id) {
        return viaroObjectMapper.alumnoGradoToAlumnoGradoDTO(
                alumnoGradoRepository.findById(id).orElseThrow(() -> new BusinessException("Alumno Grado no encontrado")));
    }

    @Override
    public List<AlumnoGradoDTO> list() {
        return StreamSupport.stream(alumnoGradoRepository.findAll().spliterator(), true)
                .map(viaroObjectMapper::alumnoGradoToAlumnoGradoDTO).toList();
    }

    @Override
    public void save(AlumnoGradoDTO alumnoGrado) {
        var gradoEntity = gradoRepository.findById(alumnoGrado.gradoId()).orElseThrow(() -> new BusinessException("Grado no encontrado"));
        var alumnoEntity = alumnoRepository.findById(alumnoGrado.alumnoId()).orElseThrow(() -> new BusinessException("Alumno no encontrado"));
        var alumnoGradoEntity = AlumnoGrado.builder().id(alumnoGrado.id()).grado(gradoEntity).alumno(alumnoEntity).seccion(alumnoGrado.seccion()).build();
        alumnoGradoRepository.save(alumnoGradoEntity);
    }

    @Override
    public void delete(Long id) {
        alumnoGradoRepository.deleteById(id);
    }
}
