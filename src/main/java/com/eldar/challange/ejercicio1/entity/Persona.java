package com.eldar.challange.ejercicio1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    @Id
    private Long dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;
}
