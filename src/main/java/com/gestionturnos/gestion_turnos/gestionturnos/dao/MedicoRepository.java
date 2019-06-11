package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.Optional;
import java.util.Set;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;
/**
 * 
 * @author flor
 *
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	
	Optional<Medico> findById(Integer idMedico);
	
	Set<Medico> findByObraSocial(ObraSocial obraSocial);
	
	//Set<Medico> findByTurno(Turno turnos);
	
	Optional<Medico> findByMatricula(Integer matricula);
		
}
