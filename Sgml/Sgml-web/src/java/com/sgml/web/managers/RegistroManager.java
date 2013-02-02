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

    public String registrarAlumno() {
        if (registrarPersona()) {
            if (registrarUsuario()) {
                Universidad universidad = universidadFacade.find(1);
                Facultad facultad = facultadFacade.find(1);
                Escuela escuela = escuelaFacade.find(1);

                alumno.setUsuarioId(usuario);
                alumno.setUniversidadId(universidad);
                alumno.setFacultadId(facultad);
                alumno.setEscuelaId(escuela);

                try {
                    alumnoFacade.create(alumno);
                    mensaje = "Gracias por registrarte! Ahora ya puedes ingresar al SGML :)";
                } catch (Exception ex) {
                    mensaje = "Error al registrar Alumno o Egresado. Comuníque este error.";
                }
            }
        }
        return mensaje;
    }

    public boolean registrarPersona() {
        try {
            personaFacade.create(persona);
        } catch (Exception ex) {
            mensaje = "Error al registrar Persona Física. Comuníque este error.";
            return false;
        }
        return true;
    }

    public boolean registrarUsuario() {
        try {
            usuario.setPersonaId(persona);
            usuario.setTipo(1);
            usuarioFacade.create(usuario);
        } catch (Exception ex) {
            mensaje = "Error al registrar Usuario. Comuníque este error.";
            return false;
        }
        return true;
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
