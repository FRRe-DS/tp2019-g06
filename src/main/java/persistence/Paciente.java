/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



/**
 *
 * @author flor
 */

@Entity
public class Paciente implements java.io.Serializable{ 
    @Id
    private Integer idPaciente;
   
    @NotNull
    @Size(min= 1, max=45)
    @Column(name = "apellido", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String apellido;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Min(1)
    @Column(name= "dni", nullable = false)
    private Integer dni;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimiento debe ser menor a la fecha actual!")
    @Column(name= "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @NotNull
    @Column(name= "sexo", nullable = false)
    //@Enumerated(EnumType.STRING)
    private String sexo;
    
    @NotNull
    @Min(1)
    @Column(name= "direccion", nullable = false)
    private String direccion;
    
    @NotNull
    @Min(1)
    @Column(name= "telefono", nullable = false)
    private Integer telefono;
    
     
    
    @OneToMany(mappedBy = "Paciente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Turno> turnos;
    public Set getTurnos(){ 
        return turnos;
    }
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "ObraSocial_idObraSocial", referencedColumnName = "idObraSocial",
            nullable = false)
    private ObraSocial obraSocial;
    
    //Getters and Setters

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    
      
}

