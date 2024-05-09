package com.viaro.test.viaro.entities;

import jakarta.persistence.Column;
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
@Table(name = "grado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grado_id")
    private Long id;
    private String nombre;
    @ManyToOne(targetEntity = Profesor.class)
    @JoinColumn(name="profesor_id", nullable=false)
    Profesor profesor;
}
