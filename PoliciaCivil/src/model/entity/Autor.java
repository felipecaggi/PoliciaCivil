/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "autor", catalog = "policia", schema = "policiaschema")
@AssociationOverrides({
    @AssociationOverride(name = "ocorrencia",
            joinColumns = @JoinColumn(name = "idOcorrencia"))
    ,
    @AssociationOverride(name = "autor",
            joinColumns = @JoinColumn(name = "cpf"))})
public class Autor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorPK autorPK;

    @ManyToOne
    @JoinColumn(name = "idOcorrencia", referencedColumnName = "idOcorrencia")
    private Ocorrencia ocorrencia;

    public Autor() {
    }

    public Autor(AutorPK autorPK) {
        this.autorPK = autorPK;
    }

    public Autor(String cpfcidadao) {
        this.autorPK = new AutorPK(cpfcidadao);
    }

    public AutorPK getAutorPK() {
        return autorPK;
    }

    public void setAutorPK(AutorPK autorPK) {
        this.autorPK = autorPK;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorPK != null ? autorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.autorPK == null && other.autorPK != null) || (this.autorPK != null && !this.autorPK.equals(other.autorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Autor[ autorPK=" + autorPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
