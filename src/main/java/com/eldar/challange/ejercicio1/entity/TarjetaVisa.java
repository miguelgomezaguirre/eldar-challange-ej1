package com.eldar.challange.ejercicio1.entity;

import com.eldar.challange.ejercicio1.menu.TarjetaEnum;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class TarjetaVisa extends Tarjeta {

    public TarjetaVisa() {
        super();
        this.setMarca(TarjetaEnum.VISA);
    }

    @Override
    public double calcularTasaDeServicio(LocalDate fecha) {
        return (double) (fecha.getYear() % 100) / fecha.getMonthValue();
    }
}
