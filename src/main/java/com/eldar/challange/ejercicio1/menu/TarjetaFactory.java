package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Tarjeta;
import com.eldar.challange.ejercicio1.entity.TarjetaAmex;
import com.eldar.challange.ejercicio1.entity.TarjetaNaranja;
import com.eldar.challange.ejercicio1.entity.TarjetaVisa;

public class TarjetaFactory {

    public static Tarjeta crearTarjeta(TarjetaEnum marca) {
        return switch (marca) {
            case VISA -> new TarjetaVisa();
            case NARA -> new TarjetaNaranja();
            case AMEX -> new TarjetaAmex();
            default -> throw new IllegalArgumentException("Tipo de tarjeta no soportado: " + marca);
        };
    }

}
