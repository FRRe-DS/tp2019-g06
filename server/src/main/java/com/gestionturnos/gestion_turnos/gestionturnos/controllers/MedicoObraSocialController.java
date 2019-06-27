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

import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.TurnoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ClaveMedicoObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/medicoObraSocial")
public class MedicoObraSocialController {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@Autowired
	private TurnoRepository turnoRepository;

	@Autowired
	private MedicoObraSocialRepository repository;

	@GetMapping()
	public Page<MedicoObraSocial> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{idMedico}")
	public ResponseEntity<MedicoObraSocial> findByIdMedico(@PathVariable Integer idMedico) {
		
		Optional<MedicoObraSocial> opt = repository.findByIdMedico(idMedico);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/obraSocial/{idObraSocial}")
    
    public ResponseEntity<MedicoObraSocial> findByIdObra(@PathVariable Integer idObraSocial) {
		
		Optional<MedicoObraSocial> opt = repository.findByIdObraSocial(idObraSocial);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<MedicoObraSocial> create(@Valid @RequestBody MedicoObraSocial createRequest) {
		var medRequest = createRequest.getIdMedico();
		var obraRequest = createRequest.getIdObraSocial();

		var medAlmacenado = medicoRepository.findById(medRequest);
		var obraAlmacenado = obraSocialRepository.findById(obraRequest);

		if (medAlmacenado.isPresent() && obraAlmacenado.isPresent()) {
			return ResponseEntity.ok(repository.save(createRequest));

		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping()
	public ResponseEntity<MedicoObraSocial> update(@Valid @RequestBody MedicoObraSocial updateRequest) {
		boolean existsMedico = repository.existsById(updateRequest.getIdMedico());
		boolean existsObra = repository.existsById(updateRequest.getIdObraSocial());
		if (existsMedico && existsObra) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/medico/{idMedico}/obraSocial/{idObraSocial}")
	public ResponseEntity<?> delete(@PathVariable Integer idMedico, @PathVariable Integer idObraSocial) {
		Optional<MedicoObraSocial> opt = repository.findByIdMedico(idMedico);
		Optional<MedicoObraSocial> opt2 = repository.findByIdObraSocial(idObraSocial);
		if (opt.isPresent() && opt2.isPresent()) {
            repository.delete(opt.get());
            repository.delete(opt2.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
}
	
	
}