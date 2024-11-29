package com.eldar.challange.ejercicio1;

import com.eldar.challange.ejercicio1.menu.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	@Autowired
	private MenuPrincipal menuPrincipal;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);
		MenuPrincipal menuPrincipal = context.getBean(MenuPrincipal.class);
		menuPrincipal.runMenu();
	}
}
