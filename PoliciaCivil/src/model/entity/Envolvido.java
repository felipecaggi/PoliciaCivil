/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "envolvido", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Envolvido.findAll", query = "SELECT e FROM Envolvido e")
    , @NamedQuery(name = "Envolvido.findByIdocorrencia", query = "SELECT e FROM Envolvido e WHERE e.envolvidoPK.idocorrencia = :idocorrencia")
    , @NamedQuery(name = "Envolvido.findByIdpolicial", query = "SELECT e FROM Envolvido e WHERE e.envolvidoPK.idpolicial = :idpolicial")})
public class Envolvido implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvolvidoPK envolvidoPK;

    public Envolvido() {
    }

    public Envolvido(EnvolvidoPK envolvidoPK) {
        this.envolvidoPK = envolvidoPK;
    }

    public Envolvido(int idocorrencia, int idpolicial) {
        this.envolvidoPK = new EnvolvidoPK(idocorrencia, idpolicial);
    }

    public EnvolvidoPK getEnvolvidoPK() {
        return envolvidoPK;
    }

    public void setEnvolvidoPK(EnvolvidoPK envolvidoPK) {
        this.envolvidoPK = envolvidoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (envolvidoPK != null ? envolvidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envolvido)) {
            return false;
        }
        Envolvido other = (Envolvido) object;
        if ((this.envolvidoPK == null && other.envolvidoPK != null) || (this.envolvidoPK != null && !this.envolvidoPK.equals(other.envolvidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Envolvido[ envolvidoPK=" + envolvidoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
