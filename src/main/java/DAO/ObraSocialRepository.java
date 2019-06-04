package DAO;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import Modelos.Medico;
import Modelos.ObraSocial;
import Modelos.Paciente;
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
