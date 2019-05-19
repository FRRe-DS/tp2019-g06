/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 *
 * @author flor
 */
@Entity
public class Turno implements java.io.Serializable {
    @Id
    private Integer idTurno;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @NotNull
    @Column(name = "hora", nullable = false)
    private java.sql.Time hora;
    
    @NotNull
    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    
    @NotNull
    @Column(name ="obra_social")
    private Boolean obraSocial;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "Paciente_idPaciente", referencedColumnName = "idPaciente", nullable = false)
    private Paciente paciente;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn( name = "Consultorio_piso", referencedColumnName = "piso",nullable = false),
        @JoinColumn( name = "Consultorio_numero", referencedColumnName = "numero", nullable = false )})
    private Consultorio consultorio;
         
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "Medico_idMedico", referencedColumnName = "idMedico", nullable = false)
    private Medico medico;
    
    //Getters and Setters

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Boolean getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(Boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

      
   
}
