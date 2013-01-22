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
@Table(name = "tb_escuela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e"),
    @NamedQuery(name = "Escuela.findById", query = "SELECT e FROM Escuela e WHERE e.id = :id"),
    @NamedQuery(name = "Escuela.findByCodigo", query = "SELECT e FROM Escuela e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Escuela.findByNombre", query = "SELECT e FROM Escuela e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escuela.findByNombreCorto", query = "SELECT e FROM Escuela e WHERE e.nombreCorto = :nombreCorto")})
public class Escuela implements Serializable {
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
    @JoinColumn(name = "FacultadId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Facultad facultadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escuelaId")
    private Collection<Alumno> alumnoCollection;

    public Escuela() {
    }

    public Escuela(Integer id) {
        this.id = id;
    }

    public Escuela(Integer id, String codigo, String nombre, String nombreCorto) {
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

    public Facultad getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Facultad facultadId) {
        this.facultadId = facultadId;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
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
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgml.ejb.persistencia.Escuela[ id=" + id + " ]";
    }
    
}
