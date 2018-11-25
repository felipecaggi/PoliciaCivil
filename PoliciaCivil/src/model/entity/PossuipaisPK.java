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
public class PossuipaisPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cpf_filho")
    private String cpfFilho;
    @Basic(optional = false)
    @Column(name = "cpf_pai")
    private String cpfPai;

    public PossuipaisPK() {
    }

    public PossuipaisPK(String cpfFilho, String cpfPai) {
        this.cpfFilho = cpfFilho;
        this.cpfPai = cpfPai;
    }

    public String getCpfFilho() {
        return cpfFilho;
    }

    public void setCpfFilho(String cpfFilho) {
        this.cpfFilho = cpfFilho;
    }

    public String getCpfPai() {
        return cpfPai;
    }

    public void setCpfPai(String cpfPai) {
        this.cpfPai = cpfPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfFilho != null ? cpfFilho.hashCode() : 0);
        hash += (cpfPai != null ? cpfPai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuipaisPK)) {
            return false;
        }
        PossuipaisPK other = (PossuipaisPK) object;
        if ((this.cpfFilho == null && other.cpfFilho != null) || (this.cpfFilho != null && !this.cpfFilho.equals(other.cpfFilho))) {
            return false;
        }
        if ((this.cpfPai == null && other.cpfPai != null) || (this.cpfPai != null && !this.cpfPai.equals(other.cpfPai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.PossuipaisPK[ cpfFilho=" + cpfFilho + ", cpfPai=" + cpfPai + " ]";
    }
    
}
