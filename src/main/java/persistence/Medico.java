/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author flor
 */

@Entity
public class Medico implements java.io.Serializable {
    
    @Id
    private Integer idMedico;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "apellido", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String apellido;
    
    @NotNull
    @Column(name = "dni", nullable = false)
    private Integer dni;
    
    @NotNull
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
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
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idObraSocial",
            nullable = false)
    private ObraSocial obraSocial;
  
    //Getters and Setters

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
    
}
