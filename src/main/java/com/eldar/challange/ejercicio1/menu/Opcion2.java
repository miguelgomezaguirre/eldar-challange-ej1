package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Persona;
import com.eldar.challange.ejercicio1.entity.Tarjeta;
import com.eldar.challange.ejercicio1.repository.PersonaRepository;
import com.eldar.challange.ejercicio1.repository.TarjetaRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Opcion2 {

    public static void ejecutar(Scanner scanner, PersonaRepository personaRepository, TarjetaRepository tarjetaRepository) {
        System.out.println("Ingrese DNI de persona para asociar tarjeta: ");
        Long dni = null;
        while (dni == null) {
            try {
                dni = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el scanner
            }
        }
        Persona persona = null;
        while (persona == null) {
            try {
                persona = personaRepository.findById(dni).orElseThrow();
            } catch (NoSuchElementException e) {
                System.out.println("DNI no encontrado. Por favor, ingrese un DNI válido.");
                return;
            }
        }
        System.out.println("=======================================================");
        System.out.println("Registrando tarjeta para: " + persona.getNombre() );
        System.out.println("=======================================================");
        System.out.println("Seleccione marca de tarjeta: ");
        System.out.println("1. Visa");
        System.out.println("2. Naranja");
        System.out.println("3. Amex");
        TarjetaEnum marca = null;
        while (marca == null) {
            int opcionMarca = scanner.nextInt();
            if (opcionMarca >= 1 && opcionMarca <= 3) {
                marca = TarjetaEnum.values()[opcionMarca - 1];
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
        Tarjeta tarjeta = TarjetaFactory.crearTarjeta(marca);
        System.out.println();
        System.out.println("Ingrese número de tarjeta: ");
        Long numeroTarjeta = null;
        while (numeroTarjeta == null) {
            try {
                numeroTarjeta = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
        System.out.println("Ingrese año de vencimiento: ");
        Integer anoVencimiento = null;
        while (anoVencimiento == null) {
            try {
                anoVencimiento = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
        System.out.println("Ingrese mes de vencimiento: ");
        Integer mesVencimiento = null;
        while (mesVencimiento == null) {
            try {
                mesVencimiento = scanner.nextInt();
                if (mesVencimiento < 1 || mesVencimiento > 12) {
                    System.out.println("Mes no válido. Por favor, ingrese un número entre 1 y 12.");
                    mesVencimiento = null;
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        String nombreTitular = persona.getNombre() + " " + persona.getApellido();
        tarjeta.setNumero(numeroTarjeta);
        tarjeta.setFechaVencimiento(LocalDate.of(anoVencimiento, mesVencimiento, 1));
        tarjeta.setNombreTitular(nombreTitular);
        tarjeta.setPersonaDni(persona);
        tarjetaRepository.save(tarjeta);
    }
}
