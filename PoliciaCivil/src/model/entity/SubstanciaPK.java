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
public class SubstanciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private int idevidencia;

    public SubstanciaPK() {
    }

    public SubstanciaPK(String tipo, int idevidencia) {
        this.tipo = tipo;
        this.idevidencia = idevidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (tipo != null ? tipo.hashCode() : 0);
        hash += (int) idevidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubstanciaPK)) {
            return false;
        }
        SubstanciaPK other = (SubstanciaPK) object;
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        if (this.idevidencia != other.idevidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.SubstanciaPK[ tipo=" + tipo + ", idevidencia=" + idevidencia + " ]";
    }
    
}
