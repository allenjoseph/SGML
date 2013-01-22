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
@Table(name = "tb_universidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u"),
    @NamedQuery(name = "Universidad.findById", query = "SELECT u FROM Universidad u WHERE u.id = :id"),
    @NamedQuery(name = "Universidad.findByCodigo", query = "SELECT u FROM Universidad u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Universidad.findByNombre", query = "SELECT u FROM Universidad u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Universidad.findByNombreCorto", query = "SELECT u FROM Universidad u WHERE u.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Universidad.findByDistritoId", query = "SELECT u FROM Universidad u WHERE u.distritoId = :distritoId")})
public class Universidad implements Serializable {
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
    @Size(min = 1, max = 250)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NombreCorto")
    private String nombreCorto;
    @Column(name = "DistritoId")
    private Integer distritoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidadId")
    private Collection<Alumno> alumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidadId")
    private Collection<Facultad> facultadCollection;

    public Universidad() {
    }

    public Universidad(Integer id) {
        this.id = id;
    }

    public Universidad(Integer id, String codigo, String nombre, String nombreCorto) {
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

    public Integer getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(Integer distritoId) {
        this.distritoId = distritoId;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @XmlTransient
    public Collection<Facultad> getFacultadCollection() {
        return facultadCollection;
    }

    public void setFacultadCollection(Collection<Facultad> facultadCollection) {
        this.facultadCollection = facultadCollection;
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
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgml.ejb.persistencia.Universidad[ id=" + id + " ]";
    }
    
}
