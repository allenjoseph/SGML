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
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author allen
 */
@Named(value = "registroManager")
@RequestScoped
public class RegistroManager implements Serializable{

    private Persona persona;
    private Usuario usuario;
    private Alumno alumno;
    private String mensaje;
    private String prueba;
    
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

    /**
     * Creates a new instance of RegistroManager
     */
    public RegistroManager() {
        persona = new Persona();
        alumno = new Alumno();
        usuario = new Usuario();
    }

    public void registrarAlumno() {
        if (registrarPersona().isEmpty()) {
            if (registrarUsuario().isEmpty()) {
                Universidad universidad = universidadFacade.find(1);
                alumno.setUniversidadId(universidad);
                Facultad facultad = facultadFacade.find(1);
                alumno.setFacultadId(facultad);
                Escuela escuela = escuelaFacade.find(1);
                alumno.setEscuelaId(escuela);
                alumno.setUsuarioId(usuario);
                try {
                    alumnoFacade.create(alumno);
                     mensaje = "Gracias por registrarte! Ahora ya puedes ingresar al SGML :)";
                } catch (Throwable ex) {
                    mensaje = "Error: " + ex;
                }               
            }
        }
    }

    public String registrarPersona() {
        try {
            System.out.println(persona.getNombres());
            System.out.println(persona.getApellidos());
            System.out.println(persona.getEmail());
            System.out.println(prueba);
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
    
    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
}
