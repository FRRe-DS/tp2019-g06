/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import com.gestionturnos.gestion_turnos.util.JPAUtil;
import com.google.protobuf.TextFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.Turno;

/**
 *
 * @author flor
 */
public class TurnoDAO {
    
    private static EntityManager entityManager;
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
    
    //INSERCION
    
    public static Turno createTurno(int idT, String fecha, String hora, String motivoConsul, Boolean estadoObraSoc, int idP, int idM ) throws TextFormat.ParseException{
        
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Turno nuevoTurno = new Turno(idT, fecha, hora, motivoConsul, estadoObraSoc, PacienteDAO.getById(idP), MedicoDAO.getById(idM));
        
        entityManager.merge(nuevoTurno);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return nuevoTurno;
    }
    
    //BUSQUEDA
    
    public static Turno getById(int idT){
        
        Turno turno = null;
        EntityManager entityManager = JPAUtil.getEntityManager();
        
        try{
            
            turno = entityManager.find(Turno.class, idT);
            
        }catch(NullPointerException e){
            
        }
        return turno;
        
    }
    
}
