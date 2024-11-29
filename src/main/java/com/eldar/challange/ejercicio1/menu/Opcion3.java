package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Tarjeta;
import com.eldar.challange.ejercicio1.repository.TarjetaRepository;

import java.util.List;
import java.util.Scanner;

public class Opcion3 {

    public static void ejecutar(Scanner scanner, TarjetaRepository tarjetaRepository) {
        System.out.println("Ingrese DNI de persona para obtener sus tarjetas: ");
        Long dniPersona = scanner.nextLong();
        List<Tarjeta> tarjetas = tarjetaRepository.findByPersonaDniDni(dniPersona);

        if (tarjetas.isEmpty()) {
            System.out.println("No se encontraron tarjetas para el DNI proporcionado.");
        } else {
            System.out.println("Tarjetas asociadas:");
            for (Tarjeta tarjeta : tarjetas) {
                System.out.println("Número: " + tarjeta.getNumero() + ", Marca: " + tarjeta.getMarca() + ", Fecha de Vencimiento: " + tarjeta.getFechaVencimiento());
            }
        }
    }
}
