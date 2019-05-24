/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.test;

import com.gestionturnos.gestion_turnos.DAO.TurnoDAO;
import com.gestionturnos.gestion_turnos.util.JPAUtil;
import com.google.protobuf.TextFormat;
import java.text.ParseException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.Turno;

/**
 *
 * @author NEGRA
 */
public class TestUpdate {

    public static void main(String[] args) throws TextFormat.ParseException, ParseException {
        try{
           Turno turno = TurnoDAO.getById(1);
           Scanner scanner = new Scanner(System.in);
    
        
        
           if (turno!=null){
               System.out.println(turno);
               System.out.println("Ingrese la NUEVA fecha: dd-mm-yyyy");
               String fecha=scanner.nextLine();
              
               System.out.println("Ingrese la NUEVA hora HH:MM");
               String hora=scanner.nextLine();
           
               System.out.println("Ingrese el MOTIVO DE CONSULTA");
               String motivo=scanner.nextLine();
               
               TurnoDAO.update(turno, fecha, hora, motivo);
               
           }
           System.out.println("Done");
           
       }catch(NullPointerException e){
           System.out.println(e);
           System.out.println("EL TURNO NO ESTA REGISTRADO");
           
       }
       JPAUtil.close();
    
    }
}
