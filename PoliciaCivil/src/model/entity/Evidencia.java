/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "evidencia", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e")
    , @NamedQuery(name = "Evidencia.findByIdevi", query = "SELECT e FROM Evidencia e WHERE e.idevi = :idevi")
    , @NamedQuery(name = "Evidencia.findByProvidencia", query = "SELECT e FROM Evidencia e WHERE e.providencia = :providencia")
    , @NamedQuery(name = "Evidencia.findByTipo", query = "SELECT e FROM Evidencia e WHERE e.tipo = :tipo")})
public class Evidencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idevi")
    private Integer idevi;
    @Basic(optional = false)
    @Column(name = "providencia")
    private String providencia;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    public Evidencia() {
    }

    public Evidencia(Integer idevi) {
        this.idevi = idevi;
    }

    public Evidencia(Integer idevi, String providencia, String tipo) {
        this.idevi = idevi;
        this.providencia = providencia;
        this.tipo = tipo;
    }

    public Integer getIdevi() {
        return idevi;
    }

    public void setIdevi(Integer idevi) {
        Integer oldIdevi = this.idevi;
        this.idevi = idevi;
        changeSupport.firePropertyChange("idevi", oldIdevi, idevi);
    }

    public String getProvidencia() {
        return providencia;
    }

    public void setProvidencia(String providencia) {
        String oldProvidencia = this.providencia;
        this.providencia = providencia;
        changeSupport.firePropertyChange("providencia", oldProvidencia, providencia);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevi != null ? idevi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidencia)) {
            return false;
        }
        Evidencia other = (Evidencia) object;
        if ((this.idevi == null && other.idevi != null) || (this.idevi != null && !this.idevi.equals(other.idevi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Evidencia[ idevi=" + idevi + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
