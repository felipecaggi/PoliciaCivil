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
public class CelularPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private int idevidencia;

    public CelularPK() {
    }

    public CelularPK(String imei, int idevidencia) {
        this.imei = imei;
        this.idevidencia = idevidencia;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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
        hash += (imei != null ? imei.hashCode() : 0);
        hash += (int) idevidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CelularPK)) {
            return false;
        }
        CelularPK other = (CelularPK) object;
        if ((this.imei == null && other.imei != null) || (this.imei != null && !this.imei.equals(other.imei))) {
            return false;
        }
        if (this.idevidencia != other.idevidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.CelularPK[ imei=" + imei + ", idevidencia=" + idevidencia + " ]";
    }
    
}
