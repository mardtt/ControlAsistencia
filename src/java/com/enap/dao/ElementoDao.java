/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.dao;

import com.enap.modelo.Elemento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SOPORTE
 */
@Stateless
public class ElementoDao extends FabricaDao<Elemento> {

    @PersistenceContext(unitName = "ControlAsistenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElementoDao() {
        super(Elemento.class);
    }
    
}
