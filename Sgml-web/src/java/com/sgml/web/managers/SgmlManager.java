/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Allen
 */
@Named(value = "sgmlManager")
@ApplicationScoped
public class SgmlManager {

    private String usuario;
    private String password;
    private String mensaje;
    
    public SgmlManager() {
    }
    
    public boolean registrarAlumno(){
        return true;
    }
    
    public boolean registrarEgresado(){
        return true;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

}
