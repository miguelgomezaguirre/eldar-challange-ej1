package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Tarjeta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Opcion4 {

    public static void ejecutar(Scanner scanner) {
        System.out.println("Ingrese la fecha que deseas consultar la tasa de servicios (dd-MM-yyyy): ");
        String fecha = null;
        LocalDate fechaLocalDate = null;
        while (fecha == null) {
            try {
                fecha = scanner.next();
                fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (Exception e) {
                System.out.println("Fecha no válida. Por favor, intente de nuevo.");
                fecha = null;
            }
        }

        for (TarjetaEnum marca : TarjetaEnum.values()) {

            Tarjeta tarjeta = TarjetaFactory.crearTarjeta(marca);
            double tasa = obtenerTasaDeServicio(tarjeta, fechaLocalDate);

            System.out.println("Tasa de servicio para " + marca + ": " + tasa);
        }
    }

    private static double obtenerTasaDeServicio(Tarjeta tarjeta, LocalDate fecha) {
        double tasa = tarjeta.calcularTasaDeServicio(fecha);
        if (tasa <= 0.3) {
            tasa = 0.3;
        } else if (tasa >= 5) {
            tasa = 5;
        }
        return tasa;
    }
}
