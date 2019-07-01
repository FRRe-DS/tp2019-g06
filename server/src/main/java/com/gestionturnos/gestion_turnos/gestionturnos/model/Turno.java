package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
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

import org.springframework.expression.ParseException;

import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;

/**
 * 
 * @author flor
 *
 */
@Entity
public class Turno implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 9066465383169529803L;

    @Id
    @Column(name = "idTurno")
    private Integer idTurno;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private java.util.Date fecha;

    @NotNull
    @Column(name = "hora", nullable = false)
    private java.sql.Time hora;

    @NotNull
    @Column(name = "motivo_consulta")
    private String motivoConsulta;

    @NotNull
    @Column(name = "obra_social")
    private Boolean obraSocial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente", nullable = false)
    private Paciente paciente;

    // Relacion medico-obra social
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({ @JoinColumn(referencedColumnName = "idMedico"), @JoinColumn(referencedColumnName = "idObraSocial") })
    private MedicoObraSocial medicoObraSocial;

    /*
     * 
     * // Relacion paciente-obra social
     * 
     * @ManyToOne(fetch = FetchType.EAGER)
     * 
     * @JoinColumn( name = "PacienteObraSocial", referencedColumnName =
     * "ClavePacienteObraSocial", nullable = false) private PacienteObraSocial
     * pacienteObraSocial;
     */
    public Turno() {
    }

    public Turno(int idT, String fech, String hora1, String motConsulta, Boolean obraSoc, MedicoObraSocial medicoObra,
            Paciente pacienteObra) throws ParseException {

        idTurno = idT;
        try {
            this.setFecha(fech);

        } catch (java.text.ParseException e) {
            System.out.println(e);
        }
        try {
            this.setHora(hora1);

        } catch (java.text.ParseException e1) {
            System.out.println(e1);
        }
        motivoConsulta = motConsulta;
        obraSocial = obraSoc;/*
                              * medicoObraSocial = medicoObra;;
                              */
        paciente = pacienteObra;

    }

    public void setFecha(String fecha) throws ParseException, java.text.ParseException {

        java.util.Date sqldate;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date imputDate = dateFormat.parse(fecha);
        sqldate = new java.util.Date(imputDate.getTime());
        this.fecha = sqldate;
    }

    public void setHora(String hora) throws ParseException, java.text.ParseException {
        java.sql.Time sqltime;
        DateFormat timeFormat = new SimpleDateFormat("hh:mm");
        Date imputTime = timeFormat.parse(hora);
        sqltime = new java.sql.Time(imputTime.getTime());
        this.hora = sqltime;
    }
    // Getters and Setters

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
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

    public Boolean getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(Boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    /*
     * public MedicoObraSocial getMedicoObraSocial() { return medicoObraSocial; }
     * 
     * public void setMedicoObraSocial(MedicoObraSocial medicoObraSocial) {
     * this.medicoObraSocial = medicoObraSocial; }
     * 
     * public PacienteObraSocial getPacienteObraSocial() { return
     * pacienteObraSocial; }
     * 
     * public void setPacienteObraSocial(PacienteObraSocial pacienteObraSocial) {
     * this.pacienteObraSocial = pacienteObraSocial; }
     * 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTurno == null) ? 0 : idTurno.hashCode());
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
        final Turno other = (Turno) obj;
        if (idTurno == null) {
            if (other.idTurno != null)
                return false;
        } else if (!idTurno.equals(other.idTurno))
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "Turno [id = " + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", motivoConsulta= " + motivoConsulta
                + ", obraSocial= " + obraSocial + "]";
    }

}