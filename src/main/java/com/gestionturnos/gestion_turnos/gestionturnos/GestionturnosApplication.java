package com.gestionturnos.gestion_turnos.gestionturnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author flor
 *
 */
@ComponentScan("Controlador")
@EntityScan("Modelos")
@EnableJpaRepositories("DAO")
@SpringBootApplication
public class GestionturnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionturnosApplication.class, args);
	}

}
