package com.viaro.test.viaro.dto;

import com.viaro.test.viaro.enums.GeneroEnum;

public record ProfesorDTO (Long id, String nombre, String apellidos, GeneroEnum genero){
}
