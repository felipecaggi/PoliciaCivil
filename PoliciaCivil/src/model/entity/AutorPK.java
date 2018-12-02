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
public class AutorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;

    @Basic(optional = false)
    @Column(name = "conduzido")
    private boolean conduzido;

    public AutorPK() {
    }

    public AutorPK(String cpf) {
        this.cpf = cpf;
    }

    public AutorPK(String cpf, boolean conduzido) {
        this.cpf = cpf;
        this.conduzido = conduzido;
    }

    public String getCpfcidadao() {
        return cpf;
    }

    public void setCpfcidadao(String cpfcidadao) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        //hash += (int) idocorrencia;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorPK)) {
            return false;
        }
        AutorPK other = (AutorPK) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    public boolean isConduzido() {
        return conduzido;
    }

    public void setConduzido(boolean conduzido) {
        this.conduzido = conduzido;
    }

}
