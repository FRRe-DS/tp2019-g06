package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.validation.Valid;

import com.gestionturnos.gestion_turnos.gestionturnos.model.ClaveMedicoObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;


/**
 * 
 * @author flor
 *
 */

@Repository
public interface MedicoObraSocialRepository extends JpaRepository<MedicoObraSocial, Integer>{
	
	Optional<MedicoObraSocial> findByIdMedico(Integer idMedico);
	Optional<MedicoObraSocial> findByIdObraSocial(Integer idObraSocial);
				
}