package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;

/**
 * 
 * @author flor
 *
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	Optional<Paciente> findById(Integer idPaciete);
	
	Set<Paciente> findByObraSocial(ObraSocial obraSocial);
	
	//Set<Paciente> findByTurno(Turno turnos);
	
}
