package DAO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Turno;
/**
 * 
 * @author flor
 *
 */
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
	
	Optional<Turno> findById(Integer idTurno);
		
	Set<Turno> findByPaciente(Paciente paciente);
	
	Set<Turno> findByMedico(Medico medico);
	
}
