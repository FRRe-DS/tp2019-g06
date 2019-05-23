/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import com.gestionturnos.gestion_turnos.util.JPAUtil;
import persistence.ObraSocial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flor
 */
public class ObraSocialDAO {
    
    private static EntityManager entityManager;
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
    
    //INSERCION
    
    public static ObraSocial getNewObra(int idO, String nomb, String direc){
        
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        ObraSocial nuevaObraSoc = new ObraSocial(idO,nomb,direc);
        
        entityManager.persist(nuevaObraSoc);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return nuevaObraSoc;
    }
    
    //BUSQUEDA
       
    public static ObraSocial getById(int idO) {
        ObraSocial obra = null;

        EntityManager entityManager = JPAUtil.getEntityManager();
        try{
        
            obra = entityManager.find(ObraSocial.class, idO);  
            
        }catch(NullPointerException e){
            
        }
    return (obra);
         
    }
    
}

 
  
       
   

