/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "tb_facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findById", query = "SELECT f FROM Facultad f WHERE f.id = :id"),
    @NamedQuery(name = "Facultad.findByCodigo", query = "SELECT f FROM Facultad f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Facultad.findByNombre", query = "SELECT f FROM Facultad f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Facultad.findByNombreCorto", query = "SELECT f FROM Facultad f WHERE f.nombreCorto = :nombreCorto")})
public class Facultad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NombreCorto")
    private String nombreCorto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultadId")
    private Collection<Escuela> escuelaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultadId")
    private Collection<Alumno> alumnoCollection;
    @JoinColumn(name = "UniversidadId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Universidad universidadId;

    public Facultad() {
    }

    public Facultad(Integer id) {
        this.id = id;
    }

    public Facultad(Integer id, String codigo, String nombre, String nombreCorto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    @XmlTransient
    public Collection<Escuela> getEscuelaCollection() {
        return escuelaCollection;
    }

    public void setEscuelaCollection(Collection<Escuela> escuelaCollection) {
        this.escuelaCollection = escuelaCollection;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    public Universidad getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Universidad universidadId) {
        this.universidadId = universidadId;
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
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgml.ejb.persistencia.Facultad[ id=" + id + " ]";
    }
    
}
