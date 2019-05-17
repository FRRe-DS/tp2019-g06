/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author flor
 */
public class Conexion {
 
  private static String servidor="jdbc:mysql://localhost:3306/turnos";
  private static String user="root";
  private static String pass="flor21";
  private static String driver="com.mysql.cj.jdbc.Driver";
  private static Connection conexion;
  
  public void conexion(){
      //Cargar el Driver
      Connection con = null;
      Statement stm = null;
      ResultSet rs = null;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          con = DriverManager.getConnection(servidor, user, pass);
          System.out.println("Ok, Conexion a la BBDD");
		  stm = con.createStatement();
		  System.out.println("Paso 4: OK, tengo el Statement");
		
		  // Paso 5 Ejecutar un query
		  String query = "SELECT * FROM Medico";
		  						
		  rs = stm.executeQuery(query);  
		  System.out.println("Paso 5: OK, ejecuté el query: " + query);
		
		  // Paso 6, procesar los resultados
		  System.out.println("Paso 6: Medico");
		  System.out.println("|id\t|Nombre");
		  System.out.println("----------------");
		  int resultadosCount = 0;
		  while(rs.next()){
              resultadosCount++;

		      int id = rs.getInt("idMedico");
		      String nombre = rs.getString(2);
		      System.out.println(
		      	String.format("|%d\t|%s", id, nombre));
		  }
		  System.out.println("----------------");
		
		  System.out.println(String.format("Paso 6: OK, procesé %d resultados.", resultadosCount));
                   
      } catch (ClassNotFoundException | SQLException e){
          
          System.out.println("Conexion fallida");
      }
  }
  
  public Connection getConnection(){
      return conexion;      
  }

  public static void main(String[] args) {
      Conexion conection = new Conexion();
      conection.conexion();
      
  }

}

