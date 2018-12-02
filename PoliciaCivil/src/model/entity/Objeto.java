/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "objeto", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Objeto.findAll", query = "SELECT o FROM Objeto o")
    , @NamedQuery(name = "Objeto.findByNome", query = "SELECT o FROM Objeto o WHERE o.objetoPK.nome = :nome")
    , @NamedQuery(name = "Objeto.findByDescricao", query = "SELECT o FROM Objeto o WHERE o.descricao = :descricao")})
public class Objeto extends Evidencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    protected ObjetoPK objetoPK;
    @Column(name = "descricao")
    private String descricao;

    public Objeto() {
    }

    public Objeto(ObjetoPK objetoPK) {
        this.objetoPK = objetoPK;
    }

    public Objeto(String nome) {
        this.objetoPK = new ObjetoPK(nome);
    }

    public ObjetoPK getObjetoPK() {
        return objetoPK;
    }

    public void setObjetoPK(ObjetoPK objetoPK) {
        this.objetoPK = objetoPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objetoPK != null ? objetoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objeto)) {
            return false;
        }
        Objeto other = (Objeto) object;
        if ((this.objetoPK == null && other.objetoPK != null) || (this.objetoPK != null && !this.objetoPK.equals(other.objetoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Objeto[ objetoPK=" + objetoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
