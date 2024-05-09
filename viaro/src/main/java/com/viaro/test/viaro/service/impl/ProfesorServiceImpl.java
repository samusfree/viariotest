package com.viaro.test.viaro.service.impl;

import com.viaro.test.viaro.dto.ProfesorDTO;
import com.viaro.test.viaro.exceptions.BusinessException;
import com.viaro.test.viaro.mapper.ViaroObjectMapper;
import com.viaro.test.viaro.repository.ProfesorRepository;
import com.viaro.test.viaro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service("profesorService")
public class ProfesorServiceImpl implements CrudService<Long, ProfesorDTO> {
    private final ProfesorRepository profesorRepository;
    private final ViaroObjectMapper viaroObjectMapper;

    @Autowired
    public ProfesorServiceImpl(
            final ProfesorRepository profesorRepository,
            final ViaroObjectMapper viaroObjectMapper) {
        this.viaroObjectMapper = viaroObjectMapper;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public ProfesorDTO findById(Long id) {
        return viaroObjectMapper.profesorTOProfesorDTO(
                profesorRepository.findById(id).orElseThrow(() -> new BusinessException("Profesor no encontrado")));
    }

    @Override
    public List<ProfesorDTO> list() {
        return StreamSupport.stream(profesorRepository.findAll().spliterator(), true)
                .map(viaroObjectMapper::profesorTOProfesorDTO).toList();
    }

    @Override
    public void save(ProfesorDTO dto) {
        profesorRepository.save(viaroObjectMapper.profesorDTOToProfesor(dto));
    }

    @Override
    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
