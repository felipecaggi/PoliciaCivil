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
public class ArmaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "calibre")
    private String calibre;
    @Basic(optional = false)
    @Column(name = "numserie")
    private String numserie;

    public ArmaPK() {
    }

    public ArmaPK(String calibre, String numserie) {
        this.calibre = calibre;
        this.numserie = numserie;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calibre != null ? calibre.hashCode() : 0);
        hash += (numserie != null ? numserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmaPK)) {
            return false;
        }
        ArmaPK other = (ArmaPK) object;
        if ((this.calibre == null && other.calibre != null) || (this.calibre != null && !this.calibre.equals(other.calibre))) {
            return false;
        }
        if ((this.numserie == null && other.numserie != null) || (this.numserie != null && !this.numserie.equals(other.numserie))) {
            return false;
        }
        return true;
    }

}
