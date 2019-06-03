/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author NEGRA
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -932093556089251203L;

    @Id
   // @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
