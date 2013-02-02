/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "tb_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findById", query = "SELECT a FROM Alumno a WHERE a.id = :id"),
    @NamedQuery(name = "Alumno.findByCodigo", query = "SELECT a FROM Alumno a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Alumno.findByFechaCreacion", query = "SELECT a FROM Alumno a WHERE a.fechaCreacion = :fechaCreacion")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10, message="El C.U. debe tener como máximo 10 digitos.")
    @Pattern(regexp="|^\\d{10}$|", message="El C.U. no puede contener letras.")
    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "UniversidadId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Universidad universidadId;
    @JoinColumn(name = "FacultadId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Facultad facultadId;
    @JoinColumn(name = "EscuelaId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Escuela escuelaId;

    public Alumno() {
    }

    public Alumno(Integer id) {
        this.id = id;
    }

    public Alumno(Integer id, String codigo, Date fechaCreacion) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Universidad getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Universidad universidadId) {
        this.universidadId = universidadId;
    }

    public Facultad getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Facultad facultadId) {
        this.facultadId = facultadId;
    }

    public Escuela getEscuelaId() {
        return escuelaId;
    }

    public void setEscuelaId(Escuela escuelaId) {
        this.escuelaId = escuelaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgml.ejb.persistencia.Alumno[ id=" + id + " ]";
    }
    
}
