package com.eldar.challange.ejercicio1.repository;

import com.eldar.challange.ejercicio1.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
