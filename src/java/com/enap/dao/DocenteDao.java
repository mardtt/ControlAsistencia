/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.dao;

import com.enap.modelo.Docente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SOPORTE
 */
@Stateless
public class DocenteDao extends FabricaDao<Docente> {

    @PersistenceContext(unitName = "ControlAsistenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteDao() {
        super(Docente.class);
    }
    
}
