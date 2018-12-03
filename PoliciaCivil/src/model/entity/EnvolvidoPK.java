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
public class EnvolvidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idocorrencia")
    private int idocorrencia;
    @Basic(optional = false)
    @Column(name = "idpolicial")
    private int idpolicial;

    public EnvolvidoPK() {
    }

    public EnvolvidoPK(int idocorrencia, int idpolicial) {
        this.idocorrencia = idocorrencia;
        this.idpolicial = idpolicial;
    }

    public int getIdocorrencia() {
        return idocorrencia;
    }

    public void setIdocorrencia(int idocorrencia) {
        this.idocorrencia = idocorrencia;
    }

    public int getIdpolicial() {
        return idpolicial;
    }

    public void setIdpolicial(int idpolicial) {
        this.idpolicial = idpolicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idocorrencia;
        hash += (int) idpolicial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnvolvidoPK)) {
            return false;
        }
        EnvolvidoPK other = (EnvolvidoPK) object;
        if (this.idocorrencia != other.idocorrencia) {
            return false;
        }
        if (this.idpolicial != other.idpolicial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.EnvolvidoPK[ idocorrencia=" + idocorrencia + ", idpolicial=" + idpolicial + " ]";
    }

}
