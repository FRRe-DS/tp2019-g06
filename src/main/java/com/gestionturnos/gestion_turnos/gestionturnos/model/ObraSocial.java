package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author flor
 *
 */
@Entity
public class ObraSocial implements java.io.Serializable{
   /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idObraSocial")
    private Integer idObraSocial;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name = "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @JsonIgnore 
    @OneToMany(mappedBy = "obraSocial",
    cascade = CascadeType.ALL,
            orphanRemoval = true)           
    private List<Paciente> paciente;
    /*
    @JsonIgnore 
    @OneToMany(mappedBy = "obraSocial", 
            cascade = CascadeType.ALL)    
    private List<MedicoObraSocial> medicoObraSociales; 
   */
    public ObraSocial(int idS, String nomb, String direc) {

        idObraSocial = idS;
        nombre = nomb;
        direccion = direc;       
    }
    
    public ObraSocial(){        
    }
    
    //Getters and Setters

    public Integer getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(Integer idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
/*
    public List<PacienteObraSocial> getPacienteObraSocial() {
        return pacientesObraSocial;
    }

    public void setPacienteObraSocial(List<PacienteObraSocial> pacientesObraSocial) {
        this.pacientesObraSocial = pacientesObraSocial;
    }

    public List<MedicoObraSocial> getMedicoObraSocial() {
        return medicoObraSociales;
    }

    public void setMedicoObraSocial(List<MedicoObraSocial> medicoObraSociales) {
        this.medicoObraSociales = medicoObraSociales;
    }

    */
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idObraSocial == null) ? 0 : idObraSocial.hashCode());
        return result;
    }    
   
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ObraSocial other = (ObraSocial) obj;
		if (idObraSocial == null) {
			if (other.idObraSocial != null)
				return false;
		} else if (!idObraSocial.equals(other.idObraSocial))
			return false;
		return true;
     
    }
    
    @Override
    public String toString() {
        return "ObraSocial [id = " + idObraSocial + ", nombre=" + nombre + ", direccion= " + direccion +"]";
    }
        
        
}