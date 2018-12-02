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
    @Column(name = "idocorrencia")
    private int idocorrencia;
    @Basic(optional = false)
    @Column(name = "cpfcidadao")
    private String cpfcidadao;
    
    @Basic(optional = false)
    @Column(name = "conduzido")
    private boolean conduzido;

    public AutorPK() {
    }

    public AutorPK(int idocorrencia, String cpfcidadao) {
        this.idocorrencia = idocorrencia;
        this.cpfcidadao = cpfcidadao;
    }

    public int getIdocorrencia() {
        return idocorrencia;
    }

    public void setIdocorrencia(int idocorrencia) {
        this.idocorrencia = idocorrencia;
    }

    public String getCpfcidadao() {
        return cpfcidadao;
    }

    public void setCpfcidadao(String cpfcidadao) {
        this.cpfcidadao = cpfcidadao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idocorrencia;
        hash += (cpfcidadao != null ? cpfcidadao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorPK)) {
            return false;
        }
        AutorPK other = (AutorPK) object;
        if (this.idocorrencia != other.idocorrencia) {
            return false;
        }
        if ((this.cpfcidadao == null && other.cpfcidadao != null) || (this.cpfcidadao != null && !this.cpfcidadao.equals(other.cpfcidadao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.AutorPK[ idocorrencia=" + idocorrencia + ", cpfcidadao=" + cpfcidadao + " ]";
    }

    public boolean isConduzido() {
        return conduzido;
    }

    public void setConduzido(boolean conduzido) {
        this.conduzido = conduzido;
    }
    
}
