/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import com.sgml.ejb.persistencia.Alumno;
import com.sgml.ejb.servicio.AlumnoFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Allen
 */
@Named(value = "alumnoManager")
@SessionScoped
public class AlumnoManager implements Serializable {

    private Alumno alumno;
    @EJB
    private AlumnoFacadeLocal alumnoFacade;

    public AlumnoManager() {
        alumno = new Alumno();
    }

    public boolean RegistrarUsuario() {        
        alumnoFacade.create(alumno);
        System.out.print("Se registro Usuario");
        return true;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
