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
public class VeiculoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numchassi")
    private String numchassi;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private int idevidencia;

    public VeiculoPK() {
    }

    public VeiculoPK(String numchassi, String placa, int idevidencia) {
        this.numchassi = numchassi;
        this.placa = placa;
        this.idevidencia = idevidencia;
    }

    public String getNumchassi() {
        return numchassi;
    }

    public void setNumchassi(String numchassi) {
        this.numchassi = numchassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        hash += (numchassi != null ? numchassi.hashCode() : 0);
        hash += (placa != null ? placa.hashCode() : 0);
        hash += (int) idevidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VeiculoPK)) {
            return false;
        }
        VeiculoPK other = (VeiculoPK) object;
        if ((this.numchassi == null && other.numchassi != null) || (this.numchassi != null && !this.numchassi.equals(other.numchassi))) {
            return false;
        }
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        if (this.idevidencia != other.idevidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.VeiculoPK[ numchassi=" + numchassi + ", placa=" + placa + ", idevidencia=" + idevidencia + " ]";
    }
    
}
