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
import persistence.Turno;

/**
 *
 * @author NEGRA
 */
public class TestDelete {
     public static void main(String[] args) throws TextFormat.ParseException, ParseException {
        try{
           Scanner scanner = new Scanner(System.in);
           System.out.println("Ingrese el id del turno a eliminar: ");
           int id=scanner.nextInt();
           Turno turno = TurnoDAO.getById(id);
           if (turno!=null){
               
               
               //System.out.println("Esta seguro que quiere elminarlo???(SI: S/ NO:N)");
               
               //if (scanner.nextLine()=="s"){
                   TurnoDAO.delete(turno);
               //}else{System.out.println("Eliminacion Cancelada");}      
           }
           System.out.println("Done");
           
       }catch(NullPointerException e){
           System.out.println(e);
           System.out.println("EL TURNO NO ESTA REGISTRADO");
           
       }
       JPAUtil.close();
    
    }
}
