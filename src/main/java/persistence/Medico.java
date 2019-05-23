/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @Column(name = "idMedico")
    private Integer idMedico;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "apellido", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String apellido;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Column(name = "dni", nullable = false)
    private Integer dni;
    
    @NotNull
    @Column(name = "sexo", nullable = false)
    //@Enumerated(EnumType.STRING)
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
    
    @NotNull
    @Column(name = "especialidad", nullable = false)
    private String especialidad;
        
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
        name = "ObraSocial_idObraSocial", referencedColumnName = "idObraSocial",
            nullable = false)
    private ObraSocial obraSocial;
            
    @OneToMany(mappedBy = "Medico", 
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Turno> turnos;
    public List getTurnos(){ 
        return turnos;
    }
    
    public Medico(){
        
    }
    
    public Medico (int idM, String ap, String nomb, int ingdni, String ingsexo, String estCivil, String direc, int matric, String espec, ObraSocial obra) {
        idMedico = idM;
        apellido = ap;
        nombre = nomb;
        dni = ingdni;
        sexo = ingsexo;
        estadoCivil = estCivil;
        direccion = direc;
        matricula = matric;
        especialidad = espec;
        obraSocial = obra;
        
    }
      
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMedico == null) ? 0 : idMedico.hashCode());
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
		final Medico other = (Medico) obj;
		if (idMedico == null) {
			if (other.idMedico != null)
				return false;
		} else if (!idMedico.equals(other.idMedico))
			return false;
		return true;
     
    }
    
    @Override
    public String toString() {
        return "Medico [id = " + idMedico + ", nombre=" + nombre + ", apellido=" + apellido +", dni= " + dni +", sexo= " + sexo +", estadoCivil= " + estadoCivil +", direccion= " + direccion +", matricula= " + matricula +", especialidad= " + especialidad +"]";
    }
      
}
