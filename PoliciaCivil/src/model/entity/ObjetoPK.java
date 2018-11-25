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
public class ObjetoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private int idevidencia;

    public ObjetoPK() {
    }

    public ObjetoPK(String nome, int idevidencia) {
        this.nome = nome;
        this.idevidencia = idevidencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (nome != null ? nome.hashCode() : 0);
        hash += (int) idevidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetoPK)) {
            return false;
        }
        ObjetoPK other = (ObjetoPK) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        if (this.idevidencia != other.idevidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.ObjetoPK[ nome=" + nome + ", idevidencia=" + idevidencia + " ]";
    }
    
}
