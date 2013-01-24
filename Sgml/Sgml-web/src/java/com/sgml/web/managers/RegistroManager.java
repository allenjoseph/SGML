/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.web.managers;

import com.sgml.ejb.persistencia.Alumno;
import com.sgml.ejb.persistencia.Escuela;
import com.sgml.ejb.persistencia.Facultad;
import com.sgml.ejb.persistencia.Persona;
import com.sgml.ejb.persistencia.Universidad;
import com.sgml.ejb.persistencia.Usuario;
import com.sgml.ejb.servicio.AlumnoFacadeLocal;
import com.sgml.ejb.servicio.EscuelaFacadeLocal;
import com.sgml.ejb.servicio.FacultadFacadeLocal;
import com.sgml.ejb.servicio.PersonaFacadeLocal;
import com.sgml.ejb.servicio.UniversidadFacadeLocal;
import com.sgml.ejb.servicio.UsuarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author allen
 */
@Named(value = "registroManager")
@RequestScoped
public class RegistroManager {

    private Persona persona;
    private Usuario usuario;
    private Alumno alumno;
    private String mensaje;
    @EJB
    private PersonaFacadeLocal personaFacade;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private AlumnoFacadeLocal alumnoFacade;
    @EJB
    private UniversidadFacadeLocal universidadFacade;
    @EJB
    private FacultadFacadeLocal facultadFacade;
    @EJB
    private EscuelaFacadeLocal escuelaFacade;

    public RegistroManager() {
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
        usuario = new Usuario();
        alumno = new Alumno();
    }

    public void registrarAlumno() {
        registrarPersona();
        registrarUsuario();

        alumno.setUsuarioId(usuario);
        
        Universidad universidad = universidadFacade.find(1);
        alumno.setUniversidadId(universidad);
        Facultad facultad = facultadFacade.find(1);
        alumno.setFacultadId(facultad);
        Escuela escuela = escuelaFacade.find(1);
        alumno.setEscuelaId(escuela);
        
        System.out.println(alumno.getUniversidadId());
        System.out.println(alumno.getFacultadId());
        System.out.println(alumno.getEscuelaId());
        System.out.println(alumno.getUsuarioId());
        try {
            alumnoFacade.create(alumno);
             mensaje = "Gracias por registrarte! Ahora ya puedes ingresar al SGML :)";             
        } catch (Throwable ex) {
            mensaje = "Error: " + ex;
        }
        System.out.println(mensaje);
    }

    public String registrarPersona() {
        try {
            personaFacade.create(persona);
            mensaje = null;
        } catch (Throwable ex) {
            mensaje = "Error: " + ex;
        }
        return mensaje;
    }

    public String registrarUsuario() {
        try {
            usuario.setPersonaId(persona); 
            usuarioFacade.create(usuario);
            mensaje = null;
        } catch (Throwable ex) {
            mensaje = "Error: " + ex;
        }
        return mensaje;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
