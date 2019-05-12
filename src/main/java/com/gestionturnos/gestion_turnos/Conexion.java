/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author flor
 */
public class Conexion {
 
  private static String servidor="jdbc:mysql://localhost:3306/hospital";
  private static String user="root";
  private static String pass="flor21";
  private static String driver="com.mysql.jdbc.Driver";
  private static Connection conexion;
  
  public Conexion(){
      //Cargar el Driver
      try{
          Class.forName("com.mysql.jdbc.Driver");
          
          conexion = DriverManager.getConnection(servidor, user, pass);
          System.out.println("Ok, Conexion a la BBDD");
                   
      } catch (ClassNotFoundException | SQLException e){
          
          System.out.println("Conexion fallida");
      }
  }
  
  public Connection getConnection(){
      return conexion;      
  }
    
}
