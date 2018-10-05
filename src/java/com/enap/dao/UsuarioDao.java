/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.dao;

import com.enap.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SOPORTE
 */
@Stateless
public class UsuarioDao extends FabricaDao<Usuario> {

    @PersistenceContext(unitName = "ControlAsistenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDao() {
        super(Usuario.class);
    }
    
    // Método que llama a la query en la entidad Usuario
    public Usuario buscarPorUsuarioPass(String u, String p) {
        Usuario usuario = new Usuario();
        
        try {
        Query consulta = em.createNamedQuery("Usuario.usuarioAndContrasena").setParameter(1, u).setParameter(2, p);
        usuario =  (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            
        }
        return usuario;
    }
    
}
