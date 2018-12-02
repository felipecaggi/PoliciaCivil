/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "delegado", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Delegado.findAll", query = "SELECT d FROM Delegado d")
    , @NamedQuery(name = "Delegado.findByIdpoldelegado", query = "SELECT d FROM Delegado d WHERE d.idPolicial = :idpoldelegado")})
public class Delegado extends Policial implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    @OneToOne
    @JoinColumn(name = "idDelegacia", referencedColumnName = "idDelegacia")
    private Delegacia delegacia;

    public Delegado() {
    }

    public Delegado(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public Delegado(Delegacia delegacia, Integer idpol) {
        super(idpol);
        this.delegacia = delegacia;
    }

    public Delegado(Delegacia delegacia, Integer idpol, String nome, String login, String senha, String cargo) {
        super(idpol, nome, login, senha, cargo);
        this.delegacia = delegacia;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getIdPolicial() != null ? super.getIdPolicial().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegado)) {
            return false;
        }
        Delegado other = (Delegado) object;
        if ((super.getIdPolicial() == null && other.getIdPolicial() != null) || (super.getIdPolicial() != null && !super.getIdPolicial().equals(other.getIdPolicial()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Delegado[ idpoldelegado=" + super.getIdPolicial() + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
