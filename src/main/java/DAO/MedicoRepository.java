package DAO;

import java.util.Optional;
import java.util.Set;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Modelos.Medico;
import Modelos.ObraSocial;
import Modelos.Turno;
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
