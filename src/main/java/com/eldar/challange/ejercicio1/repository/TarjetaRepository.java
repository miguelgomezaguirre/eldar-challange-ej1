package com.eldar.challange.ejercicio1.repository;

import com.eldar.challange.ejercicio1.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    List<Tarjeta> findByPersonaDniDni(Long dni);
}
