package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
/**
 * 
 * @author flor
 *
 */
public interface ObraSocialRepository extends JpaRepository<ObraSocial, Integer> {
	/*
	Optional<ObraSocial> findById(Integer idObraSocial);
	
	Set<ObraSocial> findByPaciente(Paciente paciente);
	
	Set<ObraSocial> findByMedico(Medico medico);
*/
}
