package com.eldar.challange.ejercicio1.entity;

import com.eldar.challange.ejercicio1.menu.TarjetaEnum;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class TarjetaNaranja extends Tarjeta {

    public TarjetaNaranja() {
        super();
        this.setMarca(TarjetaEnum.NARA);
    }

    @Override
    public double calcularTasaDeServicio(LocalDate fecha) {
        return fecha.getDayOfMonth() * 0.5;
    }
}
