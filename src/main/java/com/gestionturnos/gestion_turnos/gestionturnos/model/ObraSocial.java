package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 * 
 * @author flor
 *
 */
@Entity
public class ObraSocial implements java.io.Serializable{
   
    @Id
    @GeneratedValue
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
    
    
    
    @OneToMany(mappedBy = "obraSocial",
    cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Paciente> paciente;
    
    @OneToMany(mappedBy = "obraSocial", 
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Medico> medicos;

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

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    
    
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