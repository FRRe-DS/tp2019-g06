/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionturnos.gestion_turnos.DAO;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NEGRA
 * @param <T>
 * @param <ID>
 */
public class GenericService<T, ID extends Serializable> {
    @Autowired
    private GenericDao<T, ID> genericDao;

    /**
     *
     * @param id
     * @return
     */
    public T find(long id) {
        return this.getGenericDao().findById(id);
    }

    public List<T> all() {
        return this.getGenericDao().findAll();
    }

    @Transactional
    public T create(T newInstance) {
        return (T) this.getGenericDao().save(newInstance);
    }

    @Transactional
    public T updpate(T updateInstance) {
        return (T) this.getGenericDao().update(updateInstance);
    }

    @Transactional
    public void delete(T entity) {
         this.getGenericDao().delete(entity);
    }

    public GenericDao<T, ID> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<T, ID> genericDao) {
        this.genericDao = genericDao;
    }


}