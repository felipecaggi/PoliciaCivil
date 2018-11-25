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
@Table(name = "delegado", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Delegado.findAll", query = "SELECT d FROM Delegado d")
    , @NamedQuery(name = "Delegado.findByIdpoldelegado", query = "SELECT d FROM Delegado d WHERE d.idpoldelegado = :idpoldelegado")
    , @NamedQuery(name = "Delegado.findByIddelegacia", query = "SELECT d FROM Delegado d WHERE d.iddelegacia = :iddelegacia")})
public class Delegado implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpoldelegado")
    private Integer idpoldelegado;
    @Column(name = "iddelegacia")
    private Integer iddelegacia;

    public Delegado() {
    }

    public Delegado(Integer idpoldelegado) {
        this.idpoldelegado = idpoldelegado;
    }

    public Integer getIdpoldelegado() {
        return idpoldelegado;
    }

    public void setIdpoldelegado(Integer idpoldelegado) {
        Integer oldIdpoldelegado = this.idpoldelegado;
        this.idpoldelegado = idpoldelegado;
        changeSupport.firePropertyChange("idpoldelegado", oldIdpoldelegado, idpoldelegado);
    }

    public Integer getIddelegacia() {
        return iddelegacia;
    }

    public void setIddelegacia(Integer iddelegacia) {
        Integer oldIddelegacia = this.iddelegacia;
        this.iddelegacia = iddelegacia;
        changeSupport.firePropertyChange("iddelegacia", oldIddelegacia, iddelegacia);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoldelegado != null ? idpoldelegado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegado)) {
            return false;
        }
        Delegado other = (Delegado) object;
        if ((this.idpoldelegado == null && other.idpoldelegado != null) || (this.idpoldelegado != null && !this.idpoldelegado.equals(other.idpoldelegado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Delegado[ idpoldelegado=" + idpoldelegado + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
