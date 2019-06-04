package DAO;

import Modelos.ObraSocial;
import Modelos.Paciente;
import Modelos.Turno;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
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
