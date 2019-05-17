/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author flor
 */
@Embeddable
public class ClaveEspecialidadMedico implements java.io.Serializable {
    @Column(name = "idEspecialidad", nullable = false)
    private Integer idEspecialidad;
    
    @Column(name = "idMedico", nullable = false)
    private Integer idMedico;

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
        
}
