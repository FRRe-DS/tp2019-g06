/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author flor
 */
@Entity
public class especialidad implements java.io.Serializable {
    @Id
    private Integer idEspecialidad;
    
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @NotNull
    @Column(name = "descripcon", nullable = false)
    private String descripcion;
   
    
    //Getters and Setters
    public Integer getIdEspecialidad(){
        return idEspecialidad;
    }
    public void setIdEspecialidad(Integer idEspecialidad){
        this.idEspecialidad = idEspecialidad;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
