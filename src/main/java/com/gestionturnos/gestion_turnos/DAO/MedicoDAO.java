/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import javax.persistence.EntityManager;
import com.gestionturnos.gestion_turnos.util.JPAUtil;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.Medico;

/**
 *
 * @author flor
 */
public class MedicoDAO {
    
    private static EntityManager entityManager;
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
    
    //INSERCION
    
    public static Medico createMedico(int idM, String apellido, String nombre, int dni, String sexo, String estadoCivil, String direc, int matricula, String especialidad, int idO ){
        
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Medico nuevoMedico = new Medico(idM, apellido, nombre, dni, sexo, estadoCivil, direc, matricula, especialidad, ObraSocialDAO.getById(idO));
        
        entityManager.merge(nuevoMedico);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return nuevoMedico;
    }
        
    //BUSQUEDA
    
    public static Medico getById(int idM){
        
        Medico medico = null;
        EntityManager entityManager = JPAUtil.getEntityManager();
        
        try{
            
            medico = entityManager.find(Medico.class, idM);
            
        }catch(NullPointerException e){
            
        }
        return medico;
    }
    
}
