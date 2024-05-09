package com.viaro.test.viaro.mapper;

import com.viaro.test.viaro.dto.AlumnoDTO;
import com.viaro.test.viaro.dto.AlumnoGradoDTO;
import com.viaro.test.viaro.dto.GradoDTO;
import com.viaro.test.viaro.dto.ProfesorDTO;
import com.viaro.test.viaro.entities.Alumno;
import com.viaro.test.viaro.entities.AlumnoGrado;
import com.viaro.test.viaro.entities.Grado;
import com.viaro.test.viaro.entities.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ViaroObjectMapper {
    AlumnoDTO alumnoToAlumnoDTO(Alumno alumno);

    Alumno alumnoDTOToAlumno(AlumnoDTO alumnoDTO);

    @Mapping(source = "alumno.id", target = "alumnoId")
    @Mapping(source = "alumno.nombre", target = "nombreAlumno")
    @Mapping(source = "alumno.apellidos", target = "apellidoAlumno")
    @Mapping(source = "grado.id", target = "gradoId")
    @Mapping(source = "grado.nombre", target = "nombreGrado")
    AlumnoGradoDTO alumnoGradoToAlumnoGradoDTO(AlumnoGrado alumnoGrado);

    @Mapping(source = "grado.profesor.id", target = "profesorId")
    @Mapping(source = "grado.profesor.nombre", target = "nombreProfesor")
    @Mapping(source = "grado.profesor.apellidos", target = "apellidoProfesor")
    GradoDTO gradoToGradoDTO(Grado grado);

    ProfesorDTO profesorTOProfesorDTO(Profesor grado);

    Profesor profesorDTOToProfesor(ProfesorDTO profesorDTO);
}