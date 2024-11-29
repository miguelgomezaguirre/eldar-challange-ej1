package com.eldar.challange.ejercicio1.entity;

import com.eldar.challange.ejercicio1.menu.TarjetaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Tarjeta {
    @Id
    private Long numero;
    private LocalDate fechaVencimiento;
    private String nombreTitular;
    private TarjetaEnum marca;
    @ManyToOne
    @JoinColumn(referencedColumnName = "dni")
    private Persona personaDni;

    public abstract double calcularTasaDeServicio(LocalDate fecha);

}
