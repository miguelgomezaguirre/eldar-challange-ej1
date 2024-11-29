package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Persona;
import com.eldar.challange.ejercicio1.repository.PersonaRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Opcion1 {

    public static void ejecutar(Scanner scanner, PersonaRepository personaRepository) {
        System.out.println("Ingrese nombre: ");
        String nombre = scanner.next();
        System.out.println("Ingrese apellido: ");
        String apellido = scanner.next();
        System.out.println("Ingrese DNI: ");
        Long dni = null;
        while (dni == null) {
            try {
                dni = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el scanner
            }
        }
        System.out.println("Ingrese fecha de nacimiento (Formato: dd-MM-yyyy): ");
        String fechaNacimiento = null;
        LocalDate fechaNacimientoDate = null;
        while (fechaNacimiento == null) {
            try {
                fechaNacimiento = scanner.next();
                fechaNacimientoDate = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese una fecha válida. Formato: dd-MM-yyyy");
                fechaNacimiento = null;
            }
        }

        System.out.println("Ingrese email: ");
        String email = null;
        while (email == null) {
            email = scanner.next();
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                System.out.println("Email no válido. Por favor, ingrese un email válido.");
                email = null;
            }
        }

        Persona persona = new Persona(dni, nombre, apellido, fechaNacimientoDate, email);
        personaRepository.save(persona);
        System.out.println("Persona registrada exitosamente.");
    }
}
