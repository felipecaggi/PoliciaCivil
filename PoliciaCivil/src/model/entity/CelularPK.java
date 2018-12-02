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

    public CelularPK() {
    }

    public CelularPK(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imei != null ? imei.hashCode() : 0);
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
        return true;
    }
    
}
