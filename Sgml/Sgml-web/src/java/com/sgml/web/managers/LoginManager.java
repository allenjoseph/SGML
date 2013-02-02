/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import com.sgml.ejb.persistencia.Usuario;
import com.sgml.ejb.servicio.UsuarioFacade;
import com.sgml.ejb.servicio.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletException;
import javax.inject.Named;

/**
 *
 * @author Allen
 */
@Named(value = "loginManager")
@RequestScoped
public class LoginManager implements Serializable {

    private String nombre;
    private String password;
    private String mensaje;
    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    public LoginManager() {
        usuario = new Usuario();
    }

    public void verificarLogin() {
        String user = getNombre();
        String pass = getPassword();

        if (user != null && pass != null) {
            setUsuario(usuarioFacade.verificarUsuario(user, pass));
            if (usuario == null) {
                mensaje = "Usuario o Contraseña erroneo.";
            } else {
                try {
                    if (getUsuario().getTipo() == 1) {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Alumno.xhtml");
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Empresa.xhtml");
                    }
                } catch (IOException ex) {
                    throw new FaceletException(ex);
                }
            }
        } else {
            mensaje = "Usuario y Contraseña son obligatorios.";
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
