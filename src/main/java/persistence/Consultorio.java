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
public class Consultorio implements java.io.Serializable {
   @EmbeddedId
   private ClaveConsultorio clave;
   
   @OneToMany(mappedBy = "idTurno", 
           fetch = FetchType.LAZY,
           cascade = CascadeType.ALL,
           orphanRemoval = true)
   private Set<Turno> turnos;

    public ClaveConsultorio getClave() {
        return clave;
    }

    public void setClave(ClaveConsultorio clave) {
        this.clave = clave;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
   
   
}
