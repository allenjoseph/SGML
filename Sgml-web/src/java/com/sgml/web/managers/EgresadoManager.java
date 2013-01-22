/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Allen
 */
@Named(value = "egresadoManager")
@SessionScoped
public class EgresadoManager implements Serializable {

    public EgresadoManager() {
    }
}
