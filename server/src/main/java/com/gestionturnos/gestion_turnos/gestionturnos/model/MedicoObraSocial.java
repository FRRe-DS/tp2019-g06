package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

/**
 * 
 * @author flor
 *
 */

@Entity
@IdClass(ClaveMedicoObraSocial.class)
public class MedicoObraSocial {
    @Id
    private Integer idMedico;

    @Id
    private Integer idObraSocial;

 
    @OneToMany(mappedBy = "medicoObraSocial", 
           fetch = FetchType.LAZY,
           cascade = CascadeType.ALL,
           orphanRemoval = true)
   private Set<Turno> turnos;

   public MedicoObraSocial(){}

public Integer getIdObraSocial() {
	return null;
}

public Integer getIdMedico() {
	return null;
}

}
