/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import com.gestionturnos.gestion_turnos.util.JPAUtil;
import com.google.protobuf.TextFormat;
import java.text.ParseException;
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
    public static Turno createTurno(int idT, String fecha, String hora, String motivoConsul, Boolean estadoObraSoc, int idP, int idM) throws TextFormat.ParseException {

        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Turno nuevoTurno = new Turno(idT, fecha, hora, motivoConsul, estadoObraSoc, PacienteDAO.getById(idP), MedicoDAO.getById(idM));

        entityManager.merge(nuevoTurno);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevoTurno;
    }

    //BUSQUEDA
    public static Turno getById(int idT) {

        Turno turno = null;
        EntityManager entityManager = JPAUtil.getEntityManager();

        try {

            turno = entityManager.find(Turno.class, idT);

        } catch (NullPointerException e) {
            System.out.println("error:" + e);
        }
        return turno;

    }

    public static void update(Turno turno, String fecha, String hora, String motivo) throws TextFormat.ParseException, ParseException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            
        turno.setFecha(fecha);
        turno.setHora(hora);
        turno.setMotivoConsulta(motivo);

        entityManager.getTransaction().begin();
        entityManager.merge(turno);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Turno actualizado correctamente..");
        System.out.println("");}
        catch(Exception e){
            System.out.println("Error: "+e);
            System.out.println("No se pudo actualizar el turno");}
        
    }
    
    public static void delete(Turno turno){
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Turno turnoel = entityManager.merge(turno);
            entityManager.remove(turnoel);
            entityManager.getTransaction().commit();
            System.out.println("Turno eliminado exitosamente");
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
            System.out.println("ERROR: Por alguna razon no se ha podido eliminar el turno");
        }
    }

}
