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
@Table(name = "evidencia_ocorrencia", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "EvidenciaOcorrencia.findAll", query = "SELECT e FROM EvidenciaOcorrencia e")
    , @NamedQuery(name = "EvidenciaOcorrencia.findByIdocorrencia", query = "SELECT e FROM EvidenciaOcorrencia e WHERE e.evidenciaOcorrenciaPK.idocorrencia = :idocorrencia")
    , @NamedQuery(name = "EvidenciaOcorrencia.findByIdevidencia", query = "SELECT e FROM EvidenciaOcorrencia e WHERE e.evidenciaOcorrenciaPK.idevidencia = :idevidencia")})
public class EvidenciaOcorrencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvidenciaOcorrenciaPK evidenciaOcorrenciaPK;

    public EvidenciaOcorrencia() {
    }

    public EvidenciaOcorrencia(EvidenciaOcorrenciaPK evidenciaOcorrenciaPK) {
        this.evidenciaOcorrenciaPK = evidenciaOcorrenciaPK;
    }

    public EvidenciaOcorrencia(int idocorrencia, int idevidencia) {
        this.evidenciaOcorrenciaPK = new EvidenciaOcorrenciaPK(idocorrencia, idevidencia);
    }

    public EvidenciaOcorrenciaPK getEvidenciaOcorrenciaPK() {
        return evidenciaOcorrenciaPK;
    }

    public void setEvidenciaOcorrenciaPK(EvidenciaOcorrenciaPK evidenciaOcorrenciaPK) {
        this.evidenciaOcorrenciaPK = evidenciaOcorrenciaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evidenciaOcorrenciaPK != null ? evidenciaOcorrenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciaOcorrencia)) {
            return false;
        }
        EvidenciaOcorrencia other = (EvidenciaOcorrencia) object;
        if ((this.evidenciaOcorrenciaPK == null && other.evidenciaOcorrenciaPK != null) || (this.evidenciaOcorrenciaPK != null && !this.evidenciaOcorrenciaPK.equals(other.evidenciaOcorrenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.EvidenciaOcorrencia[ evidenciaOcorrenciaPK=" + evidenciaOcorrenciaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
