/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.test;

import com.gestionturnos.gestion_turnos.DAO.MedicoDAO;
import com.gestionturnos.gestion_turnos.DAO.ObraSocialDAO;
import com.gestionturnos.gestion_turnos.DAO.PacienteDAO;
import com.gestionturnos.gestion_turnos.DAO.TurnoDAO;
import com.google.protobuf.TextFormat;
import javax.persistence.EntityManager;
import persistence.Medico;
import persistence.ObraSocial;
import persistence.Paciente;
import persistence.Turno;

/**
 *
 * @author flor
 */
public class TestInsertar {
    
    public static void main(String[] args) throws TextFormat.ParseException {
        /*
        //OBRA SOCIAL
        ObraSocial obraSoc = ObraSocialDAO.getNewObra(15,"Medife","Belgrano 78");
        System.out.println(obraSoc);
        
        
        //PACIENTE
        Paciente paciente = PacienteDAO.createPaciente(9, "Rios", "Macarena", 52817624, "12-08-2002", "F", "Mendoza 1520", 154293647, 15);
        System.out.println(paciente);
        
        //Medico
        Medico medico = MedicoDAO.createMedico(78,"Quito","Esteban",39108888,"M","Casado","España 1047",50,"Pediatria",90);
        System.out.println(medico);
         */
        //TURNO
        Turno turno = TurnoDAO.createTurno(15,"15-08-2019","10:00","Dolor de cabeza",false,56789,3);
        System.out.println(turno);
    }
         
}
