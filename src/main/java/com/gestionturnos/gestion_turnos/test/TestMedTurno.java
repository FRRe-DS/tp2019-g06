/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.test;

import com.google.protobuf.TextFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persistence.Medico;
import persistence.ObraSocial;
import persistence.Turno;
import persistence.Paciente;
import java.util.List;

/**
 *
 * @author flor
 */
public class TestMedTurno {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
    
    public static void main(String[] args) throws TextFormat.ParseException {
        //crearDatos();
        imprimirDatos();
    }
    
   /* static void crearDatos() throws TextFormat.ParseException{
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        ObraSocial obra1 = new ObraSocial(20,"Medife","Mendoza 140");
        ObraSocial obra2 = new ObraSocial(70,"Osde","Chubut 525");
        ObraSocial obra3 = new ObraSocial(90,"Ioscor","Junin 670");
        
        em.persist(obra1);
        em.persist(obra2);
        em.persist(obra3);
        
        Paciente paciente1 = new Paciente(56789,"Perez","Laura",50832560,"09-12-2010","F","Ayacucho 450",154239855,obra1);
        em.persist(paciente1);
               
        Medico medico1 = new Medico(1,"Roberto","Caceres",21679410,"M","Soltero","General Paz 90",89,"Traumatologo",obra1);
        Medico medico2 = new Medico(2,"Rita","Ora",21679410,"F","Soltero","Las Vegas 3500",89,"Cirujano",obra2);
        Medico medico3 = new Medico(3,"Carmen","Ponce",21679410,"F","Soltero","Bella Vista 150",89,"Pediatra",obra3);
        em.persist(medico1);
        em.persist(medico2);
        em.persist(medico3);
        
        Turno turno1 = new Turno(121,"10-07-2019","17:50","Consulta de pie plano",true,paciente1, medico1);
        em.persist(turno1);
     
        
        em.getTransaction().commit();
        
        em.close();
    }
    */
    static void imprimirDatos() {
        EntityManager em = emf.createEntityManager();
        
        Medico medico1 = em.find(Medico.class,1);
        List<Turno> turnos = medico1.getTurnos();
        for(Turno turno : turnos) {
            System.out.println("* " + turno.toString());
        }
        
        System.out.println(medico1);
        
        em.close();
    }
}
