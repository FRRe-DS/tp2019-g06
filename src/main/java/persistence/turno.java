/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 *
 * @author flor
 */
@Entity
public class turno implements java.io.Serializable {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_paciente",
            nullable = false)
    private paciente paciente;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "piso",
            nullable = false)
    private consultorio consultorio;
    
    //Getters and Setters
    public Integer getIdTurno(){
        return idTurno;
    }
    public void setIdTurno(Integer idTurno){
        this.idTurno = idTurno;
    }
    
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public java.sql.Time getHora(){
        return hora;
    }
    public void setHora(java.sql.Time hora){
        this.hora = hora;
    }
    
    public String getMotivoConsulta(){
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta = motivoConsulta;
    }
}
