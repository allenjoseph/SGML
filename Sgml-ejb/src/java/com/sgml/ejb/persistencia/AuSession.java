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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "au_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuSession.findAll", query = "SELECT a FROM AuSession a"),
    @NamedQuery(name = "AuSession.findById", query = "SELECT a FROM AuSession a WHERE a.id = :id"),
    @NamedQuery(name = "AuSession.findByUsuarioId", query = "SELECT a FROM AuSession a WHERE a.usuarioId = :usuarioId"),
    @NamedQuery(name = "AuSession.findByFechaIngreso", query = "SELECT a FROM AuSession a WHERE a.fechaIngreso = :fechaIngreso")})
public class AuSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioId")
    private int usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    public AuSession() {
    }

    public AuSession(Integer id) {
        this.id = id;
    }

    public AuSession(Integer id, int usuarioId, Date fechaIngreso) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
        if (!(object instanceof AuSession)) {
            return false;
        }
        AuSession other = (AuSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgml.ejb.persistencia.AuSession[ id=" + id + " ]";
    }
    
}
