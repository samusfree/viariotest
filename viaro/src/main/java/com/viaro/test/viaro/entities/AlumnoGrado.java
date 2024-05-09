package com.viaro.test.viaro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno_grado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoGrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="alumno_id", nullable=false)
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name="grado_id", nullable=false)
    private Grado grado;
    private String seccion;
}
