package com.viaro.test.viaro.service;

import com.viaro.test.viaro.dto.GradoDTO;
import com.viaro.test.viaro.dto.ResponseDTO;
import com.viaro.test.viaro.entities.Grado;

import java.util.List;

public interface GradoService {
    GradoDTO findById(Long id);
    List<GradoDTO> list();
    ResponseDTO<GradoDTO> save(GradoDTO dto);
    void delete (Long id);
}
