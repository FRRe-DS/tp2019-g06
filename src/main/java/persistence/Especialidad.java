/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author flor
 */
@Entity
public class Especialidad implements java.io.Serializable {
    @Id
    private Integer idEspecialidad;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Size(min= 8, max=80)
    @Column(name= "descripcion", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String descripcion;
   
    
    //Getters and Setters

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
