/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.servicio;

import com.sgml.ejb.persistencia.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Allen
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "Sgml-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario verificarUsuario(String nombre, String password) {
        Query query = em.createNamedQuery("Usuario.findByNombreAndPassword");
        query.setParameter("nombre", nombre);
        query.setParameter("password", password);

        try {
            Object result = query.getSingleResult();
            return (Usuario)result;
        } catch (Exception e) {
            return null;
        }
    }    
}
