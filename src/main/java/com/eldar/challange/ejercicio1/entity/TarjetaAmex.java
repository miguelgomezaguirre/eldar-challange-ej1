package com.eldar.challange.ejercicio1.entity;

import com.eldar.challange.ejercicio1.menu.TarjetaEnum;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class TarjetaAmex extends Tarjeta {

    public TarjetaAmex() {
        super();
        this.setMarca(TarjetaEnum.AMEX);
    }

    @Override
    public double calcularTasaDeServicio(LocalDate fecha) {
        return fecha.getMonthValue() * 0.1;
    }
}
