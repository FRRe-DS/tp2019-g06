package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

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

import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.PacienteRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.TurnoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;

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

	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@Autowired
	private TurnoRepository turnoRepository;
	
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
		var obraTurno = createRequest.getObraSocial();
		var paciente = createRequest.getPaciente();
		var medico = createRequest.getMedico();
				
		var resultpacient = paciente.getObraSocial();
		var idObraSocialPac = obraSocialRepository.findById(resultpacient.getIdObraSocial());

		var resultmedic = medico.getObraSocial();
		var idObraSocialMed = obraSocialRepository.findById(resultmedic.getIdObraSocial());

		if (obraTurno == true){
			if(idObraSocialMed.isEmpty() | idObraSocialPac.isEmpty()){
				System.out.println("El medico o el paciente no tienen obra social");
				return ResponseEntity.notFound().build();
			}
		}
		
		/*if(turno == true & (resultpac.isEmpty())) {
			//System.out.println("No existe obra social del paciente"); NO SE COMO HACER PARA QUE SALGA UN MENSAJE
			return ResponseEntity.notFound().build();
		}

		if(turno == true & (resultmed.isEmpty())) {
			//System.out.println("No existe obra social del medico"); NO SE COMO HACER PARA QUE SALGA UN MENSAJE
			return ResponseEntity.notFound().build();
		}
		*/
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
