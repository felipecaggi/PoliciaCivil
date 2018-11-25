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
@Table(name = "vitima", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Vitima.findAll", query = "SELECT v FROM Vitima v")
    , @NamedQuery(name = "Vitima.findByIdocorrencia", query = "SELECT v FROM Vitima v WHERE v.vitimaPK.idocorrencia = :idocorrencia")
    , @NamedQuery(name = "Vitima.findByCpfcidadao", query = "SELECT v FROM Vitima v WHERE v.vitimaPK.cpfcidadao = :cpfcidadao")})
public class Vitima implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VitimaPK vitimaPK;

    public Vitima() {
    }

    public Vitima(VitimaPK vitimaPK) {
        this.vitimaPK = vitimaPK;
    }

    public Vitima(int idocorrencia, String cpfcidadao) {
        this.vitimaPK = new VitimaPK(idocorrencia, cpfcidadao);
    }

    public VitimaPK getVitimaPK() {
        return vitimaPK;
    }

    public void setVitimaPK(VitimaPK vitimaPK) {
        this.vitimaPK = vitimaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vitimaPK != null ? vitimaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vitima)) {
            return false;
        }
        Vitima other = (Vitima) object;
        if ((this.vitimaPK == null && other.vitimaPK != null) || (this.vitimaPK != null && !this.vitimaPK.equals(other.vitimaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Vitima[ vitimaPK=" + vitimaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
