package com.eldar.challange.ejercicio1.menu;

import com.eldar.challange.ejercicio1.entity.Persona;
import com.eldar.challange.ejercicio1.entity.Tarjeta;
import com.eldar.challange.ejercicio1.repository.PersonaRepository;
import com.eldar.challange.ejercicio1.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class MenuPrincipal {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TarjetaRepository tarjetaRepository;

    Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("=== Menú Interactivo ===");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar Tarjeta");
            System.out.println("3. Retornar información de tarjeta por DNI");
            System.out.println("4. Consultar tasa de servicio por tipo tarjeta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    Opcion1.ejecutar(scanner, personaRepository);
                    break;
                case 2:
                    Opcion2.ejecutar(scanner, personaRepository, tarjetaRepository);
                    break;
                case 3:
                    Opcion3.ejecutar(scanner, tarjetaRepository);
                    break;
                case 4:
                    Opcion4.ejecutar(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }

}
