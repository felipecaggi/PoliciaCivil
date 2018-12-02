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
@Table(name = "possuipais", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Possuipais.findAll", query = "SELECT p FROM Possuipais p")
    , @NamedQuery(name = "Possuipais.findByCpfFilho", query = "SELECT p FROM Possuipais p WHERE p.possuipaisPK.cpfFilho = :cpfFilho")
    , @NamedQuery(name = "Possuipais.findByCpfPai", query = "SELECT p FROM Possuipais p WHERE p.possuipaisPK.cpfPai = :cpfPai")})
public class Possuipais implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossuipaisPK possuipaisPK;

    public Possuipais() {
    }

    public Possuipais(PossuipaisPK possuipaisPK) {
        this.possuipaisPK = possuipaisPK;
    }

    public Possuipais(String cpfFilho, String cpfPai) {
        this.possuipaisPK = new PossuipaisPK(cpfFilho, cpfPai);
    }

    public PossuipaisPK getPossuipaisPK() {
        return possuipaisPK;
    }

    public void setPossuipaisPK(PossuipaisPK possuipaisPK) {
        this.possuipaisPK = possuipaisPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possuipaisPK != null ? possuipaisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possuipais)) {
            return false;
        }
        Possuipais other = (Possuipais) object;
        if ((this.possuipaisPK == null && other.possuipaisPK != null) || (this.possuipaisPK != null && !this.possuipaisPK.equals(other.possuipaisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Possuipais[ possuipaisPK=" + possuipaisPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
