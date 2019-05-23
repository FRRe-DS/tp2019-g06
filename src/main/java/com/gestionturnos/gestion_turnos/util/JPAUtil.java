/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.util;

/**
 *
 * @author flor
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static final EntityManagerFactory emFactory;
    
	static {
            
            emFactory = Persistence.createEntityManagerFactory("JPA_Gestion_Turnos");
	}
        
	public static EntityManager getEntityManager(){
            
            return emFactory.createEntityManager();
	}
	public static void close(){
            
            emFactory.close();
	}
    
}
