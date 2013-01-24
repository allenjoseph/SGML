/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import com.sgml.ejb.persistencia.Usuario;
import com.sgml.ejb.servicio.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Allen
 */
@Named(value = "verificacionesManager")
@RequestScoped
public class VerificacionesManager implements Serializable{

    private String mensaje;
    private Usuario usuario;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    public VerificacionesManager() {
        usuario = new Usuario();
    }
        
    public void verificacionLogin(){
        System.out.println(usuario.toString());
        usuario = usuarioFacade.verificarUsuario(usuario);
        if(usuario == null){
            mensaje = "usuario o contraseña erronea";
        }
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
}
