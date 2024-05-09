package com.viaro.test.viaro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viaro.test.viaro.enums.GeneroEnum;

import java.util.Date;


public record AlumnoDTO (Long id, String nombre, String apellidos, GeneroEnum genero,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") Date fechaNacimiento){
}
