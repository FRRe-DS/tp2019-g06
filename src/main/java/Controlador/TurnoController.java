package Controlador;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DAO.MedicoRepository;
import DAO.PacienteRepository;
import DAO.TurnoRepository;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Turno;
/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/turno")
public class TurnoController {
	
	@Autowired
	private TurnoRepository repository;

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping()
	public Page<Turno> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@GetMapping("/{idTurno}")
	public ResponseEntity<Turno> findById(@PathVariable Integer idTurno) {
		
		Optional<Turno> opt = repository.findById(idTurno);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/paciente/{idPaciente}")
	public ResponseEntity<Set<Turno>> findByPaciente(@PathVariable Integer idPaciente) {
		Paciente paciente = pacienteRepository.getOne(idPaciente);
		Set<Turno> ret = repository.findByPaciente(paciente);
		return ResponseEntity.ok(ret);
	}
	
	@GetMapping("/medico/{idMedico}")
	public ResponseEntity<Set<Turno>> findByMedico(@PathVariable Integer idMedico) {
		Medico medico = medicoRepository.getOne(idMedico);
		Set<Turno> ret = repository.findByMedico(medico);
		return ResponseEntity.ok(ret);
	}
	
	@PostMapping()
	public ResponseEntity<Turno> create(@Valid @RequestBody Turno createRequest) {
		return ResponseEntity.ok(repository.save(createRequest));
	}
	
	@PutMapping()
	public ResponseEntity<Turno> update(@Valid @RequestBody Turno updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdTurno());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idTurno}")
	public ResponseEntity<Turno> delete(@PathVariable Integer idTurno) {
		Optional<Turno> opt = repository.findById(idTurno);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
}
