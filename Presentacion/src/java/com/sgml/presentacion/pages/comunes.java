/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.presentacion.pages;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Allen
 */
@ManagedBean
@ApplicationScoped
public class comunes {

    /**
     * Creates a new instance of comunes
     */
    public comunes() {
    }
    
    public void navegar(String page){
        try {        
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/"+page);
        } catch (IOException ex) {
            Logger.getLogger(comunes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
