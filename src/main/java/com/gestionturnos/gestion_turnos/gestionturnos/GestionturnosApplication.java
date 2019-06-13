package com.gestionturnos.gestion_turnos.gestionturnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author flor
 *
 */
@ComponentScan("com.gestionturnos.gestion_turnos.gestionturnos.controllers")
@EntityScan("com.gestionturnos.gestion_turnos.gestionturnos.model")
@EnableJpaRepositories("com.gestionturnos.gestion_turnos.gestionturnos.dao")
@SpringBootApplication
public class GestionturnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionturnosApplication.class, args);
	}

}
