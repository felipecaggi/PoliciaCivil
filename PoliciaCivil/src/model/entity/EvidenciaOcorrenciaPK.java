/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hueli
 */
@Embeddable
public class EvidenciaOcorrenciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idocorrencia")
    private int idocorrencia;
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private int idevidencia;

    public EvidenciaOcorrenciaPK() {
    }

    public EvidenciaOcorrenciaPK(int idocorrencia, int idevidencia) {
        this.idocorrencia = idocorrencia;
        this.idevidencia = idevidencia;
    }

    public int getIdocorrencia() {
        return idocorrencia;
    }

    public void setIdocorrencia(int idocorrencia) {
        this.idocorrencia = idocorrencia;
    }

    public int getIdevidencia() {
        return idevidencia;
    }

    public void setIdevidencia(int idevidencia) {
        this.idevidencia = idevidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idocorrencia;
        hash += (int) idevidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciaOcorrenciaPK)) {
            return false;
        }
        EvidenciaOcorrenciaPK other = (EvidenciaOcorrenciaPK) object;
        if (this.idocorrencia != other.idocorrencia) {
            return false;
        }
        if (this.idevidencia != other.idevidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.EvidenciaOcorrenciaPK[ idocorrencia=" + idocorrencia + ", idevidencia=" + idevidencia + " ]";
    }

}
