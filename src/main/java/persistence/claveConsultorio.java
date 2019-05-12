/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author flor
 */
@Embeddable
public class claveConsultorio implements java.io.Serializable {
    @Column(name = "piso", nullable = false)
    private Integer piso;
    
    @Column(name = "numero", nullable = false)
    private Integer numero;
    
    public Integer getPiso(){
        return piso;
    }
    public void setPiso(Integer piso){
        this.piso = piso;
    }
    
    public Integer getNumero(){
        return numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }
}
