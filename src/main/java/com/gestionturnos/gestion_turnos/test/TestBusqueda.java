/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.test;


import com.gestionturnos.gestion_turnos.DAO.MedicoDAO;
import com.gestionturnos.gestion_turnos.DAO.ObraSocialDAO;
import com.gestionturnos.gestion_turnos.util.JPAUtil;
import persistence.ObraSocial;
import persistence.Paciente;
import com.gestionturnos.gestion_turnos.DAO.PacienteDAO;
import com.gestionturnos.gestion_turnos.DAO.TurnoDAO;
import org.hibernate.HibernateException;
import persistence.Medico;
import persistence.Turno;

/**
 *
 * @author flor
 */
public class TestBusqueda {
    
    public static void main(String[] args) {
       /* 
      
        //OBRA SOCIAL
        try{
            ObraSocial obra = ObraSocialDAO.getById(90);
            System.out.println("Nombre:"+ obra.getNombre()+", Direccion:"+ obra.getDireccion());
            System.out.println("Done");
        
        } catch(NullPointerException e){
            System.out.println(e);
            System.out.println("LA OBRA SOCIAL NO SE ENCUENTRA EN LA BASE DE DATOS");
        }    
	JPAUtil.close();
    }
}
        
        //PACIENTE
        try{
            Paciente paciente = PacienteDAO.getById(5678);
            System.out.println("Apellido:"+ paciente.getApellido()+", Nommbre:"+ paciente.getNombre());	
            System.out.println("Done");
        
        } catch(NullPointerException e ){
            System.out.println(e);
            System.out.println("EL PACIENTE NO SE ENCUENTRA EN LA BASE DE DATOS");
            
        }
        JPAUtil.close();
    }
    
}
        //MEDICO

       try{
           Medico medico = MedicoDAO.getById(1);
           System.out.println("Apellido:"+ medico.getApellido()+", Nombre:"+ medico.getNombre());
           System.out.println("Done");
           
       }catch(NullPointerException e){
           System.out.println(e);
           System.out.println("EL MEDICO NO SE ENCUENTRA EN LA BASE DE DATOS");
           
       }
       JPAUtil.close();
    }
}
*/      //TURNO
        try{
           Turno turno = TurnoDAO.getById(1);
           System.out.println("Apellido:"+ turno.getPaciente().getApellido()+", Nombre:"+ turno.getFecha());
           System.out.println("Done");
           
       }catch(NullPointerException e){
           System.out.println(e);
           System.out.println("EL TURNO NO ESTA REGISTRADO");
           
       }
       JPAUtil.close();
    }
}