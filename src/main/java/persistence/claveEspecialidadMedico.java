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
public class claveEspecialidadMedico implements java.io.Serializable {
    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;
    
    @Column(name = "id_medico", nullable = false)
    private Integer idMedico;
    
    public Integer getIdEspecialidad(){
        return idEspecialidad;
    }
    public void setIdEpecialidad(Integer idEspecialidad){
        this.idEspecialidad = idEspecialidad;
    }
    
    public Integer getIdMedico(){
        return idMedico;
    }
    public void setIdMedico(Integer idMedico){
        this.idMedico = idMedico;
    } 
}
