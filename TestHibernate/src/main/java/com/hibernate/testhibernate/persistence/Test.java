/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.testhibernate.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.Medico;

/**
 *
 * @author NEGRA
 */
public class Test {
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        /* Crear el gestor de persistencia (EM).*/
        emf = Persistence.createEntityManagerFactory("persistenceHibernate");
        manager = emf.createEntityManager();
        
        List <Medico> medicos = (List<Medico>)manager.createQuery("FROM Medico").getResultList();
        System.out.println(medicos);
        System.out.println("En esta base de datos hay "+ medicos.size()+" medicos.");
    
    }
}
