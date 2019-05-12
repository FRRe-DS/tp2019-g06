/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author flor
 */
@Entity
public class especialidad_has_medico implements java.io.Serializable {
    @EmbeddedId
    private claveEspecialidadMedico clave;
 
    @OneToMany(mappedBy = "id_turno", 
           fetch = FetchType.LAZY,
           cascade = CascadeType.ALL,
           orphanRemoval = true)
   private Set<turno> turnos;
}
