/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NEGRA
 */
public interface GenericDao<T, ID extends Serializable>{
//T hace referencia a la clase, ID hace referencia al id del objeto
	T save(T entity);  	     // save seria como insertar
	T update(T entity);		// modificar
	void delete(T entity); // eliminacion
	T findById(ID id);    // busqueda por ID
	List<T> findAll();   // lista de todos los elementos
	void flush();		/**descarga la secuencia. Si la secuencia 
	ha guardado algunos caracteres de los distintos métodos de escritura () en un búfer,
	escríbalos inmediatamente a su destino deseado.*/
}
