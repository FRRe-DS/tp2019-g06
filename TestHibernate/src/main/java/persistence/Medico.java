/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author NEGRA
 */

@Entity
@Table(name="Medico")
public class Medico implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="nombre")
    @Size(min= 1, max=30)
    private String nombre;
    
    @Column(name="apellido")
    @Size(min= 1, max=30)
    private String apellido;
    
    @Column(name="matricula")
    private int matricula;

    public Medico(int id, String nombre, String apellido, int matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Medico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}
