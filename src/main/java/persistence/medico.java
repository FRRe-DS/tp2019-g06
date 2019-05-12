/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author flor
 */
@Entity
public class medico implements java.io.Serializable {
    @Id
    private Integer idMedico;
    
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @NotNull
    @Column(name = "apellido", nullable = false)
    private String apellido;
    
    @NotNull
    @Column(name = "dni", nullable = false)
    private Integer dni;
    
    @NotNull
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    @Past(message = "F 'Sexo Femenino', M 'Sexo Masculino'")
    private String sexo;
    
    @NotNull
    @Column(name = "estado_civil", nullable = false)
    private String estadoCivil;
    
    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @NotNull
    @Column(name = "matricula", nullable = false)
    private Integer matricula;
    
  
    //Getters and Setters
    public Integer getIdMedico(){
        return idMedico;
    }
    public void setIdMedico(Integer idMedico){
        this.idMedico = idMedico;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public Integer getDni(){
        return dni;
    }
    public void setDni(Integer dni){
        this.dni = dni;
    }
    
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getEstadoCivil(){
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public Integer getMatricula(){
        return matricula;
    }
    public void setMatricula(Integer matricula){
        this.matricula = matricula;
    }
    
}
