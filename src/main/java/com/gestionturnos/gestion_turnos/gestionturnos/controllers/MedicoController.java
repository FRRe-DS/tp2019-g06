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
import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;

	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@GetMapping()
	public Page<Medico> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{idMedico}")
	public ResponseEntity<Medico> findById(@PathVariable Integer idMedico) {

		Optional<Medico> opt = repository.findById(idMedico);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<Medico> findByNroMatricula(@PathVariable Integer matricula) {
		Optional<Medico> opt = repository.findByMatricula(matricula);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/obraSocial/{idObraSocial}")
	public ResponseEntity<Set<Medico>> findByObraSocial(@PathVariable Integer idObraSocial) {
		ObraSocial obraSocial = obraSocialRepository.getOne(idObraSocial);
		Set<Medico> ret = repository.findByObraSocial(obraSocial);
		return ResponseEntity.ok(ret);
	}

	/*
	 * @GetMapping("/turno/{idTurno}") public ResponseEntity<Set<Medico>>
	 * findByTurno(@PathVariable Integer idTurno) { Turno turno =
	 * turnoRepository.getOne(idTurno); Set<Medico> ret =
	 * repository.findByTurno(turno); return ResponseEntity.ok(ret); }
	 */

	@PostMapping()
	public ResponseEntity<Medico> create(@Valid @RequestBody Medico createRequest) {
		return ResponseEntity.ok(repository.save(createRequest));
	}

	@PutMapping()
	public ResponseEntity<Medico> update(@Valid @RequestBody Medico updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdMedico());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{idMedico}")
	public ResponseEntity<?> delete(@PathVariable Integer idMedico) {
		Optional<Medico> opt = repository.findById(idMedico);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
