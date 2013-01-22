/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import com.sgml.ejb.persistencia.Usuario;
import com.sgml.ejb.servicio.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Allen
 */
@Named(value = "usuarioManager")
@SessionScoped
public class UsuarioManager implements Serializable {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    public UsuarioManager() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
    public Usuario varificarUsuario(){
        usuario =  usuarioFacade.varificarUsuario(usuario);
        return usuario;
    }
}
