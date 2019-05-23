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
import persistence.ObraSocial;
import persistence.Paciente;

/**
 *
 * @author flor
 */
public class PacienteDAO {
    
    private static EntityManager entityManager;
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
    
    //INSERCION
    
    public static Paciente createPaciente(int idP, String apellido, String nomb,int dni,String fecha, String sexo, String direc, int tel, int idO) throws TextFormat.ParseException{
        
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Paciente nuevoPaciente = new Paciente(idP,apellido,nomb,dni,fecha,sexo,direc,tel,ObraSocialDAO.getById(idO));
        
        entityManager.merge(nuevoPaciente);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return nuevoPaciente;
    }
    
    //BUSQUEDA
       
    public static Paciente getById(int idP) {
        
        Paciente paciente = null;
    
        EntityManager entityManager = JPAUtil.getEntityManager();
        try{
          
            paciente = entityManager.find(Paciente.class, idP);    
          
        } catch(NullPointerException e ){
            
        }
        return (paciente);
    }
    
}

  
